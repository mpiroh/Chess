package com.matus.chess;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(680, 680);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(new Game());
		frame.setVisible(true);
	}

}
