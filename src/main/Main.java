package main;

import chess.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Board board;
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
			board.update(index);
			
		});
		
		window.setScene(scene);
		window.show();
	}

}
