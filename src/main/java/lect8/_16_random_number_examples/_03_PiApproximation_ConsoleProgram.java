/**
 * _03_PiApproximation_ConsoleProgram.java
 * 
 * This program computes an approximation to pi by simulating
 * a dart board, as described in Chapter 6, Programming Exercise 3
 * of "The Art and Science of Java". The general technique
 * is called Monte Carlo integration.
 * 
 * */

package lect8._16_random_number_examples;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class _03_PiApproximation_ConsoleProgram extends ConsoleProgram {

	private static final int MAX_ATTEMPTS = 10000;

	public void run() {
		int counter = 0;
		while (counter++ < MAX_ATTEMPTS) {
			double result = throwDart();
			if (result < 1.0) {
				insideCircle++;
			} 
		}

		println("Inside Circle: " + insideCircle);
		
		/*
		 * Note: area of circle = PI * r * r = PI * 1 * 1 = PI
		 * area of square = side * side = 2 * 2 = 4
		 * So, PI/4 is the fraction of darts landing in circle:
		 * darts in circle = NDARTS * PI/4
		 * PI = (4 * darts in circle)/NDARTS
		 */
		 double pi = (4.0 * insideCircle) / MAX_ATTEMPTS;
		 println("Pi is approximately " + pi);

		
	}

	private double throwDart() {
		double x = rgen.nextDouble(-1.0, 1.0);
		double y = rgen.nextDouble(-1.0, 1.0);
		return x * x + y * y;
	}

	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

	private double insideCircle;
	
}
