package chess;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import pieces.Piece;

public class Square extends StackPane {
	private Piece piece;
	private ImageView img = new ImageView();
	private SquareColor color = SquareColor.NULL;
	public boolean highlighted = false;
	
	public Square() {
		img.setFitHeight(100);
		img.setFitWidth(100);
		img.setPreserveRatio(true);
		this.getChildren().add(img);
	}
	
	public Square(SquareColor color) {
		this.setMinSize(100, 100);
		this.setMaxSize(100, 100);
		img.setFitHeight(100);
		img.setFitWidth(100);
		img.setPreserveRatio(true);
		this.getChildren().add(img);
		this.color = color;
		setHighlighted(false);
	}
	
	private void setColor(Color color) {
		this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(0), new Insets(0))));
	}
	
	public void select() {
		if (piece != null) setColor(Color.GREENYELLOW);
	}
	
	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
		if (highlighted) setColor(color.highlight);
		else setColor(color.color);
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void removePiece() {
		this.piece = null;
		update();
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
		update();
	}
	
	public void update() {
		if (piece != null) img.setImage(piece.getImage());
		else img.setImage(null);
	}
}
