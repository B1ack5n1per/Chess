package pieces;

import java.util.ArrayList;

import chess.Move;
import chess.PlayerColor;
import javafx.scene.image.Image;
import main.Main;

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
		ArrayList<Move> initialMoves = new ArrayList<Move>(), validMoves = new ArrayList<Move>();
		
		if (checkMove(index - 11)) initialMoves.add(new Move(index, index - 11));
		if (checkMove(index - 10)) initialMoves.add(new Move(index, index - 10));
		if (checkMove(index - 9)) initialMoves.add(new Move(index, index - 9));
		if (checkMove(index - 1)) initialMoves.add(new Move(index, index - 1));
		if (checkMove(index + 1)) initialMoves.add(new Move(index, index + 1));
		if (checkMove(index + 9)) initialMoves.add(new Move(index, index + 9));
		if (checkMove(index + 10)) initialMoves.add(new Move(index, index + 10));
		if (checkMove(index + 11)) initialMoves.add(new Move(index, index + 11));
		
		if (!moved) {
			if (!left.moved && checkMoveBlocked(index - 1) && checkMoveBlocked(index - 2) && checkMoveBlocked(index - 3)) initialMoves.add(new Move(index, index - 2, index - 4, index - 1));
			if (!right.moved && checkMoveBlocked(index + 1) && checkMoveBlocked(index + 2)) initialMoves.add(new Move(index, index + 2, index + 3, index + 1));
		}
		
		for (Move move: initialMoves) {
			if (this.resolvesCheck(move.clone())) validMoves.add(move);

		}
		
		return validMoves;
	}
}
