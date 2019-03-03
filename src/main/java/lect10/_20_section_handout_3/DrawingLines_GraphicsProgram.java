package lect10._20_section_handout_3;

import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * DrawingLines_GraphicsProgram.java
 * This program lets the user draw a line by dragging the pressed
 * mouse from one point to other
 * */
public class DrawingLines_GraphicsProgram extends GraphicsProgram{
	
	public void run() {
		addMouseListeners();
	}
	
	/**
	 * sets the starting coordinates of line, when mouse is pressed
	 * */
	public void mousePressed(MouseEvent e) {
		xStart = e.getX();
		yStart = e.getY();
	}
	
	/**
	 * sets the ending coordinates of line, when mouse is released
	 * also draws the line on the canvas
	 * */
	public void mouseReleased(MouseEvent e) {
		xEnd = e.getX();
		yEnd = e.getY();
		drawLine();
	}

	/**
	 * Draws the line on the canvas using the starting and ending coordinates
	 * */
	private void drawLine() {
		add(new GLine(xStart, yStart, xEnd, yEnd));
	}

	
	/* ivars */
	// Line Starting x
	private double xStart;
	
	// Line Starting y
	private double yStart;

	// Line Ending x
	private double xEnd;
	
	// Line Ending y
	private double yEnd;
	
}
