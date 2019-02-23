package com.matus.chess;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.matus.chess.Piece.Player;

public class King extends Piece {

	public King(Player player) {
		super(player);
		
		if (player == Player.black) {
			try {
				image = ImageIO.read(new File("king_b.png"));
			} catch (IOException e) {
			}			
		} else {
			try {
				image = ImageIO.read(new File("king_w.png"));
			} catch (IOException e) {
			}
		}
	}

	@Override
	public boolean[][] getMove(int x, int y, Piece[][] board) {
		boolean[][] moveResult = new boolean[Game.GRID_SIZE][Game.GRID_SIZE];

		switch (player) {
		case black:
			if (x - 1 >= 0 && y - 1 >= 0 && (board[x - 1][y - 1] == NO_VALUE || board[x - 1][y - 1].getPlayer() == Player.white)) {
				moveResult[x - 1][y - 1] = true;
			}
			if (x - 1 >= 0 && (board[x - 1][y] == NO_VALUE || board[x - 1][y].getPlayer() == Player.white)) {
				moveResult[x - 1][y] = true;
			}
			if (x - 1 >= 0 && y + 1 < Game.GRID_SIZE && (board[x - 1][y + 1] == NO_VALUE || board[x - 1][y + 1].getPlayer() == Player.white)) {
				moveResult[x - 1][y + 1] = true;
			}
			
			if (y - 1 >= 0 && (board[x][y - 1] == NO_VALUE || board[x][y - 1].getPlayer() == Player.white)) {
				moveResult[x][y - 1] = true;
			}
			if (y + 1 < Game.GRID_SIZE && (board[x][y + 1] == NO_VALUE || board[x][y + 1].getPlayer() == Player.white)) {
				moveResult[x][y + 1] = true;
			}
			
			if (x + 1 < Game.GRID_SIZE && y - 1 >= 0 && (board[x + 1][y - 1] == NO_VALUE || board[x + 1][y - 1].getPlayer() == Player.white)) {
				moveResult[x + 1][y - 1] = true;
			}
			if (x + 1 < Game.GRID_SIZE && (board[x + 1][y] == NO_VALUE || board[x + 1][y].getPlayer() == Player.white)) {
				moveResult[x + 1][y] = true;
			}
			if (x + 1 < Game.GRID_SIZE && y + 1 < Game.GRID_SIZE && (board[x + 1][y + 1] == NO_VALUE || board[x + 1][y + 1].getPlayer() == Player.white)) {
				moveResult[x + 1][y + 1] = true;
			}
			
			return moveResult;
			
		case white:
			if (x - 1 >= 0 && y - 1 >= 0 && (board[x - 1][y - 1] == NO_VALUE || board[x - 1][y - 1].getPlayer() == Player.black)) {
				moveResult[x - 1][y - 1] = true;
			}
			if (x - 1 >= 0 && (board[x - 1][y] == NO_VALUE || board[x - 1][y].getPlayer() == Player.black)) {
				moveResult[x - 1][y] = true;
			}
			if (x - 1 >= 0 && y + 1 < Game.GRID_SIZE && (board[x - 1][y + 1] == NO_VALUE || board[x - 1][y + 1].getPlayer() == Player.black)) {
				moveResult[x - 1][y + 1] = true;
			}
			
			if (y - 1 >= 0 && (board[x][y - 1] == NO_VALUE || board[x][y - 1].getPlayer() == Player.black)) {
				moveResult[x][y - 1] = true;
			}
			if (y + 1 < Game.GRID_SIZE && (board[x][y + 1] == NO_VALUE || board[x][y + 1].getPlayer() == Player.black)) {
				moveResult[x][y + 1] = true;
			}
			
			if (x + 1 < Game.GRID_SIZE && y - 1 >= 0 && (board[x + 1][y - 1] == NO_VALUE || board[x + 1][y - 1].getPlayer() == Player.black)) {
				moveResult[x + 1][y - 1] = true;
			}
			if (x + 1 < Game.GRID_SIZE && (board[x + 1][y] == NO_VALUE || board[x + 1][y].getPlayer() == Player.black)) {
				moveResult[x + 1][y] = true;
			}
			if (x + 1 < Game.GRID_SIZE && y + 1 < Game.GRID_SIZE && (board[x + 1][y + 1] == NO_VALUE || board[x + 1][y + 1].getPlayer() == Player.black)) {
				moveResult[x + 1][y + 1] = true;
			}
			
			return moveResult;
			
		default:
			return null;
		}
	}

}
