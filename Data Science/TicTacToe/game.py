from game_messages import welcome_message
from board import board as boardClass

welcome_message()


def player_vs_ai():
    
    
    
    
    
    return True


def two_player():
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

            if(not board.place(int(row), int(col))): 
                print('Illigal move!')
                continue

            board.print_board()

            if board.check_if_game_is_won(): game_over = True
            else: 
                board.toggleTurn()
        else:        
            print("Congratulation's " + board.get_player() + ", you won the game!")
            run_game_loop = False




