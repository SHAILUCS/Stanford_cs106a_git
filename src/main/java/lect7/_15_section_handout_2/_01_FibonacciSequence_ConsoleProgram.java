/**
 * _01_FibonacciSequence_ConsoleProgram.java
 *  Program displays the terms in the Fibonacci sequence, starting with Fib(0) 
 *  and continuing as long as the terms are less than 10,000.
 *  @author shailendra.rajawat 30 Jan 2019
 * */
package lect7._15_section_handout_2;

import acm.program.ConsoleProgram;

public class _01_FibonacciSequence_ConsoleProgram extends ConsoleProgram {

	private static final int FIRST_TERM = 0;
	private static final int SECOND_TERM = 1;
	private static final int MAX_TERM_VALUE = 10000;

	public void run() {

		/*
		 * Fibonacci sequence is 
		 * 0 1 1 2 3 5 8 13 ....
		 * here we have fixed first and second terms(0, 1). 
		 * now the logic is to hold the old term in one variable and add it to the current term, and repeat the process.
		 * 
		 * Algo for each iteration.
		 * 1. hold oldTerm(0) + current term(1) --> print term(1)
		 * 2. hold oldTerm(1) + current term(1) --> print term(2)
		 * 3. hold oldTerm(1) + current term(2) --> print term(3)
		 * 4. hold oldTerm(2) + current term(3) --> print term(5)
		 * 5. hold oldTerm(3) + current term(5) --> print term(8)....
		 * 
		 * */
		println("This program lists the Fibonacci sequence:");
		println(FIRST_TERM);
		println(SECOND_TERM);
		
		int oldTerm = 0;
		int term = SECOND_TERM;
		while (true) {
			int temp = term;
			term += oldTerm;
			if (term > MAX_TERM_VALUE)
				break;
			println(term);
			oldTerm = temp;
		}
	}

}
