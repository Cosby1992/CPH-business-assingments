

class board():

    def __init__(self):
        self.__board = [[' ', ' ', ' '],[' ', ' ', ' '],[' ', ' ', ' ']]
        self.__player = 'X'
    
    def place(self, row, col):
        if not (row >= 0 and row < 3 and col >= 0 and col < 3): return False
        if not (self.posistion_is_empty(row, col)): return False
        
        self.__board[row][col] = self.__player
        return True
    
    def check_if_game_is_won(self):
        b = self.__board
        empty_cell = ' '
        # horizontal check
        if b[0][0] != empty_cell and b[0][0] == b[0][1] and b[0][1] == b[0][2]: return True
        if b[1][0] != empty_cell and b[1][0] == b[1][1] and b[1][1] == b[1][2]: return True
        if b[2][0] != empty_cell and b[2][0] == b[2][1] and b[2][1] == b[2][2]: return True

        # Vertical check
        if b[0][0] != empty_cell and b[0][0] == b[1][0] and b[1][0] == b[2][0]: return True
        if b[0][1] != empty_cell and b[0][1] == b[1][1] and b[1][1] == b[2][1]: return True
        if b[0][2] != empty_cell and b[0][2] == b[1][2] and b[1][2] == b[2][2]: return True

        # Diagonal check
        if b[0][0] != empty_cell and b[0][0] == b[1][1] and b[1][1] == b[2][2]: return True
        if b[2][0] != empty_cell and b[2][0] == b[1][1] and b[1][1] == b[0][2]: return True

        return False

    def print_board(self):
        print('+---+---+---+')
        print('| ' + self.__board[0][0] + ' | ' + self.__board[0][1] + ' | ' + self.__board[0][2] + ' |')
        print('+---+---+---+')
        print('| ' + self.__board[1][0] + ' | ' + self.__board[1][1] + ' | ' + self.__board[1][2] + ' |')
        print('+---+---+---+')
        print('| ' + self.__board[2][0] + ' | ' + self.__board[2][1] + ' | ' + self.__board[2][2] + ' |')
        print('+---+---+---+')

    def get_player(self):
        return self.__player

    def posistion_is_empty(self, row, col):
        if not self.__board[row][col] == ' ': return False
        else: return True
    
    
    def toggleTurn(self):
        if self.__player == 'X': self.__player = 'O'
        else: self.__player = 'X'
