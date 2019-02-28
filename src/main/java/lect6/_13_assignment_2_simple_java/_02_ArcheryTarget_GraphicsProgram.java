/**
 * _02_ArcheryTarget_GraphicsProgram.java
 * Draws an image of an archery target
 * @author shailendra.rajawat 29 Jan 2019
 * */

package lect6._13_assignment_2_simple_java;

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class _02_ArcheryTarget_GraphicsProgram extends GraphicsProgram {

	private static final double FIRST_CIRCLE_RADIUS=72;
	private static final double SECOND_CIRCLE_RADIUS=46.8;
	private static final double THIRD_CIRCLE_RADIUS=21.6; 
	
	public void run() {
		
		double x=getWidth()/2;
		double y=getHeight()/2;
		
		GOval oval=new GOval(x-FIRST_CIRCLE_RADIUS, y-FIRST_CIRCLE_RADIUS, FIRST_CIRCLE_RADIUS*2, FIRST_CIRCLE_RADIUS*2);
		oval.setFilled(true);
		oval.setFillColor(Color.RED);
		add(oval);
		
		oval=new GOval(x-SECOND_CIRCLE_RADIUS, y-SECOND_CIRCLE_RADIUS, SECOND_CIRCLE_RADIUS*2, SECOND_CIRCLE_RADIUS*2);
		oval.setFilled(true);
		oval.setFillColor(Color.WHITE);
		add(oval);
		
		oval=new GOval(x-THIRD_CIRCLE_RADIUS, y-THIRD_CIRCLE_RADIUS, THIRD_CIRCLE_RADIUS*2, THIRD_CIRCLE_RADIUS*2);
		oval.setFilled(true);
		oval.setFillColor(Color.RED);
		add(oval);
		
	}
}
