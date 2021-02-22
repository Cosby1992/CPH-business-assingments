

def minimax(board, player):
    return True

def maximizer():
    return True

def minimizer():
    return True


def board_state_score(board, is_maximizer):
        b = board
        empty_cell = ' '
        # horizontal check
        if ((b[0][0] != empty_cell and b[0][0] == b[0][1] and b[0][1] == b[0][2]) or
            (b[1][0] != empty_cell and b[1][0] == b[1][1] and b[1][1] == b[1][2]) or
            (b[2][0] != empty_cell and b[2][0] == b[2][1] and b[2][1] == b[2][2]) or
            # Vertical check
            (b[0][0] != empty_cell and b[0][0] == b[1][0] and b[1][0] == b[2][0]) or
            (b[0][1] != empty_cell and b[0][1] == b[1][1] and b[1][1] == b[2][1]) or
            (b[0][2] != empty_cell and b[0][2] == b[1][2] and b[1][2] == b[2][2]) or
            # Diagonal check
            (b[0][0] != empty_cell and b[0][0] == b[1][1] and b[1][1] == b[2][2]) or
            (b[2][0] != empty_cell and b[2][0] == b[1][1] and b[1][1] == b[0][2])):
            
            if is_maximizer: return 10
            else: return -10
        
        else: return 0