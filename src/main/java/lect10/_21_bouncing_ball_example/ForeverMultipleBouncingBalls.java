package lect10._21_bouncing_ball_example;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class ForeverMultipleBouncingBalls extends GraphicsProgram {

	private static final int BALLS_COUNT = 20;
	private static final double BALL_DIAMETER = 20;
	private static final double MOVE_X = 5;
	private static final double MOVE_Y = 5;
	private static final double PAUSE_TIME = 20;

	public void run() {
		pause(2000);
		
		// An Array of balls
		GOval[] balls = new GOval[BALLS_COUNT];

		// Creating and adding the balls to the canvas
		for (int i = 0; i < balls.length; i++) {
			GOval ball = new GOval(rgen.nextInt(getWidth()), rgen.nextInt(getHeight()), BALL_DIAMETER, BALL_DIAMETER);
			ball.setFilled(true);
			ball.setFillColor(rgen.nextColor());
			add(ball);
			balls[i]=ball;
		}

		// Starting the movement
		moveBalls(balls);
	}

	/**
	 * Will move the balls forever in the canvas
	 * */
	private void moveBalls(GOval[] balls) {
		double[] xOffset = new double[BALLS_COUNT];
		double[] yOffset = new double[BALLS_COUNT];
		double[] velocity = new double[BALLS_COUNT];
		
		
		for (int i = 0; i < balls.length; i++) {
			double vx = rgen.nextDouble(1.0, MOVE_X);
			if (rgen.nextBoolean(0.5))
				vx = -vx;
			
			double vy = rgen.nextDouble(1.0, MOVE_Y);
			if (rgen.nextBoolean(0.5))
				vy = -vy;
			xOffset[i]= vx ;
			yOffset[i]= vy ;
			velocity[i]=rgen.nextDouble(1.00,1.02);
		}
		
		while (true) {
			pause(PAUSE_TIME);
			for (int i = 0; i < balls.length; i++) {
				double y = balls[i].getY();
				double x = balls[i].getX();

				if ((y + BALL_DIAMETER) >= getHeight() || y < 0) {
					yOffset[i] = -yOffset[i];//*velocity[i];
				}

				if ((x + BALL_DIAMETER) >= getWidth() || x < 0) {
					xOffset[i] = -xOffset[i];//*velocity[i];
				}
				
				balls[i].move(xOffset[i], yOffset[i]);

				if (balls[i].getY() + BALL_DIAMETER > getHeight()) {
					balls[i].move(MOVE_X, -(balls[i].getY() + BALL_DIAMETER - getHeight()));
				}

				if (balls[i].getX() + BALL_DIAMETER > getWidth()) {
					balls[i].move(-(balls[i].getX() + BALL_DIAMETER - getWidth()), MOVE_Y);
				}

				if(checkForCollision(balls[i])) {
					xOffset[i] = -xOffset[i];
					yOffset[i] = -yOffset[i];
				}
			}
		}
	}

	/**
	 * The idea behind this method is to create a bounce effect, 
	 * when two balls collide with each other.
	 * This will check if the ball collide with some other ball,
	 * if ball collides then this will return true,
	 * which can be used to deflect the dx and dy of passed ball
	 * */
	private boolean checkForCollision(GOval gOval) {
		 double x = gOval.getX();
		 double y = gOval.getY();

		GObject object = getElementAt(x, y);
		if(object != null) {
			return object instanceof GOval;
		}

		object = getElementAt(x + BALL_DIAMETER, y);
		if(object != null) {
			return object instanceof GOval;
		}

		object = getElementAt(x, y + BALL_DIAMETER);
		if(object != null) {
			return object instanceof GOval;
		}
		
		object = getElementAt(x + BALL_DIAMETER, y + BALL_DIAMETER);
		if(object != null) {
			return object instanceof GOval;
		}
		
		return false;
	}

	/** ivars */
	RandomGenerator rgen = RandomGenerator.getInstance();
}
