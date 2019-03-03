package lect10._20_section_handout_3;

import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/** 
 * RandomCircles.java
 * This program draws a set of 10 Random circles with different sizes, position and color. 
 * provided radius is between 5 - 10 px
 * also all circles will be fit inside the canvas
 * */
public class RandomCircles_GraphicsProgram extends GraphicsProgram{

	/* total circles */
	private static final int TOTAL_CIRCLES = 10;

	/* MINIMUM RADIUS */
	private static final double MINIMUM_RADIUS = 5.0;
	
	/* MAXIMUM RADIUS */
	private static final double MAXIMUM_RADIUS = 50.0;
	
	public void run() {
		/*
		 * click to run this program, also click again to run again and again and again
		 * :)
		 */
		while(true) {
			waitForClick();
			removeAll();
			for (int i = 0; i < TOTAL_CIRCLES; i++) {
				GOval circle = getMeARandomCircle();
				add(circle);
			}
		}
	}
	
	/** Creates a new circle with random radius, color and point */
	private GOval getMeARandomCircle() {
		double radius = rgen.nextDouble(MINIMUM_RADIUS, MAXIMUM_RADIUS);
		GOval circle = new GOval(2 * radius, 2 * radius);
		circle.setFilled(true);
		circle.setFillColor(rgen.nextColor());
		circle.setLocation(getCircleLocation(radius));
		return circle;
	}

	/**
	 * Helper method which returns the appropriate point, so that circle comes
	 * within the canvas
	 */
	private GPoint getCircleLocation(double radius) {
		double x = rgen.nextDouble(0.0, getWidth());
		double y = rgen.nextDouble(0.0, getHeight());

		if(x > getWidth() - 2 * radius) {
			x -= 2 * radius;
		}

		if(y > getHeight() - 2 * radius) {
			y -= 2 * radius;
		}
		
		return  new GPoint(x, y);
	}

	/*ivars*/
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
