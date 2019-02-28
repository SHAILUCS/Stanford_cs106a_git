/**
 * ForeverBouncingBall.java
 * This program creates an effect of a ball moving inside the Walls of graphics window 
 * */

package lect10._21_bouncing_ball_example;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class ForeverBouncingBall extends GraphicsProgram {

	private static final double BALL_DIAMETER = 20;
	private static final double START_X = 0;
	private static final double START_Y = 0;
	private static final double MOVE_X = 5;
	private static final double MOVE_Y = 5;

	public void run() {

		GOval ball = new GOval(START_X, START_Y, BALL_DIAMETER, BALL_DIAMETER);
		ball.setFilled(true);
		add(ball);

		double xOffset = MOVE_X;
		double yOffset = MOVE_Y;
		while (true) {

			double y = ball.getY();
			double x = ball.getX();

			if ((y + BALL_DIAMETER) >= getHeight() || y < 0) {
				yOffset = -yOffset;
			}
			
			if((x + BALL_DIAMETER) >= getWidth() || x < 0){
				xOffset= -xOffset;
			}

			ball.move(xOffset, yOffset);
			pause(30);

			if (ball.getY() + BALL_DIAMETER > getHeight()) {
				ball.move(MOVE_X, -(ball.getY() + BALL_DIAMETER - getHeight()));
			}
			
			if(ball.getX() + BALL_DIAMETER > getWidth()){
				ball.move(-(ball.getX() + BALL_DIAMETER - getWidth()), MOVE_Y);
			}
			
		}

	}
}
