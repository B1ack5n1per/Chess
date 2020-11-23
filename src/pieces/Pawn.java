package pieces;

import java.util.ArrayList;

import chess.Move;
import chess.PlayerColor;
import javafx.scene.image.Image;
import main.Main;

public class Pawn extends Piece {

	public Pawn(PlayerColor color) {
		super(color, Pieces.PAWN);
		this.img = new Image("pawn_" + color.toString().toLowerCase() + ".png");
	}

	@Override
	public ArrayList<Move> getMoves(int index) {
		ArrayList<Move> moves = new ArrayList<Move>();
		if (checkMoveBlocked(index + 10 * color.dir)) moves.add(new Move(index, index + 10 * color.dir));
		if (!moved && checkMoveBlocked(index + 20 * color.dir)) moves.add(new Move(index, index + 20 * color.dir));
		if(checkPawnAttack(index + 9 * color.dir)) moves.add(new Move(index, index + 9 * color.dir));
		if(checkPawnAttack(index + 11 * color.dir)) moves.add(new Move(index, index + 11 * color.dir));
		
		return moves;
	}
	
	private boolean checkPawnAttack(int index) {
		Piece testPiece = Main.board.getPiece(index);
		if (checkMove(index) && testPiece != null && testPiece.color != color) return true;
		return false;
	}
}
