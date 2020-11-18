package chess;

import java.util.ArrayList;
import java.util.HashSet;

import javafx.scene.image.Image;

public abstract class Piece {
	public PlayerColor color;
	public HashSet<Integer> invalidMoves;
	
	public Piece() {
		invalidMoves = new HashSet<Integer>();
		for (int i = 0; i < 20; i++) invalidMoves.add(i);
		for (int i = 100; i < 120; i++) invalidMoves.add(i);
		for (int i = 20; i < 100; i += 10) invalidMoves.add(i);
		for (int i = 29; i < 109; i += 10) invalidMoves.add(i);
	}
	
	public abstract Image getImage();
	public abstract ArrayList<Integer> getMoves(int index);
	
}
