/**
 * AddingCommasToNumericStrings.java
 * 
 * This program add commas to numeric string
 * 
 * */

package lect13._24_section_handout_4;

import acm.program.ConsoleProgram;

public class AddingCommasToNumericStrings_ConsoleProgram extends ConsoleProgram{
	@Override
	public void run() {
		while (true) {
			String numStr = readLine("?");
			if(numStr.length() == 0) break;
			println(addCommasToNumericString(numStr));
		}
	}

	/**
	 * Adds comma to the string, 
	 * If the string length is more than 3 
	 * then loop from last index to first.
	 * 	and add comma at every third interval 
	 * else return the exact string
	 * */
	private String addCommasToNumericString(String numStr) {
		String newStr = "";
		int strLen = numStr.length();
		int counter = 0;
		
		if(strLen > 3) {
			for (int i = strLen-1; i >= 0; i--) {
				
				String tempChar = numStr.charAt(i)+"";
				
				counter++;
				if(counter % 3 == 0 && i != 0) {
					tempChar = ","+tempChar;
				}
				newStr = tempChar + newStr;
			}
		} else {
			newStr = numStr;
		}
		
		return newStr;
	}
}
