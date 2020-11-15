package homework7;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * This is a solution for HW#7
 * There are two classes that interact: 
 * The OOPCalculator creates the OOPCalculator object.  
 * The TestCalculator instantiates the OOPCalculator object and drives through the functionality.  
 * 
 * Within the OOPCalculator Class: 
 * The constructor class creates an object with three attributes:  a string representing userChoice (default to "0"), a scanner object, and an empty Float Array.  
 * There are three public class methods to execute functionality.  These are used by the TestCalculator main method.  They are the getUserChoice, executeUserChoice, promptEnterKey.  
 * There are seven private class methods that are used internally.  These are to either A) execute the operations of the calculator (updateRunCalc, promptFloat, validateDivisor) or B) execute tasks within the program (addTwoFloats, subtractTwoFloats, multiplyTwoFloats, divideTwoFloats).   
 *  
**/

public class OOPCalculator {
	
	public boolean runCalc=true; //Public boolean to drive whether the calc should continue to run
	private String userChoice; //choice for the user to select within the menu
	private String validChoice = "12345aAsSmMdDxX";  //valid choices from the menu
	private float[] floatArray; //float array to capture the values
	private Scanner getInput; //Scanner object to capture inputs
	
	/*
	 * The constructor class does not require any parameters, but does instantiate the userChoice value, a floatArray to capture details, as well as Scanner object. 
	 */	
	public OOPCalculator() {
		userChoice="0"; //choice for the user to select within the menu
		floatArray=new float[2]; //float array to capture the values
		getInput=new Scanner(System.in);
	}; 
	
	/*
	 * The getUserChoice class method displays a menu for users to select an operation to run. 
	 * It provides re-prompts users for out of range selections as well as provides exception handling.  
	 * It requires no parameters, but will access the object attribute for userChoice and Scanner object.   
	 * It doesn't return any value, rather it updates the class value for userChoice directly.  
	 */
	public void getUserChoice() {	 
		boolean rePromptUserChoice=false; 
		//Provides the choices for the user to select within the program.
		System.out.println("Welcome to Michael Wagner's Handy Calculator\n"); 
		System.out.println("1. Addition (1 or A)");
		System.out.println("2. Subtraction (2 or S)");
		System.out.println("3. Multiplication (3 or M)");
		System.out.println("4. Division (4 or D)");
		System.out.println("5. Exit (5 or X)\n");
				
		//Ask the user for their choice. 
		
		do {
			System.out.println("What would you like to do?");
			userChoice=getInput.nextLine(); 
			//Throw an exception if NOT between a valid choice from the validChoice String (so containing these values: 12345aAsSmMdDxX)		 
			if(!validChoice.contains(userChoice)) {
				System.out.println("You have not entered a valid entry.  Try again"); 
				getInput.nextLine();//clean the buffer 
				}
				else {
					rePromptUserChoice=true; 
				}
		}
		while(rePromptUserChoice);
		
		/*
		//The for-loop will continue asking the user until a valid choice is received.  
		for(int i=0;i<=1;i++) {
			userChoice=getInput.nextLine(); 
			//Throw an exception if NOT between a valid choice from the validChoice String (so containing these values: 12345aAsSmMdDxX)		 
				if(!validChoice.contains(userChoice)) {
					System.out.println("You have not entered a valid entry.  Try again"); 
					getInput.nextLine();//clean the buffer
					i--; 
				}
				else {
					i++;
				}
			}
  */
		}

	/*
	 * The executeUserChoice method doesn't require any parameters, it access the class values for userChoice and the Scanner Object.  It updates the class values for floatArray. 
	 * The executeUserChoice method calls the updateRunCalc method to update the runCalc boolean if an option to exit was selected. 
	 * The executeUserChoice method uses a switch since the options are discrete and mutually exclusive. (Addition, Subtraction, Multiplication, and Division) 
	 * It executes methods to capture the floats (promptFloat) as well as perform the calculations for each (ie: addTwoFloats, subtractTwoFloats, etc). 
	 * It does not return any values, but does print out the results of the calculation.  
	*/
	public void executeUserChoice() {
		updateRunCalc(userChoice); /// Updating the status for run
		switch(userChoice) {
		case "a":
		case "A":
		case "1": //Addition Flow.  Executes the addTwoFloats method in the print statement. 
			System.out.println("Please enter two floats to add, separated by a space: "); 
			promptFloat(floatArray, getInput); 
			System.out.printf("Result of adding %.2f and %.2f is %.2f \n", floatArray[0], floatArray[1], addTwoFloats(floatArray));
			break; 
		case "s":
		case "S":
		case "2": //Subtraction Flow.  Executes the subtractTwoFloats method in the print statement.
			System.out.println("Please enter two floats to subtract, separated by a space: ");
			promptFloat(floatArray, getInput);		
			System.out.printf("Result of subtracting %.2f from %.2f is %.2f \n", floatArray[1], floatArray[0], subtractTwoFloats(floatArray));
			break; 
		case "m":
		case "M":
		case "3": //Multiplication Flow.  Executes the multiplyTwoFloats method in the print statement.
			System.out.println("Please enter two floats to multiply, separated by a space: ");
			promptFloat(floatArray, getInput); 
			System.out.printf("Result of multiplying %.2f by %.2f is %.2f \n", floatArray[0], floatArray[1], multiplyTwoFloats(floatArray));
			break; 
		case "d":
		case "D":
		case "4": //Division Flow.  Executes the divideTwoFloats method in the print statement.
			System.out.println("Please enter two floats to divide, separated by a space: ");
			promptFloat(floatArray, getInput);
			validateDivisor(floatArray, getInput); 
			System.out.printf("Result of dividing %.2f by %.2f is %.2f \n", floatArray[0], floatArray[1], divideTwoFloats(floatArray));
			break; 
		case "x":
		case "X":
		case "5": //Exit Flow
			System.out.println("Thank you for using Michael Wagner's Handy Calculator"); //displays a message thanking them for using.
			break;	
		}
		getInput.nextLine();//clean the buffer
	}

	/*
	 * The promptEnterKey validates the user enters in the enter key. 
	 * If the user does not, it throws an error.  
	 */
	
	public void promptEnterKey() {
		System.out.println("Press enter to continue .... \n"); 
		try {
			int read=System.in.read(new byte[2]); 
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * The updateRunCalc sets the boolean for runCalc to false if one of the userChoices is either 5,x, or X.  
	 * These choices represent the exit flow for the user.  
	 */
	
	private void updateRunCalc(String userChoice) {
		if (userChoice.equals("5")||userChoice.equals("x")||userChoice.equals("X"))
			runCalc=false; 
	}; 
	
	
	/*
	 * The promptFloat method allows the user to enter two floats.  
	 * If the user does not enter in two floats, it throws an exception, and uses a recursive statement for the user to re-enter both floats again. 
	 * It requires two parameters-- a float array and a Scanner object.  
	 * It returns the modified floatArray to be consumed within the executeUserChoice method.  
	 */
	
	private float[] promptFloat(float[] floatArray, Scanner getInput) {
		int errorCount=0; //tracks the number of errors within the iteration
		for (int i=0;i<floatArray.length;i++) {
			try {
				floatArray[i]=getInput.nextFloat();
			}
			catch(InputMismatchException e) {
				System.out.println("You have entered invalid floats please re-enter: "); 
				getInput.next();// This clears getInput holder; allowing the user to enter in something new
				errorCount++; //increments the number of errors
			}	
		}
		if (errorCount>0) //this ensures that the promptFloat is only re-executed once, even in the scenario of multiple errors
			promptFloat(floatArray, getInput); //Recursively calls itself only if in error state.  If not, the array is returned.  
		return floatArray; 
	}
	
	/*
	 * The validateDivisor method is only used within the divisor operations. 
	 * It checks whether the divisor is 0, and if it is, it displays a message and prompts the user to re-enter both floats.  
	 * It calls the promptFloatArray to have the user re-enter, and then call itself re-cursively validate.
	 * It requires two parameters, the floatArray and the Scanner Object. 
	 * It returns the floatArray 
	 */

	private float[] validateDivisor(float[] floatArray, Scanner getInput) {
		if(floatArray[1]==0) {//Only executes if the divisor is zero. Critical to avoid unlimited recursion. 
			System.out.println("You can't divide by zero please re-enter both floats: "); 
			promptFloat(floatArray, getInput); //calls promptFloat for the user to re-enter
			validateDivisor(floatArray, getInput); //recursively calls its itself to validate the divisor is correct.  
		} 
		return floatArray; 
	}
	

	
	/*
	 * The addTwoFloats method adds the value of two floats.  
	 * It requires one parameter-- a floatArray object, and returns a float of the two values added
	 */
	private float addTwoFloats(float[] floatArray) { 
		float result = floatArray[0]+floatArray[1]; 
		return result; 
	} 
	/*
	 * The subtractTwoFloats method subtracts the value of two floats.  
	 * It requires one parameter-- a floatArray object, and returns a float of the second value subtracted from the first. 
	 */
	private float subtractTwoFloats(float[] floatArray) {
		float result = floatArray[0]-floatArray[1]; 
		return result;
	}
	
	/*
	 * The multiplyTwoFloats method multiplies the value of two floats.  
	 * It requires one parameter-- a floatArray object, and returns a float of the two values multiplied together. 
	 */
	private float multiplyTwoFloats(float[] floatArray) {
		float result = floatArray[0]*floatArray[1]; 
		return result;
	}
	
	/*
	 * The divideTwoFloats method adds the value of two floats.  
	 * It requires one parameter-- a floatArray object, and returns a float of the the first value divided by the second value.  
	 */
	private float divideTwoFloats(float[] floatArray) {
		float result = floatArray[0]/floatArray[1]; 
		return result;
	}	
}
