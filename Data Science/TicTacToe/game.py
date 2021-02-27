import copy
from board import board as boardClass
import minimax_aplha_beta as minimax
#import minimax
import constants

def init_game():
    
    player_input = ''
    
    while player_input != constants.EXIT:
        player_input = input(f"Input a game mode ({constants.GAME_MODE_PVP}, {constants.GAME_MODE_AIVP}, {constants.GAME_MODE_AIVAI}) or {constants.EXIT} or {constants.HELP}: ")

        if player_input == constants.GAME_MODE_PVP: 
            init_pvp_game()
        elif player_input == constants.GAME_MODE_AIVP:
            init_player_vs_ai_game()
        elif player_input == constants.GAME_MODE_AIVAI:
            init_ai_vs_ai_game()
        elif player_input == constants.HELP:
            print()
            print("COMMAND  ACTION")
            print("pvp      Two player mode, player vs player")
            print("aivp     Single player vs AI")
            print("aivai    Spectator mode, AI vs AI")
            print("exit     Exits this game")
            print("help     Prints this help menu")
    else: print("GG WP, see you next time!")        


def init_pvp_game():
    # creating and printing empty board
    board = boardClass()
    run_game_loop = True
    game_over = False

    while run_game_loop:

        while not game_over:
            print("\n\n")
            print('it is ' + board.get_player() + "'s turn")
            row = input("Please enter a row number (0-2):")
            col = input("Please enter a column number (0-2):")
            print('row: ' + row + ' col: ' + col)

            if(not board.make_move(int(row), int(col))): 
                print('Illigal move!')
                continue

            board.print_board()

            if board.game_is_won(): game_over = True
            else: 
                board.toggle_turn()
        
        if board.game_is_tie(): print("The game was a tie!")
        else: 
            print("Congratulation's " + board.get_player() + ", you won the game!")
        
        board = boardClass()
        game_over = False

        play_again = False
        while not play_again:
            play_again = input("Do you want to play again? (y / n): ")
        else:
            run_game_loop = True if play_again == 'y' else False


def init_player_vs_ai_game():
    board = boardClass()
    run_game_loop = True
    game_over = False
    turn = 1

    while run_game_loop:
        print("\nNew game vs AI started. Good Luck ;)")

        while True:
            
            # if(board.is_empty()):
            #     board.make_move(1,1)
            #     board.print_board()
            # else: 
            newBoard = copy.deepcopy(board)
            best_move = minimax.get_best_move_maximizer(newBoard)
            board.make_move(best_move[0], best_move[1])
            board.print_board()

            if board.game_is_won() or board.game_is_tie(): 
                break
            
            board.toggle_turn()
            player_turn = True

            while(player_turn):
                print("\n\n")
                print('it is ' + board.get_player() + "'s turn")
                row = input("Please enter a row number (0-2):")
                col = input("Please enter a column number (0-2):")
                print('row: ' + row + ' col: ' + col)

                if(not board.make_move(int(row), int(col))): 
                    print('Illigal move! Try again')
                    board.print_board()
                else: player_turn = False

            board.print_board()
            

            if board.game_is_won() or board.game_is_tie(): 
                break

            board.toggle_turn()

        if board.game_is_tie(): print("The game was a tie!")
        else: 
            if board.get_player() == 'O': print("Congratulation's, you beat the machine!")
            else: print("AI won the game.\nNext step: KILL ALL HUMANS")
        
        board = boardClass()
        game_over = False

        play_again = False
        while not play_again:
            play_again = input("Do you want to play again? (y / n): ")
        else:
            run_game_loop = True if play_again == 'y' else False


def init_ai_vs_ai_game():

    board = boardClass()
    run_game_loop = True
    game_over = False

    while(run_game_loop):

        print("New AI vs AI game starting...")

        while not game_over:
            
            newBoard = copy.deepcopy(board)
            if board.get_player() == 'X':
                best_move = minimax.get_best_move_maximizer(newBoard)
            else: best_move = minimax.get_best_move_minimizer(newBoard)
            board.make_move(best_move[0], best_move[1])

            board.print_board()
            print(f"AI({board.get_player()})'s placed in {best_move}")
            print("\n\n")

            if board.game_is_won() or board.game_is_tie(): 
                game_over = True
            else: 
                board.toggle_turn()
        
        else: 
            
            if board.game_is_tie(): print("The game was a tie!")
            else: 
                print(f"AI({board.get_player()}) won the game!")

        board = boardClass()
        game_over = False

        play_again = False
        while not play_again:
            play_again = input("Do you want to see a similar game? (y / n): ")
        else:
            run_game_loop = True if play_again == 'y' else False

