package com.shan;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel {

	public static int[][] number;
	public JFrame jFrame;
	public JPanel jPanel;
	public JButton[][] jButtons;

	public static void main(String[] args) {
		Panel panel = new Panel();
		panel.init();
	}

	public void init() {
		number = new int[4][4];
		Random random = new Random();
		final Arithmetic arithmetic = new Arithmetic();
		jFrame = new JFrame();
		jPanel = new JPanel();
		int count = 0;
		jButtons = new JButton[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				jButtons[i][j] = new JButton();
			}
		}
		while (count < 2) {
			int x = random.nextInt(4);
			int y = random.nextInt(4);
			if (number[x][y] == 0) {
				number[x][y] = 2;
				count++;
			}
		}
		show();
		jPanel.setLayout(new GridLayout(4, 4));
		jPanel.setVisible(true);
		jFrame.add(jPanel);
		jFrame.setVisible(true);
		jFrame.setTitle("2048");
		jFrame.setSize(600, 600);
		jFrame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				boolean notOver = true;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					notOver = arithmetic.keyDown(4);
				else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					notOver = arithmetic.keyDown(3);
				else if (e.getKeyCode() == KeyEvent.VK_UP)
					notOver = arithmetic.keyDown(2);
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
					notOver = arithmetic.keyDown(1);
				show();
				if (!notOver) {
					int sum = 0;
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							sum += number[i][j];
						}
					}
					Object[] options = { "重新游戏", "退出游戏" };
					int i = JOptionPane.showOptionDialog(jFrame, "游戏结束了，你的得分是："
							+ sum, "游戏结束", JOptionPane.YES_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					if (i == 0) {
						int count = 0;
						Random random = new Random();
						for (int j = 0; j < 4; j++) {
							for (int k = 0; k < 4; k++) {
								number[j][k] = 0;
							}
						}
						while (count < 2) {
							int x = random.nextInt(4);
							int y = random.nextInt(4);
							if (number[x][y] == 0) {
								number[x][y] = 2;
								count++;
							}
						}
						show();
					} else if (i == 1) {
						System.exit(0);
					}
				}
			}

		});
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void show() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				jButtons[i][j].setEnabled(false);
				jButtons[i][j].setFont(new Font(null, Font.PLAIN, 48));
				if (number[i][j] == 0) {
					jButtons[i][j].setText("");
				} else {
					jButtons[i][j].setText(number[i][j] + "");
				}
				jPanel.add(jButtons[i][j]);
			}
		}
	}
}
