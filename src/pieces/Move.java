package pieces;

import java.util.Stack;

import main.Main;

public class Move extends Stack<int[]>{
	private static final long serialVersionUID = 1L;
	
	public Move(int... id) {
		super();
		
		for (int i = id.length - 1; i >= 0; i -= 2) this.push(new int[] {id[i - 1], id[i]});
	}
	
	public void preform() {
		Main.turns++;
		while(!this.empty()) {
			int[] move = this.pop();
			Main.board.move(move[0], move[1]);
		}
	}
}
