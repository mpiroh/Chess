package com.matus.chess;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.matus.chess.Piece.Player;

public class Knight extends Piece {

	public Knight(Player player) {
		super(player);
		
		if (player == Player.black) {
			try {
				image = ImageIO.read(new File("knight_b.png"));
			} catch (IOException e) {
			}			
		} else {
			try {
				image = ImageIO.read(new File("knight_w.png"));
			} catch (IOException e) {
			}
		}
	}

	@Override
	public boolean[][] getMove(int x, int y, Piece[][] board) {
		boolean[][] moveResult = new boolean[Game.GRID_SIZE][Game.GRID_SIZE];

		switch (player) {
		case black:
			if (x - 2 >= 0 && y - 1 >= 0)
				if (board[x - 2][y - 1] == NO_VALUE || board[x - 2][y - 1].getPlayer() == Player.white) {
					moveResult[x - 2][y - 1] = true;
				}

			if (x - 2 >= 0 && y + 1 < Game.GRID_SIZE)
				if (board[x - 2][y + 1] == NO_VALUE || board[x - 2][y + 1].getPlayer() == Player.white) {
					moveResult[x - 2][y + 1] = true;
				}
			
			if (x + 2 < Game.GRID_SIZE && y - 1 >= 0)
				if (board[x + 2][y - 1] == NO_VALUE || board[x + 2][y - 1].getPlayer() == Player.white) {
					moveResult[x + 2][y - 1] = true;
				}
			
			if (x + 2 < Game.GRID_SIZE && y + 1 < Game.GRID_SIZE)
				if (board[x + 2][y + 1] == NO_VALUE || board[x + 2][y + 1].getPlayer() == Player.white) {
					moveResult[x + 2][y + 1] = true;
				}
			
			if (x - 1 >= 0 && y - 2 >= 0) 
				if (board[x - 1][y - 2] == NO_VALUE || board[x - 1][y - 2].getPlayer() == Player.white) {
					moveResult[x - 1][y - 2] = true;
				}
			
			if (x + 1 < Game.GRID_SIZE && y - 2 >= 0) 
				if (board[x + 1][y - 2] == NO_VALUE || board[x + 1][y - 2].getPlayer() == Player.white) {
					moveResult[x + 1][y - 2] = true;
				}
			
			if (x - 1 >= 0 && y + 2 < Game.GRID_SIZE) 
				if (board[x - 1][y + 2] == NO_VALUE || board[x - 1][y + 2].getPlayer() == Player.white) {
					moveResult[x - 1][y + 2] = true;
				}
			
			if (x + 1 < Game.GRID_SIZE && y + 2 < Game.GRID_SIZE) 
				if (board[x + 1][y + 2] == NO_VALUE || board[x + 1][y + 2].getPlayer() == Player.white) {
					moveResult[x + 1][y + 2] = true;
				}
			
			return moveResult;
			
		case white:
			if (x - 2 >= 0 && y - 1 >= 0)
				if (board[x - 2][y - 1] == NO_VALUE || board[x - 2][y - 1].getPlayer() == Player.black) {
					moveResult[x - 2][y - 1] = true;
				}

			if (x - 2 >= 0 && y + 1 < Game.GRID_SIZE)
				if (board[x - 2][y + 1] == NO_VALUE || board[x - 2][y + 1].getPlayer() == Player.black) {
					moveResult[x - 2][y + 1] = true;
				}
			
			if (x + 2 < Game.GRID_SIZE && y - 1 >= 0)
				if (board[x + 2][y - 1] == NO_VALUE || board[x + 2][y - 1].getPlayer() == Player.black) {
					moveResult[x + 2][y - 1] = true;
				}
			
			if (x + 2 < Game.GRID_SIZE && y + 1 < Game.GRID_SIZE)
				if (board[x + 2][y + 1] == NO_VALUE || board[x + 2][y + 1].getPlayer() == Player.black) {
					moveResult[x + 2][y + 1] = true;
				}
			
			if (x - 1 >= 0 && y - 2 >= 0) 
				if (board[x - 1][y - 2] == NO_VALUE || board[x - 1][y - 2].getPlayer() == Player.black) {
					moveResult[x - 1][y - 2] = true;
				}
			
			if (x + 1 < Game.GRID_SIZE && y - 2 >= 0) 
				if (board[x + 1][y - 2] == NO_VALUE || board[x + 1][y - 2].getPlayer() == Player.black) {
					moveResult[x + 1][y - 2] = true;
				}
			
			if (x - 1 >= 0 && y + 2 < Game.GRID_SIZE) 
				if (board[x - 1][y + 2] == NO_VALUE || board[x - 1][y + 2].getPlayer() == Player.black) {
					moveResult[x - 1][y + 2] = true;
				}
			
			if (x + 1 < Game.GRID_SIZE && y + 2 < Game.GRID_SIZE) 
				if (board[x + 1][y + 2] == NO_VALUE || board[x + 1][y + 2].getPlayer() == Player.black) {
					moveResult[x + 1][y + 2] = true;
				}
			
			return moveResult;
			
		default:
			return null;
		}
	}

}
