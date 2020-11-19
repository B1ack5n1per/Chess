package pieces;

import java.util.ArrayList;

import chess.PlayerColor;
import javafx.scene.image.Image;

public class Queen extends Piece {

	public Queen(PlayerColor color) {
		super(color, Pieces.QUEEN);
		this.img = new Image("queen_" + color.toString().toLowerCase() + ".png");
	}

	@Override
	public ArrayList<Move> getMoves(int index) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		generateMoves(moves, index, -11);
		generateMoves(moves, index, -10);
		generateMoves(moves, index, -9);
		generateMoves(moves, index, -1);
		generateMoves(moves, index, 1);
		generateMoves(moves, index, 9);
		generateMoves(moves, index, 10);
		generateMoves(moves, index, 11);
		
		return moves;
	}
}
