package chess;

public enum PlayerColor {
	WHITE(-1), BLACK(1), NULL(1);
	
	public int dir;
	PlayerColor(int dir) {
		this.dir = dir;
	}
}
