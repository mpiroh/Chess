package com.matus.chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JPanel;

import org.omg.CORBA.NO_IMPLEMENT;

import com.matus.chess.Piece.Player;

public class Game extends JPanel {
	public static final int GRID_SIZE = 8;
	public static final int SQUARE_SIZE = 75;
	
	private Piece[][] board = new Piece[GRID_SIZE][GRID_SIZE];
	private Player turn;
	private boolean selectedPiece = false;
	private int selected_x;
	private int selected_y;
	private boolean[][] moveSquares = new boolean[GRID_SIZE][GRID_SIZE];
	
	public Game() {
		board[0][0] = new Rook(Player.black);
		board[1][0] = new Knight(Player.black);
		board[2][0] = new Bishop(Player.black);
		board[3][0] = new Queen(Player.black);
		board[4][0] = new King(Player.black);
		board[5][0] = new Bishop(Player.black);
		board[6][0] = new Knight(Player.black);
		board[7][0] = new Rook(Player.black);
		board[0][1] = new Pawn(Player.black);
		board[1][1] = new Pawn(Player.black);
		board[2][1] = new Pawn(Player.black);
		board[3][1] = new Pawn(Player.black);
		board[4][1] = new Pawn(Player.black);
		board[5][1] = new Pawn(Player.black);
		board[6][1] = new Pawn(Player.black);
		board[7][1] = new Pawn(Player.black);
		
		board[0][7] = new Rook(Player.white);
		board[1][7] = new Knight(Player.white);
		board[2][7] = new Bishop(Player.white);
		board[3][7] = new Queen(Player.white);
		board[4][7] = new King(Player.white);
		board[5][7] = new Bishop(Player.white);
		board[6][7] = new Knight(Player.white);
		board[7][7] = new Rook(Player.white);
		board[0][6] = new Pawn(Player.white);
		board[1][6] = new Pawn(Player.white);
		board[2][6] = new Pawn(Player.white);
		board[3][6] = new Pawn(Player.white);
		board[4][6] = new Pawn(Player.white);
		board[5][6] = new Pawn(Player.white);
		board[6][6] = new Pawn(Player.white);
		board[7][6] = new Pawn(Player.white);
		//repaint();
		
		turn = Player.white;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x_pix = e.getX();
				int y_pix = e.getY();
				if (x_pix <= Game.GRID_SIZE * Game.SQUARE_SIZE && y_pix <= Game.GRID_SIZE * Game.SQUARE_SIZE) {
					int x = x_pix / Game.SQUARE_SIZE;
					int y = y_pix / Game.SQUARE_SIZE;
					
					if (selectedPiece) {
						if (moveSquares[x][y]) {
							board[x][y] = board[selected_x][selected_y];
							board[selected_x][selected_y] = Piece.NO_VALUE;
							for (int i = 0; i < GRID_SIZE; i++) {
								Arrays.fill(moveSquares[i], false);
							}
							selectedPiece = false;
							if (turn == Player.black) {
								turn = Player.white;
							} else {
								turn = Player.black;
							}
						} else {
							for (int i = 0; i < GRID_SIZE; i++) {
								Arrays.fill(moveSquares[i], false);
							}
							selectedPiece = false;
						}
						repaint();
					} else {
						if (board[x][y] != Piece.NO_VALUE && board[x][y].getPlayer() == turn
								&& !isPlayerInCheck(turn)) {
							selectedPiece = true;
							selected_x = x;
							selected_y = y;
							moveSquares = board[x][y].getMove(x, y, board);
							repaint();
						} else if (board[x][y] != Piece.NO_VALUE && board[x][y].getPlayer() == turn
								&& isPlayerInCheck(turn)) {
							selectedPiece = true;
							selected_x = x;
							selected_y = y;
							
						}
					}
				}
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawBoard(g);
		drawMoveSquares(g);
		drawPieces(g);
	}
	
	public void drawBoard(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(204, 102, 0));
		g2d.fillRect(0, 0, 600, 600);
		
		g2d.setColor(Color.white);
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
					g2d.fillRect(i*SQUARE_SIZE, j*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
				}
			}
		}
	}
	
	public void drawMoveSquares(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) { // light square
					if (moveSquares[i][j]) {
						g2d.setColor(new Color(255, 255, 102));
						g2d.fillRect(i*SQUARE_SIZE, j*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
					}
				} else {
					if (moveSquares[i][j]) {
						g2d.setColor(new Color(204, 204, 0));
						g2d.fillRect(i*SQUARE_SIZE, j*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
					}
				}
			}
		}
	}
	
	public void drawPieces(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (board[i][j] != Piece.NO_VALUE) {
					g2d.drawImage(board[i][j].getImage(), i*SQUARE_SIZE, j*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, null);
				}
			}
		}
	}
	
	public boolean isPlayerInCheck(Player player) {
		boolean[][] attackedSquares = new boolean[GRID_SIZE][GRID_SIZE];
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (board[i][j] != Piece.NO_VALUE && board[i][j].getPlayer() != player) {
					boolean[][] moveSquares = board[i][j].getMove(i, j, board);
					
					for (int ii = 0; ii < GRID_SIZE; ii++) {
						for (int jj = 0; jj < GRID_SIZE; jj++) {
							if (moveSquares[ii][jj]) {
								attackedSquares[ii][jj] = true;
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (board[i][j] != Piece.NO_VALUE && board[i][j].getPlayer() == player
						&& board[i][j] instanceof King && attackedSquares[i][j]) {
					return true;
				}
			}
		}
		
		return false;
	}
}
