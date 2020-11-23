package chess;

import java.util.Stack;

import main.Main;
import pieces.Piece;

public class Move extends Stack<int[]>{
	private static final long serialVersionUID = 1L;
	public Piece taken;
	public boolean firstMove = false;
	
	public Move(int... id) {
		super();
		
		for (int i = id.length - 1; i >= 0; i -= 2) this.push(new int[] {id[i - 1], id[i]});
	}
	
	public void preform() {
		Main.turns++;
		Move clone = this.clone();
		while(!this.empty()) {
			int[] move = this.pop();
			Main.board.move(clone, move[0], move[1]);
		}
	}
	
	public Move clone() {
		Stack<int[]> temp = new Stack<int[]>();
		Move res = new Move();
		while(!this.empty()) temp.push(this.pop());
		while(!temp.empty()) {
			res.push(temp.peek());
			this.push(temp.pop());
		}
		return res;
	}
	
	public int getTarget() {
		return peek()[1];
	}
}
