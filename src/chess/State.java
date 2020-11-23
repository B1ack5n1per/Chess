package chess;

import java.util.ArrayList;

public class State {
	public Square[] squares;
	public long turns;
	public ArrayList<Move> moves;
	
	public State(Square[] squares, long turns, ArrayList<Move> moves) {
		this.squares = squares;
		this.turns = turns;
		this.moves = moves;
	}
	
	@Override
	public String toString() {
		String res = "squares: [";
		
		for(int i = 0; i < squares.length; i++) {
			if (squares[i].getPiece() != null)res += squares[i].getPiece().getClass().getName();
			else res += "empty";
			if (i < squares.length - 1) res += ", ";
		}
		res += "] turns: " + turns;
		
		return res;
	}
}
