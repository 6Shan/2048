package com.shan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arithmetic {

	private int[][] number;

	/**
	 * 
	 * @param direction
	 *            1 表示向下 2 表示向上 3 表示向左 4 表示向右
	 */
	public boolean keyDown(int direction) {
		number = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				number[i][j] = Panel.number[i][j];
			}
		}
		switch (direction) {
		case 1:
			move(1);
			add(1);
			move(1);
			if (!same()) {
				if (!addNumber()) {
					return false;
				}
			}
			break;
		case 2:
			move(2);
			add(2);
			move(2);
			if (!same()) {
				if (!addNumber()) {
					return false;
				}
			}
			break;
		case 3:
			move(3);
			add(3);
			move(3);
			if (!same()) {
				if (!addNumber()) {
					return false;
				}
			}
			break;
		case 4:
			move(4);
			add(4);
			move(4);
			if (!same()) {
				if (!addNumber()) {
					return false;
				}
			}
			break;
		default:
			break;
		}
		return true;
	}

	public void move(int direction) {
		List<List<Point>> lists = new ArrayList<List<Point>>();
		lists.add(new ArrayList<Point>());
		lists.add(new ArrayList<Point>());
		lists.add(new ArrayList<Point>());
		lists.add(new ArrayList<Point>());
		int count = 0;
		switch (direction) {
		case 1:
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > -1; j--) {
					if (Panel.number[j][i] != 0) {
						Point point = new Point(j, i);
						point.setValue(Panel.number[j][i]);
						lists.get(i).add(point);
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > -1; j--) {
					if (count < lists.get(i).size()) {
						Panel.number[j][i] = lists.get(i).get(count).getValue();
						count++;
					} else {
						Panel.number[j][i] = 0;
					}
				}
				count = 0;
			}
			break;

		case 2:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (Panel.number[j][i] != 0) {
						Point point = new Point(j, i);
						point.setValue(Panel.number[j][i]);
						lists.get(i).add(point);
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (count < lists.get(i).size()) {
						Panel.number[j][i] = lists.get(i).get(count).getValue();
						count++;
					} else {
						Panel.number[j][i] = 0;
					}
				}
				count = 0;
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (Panel.number[i][j] != 0) {
						Point point = new Point(i, j);
						point.setValue(Panel.number[i][j]);
						lists.get(i).add(point);
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (count < lists.get(i).size()) {
						Panel.number[i][j] = lists.get(i).get(count).getValue();
						count++;
					} else {
						Panel.number[i][j] = 0;
					}
				}
				count = 0;
			}
			break;

		case 4:
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > -1; j--) {
					if (Panel.number[i][j] != 0) {
						Point point = new Point(i, j);
						point.setValue(Panel.number[i][j]);
						lists.get(i).add(point);
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > -1; j--) {
					if (count < lists.get(i).size()) {
						Panel.number[i][j] = lists.get(i).get(count).getValue();
						count++;
					} else {
						Panel.number[i][j] = 0;
					}
				}
				count = 0;
			}
			break;

		default:
			break;
		}
	}

	public boolean addNumber() {
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Panel.number[i][j] == 0) {
					Point point = new Point(i, j);
					list.add(point);
				}
			}
		}
		Random random = new Random();
		int i = random.nextInt(list.size());
		Point point = list.get(i);
		Panel.number[point.getX()][point.getY()] = 2;
		if (list.size() == 1) {
			if (!isOver()) {
				for (int k = 0; k < 4; k++) {
					for (int j = 0; j < 4; j++) {
						Panel.number[k][j] = number[k][j];
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isOver() {
		number = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				number[i][j] = Panel.number[i][j];
			}
		}
		add(1);
		add(2);
		add(3);
		add(4);
		if (same()) {
			return true;
		}
		return false;
	}

	public boolean same() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (number[i][j] != Panel.number[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public void add(int direction) {
		switch (direction) {
		case 1:
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > 0; j--) {
					if (Panel.number[j][i] != 0
							&& Panel.number[j][i] == Panel.number[j - 1][i]) {
						Panel.number[j][i] *= 2;
						Panel.number[j - 1][i] = 0;
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if (Panel.number[j][i] != 0
							&& Panel.number[j][i] == Panel.number[j + 1][i]) {
						Panel.number[j][i] *= 2;
						Panel.number[j + 1][i] = 0;
					}
				}
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if (Panel.number[i][j] != 0
							&& Panel.number[i][j] == Panel.number[i][j + 1]) {
						Panel.number[i][j] *= 2;
						Panel.number[i][j + 1] = 0;
					}
				}
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > 0; j--) {
					if (Panel.number[i][j] != 0
							&& Panel.number[i][j] == Panel.number[i][j - 1]) {
						Panel.number[i][j] *= 2;
						Panel.number[i][j - 1] = 0;
					}
				}
			}
			break;
		default:
			break;
		}
	}
}
