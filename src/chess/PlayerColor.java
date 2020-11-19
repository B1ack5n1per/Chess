package chess;

public enum PlayerColor {
	WHITE(-1, 0), BLACK(1, 1), NULL(1, 1);
	
	public int dir, mod;
	PlayerColor(int dir, int mod) {
		this.dir = dir;
		this.mod = mod;
	}
}
