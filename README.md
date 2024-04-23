Final Project 
COMP 220 – Computer Programming II 
Due Friday, March 8 by 11:55 PM 

Overview
Chess is a game where two players move pieces on a board to try and capture each other's king. It's all about planning ahead and using your pieces wisely to win.

Background: Chess
A chessboard is on an 8x8 grid and is a turn-based game that ends when the King is taken. 
Pawn: Moves a single space forward or two spaces on its first move or it can be moved diagonally on an attack. 
Knight: can be moved in an L shape in any direction. 
Rook: Can move in straight lines for the entirety of the board.
Bishop: Can move in a diagonal line for the entirety of the board. 
King: Can move one space in any direction.
Queen: Can move in any direction for the entirety of the board. 
Board Class
A constructor: This builds out an 8x8 grid 
Methods:
Display the current state of the board.
Check if a given square is occupied by a piece.
Move a piece on the board.
Check if a move is valid.
Abstract Piece Class
Pawn, Knight, Rook, Bishop, King, Queen
Private Variables that store the position of the piece.
Methods:
Calculate valid moves for the piece
Check if the move is valid 
Game Class
Game class to manage the flow of the game
Initialize a new game by creating an instance of the ‘Board’ class and placing pieces on it. 
Alternate between player moves.
