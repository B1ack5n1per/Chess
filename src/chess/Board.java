package chess;

import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.layout.GridPane;
import main.Main;
import pieces.*;

public class Board extends GridPane {
	
	private Square[] squares = new Square[120];
	private ArrayList<Move> moves = new ArrayList<Move>();
	private Stack<State> saves = new Stack<State>();
	
	public Board() {
		
		SquareColor lastColor = SquareColor.LIGHT;
		for (int i = 0; i < squares.length; i++) {
			if (i < 21 || i > 98 || i % 10 == 0 || i % 10 == 9) {
				squares[i] = new Square();
				continue;
			}

			squares[i] = new Square(lastColor);
			if (i % 10 != 8) {
				if (lastColor == SquareColor.DARK) lastColor = SquareColor.LIGHT;
				else lastColor = SquareColor.DARK;
			}
			
			this.add(squares[i], i % 10 - 1, (int) (Math.floor(i / 10) - 1));
		}
		
		Rook blackLeft = new Rook(PlayerColor.BLACK);
		Rook blackRight = new Rook(PlayerColor.BLACK);
		Rook whiteLeft = new Rook(PlayerColor.WHITE);
		Rook whiteRight = new Rook(PlayerColor.WHITE);
		
		// Black Pieces
		squares[21].setPiece(blackLeft);
		squares[22].setPiece(new Knight(PlayerColor.BLACK));
		squares[23].setPiece(new Bishop(PlayerColor.BLACK));
		squares[24].setPiece(new Queen(PlayerColor.BLACK));
		squares[25].setPiece(new King(PlayerColor.BLACK, whiteLeft, whiteRight));
		squares[26].setPiece(new Bishop(PlayerColor.BLACK));
		squares[27].setPiece(new Knight(PlayerColor.BLACK));
		squares[28].setPiece(blackRight);
		squares[31].setPiece(new Pawn(PlayerColor.BLACK));
		squares[32].setPiece(new Pawn(PlayerColor.BLACK));
		squares[33].setPiece(new Pawn(PlayerColor.BLACK));
		squares[34].setPiece(new Pawn(PlayerColor.BLACK));
		squares[35].setPiece(new Pawn(PlayerColor.BLACK));
		squares[36].setPiece(new Pawn(PlayerColor.BLACK));
		squares[37].setPiece(new Pawn(PlayerColor.BLACK));
		squares[38].setPiece(new Pawn(PlayerColor.BLACK));
		
		// White Pieces
		squares[81].setPiece(new Pawn(PlayerColor.WHITE));
		squares[82].setPiece(new Pawn(PlayerColor.WHITE));
		squares[83].setPiece(new Pawn(PlayerColor.WHITE));
		squares[84].setPiece(new Pawn(PlayerColor.WHITE));
		squares[85].setPiece(new Pawn(PlayerColor.WHITE));
		squares[86].setPiece(new Pawn(PlayerColor.WHITE));
		squares[87].setPiece(new Pawn(PlayerColor.WHITE));
		squares[88].setPiece(new Pawn(PlayerColor.WHITE));
		squares[91].setPiece(whiteLeft);
		squares[92].setPiece(new Knight(PlayerColor.WHITE));
		squares[93].setPiece(new Bishop(PlayerColor.WHITE));
		squares[94].setPiece(new Queen(PlayerColor.WHITE));
		squares[95].setPiece(new King(PlayerColor.WHITE, whiteLeft, whiteRight));
		squares[96].setPiece(new Bishop(PlayerColor.WHITE));
		squares[97].setPiece(new Knight(PlayerColor.WHITE));
		squares[98].setPiece(whiteRight);
	}
	
	public Piece getPiece(int index) {
		return squares[index].getPiece();
	}
	
	public Square getSquare(int index) {
		return squares[index];
	}
	
	public void clear() {
		for (int i = 0; i < squares.length; i++) squares[i].setHighlighted(false);
	}
	
	public void move(int start, int end) {
		squares[end].setPiece(squares[start].getPiece());
		squares[end].getPiece().moved = true;
		squares[start].removePiece();
	}
	
	public PlayerColor testCheck() {
		return PlayerColor.NULL;
	}
	
	public PlayerColor testCheckmate() {
		PlayerColor turn;
		if (Main.turns % 2 == 0) turn = PlayerColor.WHITE;
		else turn = PlayerColor.BLACK;
		if (testCheck() != turn) return PlayerColor.NULL;
		
		/*ArrayList<Move> moves = getAllMoves(turn);
		for(Move move: moves) {
			
		}*/
		return PlayerColor.NULL;
	}
	
	public boolean checkStalemate() {
		ArrayList<ArrayList<Move>> moves = new ArrayList<ArrayList<Move>>();
		moves.add(getAllMoves(PlayerColor.WHITE));
		moves.add(getAllMoves(PlayerColor.BLACK));
		/*
		PlayerColor turn;
		if (Main.turns % 2 == 0) turn = PlayerColor.WHITE;
		else turn = PlayerColor.BLACK;
		*/
		
		if (moves.get((int) (Main.turns % 2)).size() == 0) return true;
		for (Move move: moves.get((int) (Main.turns % 2))) {
			if (squares[move.peek()[0]].getPiece().type == Pieces.KING) {
				
			}
		}
		return false;
	}
	
	private ArrayList<Move> getAllMoves(PlayerColor color) {
		ArrayList<Move> allMoves = new ArrayList<Move>();
		for (int i = 0; i < squares.length; i++) 
			if (squares[i].getPiece() != null && squares[i].getPiece().color == color)
				for(Move move: squares[i].getPiece().getMoves(i)) allMoves.add(move);
		return allMoves;
	}
	
	public void save() {
		Square[] backup = new Square[squares.length];
		for (int i = 0; i < squares.length; i++) backup[i] = squares[i];
		saves.push(new State(backup, Main.turns));
	}
	
	public void revert() {
		State state = saves.pop();
		squares = state.squares;
		Main.turns = state.turns;
	}
	
	public void update(int index) {
		Square target = getSquare(index);
		
		if (!target.highlighted) {
			clear();
			if (target.getPiece() != null && Main.turns % 2 == target.getPiece().color.mod) {
				target.select();
				moves = target.getPiece().getMoves(index);
				for (Move move: moves) getSquare(move.peek()[1]).setHighlighted(true);
			}
		} else {
			for (Move move: moves) if (move.peek()[1] == index) move.preform();
			clear();
			checkStalemate();
		}
	}
	
	public boolean testForIndexViolation(int index) {
		for (int i = 0; i < squares.length; i++) {
			update(i);
			if (moves.get(0).peek()[1] == index) return true;
		}
		return false;
	}
}
