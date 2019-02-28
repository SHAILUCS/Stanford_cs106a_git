/**
 * _03_AcmProgramClassHierarchy_GraphicsProgram.java
 * This program creates graphical representation of 
 * Program--> GraphicsProgram, ConsoleProgram and DialogProgram class hierarchy 
 * @author shailendra.rajawat 29 Jan 2019
 * */

package lect6._13_assignment_2_simple_java;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class _03_AcmProgramClassHierarchy_GraphicsProgram extends GraphicsProgram {

	// Width of the Box
	private static final double BOX_WIDTH = 120;

	// Height of the Box
	private static final double BOX_HEIGHT = 50;

	// Space between Boxes vertically, need this to align whole thing in center
	private static final double SPACE_Y = 50;

	// Space between Boxes horizontally, need this to align whole thing in
	// center
	private static final double SPACE_X = 20;

	public void run() {
		pause(2000);
		
		topX=(getWidth()-BOX_WIDTH*3-SPACE_X*2)/2;
		topY=(getHeight()-BOX_HEIGHT*2-SPACE_Y)/2;

		// PROGRAM
		createProgramBoxWithLabel();

		// GRAPHICS PROGRAM
		createGraphicsProgramBoxWithLabel();

		// CONSOLE PROGRAM
		createConsoleProgramBoxWithLabel();

		// DIALOG PROGRAM
		createDialogProgramBoxWithLabel();
		
		
		//ADDNIG LINES
		
		//FROM Program to Graphics Program
		lineXStart=topX+BOX_WIDTH+SPACE_X+BOX_WIDTH/2;
		lineYStart=topY+BOX_HEIGHT;

		lineXEnd=topX+BOX_WIDTH/2;
		lineYEnd=topY+BOX_HEIGHT+SPACE_Y;
		line=new GLine(lineXStart, lineYStart, lineXEnd, lineYEnd);
		add(line);
		
		//FROM Program to Console Program
		lineXEnd=topX+BOX_WIDTH+SPACE_X+BOX_WIDTH/2;
		line=new GLine(lineXStart, lineYStart, lineXEnd, lineYEnd);
		add(line);
		
		//FROM Program to Dialog Program
		lineXEnd=topX+BOX_WIDTH*2+SPACE_X*2+BOX_WIDTH/2;
		line=new GLine(lineXStart, lineYStart, lineXEnd, lineYEnd);
		add(line);
		
	}

	private void createDialogProgramBoxWithLabel() {
		x=topX+BOX_WIDTH*2+SPACE_X*2;
		y=topY+BOX_HEIGHT+SPACE_Y;
		box_DialogProgram = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(box_DialogProgram);
		
		label=new GLabel("Dialog Program");
		x_Label=x+(BOX_WIDTH-label.getWidth())/2;
		y_Label=y+(BOX_HEIGHT-label.getAscent())/2+label.getAscent();
		label.setLocation(x_Label, y_Label);
		add(label);
	}

	private void createConsoleProgramBoxWithLabel() {
		x=topX+BOX_WIDTH+SPACE_X;
		y=topY+BOX_HEIGHT+SPACE_Y;
		box_ConsoleProgram = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(box_ConsoleProgram);
		
		label=new GLabel("Console Program");
		x_Label=x+(BOX_WIDTH-label.getWidth())/2;
		y_Label=y+(BOX_HEIGHT-label.getAscent())/2+label.getAscent();
		label.setLocation(x_Label, y_Label);
		add(label);
	}

	private void createGraphicsProgramBoxWithLabel() {
		x=topX;
		y=topY+BOX_HEIGHT+SPACE_Y;
		box_GraphicsProgram = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(box_GraphicsProgram);
		
		label=new GLabel("Graphics Program");
		x_Label=x+(BOX_WIDTH-label.getWidth())/2;
		y_Label=y+(BOX_HEIGHT-label.getAscent())/2+label.getAscent();
		label.setLocation(x_Label, y_Label);
		add(label);
	}

	private void createProgramBoxWithLabel() {
		x=topX+BOX_WIDTH+SPACE_X;
		y=topY;
		box_Program=new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(box_Program);
		
		GLabel label=new GLabel("Program");
		x_Label=x+(BOX_WIDTH-label.getWidth())/2;
		y_Label=y+(BOX_HEIGHT-label.getAscent())/2+label.getAscent();
		label.setLocation(x_Label, y_Label);
		add(label);
	}

	private GRect box_Program;
	private GRect box_GraphicsProgram;
	private GRect box_ConsoleProgram;
	private GRect box_DialogProgram;
	
	private GLabel label;
	
	private GLine line;
	
	private double topX=0.0;
	private double topY=0.0;

	private double x=0.0;
	private double y=0.0;
	
	private double x_Label=0.0;
	private double y_Label=0.0;

	private double lineXStart=0.0;
	private double lineXEnd=0.0;
	private double lineYStart=0.0;
	private double lineYEnd=0.0;
	
}
