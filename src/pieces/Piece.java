package pieces;

import java.util.ArrayList;
import java.util.HashSet;

import chess.Move;
import chess.PlayerColor;
import javafx.scene.image.Image;
import main.Main;

public abstract class Piece {
	public PlayerColor color;
	protected HashSet<Integer> invalidMoves;
	protected Image img;
	public boolean moved = false;
	public Pieces type;
	
	public Piece(PlayerColor color, Pieces type) {
		this.color = color;
		this.type = type;
		invalidMoves = new HashSet<Integer>();
		for (int i = 0; i < 20; i++) invalidMoves.add(i);
		for (int i = 100; i < 120; i++) invalidMoves.add(i);
		for (int i = 20; i < 100; i += 10) invalidMoves.add(i);
		for (int i = 29; i < 109; i += 10) invalidMoves.add(i);
	}
	
	public Image getImage() {
		return img;
	};
	
	public boolean checkMove(int index) {
		Piece testPiece = Main.board.getPiece(index);
		if (!invalidMoves.contains(index) && (testPiece == null || testPiece.color != color)) return true;
		return false;
	}
	
	public boolean checkMoveBlocked(int index) {
		Piece testPiece = Main.board.getPiece(index);
		if (!invalidMoves.contains(index) && testPiece == null) return true;
		return false;
	}
	
	protected void generateMoves(ArrayList<Move> out, int index, int modifier) {
		int test = index + modifier;
		while(!invalidMoves.contains(test)) {
			Piece testPiece = Main.board.getPiece(test);
			if (testPiece != null && testPiece.color == color) break;
			Move newMove = new Move(index, test);
			out.add(newMove);
			if (testPiece != null) break;
			test += modifier;
		}
	}
	
	public boolean resolvesCheck(Move move) {
		//if (Main.board.inCheck != color) return true;
		move.clone().preform();
		boolean inCheck = Main.board.testCheck(color);
		Main.board.restore();
		if (inCheck) return false;
		return true;
	}
	
	public abstract ArrayList<Move> getMoves(int index);
	
	@Override
	public String toString() {
		return "" + color + type;
	}
}
