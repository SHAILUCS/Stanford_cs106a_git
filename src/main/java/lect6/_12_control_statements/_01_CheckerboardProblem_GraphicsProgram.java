/**
 * _01_CheckerboardProblem_GraphicsProgram.java
 * Create a GraphicsProgram subclass that draws a checkerboard in the graphics window.
 * The number of rows and columns are given by the named constants NROWS and NCOLUMNS, and 
 * the squares should be sized so that they fill the vertical space
 * 
 * @author shailendra.rajawat 29 Jan 2019
 * */

package lect6._12_control_statements;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * Extending GraphicsProgram class so that an applet window is loaded and
 * components present in run method are drawn on it.
 */
public class _01_CheckerboardProblem_GraphicsProgram extends GraphicsProgram {

	// number of rows
	private static final int NROWS = 10;

	// number of cols
	private static final int NCOLS = 10;

	private double x = 0.0;
	private double y = 0.0;

	public void run() {
		double squareEdge = getHeight() / NROWS;

		for (int i = 0; i < NROWS; i++) {
			for (int j = 0; j < NCOLS; j++) {
				x = i * squareEdge;
				y = j * squareEdge;
				GRect square = new GRect(x, y, squareEdge, squareEdge);
				square.setFilled((i + j) % 2 == 0);
				add(square);
			}
		}

	}

}
