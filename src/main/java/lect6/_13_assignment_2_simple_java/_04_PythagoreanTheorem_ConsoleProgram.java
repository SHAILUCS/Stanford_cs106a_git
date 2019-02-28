/**
 * _04_PythagoreanTheorem_ConsoleProgram.java
 * This program calculates the Pythagorean Theoram
 * @author shailendra.rajawat 30 Jan 2019 
 * */

package lect6._13_assignment_2_simple_java;

import acm.program.ConsoleProgram;

public class _04_PythagoreanTheorem_ConsoleProgram extends ConsoleProgram{
	
	public void run() {
		println("Enter values to compute pyhthagorean theoram.");
		int a=readInt("a: ");
		int b=readInt("b: ");
		double c=Math.sqrt(a*a+b*b);
		println("c = "+c);
	}
	
}
