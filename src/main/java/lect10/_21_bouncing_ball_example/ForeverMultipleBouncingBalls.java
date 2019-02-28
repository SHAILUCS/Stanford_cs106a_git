package lect10._21_bouncing_ball_example;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class ForeverMultipleBouncingBalls extends GraphicsProgram {

	private static final int BALLS_COUNT = 50;
	private static final double BALL_DIAMETER = 20;
	private static final double MOVE_X = 5;
	private static final double MOVE_Y = 5;
	private static final double PAUSE_TIME = 20;

	public void run() {
		pause(2000);
		
		GOval[] balls = new GOval[BALLS_COUNT];

		for (int i = 0; i < balls.length; i++) {
			GOval ball = new GOval(rgen.nextInt(getWidth()), rgen.nextInt(getHeight()), BALL_DIAMETER, BALL_DIAMETER);
			ball.setFilled(true);
			ball.setFillColor(rgen.nextColor());
			add(ball);
			balls[i]=ball;
		}

		moveBalls(balls);
	}

	private void moveBalls(GOval[] balls) {
		double[] xOffset = new double[BALLS_COUNT];
		double[] yOffset = new double[BALLS_COUNT];
		double[] velocity = new double[BALLS_COUNT];
		
		
		for (int i = 0; i < balls.length; i++) {
			xOffset[i]= MOVE_X;
			yOffset[i]= MOVE_Y;
			velocity[i]=rgen.nextDouble(1.00,1.02);
		}
		
		while (true) {
			pause(PAUSE_TIME);
			for (int i = 0; i < balls.length; i++) {
				double y = balls[i].getY();
				double x = balls[i].getX();

				if ((y + BALL_DIAMETER) >= getHeight() || y < 0) {
					yOffset[i] = -yOffset[i]*velocity[i];
				}

				if ((x + BALL_DIAMETER) >= getWidth() || x < 0) {
					xOffset[i] = -xOffset[i]*velocity[i];
				}
				
				balls[i].move(xOffset[i], yOffset[i]);

				if (balls[i].getY() + BALL_DIAMETER > getHeight()) {
					balls[i].move(MOVE_X, -(balls[i].getY() + BALL_DIAMETER - getHeight()));
				}

				if (balls[i].getX() + BALL_DIAMETER > getWidth()) {
					balls[i].move(-(balls[i].getX() + BALL_DIAMETER - getWidth()), MOVE_Y);
				}

			}
		}
	}

	/** ivars */
	RandomGenerator rgen = RandomGenerator.getInstance();
}
