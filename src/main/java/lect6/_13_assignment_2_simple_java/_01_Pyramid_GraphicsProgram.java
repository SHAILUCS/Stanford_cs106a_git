/**
 * _01_Pyramid_GraphicsProgram.java 
 * Write a GraphicsProgram subclass that draws a pyramid consisting of bricks arranged in 
 * horizontal rows, so that the number of bricks in each row decreases by one as you move 
 * up the pyramid, as shown in the following sample run:
 * 
 * The pyramid should be centered at the bottom of the window and should use
 * constants for the following parameters:
 * BRICK_WIDTH The width of each brick (30 pixels)
 * BRICK_HEIGHT The height of each brick (12 pixels)
 * BRICKS_IN_BASE The number of bricks in the base (14)
 * The numbers in parentheses show the values for this diagram, but you must be able
 * to change those values in your program.
 * 
 * @author shailendra.rajawat 29 Jan 2019
 * */

package lect6._13_assignment_2_simple_java;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class _01_Pyramid_GraphicsProgram extends GraphicsProgram {
	private static final int BRICK_WIDTH=30;
	private static final int BRICK_HEIGHT=15;
	private static final int BRICKS_IN_BASE=7;
	
	public void run() {
		double y=getHeight()-BRICK_HEIGHT;
		double x=0.0;

		for (int i = BRICKS_IN_BASE; i > 0; i--) {
			x=(getWidth()-BRICK_WIDTH*i)/2;
			for (int j = 0; j < i; j++) {
				GRect brick=new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				add(brick);
				x+=BRICK_WIDTH;
			}
			y=y-BRICK_HEIGHT;
		}

	}
	
}
