/**
 * RemoveAllOccurrences_ConsoleProgram.java
 * This program deletes the characters from String
 * */

package lect13._24_section_handout_4;

import acm.program.ConsoleProgram;

public class RemoveAllOccurrences_ConsoleProgram extends ConsoleProgram{
	
	public void run() {
		while(true) {
			String val = readLine("Please enter some text : \n");
			String charToRemove = "";
			if(val.length() == 0) {
				break;
			}else {
				charToRemove = readLine("Please enter a character to be remove from above text : \n");
			}
			println(removeAllOccurrences(val,charToRemove.charAt(0)));
		}
	}
	
	/**
	 * Removes the supplied character from the string, 
	 * by looping from firt to last index. and keeping 
	 * only the un-matched characters in the returned result
	 * Precon:	 NA
	 * Postcon:	 NA
	 * @param str The Text from which char will be removed
	 * @param ch The char which needs to be removed
	 * @return The result from the char is been removed
	 * @author Shailendra.Rajawat
	 * 
	 * */
	public String removeAllOccurrences(String str, char ch) {
		String newStr = "";
			for(int i = 0; i < str.length(); i++) {
				if(ch != str.charAt(i))
					newStr += str.charAt(i);
			}
		return newStr;
	}
}
