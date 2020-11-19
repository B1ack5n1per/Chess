package pieces;

import java.util.ArrayList;

import chess.PlayerColor;
import javafx.scene.image.Image;

public class Bishop extends Piece {

	public Bishop(PlayerColor color) {
		super(color);
		this.img = new Image("bishop_" + color.toString().toLowerCase() + ".png");
	}

	@Override
	public ArrayList<Move> getMoves(int index) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		generateMoves(moves, index, -11);
		generateMoves(moves, index, -9);
		generateMoves(moves, index, 9);
		generateMoves(moves, index, 11);
		
		return moves;
	}
}
