/**
 * BouncingBall_ChangesColor.java
 * This program creates an effect of bouncing ball on the graphics window
 * Also each time the ball hits the ground it changes the color
 * */

package lect10._21_bouncing_ball_example;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class BouncingBall_ChangesColor extends GraphicsProgram{

	private static final double BALL_DIAMETER=20;
	private static final double START_X=0;
	private static final double START_Y=0;
	private static final double MOVE_X=10;
	private static final double MOVE_Y=5;
	private static final double LOSS_FACTOR=0.9;
	
	
	public void run() {
		
		GOval ball=new GOval(START_X, START_Y, BALL_DIAMETER, BALL_DIAMETER);
		ball.setFilled(true);
		add(ball);
		
		double yOffset=START_Y;
		while (ball.getX() < getWidth()) {
			
			if(ball.getY() >= getHeight()-BALL_DIAMETER){
				yOffset = -yOffset*LOSS_FACTOR;
				ball.setFillColor(rgen.nextColor());
			}
			
			yOffset+=MOVE_Y;
			ball.move(MOVE_X, yOffset);
			pause(100);
			
			if(ball.getY()+BALL_DIAMETER > getHeight()){
				ball.move(MOVE_X, -(ball.getY()+BALL_DIAMETER-getHeight()));
			}
		}
		
	}
	
	RandomGenerator rgen=RandomGenerator.getInstance();
}
