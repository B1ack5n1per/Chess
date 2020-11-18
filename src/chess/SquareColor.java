package chess;

import javafx.scene.paint.Color;

public enum SquareColor {
	DARK(Color.SADDLEBROWN, Color.CORNFLOWERBLUE), LIGHT(Color.MOCCASIN, Color.LIGHTSKYBLUE), NULL(Color.TRANSPARENT, Color.TRANSPARENT);
	
	public Color color, highlight;
	SquareColor(Color color, Color highlight) {
		this.color = color;
		this.highlight = highlight;
	}
}
