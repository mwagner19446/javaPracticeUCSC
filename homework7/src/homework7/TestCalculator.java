package homework7;

/**
 * This is a solution for HW#7
 * There are two classes that interact: 
 * The OOPCalculator creates the OOPCalculator object.  
 * The TestCalculator instantiates the OOPCalculator object and drives through the functionality.  
 *
 * Within the TestCalculator main method: 
 * The OOPCalculator object is instantiated
 * While the OOPCalculator.runCalc boolean is true, the calculator menu will prompt the user.  If the user selects the exit option, this boolean will switch to false and the calculator menu will not prompt. 
 * Three actions are prompted:
 * A) The user is prompted for their menu choice.  This is what operation they'd like to perform
 * B) The program executes their choice by prompting them for values and then performing the calculation
 * C) The program prompts them to press the enter key to continue.  
 * 
 * @author michael
 * @date 9/25/2020
 */

public class TestCalculator {
	public static void main (String[] args) {
		
		OOPCalculator calc= new OOPCalculator(); 
		
		do {
			calc.getUserChoice(); //captures the user choice from the menu
			calc.executeUserChoice(); //executes the operation against the user's choice.  
			calc.promptEnterKey(); //prompts the user to continue 
		}
		while(calc.runCalc==true);
		{
			System.out.print("Have a nice day!");
		}
	}
}
