package pieces;

import java.util.ArrayList;

import chess.PlayerColor;
import javafx.scene.image.Image;

public class Rook extends Piece {

	public Rook(PlayerColor color) {
		super(color);
		this.img = new Image("rook_" + color.toString().toLowerCase() + ".png");
	}

	@Override
	public ArrayList<Move> getMoves(int index) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		generateMoves(moves, index, -10);
		generateMoves(moves, index, -1);
		generateMoves(moves, index, 1);
		generateMoves(moves, index, 10);
		
		return moves;
	}
}
