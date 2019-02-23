package com.matus.chess;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.matus.chess.Piece.Player;

public class Bishop extends Piece {

	public Bishop(Player player) {
		super(player);
		
		if (player == Player.black) {
			try {
				image = ImageIO.read(new File("bishop_b.png"));
			} catch (IOException e) {
			}			
		} else {
			try {
				image = ImageIO.read(new File("bishop_w.png"));
			} catch (IOException e) {
			}
		}
	}

	@Override
	public boolean[][] getMove(int x, int y, Piece[][] board) {
		boolean[][] moveResult = new boolean[Game.GRID_SIZE][Game.GRID_SIZE];

		switch (player) {
		case black:
			int xx = x;
			int yy = y;
			while (true) {
				xx--;
				yy--;
				if (xx >= 0 && yy >= 0 && (board[xx][yy] == NO_VALUE || board[xx][yy].getPlayer() == Player.white)) {
					moveResult[xx][yy] = true;
				} else {
					break;
				}
			}
			
			xx = x;
			yy = y;
			while (true) {
				xx--;
				yy++;
				if (xx >= 0 && yy < Game.GRID_SIZE && (board[xx][yy] == NO_VALUE || board[xx][yy].getPlayer() == Player.white)) {
					moveResult[xx][yy] = true;
				} else {
					break;
				}
			}
			
			xx = x;
			yy = y;
			while (true) {
				xx++;
				yy--;
				if (xx < Game.GRID_SIZE && yy >= 0 && (board[xx][yy] == NO_VALUE || board[xx][yy].getPlayer() == Player.white)) {
					moveResult[xx][yy] = true;
				} else {
					break;
				}
			}
			
			xx = x;
			yy = y;
			while (true) {
				xx++;
				yy++;
				if (xx < Game.GRID_SIZE && yy < Game.GRID_SIZE && (board[xx][yy] == NO_VALUE || board[xx][yy].getPlayer() == Player.white)) {
					moveResult[xx][yy] = true;
				} else {
					break;
				}
			}
			
			return moveResult;
			
		case white:
			xx = x;
			yy = y;
			while (true) {
				xx--;
				yy--;
				if (xx >= 0 && yy >= 0 && (board[xx][yy] == NO_VALUE || board[xx][yy].getPlayer() == Player.black)) {
					moveResult[xx][yy] = true;
				} else {
					break;
				}
			}
			
			xx = x;
			yy = y;
			while (true) {
				xx--;
				yy++;
				if (xx >= 0 && yy < Game.GRID_SIZE && (board[xx][yy] == NO_VALUE || board[xx][yy].getPlayer() == Player.black)) {
					moveResult[xx][yy] = true;
				} else {
					break;
				}
			}
			
			xx = x;
			yy = y;
			while (true) {
				xx++;
				yy--;
				if (xx < Game.GRID_SIZE && yy >= 0 && (board[xx][yy] == NO_VALUE || board[xx][yy].getPlayer() == Player.black)) {
					moveResult[xx][yy] = true;
				} else {
					break;
				}
			}
			
			xx = x;
			yy = y;
			while (true) {
				xx++;
				yy++;
				if (xx < Game.GRID_SIZE && yy < Game.GRID_SIZE && (board[xx][yy] == NO_VALUE || board[xx][yy].getPlayer() == Player.black)) {
					moveResult[xx][yy] = true;
				} else {
					break;
				}
			}
			
			return moveResult;
			
		default:
			return null;
		}
	}

}
