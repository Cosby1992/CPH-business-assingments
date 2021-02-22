from game_messages import welcome_message
from board import board as boardClass

welcome_message()

# creating and printing empty board
board = boardClass()
run_game_loop = True
game_not_over = True

while run_game_loop:

    while game_not_over:
        print("\n\n")
        print('it is ' + board.get_player() + "'s turn")
        row = input("Please enter a row number (0-2):")
        col = input("Please enter a column number (0-2):")
        print('row: ' + row + ' col: ' + col)

        board.place(int(row), int(col))

        board.print_board()

        if board.check_if_game_is_won(): game_not_over = False
        else: 
            board.toggleTurn()
    else:        
        print("Congratulation's " + board.get_player() + ", you won the game!")
        run_game_loop = False




