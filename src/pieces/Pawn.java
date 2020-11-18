package pieces;

import java.util.ArrayList;

import chess.Piece;
import chess.PlayerColor;
import javafx.scene.image.Image;
import main.Main;

public class Pawn extends Piece {
	private boolean moved = false;
	private Image img;

	public Pawn(PlayerColor color) {
		this.color = color;
		img = new Image("pawn_" + color.toString().toLowerCase() + ".png");
	}

	@Override
	public Image getImage() {
		return img;
	}

	@Override
	public ArrayList<Integer> getMoves(int index) {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		Piece target = Main.board.getPiece(index + 10 * color.dir);
		if (!invalidMoves.contains(index + 10 * color.dir) && (target == null || target.color != color)) moves.add(index + 10 * color.dir);
		
		target = Main.board.getPiece(index + 20 * color.dir);
		if (!moved && !invalidMoves.contains(index + 20 * color.dir) && (target == null || target.color != color)) moves.add(index + 20 * color.dir);
		
		return moves;
	}
}
