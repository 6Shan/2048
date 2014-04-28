package com.shan;

import java.util.Random;

import org.junit.Test;

public class ArithmeticTest {
	

	@Test
	public void test() {
	}

	@Test
	public void addNumber() {
		new Panel().init();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		new Arithmetic().addNumber();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(Panel.number[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	@Test
	public void add() {
		int[][] number = {{0,2,0,0},{2,0,2,0},{2,2,2,0},{2,0,0,0}};
		Panel.number = number;
		int count = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(Panel.number[i][j] + ",");
			}
			System.out.println();
		}
		for (int q = 0; q < 10; q++) {
			System.out.println("µÚ" +count+ "´Î");
			Random random = new Random();
			int k = random.nextInt(4);
			System.out.println(k+1);
			new Arithmetic().keyDown(1);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					System.out.print(Panel.number[i][j] + ",");
				}
				System.out.println();
			}
			count++;
		}
	}
	
	@Test
	public void move() {
		int[][] number = {{2,2,0,0},{2,2,2,2},{2,0,2,0},{2,0,2,0}};
		Panel.number = number;
		new Arithmetic().move(1);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(Panel.number[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	@Test
	public void isOver() {
		int[][] number = {{1,2,2,4},{5,6,7,8},{9,10,12,11},{14,13,22,0}};
		Panel.number = number;
		Arithmetic a = new Arithmetic();
		a.keyDown(1);
	}
}
