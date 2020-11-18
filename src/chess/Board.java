package chess;

import javafx.scene.layout.GridPane;
import pieces.*;

public class Board extends GridPane {
	private Square[] squares = new Square[120];
	
	public Board() {
		
		SquareColor lastColor = SquareColor.LIGHT;
		for (int i = 0; i < squares.length; i++) {
			if (i < 21 || i > 98 || i % 10 == 0 || i % 10 == 9) {
				squares[i] = new Square();
				continue;
			}

			squares[i] = new Square(lastColor);
			if (i % 10 != 8) {
				if (lastColor == SquareColor.DARK) lastColor = SquareColor.LIGHT;
				else lastColor = SquareColor.DARK;
			}
			
			this.add(squares[i], i % 10 - 1, (int) (Math.floor(i / 10) - 1));
		}
		
		squares[74].setPiece(new Pawn(PlayerColor.WHITE));
	}
	
	public Piece getPiece(int index) {
		return squares[index].getPiece();
	}
	
	public Square getSquare(int index) {
		return squares[index];
	}
	
	public void clear() {
		for (int i = 0; i < squares.length; i++) squares[i].setHighlighted(false);
	}
}
