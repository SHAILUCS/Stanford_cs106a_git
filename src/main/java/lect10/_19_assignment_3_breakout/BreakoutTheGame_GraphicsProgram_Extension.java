package lect10._19_assignment_3_breakout;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class BreakoutTheGame_GraphicsProgram_Extension extends GraphicsProgram {

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 30;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 10;

	private int BRICK_WIDTH;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private int BALL_RADIUS;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 20;

	/** Number of turns */
	private static final int NTURNS = 3;

	/** pause time in milliseconds */
	private static final double PAUSE = 60;

	public void run() {
		BRICK_WIDTH = (getWidth() - BRICK_SEP * 2) / NBRICKS_PER_ROW;
		BALL_RADIUS = BRICK_WIDTH / 4;
		setup();
		waitForClick();
		startBallMovement();
	}

	/** Setups the game */
	private void setup() {
		// Must call this method to be able to get mouse events
		addMouseListeners();

		setupBricks();
		createPaddle();
		createBall();
	}

	// This method will initialize the ball movement
	private void startBallMovement() {

		int currentTurn = 1;

		// This will randomly start the x movement of ball
		setRandomVxForBall();

		// This loop will go on until player lost
		// all his turns or all bricks are finished
		while (true) {

			double y = ball.getY();
			double x = ball.getX();

			// this will get any colliding object with the ball
			// if the collider is brick, then brick will be removed and
			// score will be increased
			// if the collider is paddle, then ball will bounce back
			GObject collider = getCollidingObject();
			if (collider != null) {
				if (collider == paddle || collider == scoreLabel) {
					vy = -vy;

					// Just before the ball is going to pass the paddle
					// level, move the paddle
					// quickly so that the paddle collides with the ball
					// rather than vice-versa. Does everything still
					// work, or does your ball seem to get “glued” to the
					// paddle? If you get this error, try to
					// understand why it occurs and how you might fix it
					// To solve this I am thinking to add below statements,
					// that will check the collision with paddle
					// whenever the paddle is moved, and if the collision is
					// found then it will make sure that the ball goes
					// upwards.
					if ((ball.getY() + BALL_RADIUS * 2) > (getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT)) {
						ball.move(vx,
								-((ball.getY() + BALL_RADIUS * 2) - (getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT)));
					}

				} else {
					updateScoreLabel();
					bricksCount--;
					remove(collider);
					vy = -vy;

					// If all the bricks are finished, then stopping the
					// loop and printing the success message
					if (bricksCount == 0) {
						createWinMessage();
						break;
					}
				}
			}

			// when ball moves below paddle and hits bottom wall,
			// we will remove the ball and place a new one at starting
			// position
			// also we will set random vy to the ball
			if ((y + BALL_RADIUS * 2) >= getHeight()) {
				remove(ball);
				if (currentTurn == NTURNS) {
					createGameOverLabel();
					break;
				} else {
					currentTurn++;
					createBall();
					setRandomVxForBall();
					setRandomVyForBall();
					waitForClick();
				}
			}

			// If ball hits top wall then making it bounce back
			// also Ball is glued to the top wall, this code is fixing this
			// issue
			if (y < 0) {
				vy = -vy;
				ball.move(-vx, -y);
			}

			// If ball hits right side walls then making it bounce back
			if ((x + BALL_RADIUS * 2) >= getWidth()) {
				vx = -vx;
			}

			// Bounce the ball when it hits left wall
			// also Ball is glued to the left wall, this code is fixing this
			// issue
			if (x < 0) {
				vx = -vx;
				ball.move(-x, -vy);
			}

			ball.move(vx, vy);
			pause(PAUSE);

			if (ball.getY() + BALL_RADIUS * 2 > getHeight()) {
				// start the game again untill turn != 0
				ball.move(vx, -(ball.getY() + BALL_RADIUS * 2 - getHeight()));
			}

			if (ball.getX() + BALL_RADIUS * 2 > getWidth()) {
				ball.move(-(ball.getX() + BALL_RADIUS * 2 - getWidth()), vy);
			}
		}
	}

	/*
	 * this will create a label for Win
	 */
	private void createWinMessage() {
		GLabel label = new GLabel("You Won!!");
		label.setFont("SansSerif-20");
		label.setLocation((getWidth() - label.getWidth()) / 2,
				NBRICK_ROWS * BRICK_HEIGHT + BRICK_SEP + BRICK_Y_OFFSET + label.getAscent());
		add(label);
	}

	/*
	 * This method will update the score board label, which is shown just below
	 * the paddle for showing the score to the player
	 */
	private void updateScoreLabel() {
		score++;
		scoreLabel.setLabel(score + "");
	}

	/*
	 * This method will create a Game Over label at the center of screen, when
	 * player loses all his turns
	 */
	private void createGameOverLabel() {
		GLabel label = new GLabel("Game Over");
		label.setFont("SansSerif-20");
		label.setLocation((getWidth() - label.getWidth()) / 2,
				NBRICK_ROWS * BRICK_HEIGHT + BRICK_SEP + BRICK_Y_OFFSET + label.getAscent());
		add(label);
	}

	/**
	 * This method is used for providing random Y direction motion to the ball
	 * used only at the start or when recreating the ball
	 */
	private void setRandomVyForBall() {
		if (rgen.nextBoolean(0.5))
			vy = -vy;
	}

	/**
	 * This method is used for providing random X direction motion to the ball
	 * used only at the start or when recreating the ball
	 */
	private void setRandomVxForBall() {
		vx = rgen.nextDouble(1.0, 5.0);
		if (rgen.nextBoolean(0.5))
			vx = -vx;
	}

	// This method will check for collision with paddle, scoreLabel and brick
	// If the collision is with Brick, the brick will hide
	// If the collision with paddle or scoreLabel ball will reflect
	private GObject getCollidingObject() {

		double y = ball.getY();
		double x = ball.getX();
		GObject obj = null;

		/**
		 * When we
		 */

		obj = getElementAt(x, y);
		if (obj != null) {
			return obj;
		}

		obj = getElementAt(x + 2 * BALL_RADIUS, y);
		if (obj != null) {
			return obj;
		}

		obj = getElementAt(x, y + 2 * BALL_RADIUS);
		if (obj != null) {
			return obj;
		}

		obj = getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS);
		if (obj != null) {
			return obj;
		}

		return null;
	}

	// This method will create a new ball and place it at the top center of the
	// paddle
	private void createBall() {
		ball = new GOval((getWidth() - 2 * BALL_RADIUS) / 2, NBRICK_ROWS * BRICK_HEIGHT + BRICK_SEP + BRICK_Y_OFFSET,
				2 * BALL_RADIUS, 2 * BALL_RADIUS);
		ball.setFilled(true);
		ball.setFillColor(Color.BLACK);
		add(ball);
	}

	// This method is called everytime user move the mouse
	public void mouseMoved(MouseEvent e) {
		// Ensure that paddle is not moving off the right edge
		if (paddle != null && scoreLabel != null) {
			double paddleX = 0.0;
			double paddleY = getHeight() - PADDLE_Y_OFFSET;
			
			double scoreX = 0.0;
			double scoreY = (getHeight() - PADDLE_Y_OFFSET + PADDLE_HEIGHT + scoreLabel.getAscent());
			
			if(e.getX() + PADDLE_WIDTH / 2 < getWidth()){
				if(e.getX() - PADDLE_WIDTH / 2 < 0) {
					scoreX = (PADDLE_WIDTH - scoreLabel.getWidth()) / 2;
				}else{
					paddleX = e.getX() - PADDLE_WIDTH / 2;
					scoreX = e.getX() - scoreLabel.getWidth() / 2;
				}
			paddle.setLocation(paddleX, paddleY);
			scoreLabel.setLocation(scoreX,scoreY);
			}
			
		}
	}

	/*
	 * This method will create a paddle at the bottom center of the window also
	 * will create a score board type label
	 */
	private void createPaddle() {
		paddle = new GRect((getWidth() - PADDLE_WIDTH) / 2, (getHeight() - PADDLE_Y_OFFSET), PADDLE_WIDTH,
				PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setFillColor(Color.BLACK);

		scoreLabel = new GLabel(score + "");
		scoreLabel.setLocation((getWidth() - scoreLabel.getWidth()) / 2,
				(getHeight() - PADDLE_Y_OFFSET + PADDLE_HEIGHT + scoreLabel.getAscent()));

		add(paddle);
		add(scoreLabel);
	}

	// This method will create a Bricks grid
	private void setupBricks() {

		for (int row = 0; row < NBRICK_ROWS; row++) {
			for (int col = 0; col < NBRICKS_PER_ROW; col++) {
				double x = col * BRICK_WIDTH + BRICK_SEP;
				double y = row * BRICK_HEIGHT + BRICK_SEP + BRICK_Y_OFFSET;
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				brick.setFillColor(getColor(row));
				add(brick);
				bricksCount++;
			}
		}

	}

	// This method will provide the appropriate color as per the brick row
	// number
	private Color getColor(int row) {
		Color c = null;
		if (row <= 1) {
			c = Color.RED;
		} else if (row >= 2 && row <= 3) {
			c = Color.ORANGE;
		} else if (row >= 4 && row <= 5) {
			c = Color.YELLOW;
		} else if (row >= 6 && row <= 7) {
			c = Color.GREEN;
		} else if (row >= 8 && row <= 9) {
			c = Color.BLUE;
		}
		return c;
	}

	/* Paddle GRect Object */
	private GRect paddle;

	/* Score GLabel Object */
	private GLabel scoreLabel;

	/* Ball GOval Object */
	private GOval ball;

	/* RandomGenerator Object for getting different vx value */
	private RandomGenerator rgen = RandomGenerator.getInstance();

	/* Velocity of ball */
	private double vx;
	private double vy = 5;

	/* Score of player */
	private int score = 0;

	/* Count of bricks */
	private int bricksCount = 0;
	
}
