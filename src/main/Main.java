package main;

import java.util.ArrayList;

import chess.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pieces.Move;
import pieces.Piece;

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
				ArrayList<Move> moves = target.getMoves(10 * (y + 2) + x + 1);
				for (Move move: moves) board.getSquare(move.get(0)[1]).setHighlighted(true);
			}
		});
		
		window.setScene(scene);
		window.show();
	}

}
