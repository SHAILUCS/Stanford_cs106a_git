/**
 * _05_MinMaxUntillSentinel_ConsoleProgram.java
 * This program reads in a list of integers, one per line, until a sentinel 
 * value of 0 (which you should be able to change easily to some other value). When the
 * sentinel is read, your program should display the smallest and largest values in the
 * list
 * @author shailendra.rajawat 30 Jan 2019
 * */
package lect6._13_assignment_2_simple_java;

import acm.program.ConsoleProgram;

public class _05_MinMaxUntillSentinel_ConsoleProgram extends ConsoleProgram {

	public void run() {

		// these variable will hold the max value
		int max = 0;

		// these variable will hold the min value
		int min = 0;

		while (true) {
			int val = readInt("?");
			if (val == 0)
				break;

			// checking the entered value is greater than old value of max OR
			// max is 0 (when second entered value is sentinel)
			if (val > max || max == 0) {
				// Then setting the value to max
				max = val;
			}

			// checking the entered value is lesser than old value of min OR min
			// is 0 (when second entered value is sentinel)
			if (val < min || min == 0) {
				// Then setting the value to min
				min = val;
			}

		}

		// In case user enters first value as sentinel(0)
		if (min == 0 && max == 0) {
			println("no values have been entered");
		} else {
			println("smallest: " + min);
			println("largest: " + max);
		}
	}
}
