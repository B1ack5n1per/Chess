package main;

import java.util.ArrayList;

import chess.Board;
import chess.Piece;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Board board;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		
		board = new Board();
		
		
		BorderPane container = new BorderPane();
		container.setCenter(board);
		
		Scene scene = new Scene(container, 800, 800);
		scene.setOnMouseClicked(e -> {
			board.clear();
			
			int x = (int) Math.floor(e.getSceneX() / 100);
			int y = (int) Math.floor(e.getSceneY() / 100);
			
			Piece target = board.getPiece(10 * (y + 2) + x + 1);
			if (target != null) {
				board.getSquare(10 * (y + 2) + x + 1).select();
				ArrayList<Integer> moves = target.getMoves(10 * (y + 2) + x + 1);
				for (Integer move: moves) board.getSquare(move).setHighlighted(true);
			}
		});
		
		window.setScene(scene);
		window.show();
	}

}
