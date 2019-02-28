/**
 * _02_DrawingFace_GraphicsProgram.java
 * Program displays a robot face on graphics window  
 * @author shailendra.rajawat 30 Jan 2019
 * */

package lect7._15_section_handout_2;

import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class _02_DrawingFace_GraphicsProgram extends GraphicsProgram {

	private static final double EYE_RADIUS = 10;

	private static final double HEAD_WIDTH = 70;

	private static final double HEAD_HEIGHT = 100;

	private static final double MOUTH_HEIGHT = 20;

	private static final double MOUTH_WIDTH = 50;

	public void run() {
		crateHead();
	}

	/**
	 * Creates a robot face with predefined dimensions
	 * */
	private void crateHead() {
		// Getting the top left coordinates of whole face
		double x = (getWidth() - HEAD_WIDTH) / 2;
		double y = (getHeight() - HEAD_HEIGHT) / 2;

		/*
		 * The head is a big rectangle whose dimensions are given by the named
		 * constants HEAD_WIDTH and HEAD_HEIGHT. The interior of the head is
		 * gray, although it should be framed in black
		 */
		createHeadRect(x, y);

		/*
		 * The eyes should be cricles whose radius in pixels is given by the
		 * named constant EYE_RADIUS. The centers of the eyes should be set
		 * horizontally a quarter of the width of the head in from either edge,
		 * and one quarter of the distance down from the top of the head. The
		 * eyes are yellow.
		 */
		double leftx = x + HEAD_WIDTH / 4 - EYE_RADIUS;
		double eyeY = y + HEAD_HEIGHT / 4 - EYE_RADIUS;
		createEye(leftx, eyeY);

		double rightx = x + HEAD_WIDTH * 3 / 4 - EYE_RADIUS;
		createEye(rightx, eyeY);

		/*
		 * The mouth should be centered with respect to the head in the
		 * x-dimension and one quarter of the distance up from the bottom of the
		 * head in the y-dimension. The dimensions of the mouth are given by the
		 * named constants MOUTH_WIDTH and MOUTH_HEIGHT. The mouth is white.
		 */
		double mouthx = x + (HEAD_WIDTH - MOUTH_WIDTH) / 2;
		double mouthy = y + HEAD_HEIGHT * 3 / 4;
		createMouth(mouthx, mouthy);
	}

	private void createMouth(double mouthx, double mouthy) {
		mouth = new GRect(mouthx, mouthy, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		add(mouth);
	}

	private void createEye(double x, double y) {
		eye = new GOval(x, y, EYE_RADIUS * 2, EYE_RADIUS * 2);
		eye.setFilled(true);
		eye.setColor(Color.YELLOW);
		add(eye);
	}

	private void createHeadRect(double x, double y) {
		head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
		head.setFilled(true);
		head.setFillColor(Color.GRAY);
		add(head);
	}

	/* GRect object for mouth */
	private GRect mouth;

	/* GRect object for whole head */
	private GRect head;

	/* GOval object for both eyes */
	private GOval eye;
}
