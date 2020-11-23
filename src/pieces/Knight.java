package pieces;

import java.util.ArrayList;

import chess.Move;
import chess.PlayerColor;
import javafx.scene.image.Image;

public class Knight extends Piece {

	public Knight(PlayerColor color) {
		super(color, Pieces.KNIGHT);
		this.img = new Image("knight_" + color.toString().toLowerCase() + ".png");
	}

	@Override
	public ArrayList<Move> getMoves(int index) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		if (checkMove(index - 21)) moves.add(new Move(index, index - 21));
		if (checkMove(index - 19)) moves.add(new Move(index, index - 19));
		if (checkMove(index - 12)) moves.add(new Move(index, index - 12));
		if (checkMove(index - 8)) moves.add(new Move(index, index - 8));
		if (checkMove(index + 8)) moves.add(new Move(index, index + 8));
		if (checkMove(index + 12)) moves.add(new Move(index, index + 12));
		if (checkMove(index + 19)) moves.add(new Move(index, index + 19));
		if (checkMove(index + 21)) moves.add(new Move(index, index + 21));
		
		return moves;
	}
}
