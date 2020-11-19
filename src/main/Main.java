package main;

import java.util.ArrayList;

import chess.Board;
import chess.Square;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pieces.Move;

public class Main extends Application {
	
	public static Board board;
	private static ArrayList<Move> moves;
	public static long turns = 0;

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
			int index = (int) (10 * (Math.floor(e.getSceneY() / 100) + 2) + Math.floor(e.getSceneX() / 100) + 1);
			Square target = board.getSquare(index);
			
			if (!target.highlighted) {
				board.clear();
				if (target.getPiece() != null && turns % 2 == target.getPiece().color.mod) {
					target.select();
					moves = target.getPiece().getMoves(index);
					for (Move move: moves) board.getSquare(move.peek()[1]).setHighlighted(true);
				}
			} else {
				for (Move move: moves) if (move.peek()[1] == index) move.preform();
				board.clear();
			}
			
		});
		
		window.setScene(scene);
		window.show();
	}

}
