package pieces;

import java.util.ArrayList;

public class Move extends ArrayList<int[]>{
	private static final long serialVersionUID = 1L;
	
	public Move(int... id) {
		super();
		
		for (int i = 0; i < id.length; i += 2) add(new int[] {id[i], id[i + 1]});
	}
	
	public void preform() {
		
	}
}
