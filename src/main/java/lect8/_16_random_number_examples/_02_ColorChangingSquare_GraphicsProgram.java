/*
* File: _02_ColorChangingSquare_GraphicsProgram.java
* ------------------------------
* This program puts up a square in the center of the window
* and randomly changes its color every second.
*/

package lect8._16_random_number_examples;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class _02_ColorChangingSquare_GraphicsProgram extends GraphicsProgram{

	/*Size of the square in pixels*/
	private static final double SQUARE_SIZE=50;
	
	/*pause time in milliseconds*/
	private static final double PAUSE_TIME=1000;
	
	
	public void run() {
		createSquare();
		while(true){
			square.setFillColor(rgen.nextColor());
			pause(PAUSE_TIME);
		}
	}

	private void createSquare() {
		double x=(getWidth()-SQUARE_SIZE)/2;
		double y=(getHeight()-SQUARE_SIZE)/2;
		square=new GRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
		square.setFilled(true);
		add(square);
	}
	
	/* Private instance variables */
	private RandomGenerator rgen=RandomGenerator.getInstance();
	
	private GRect square;
}
