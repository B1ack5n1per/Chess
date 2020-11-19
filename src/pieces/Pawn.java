package pieces;

import java.util.ArrayList;

import chess.PlayerColor;
import javafx.scene.image.Image;

public class Pawn extends Piece {

	public Pawn(PlayerColor color) {
		super(color);
		this.img = new Image("pawn_" + color.toString().toLowerCase() + ".png");
	}

	@Override
	public ArrayList<Move> getMoves(int index) {
		ArrayList<Move> moves = new ArrayList<Move>();
		if (checkMove(index + 10 * color.dir)) moves.add(new Move(index, index + 10 * color.dir));
		if (!moved && checkMove(index + 20 * color.dir)) moves.add(new Move(index, index + 20 * color.dir));
		
		return moves;
	}
}
