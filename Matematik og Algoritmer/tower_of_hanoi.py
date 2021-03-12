import math
import copy

# Assignment #3 - Sequences and recursion - Discrete Mathematics
# Towers of Hanoi
# Create a Visual (text-based or GUI) recursive version of Towers of Hanoi

#  @author Cosby1992, stabz

# This program recursively solves a Towers of Hanoi game and prints it to the console

# [[A],[B],[C]] => The Tower of Hanoi board as 2 dim array
toh_board = [[1,2,3,4,5,6,7],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0]]
array_size = 0 # The number of discs on the board

# Starts a new game with the number of discs as argument
def init_game(n):

    global array_size
    array_size = n

    A = []
    BC = []

    for i in range(n):
        A.append(i+1)
        BC.append(0)
    
    # Fills the board with initial values 
    # Number of discs = n
    toh_board[0] = copy.deepcopy(A)
    toh_board[1] = copy.deepcopy(BC)
    toh_board[2] = copy.deepcopy(BC)

    # Print initial board
    printTowerOfHanoiGame(n,'A', 'A')

    # Solve Tower of Hanoi game recursively
    TowerOfHanoi(n,'A','B','C')  
    # A, C, B are the name of rods




# This method makes a move (from recursive method)
# on the board, then it prints the move to the 
# console using symbols
def printTowerOfHanoiGame(n, source, destination):

    # Get index from source disc
    if source == 'A': source_index = 0
    elif source == 'B': source_index = 1
    else: source_index = 2

    move_index = toh_board[source_index].index(n)

    # Get index from desstination disc
    if destination == 'A': des_index = 0
    elif destination == 'B': des_index = 1
    else: des_index = 2

    # Make the move
    for i in range(len(toh_board[des_index])-1, -1, -1):
        if toh_board[des_index][i] == 0:
            toh_board[des_index][i] = toh_board[source_index][move_index]
            toh_board[source_index][move_index] = 0

    # Create array to print in console
    print_array = [['']  * array_size,[''] * array_size,[''] * array_size]

    # Go through every move in Tower of Hanoi board and 
    # create a pretty string representation of the integer 
    # value from the board as 2 dim array to print in console
    for i in range(len(toh_board)):
        for j in range(len(toh_board[i])):
            string_var = ''
            if toh_board[i][j] == 0: # if theres no disc on this posistion
                spaces = ((array_size * 2) - 1)//2
                string_var += ' ' * spaces
                string_var += '║'
                string_var += ' ' * spaces
                print_array[i][j] = string_var
            else: # if theres a disc on this posistion
                num_of_hashtags = (toh_board[i][j] * 2) - 1
                spaces = ((array_size * 2) - 1) - num_of_hashtags
                string_var += ' ' * (spaces//2)
                string_var += '█' * num_of_hashtags
                string_var += ' ' * (spaces//2)
                print_array[i][j] = string_var
                
    # Print the entire board
    for i in range(array_size):
        print(print_array[0][i], print_array[1][i], print_array[2][i])

    # Calculate spaces for rods name posistion
    string_var = ''
    spaces = ((array_size * 2) - 1)//2
    string_var += ' ' * spaces
    
    # Print horizontal line above rod names
    print('━' * (array_size * 2 * 3))
    # Print rod names with correct spaces
    print(string_var + "A" + string_var + string_var + " B" + string_var + string_var + " C" + string_var)
    print() # Empty line

# Recursive method (more or less stolen from geeksforgeeks)
# Link: https://www.geeksforgeeks.org/python-program-for-tower-of-hanoi/

# It takes n for the number of discs, 
# Source is the disc there should be moved 
# Destination is where the finish pile will end up in the end
# Auxiliary is the last one..
def TowerOfHanoi(n , source, destination, auxiliary): 
    if n==1: # if disc is 1
        # Prints the current tower to the console
        # "makes the move and prints it"
        printTowerOfHanoiGame(1, source, destination)
        return
    # Shift rod B and C until disc = 1
    TowerOfHanoi(n-1, source, auxiliary, destination) 
    # Make move on "board before last recursion"
    # print the move
    printTowerOfHanoiGame(n, source, destination)  
    # Shift rod A and C until disc = 1
    TowerOfHanoi(n-1, auxiliary, destination, source) 
          
# Inits a game with 4 discs
# OBS: The number of moves raises with (2^n) - 1
# 10 discs =      1023 moves
# 20 discs ~ 1.048.500 moves
init_game(4)          




