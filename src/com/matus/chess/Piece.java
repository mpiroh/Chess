package com.matus.chess;

import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Piece {
	enum Player {
		white, black
	}
	
	public static final Piece NO_VALUE = null;
	protected Player player;
	protected BufferedImage image;
	
	public abstract boolean[][] getMove(int x, int y, Piece[][] board);

	public Piece(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
