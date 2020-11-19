package pieces;

import java.util.ArrayList;

import chess.PlayerColor;
import javafx.scene.image.Image;

public class King extends Piece {
	
	Rook left, right;

	public King(PlayerColor color, Rook left, Rook right) {
		super(color, Pieces.KING);
		this.img = new Image("king_" + color.toString().toLowerCase() + ".png");
		this.left = left;
		this.right = right;
	}

	@Override
	public ArrayList<Move> getMoves(int index) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		if (checkMove(index - 11)) moves.add(new Move(index, index - 11));
		if (checkMove(index - 10)) moves.add(new Move(index, index - 10));
		if (checkMove(index - 9)) moves.add(new Move(index, index - 9));
		if (checkMove(index - 1)) moves.add(new Move(index, index - 1));
		if (checkMove(index + 1)) moves.add(new Move(index, index + 1));
		if (checkMove(index + 9)) moves.add(new Move(index, index + 9));
		if (checkMove(index + 10)) moves.add(new Move(index, index + 10));
		if (checkMove(index + 11)) moves.add(new Move(index, index + 11));
		
		if (!moved) {
			if (!left.moved && checkMoveBlocked(index - 1) && checkMoveBlocked(index - 2) && checkMoveBlocked(index - 3)) moves.add(new Move(index, index - 2, index - 4, index - 1));
			if (!right.moved && checkMoveBlocked(index + 1) && checkMoveBlocked(index + 2)) moves.add(new Move(index, index + 2, index + 3, index + 1));
		}
		
		return moves;
	}
}
