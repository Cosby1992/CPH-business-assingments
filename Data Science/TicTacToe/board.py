import constants

# This class handles a tic tac toe board
# including player toggle and
# print methods 
class board():

    # contructor
    # initialize empty board and starting player
    def __init__(self):
        self.__board = [[' ', ' ', ' '],[' ', ' ', ' '],[' ', ' ', ' ']] 
        self.__player = 'X'
    
    # sets a posistion on the board to the current player
    def make_move(self, row, col):
        # returns false if position is occupied or 
        # an illegal posistion is provided as argument
        if not (row >= 0 and row < 3 and col >= 0 and col < 3): return False
        if not (self.posistion_is_empty(row, col)): return False
        
        # else make the move and return true
        self.__board[row][col] = self.__player
        return True
    
    # resets a posistion on the board
    def clear_index(self, row, col):
        self.__board[row][col] = ' '
    
    # checks if the game is won
    def game_is_won(self):
        b = self.__board
        empty_cell = ' '
        # horizontal check
        if b[0][0] != empty_cell and b[0][0] == b[0][1] and b[0][1] == b[0][2]: return True
        elif b[1][0] != empty_cell and b[1][0] == b[1][1] and b[1][1] == b[1][2]: return True
        elif b[2][0] != empty_cell and b[2][0] == b[2][1] and b[2][1] == b[2][2]: return True

        # Vertical check
        elif b[0][0] != empty_cell and b[0][0] == b[1][0] and b[1][0] == b[2][0]: return True
        elif b[0][1] != empty_cell and b[0][1] == b[1][1] and b[1][1] == b[2][1]: return True
        elif b[0][2] != empty_cell and b[0][2] == b[1][2] and b[1][2] == b[2][2]: return True

        # Diagonal check
        elif b[0][0] != empty_cell and b[0][0] == b[1][1] and b[1][1] == b[2][2]: return True
        elif b[2][0] != empty_cell and b[2][0] == b[1][1] and b[1][1] == b[0][2]: return True
        else: return False # if game is not won

    # check witch player has won and returns it
    def player_won(self):
        b = self.__board
        empty_cell = ' '
        winner = ' '
        # horizontal check
        if b[0][0] != empty_cell and b[0][0] == b[0][1] and b[0][1] == b[0][2]: winner = b[0][0] 
        elif b[1][0] != empty_cell and b[1][0] == b[1][1] and b[1][1] == b[1][2]: winner = b[1][0]
        elif b[2][0] != empty_cell and b[2][0] == b[2][1] and b[2][1] == b[2][2]: winner = b[2][0]

        # Vertical check
        elif b[0][0] != empty_cell and b[0][0] == b[1][0] and b[1][0] == b[2][0]: winner = b[0][0]
        elif b[0][1] != empty_cell and b[0][1] == b[1][1] and b[1][1] == b[2][1]: winner = b[0][1]
        elif b[0][2] != empty_cell and b[0][2] == b[1][2] and b[1][2] == b[2][2]: winner = b[0][2]

        # Diagonal check
        elif b[0][0] != empty_cell and b[0][0] == b[1][1] and b[1][1] == b[2][2]: winner = b[0][0]
        elif b[2][0] != empty_cell and b[2][0] == b[1][1] and b[1][1] == b[0][2]: winner = b[2][0]

        return winner # the player (X or O) with three in a row

    # checks if the game has tied
    def game_is_tie(self):
        if self.get_possible_positions() == constants.EMPTY_MOVE_LIST and not self.game_is_won():
            return True 
        else: return False

    # print the current board to the console
    def print_board(self):
        print('+---+---+---+')
        print('| ' + self.__board[0][0] + ' | ' + self.__board[0][1] + ' | ' + self.__board[0][2] + ' |')
        print('+---+---+---+')
        print('| ' + self.__board[1][0] + ' | ' + self.__board[1][1] + ' | ' + self.__board[1][2] + ' |')
        print('+---+---+---+')
        print('| ' + self.__board[2][0] + ' | ' + self.__board[2][1] + ' | ' + self.__board[2][2] + ' |')
        print('+---+---+---+')

    # checks if a position is empty
    def posistion_is_empty(self, row, col):
        return True if self.__board[row][col] == ' ' else False

    # returns a board with booleans representing 
    # empty and non empty cells (True if empty)
    def get_possible_positions(self):
        empty_pos_arr = [[False, False, False],[False, False, False],[False, False, False]]
        for row in range(len(self.__board)):
            for col in range(len(self.__board[row])):
                empty_pos_arr[row][col] = self.posistion_is_empty(row, col)
        return empty_pos_arr

    # checks if the board is empty
    def is_empty(self):
        return self.__board == [[' ', ' ', ' '],[' ', ' ', ' '],[' ', ' ', ' ']]          
    
    # Toogle between players (X or O)
    def toggle_turn(self):
        if self.__player == 'X': self.__player = 'O'
        else: self.__player = 'X'

    # returns the current board state
    def get_board(self):
        return self.__board
    
    # returns the boards current player
    def get_player(self):
        return self.__player
    
    # sets the current player
    def set_player(self, player):
        self.__player = player

