package chess;

public class State {
	public Square[] squares;
	public long turns;
	
	public State(Square[] squares, long turns) {
		this.squares = squares;
		this.turns = turns;
	}
}
