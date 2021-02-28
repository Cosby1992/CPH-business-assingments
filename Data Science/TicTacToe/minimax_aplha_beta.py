import copy
import constants
import time
from board import board as boardClass

# Global counters
calculations_made = 0
pruning_count = 0

# Function that returns best possible move for a given board state
def minimax(board, depth, alpha, beta):
    #print("depth " + str(depth))
    # board.print_board()
    
    # check if a player has won and get the player
    won = board.player_won()

    # evaluate board and return best score
    # depth is subtracted to give scored with fewer
    # moves a better score
    if won == 'X':
        return constants.MAX_SCORE - depth 
    elif won == 'O':
        return constants.MIN_SCORE - depth
    elif board.game_is_tie():
        # depth is added to tie to force the most 
        # moves for player to make a mistake 
        return constants.TIE_SCORE + depth
    
    # if player is maximizer 
    # (player the algoritm wants to win)
    if board.get_player() == 'X':
        # value lower than lowest score a move can have
        best_score = -10000 
        
        # iterate through all possible moves 
        for i in range(3):
            for j in range(3):

                # check if cell is empty
                if (board.posistion_is_empty(i, j)):

                    # pruning 
                    if beta <= best_score: 
                        increment_global_pruning_count()
                        break
                    
                    # make the move
                    board.make_move(i, j)

                    # Count amount of moves consideret
                    increment_global_counter()

                    # change to minimizing player
                    board.toggle_turn() 

                    # call minimax recursively and choose
                    # the maximum value
                    best_score = max(best_score, minimax(board, depth + 1, best_score, beta))
                    
                    # reset board by undoing the move 
                    # and change back to maximizing player
                    board.toggle_turn()
                    board.clear_index(i, j)
        
        # return the score of the best 
        # possible move the ai can make
        return best_score 

    # if player is minimizer 
    # (player the algoritm wants to lose)
    else:
        # value higher than highest score a move can have
        best_score = 10000

        # iterate through all possible moves
        for i in range(3):
            for j in range(3):

                # check if cell is empty
                if (board.posistion_is_empty(i, j)):
                    
                    # pruning
                    if alpha >= best_score: 
                        increment_global_pruning_count()
                        break
                    
                    # make the move
                    board.make_move(i, j)

                    # Count amount of moves consideret
                    increment_global_counter()

                    board.toggle_turn() # change to minimizing player

                    # call minimax recursively and choose
                    # the minimum value
                    best_score = min(best_score, minimax(board, depth + 1, alpha, best_score))
                    
                    # reset board by undoing the move 
                    # and change back to minimizing player
                    board.toggle_turn()
                    board.clear_index(i, j)

        # return the score of the best 
        # possible move the ai's opponent can make
        return best_score


# Function that uses the minimax function to get 
# the posistion for the best posssible move for "X" / Attacing player
def get_best_move_maximizer(board):

    # start algorithm timer
    timer_start = time.perf_counter()

    # Used to calculate all possible board combinations
    empty_cell_count = 0

    # initialize start values
    best_posistion = (-1, -1)
    best_score = -10000
    beta = 10000

    # Iterate through all cells, evaluate minimax function for
    # all empty cells. And return the cell with optimal
    # value.
    for i in range(3):
        for j in range(3):

            # Check if cell is empty
            if (board.posistion_is_empty(i, j)):

                empty_cell_count += 1

                # Make the move
                board.make_move(i, j)

                # Count amount of moves consideret
                increment_global_counter()

                # change player before starting minimax
                board.toggle_turn()

                # Use minimax to get the best score for this move
                move_score = minimax(board, 0, best_score, beta)

                # reset board before next loop
                board.toggle_turn()
                board.clear_index(i, j)

                # If the value of the current move is
                # more than the best value, then update
                # best score and posistion 
                if (move_score > best_score):
                    best_posistion = (i, j)
                    best_score = move_score

    # Stop timer
    timer_stop = time.perf_counter()

    # calculate all possible board combinations
    total_posible_moves = calculate_faculty(empty_cell_count)

    # Getting global variables
    global calculations_made
    global pruning_count

    # Printing info about this move
    print(f"{total_posible_moves} total possible moves")
    print(f"{calculations_made} moves considered in {(timer_stop - timer_start)*1000.0:0.4f} ms")
    print(f"{pruning_count} prunings were made")
    print("Score of the worst case scenario is: ", best_score)
    
    # Taunt player if winning
    if best_score > constants.MAX_SCORE - 10 and best_score < constants.MAX_SCORE: 
        print("AI will win this game...")

    # reset the global counters
    reset_global_counter()
    reset_global_pruning_count()

    # return posistion of the best move 
    return best_posistion

# Function that uses the minimax function to get 
# the posistion for the best posssible move for "O" / defending player
def get_best_move_minimizer(board):

    # Start algorithm timer
    timer_start = time.perf_counter()

    # Used to calculate all possible board combinations from board state
    empty_cell_count = 0

    # Initialize start values 
    best_posistion = (-1, -1)
    best_score = 10000
    alpha = -10000

    # Iterate through all cells, evaluate minimax function for
    # all empty cells. And return the cell with optimal
    # value.
    for i in range(3):
        for j in range(3):

            # Check if cell is empty
            if (board.posistion_is_empty(i, j)):

                empty_cell_count += 1

                # Make the move
                board.make_move(i, j)

                # Count amount of moves consideret
                increment_global_counter()

                # change player before starting minimax
                board.toggle_turn()

                # Use minimax to get the best score for this move
                move_score = minimax(board, 0, alpha, best_score)

                # reset board before next loop
                board.toggle_turn()
                board.clear_index(i, j)

                # If the value of the current move is
                # more than the best value, then update
                # best score and posistion 
                if (move_score < best_score):
                    best_posistion = (i, j)
                    best_score = move_score

    # Stop the timer
    timer_stop = time.perf_counter()
    
    # Calculate all possible board combinations
    total_posible_moves = calculate_faculty(empty_cell_count)

    # Get global variable
    global calculations_made
    global pruning_count

    # Print move data
    print(f"{total_posible_moves} total possible moves")
    print(f"{calculations_made} moves considered in {(timer_stop - timer_start)*1000.0:0.4f} ms")
    print(f"{pruning_count} moves pruned")
    print("Score of the worst case scenario is: ", best_score)

    # Reset global counters
    reset_global_counter()
    reset_global_pruning_count()

    # return posistion of the best move 
    return best_posistion



def increment_global_counter():
    global calculations_made
    calculations_made += 1

def reset_global_counter():
    global calculations_made
    calculations_made = 0

def increment_global_pruning_count():
    global pruning_count
    pruning_count += 1

def reset_global_pruning_count():
    global pruning_count
    pruning_count = 0

def calculate_faculty(number):
    temp = number
    for i in range(number-2):
        temp *= number-(i+1)
    
    return temp