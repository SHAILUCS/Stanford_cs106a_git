/**
 * _06_DouglasHofstadter_MathPuzzle_ConsoleProgram.java
 * This program illustrates:  
 * Douglas Hofstadter’s Pulitzer-prize-winning book Gödel, Escher, Bach contains 
 * many interesting mathematical puzzles, many of which can be expressed in the form 
 * of computer programs. In Chapter XII, Hofstadter mentions a wonderful problem that
 * is well within the scope of the control statements from Chapter 4. The problem can
 * be expressed as follows:
 * Pick some positive integer and call it n.
 * If n is even, divide it by two.
 * If n is odd, multiply it by three and add one.
 * Continue this process until n is equal to one.
 * @author shailendra.rajawat 30 Jan 2019
 * */

package lect6._13_assignment_2_simple_java;

import acm.program.ConsoleProgram;

public class _06_DouglasHofstadter_MathPuzzle_ConsoleProgram extends ConsoleProgram {

	public void run() {
		int num = readInt("Enter a number: ");
		// In case the number is less than or equal to 0, we will ask user to again enter a valid number
		while (num <= 0) {
			num = readInt("Number can not be less than or equal to 0, retry");
		}
		
		int temp = num;
		int counter = 0;
		while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
				println(temp + " is even so I take half: " + num);
			} else {
				num = num * 3 + 1;
				println(temp + " is odd so I make 3n+1: " + num);
			}
			counter++;
		}
		println("The process took " + counter + " to reach 1");
	}

}
