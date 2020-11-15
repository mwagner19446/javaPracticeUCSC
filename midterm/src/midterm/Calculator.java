package midterm;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException; 


/**
 * This is the solution for the midterm.  
 * The class has nine static methods and a main method.  The main method drives the execution.  
 * The nine static methods have five "function" methods-- which execution a specific function for the calculator.  They are:   
 * getUserChoice-- captures the user choice from a menu. It catches the exception of out of range integers as well as exception handling.  It requires two parameters-- an integer for the choice and a Scanner object to capture the entry.  
 * executeUserChoice-- executes one of the four operator methods below.  It requires three parameters-- the choice the user entered in the getUserChoice, the floatArray, and the Scanner object.  
 * promptFloat-- prompts the user to enter in two floats.  It has exception handling for non-floats (and recursively calls itself to force the user to re-enter).  It is used by all the operators.  It requires two parameters, the floatArray and the Scanner Object. 
 * validateDivisor- validates whether the second parameter in a float array does NOT equal zero.  If it does, it recalls the promptFloat and then recursively calls itself to validate the divisor is correct.  It requires two parameters, the floatArray and the Scanner Object.   
 * promptEnterKey-- prompts the user press the enter key.  
 * 
 * Additionally, there are four "operator" methods-- which do the calculations.  They all require two parameters-- a float array and a Scanner Object.  They are:  
 * addTwoFloats-- adds the two floats
 * subtractTwoFloats-- subtracts the second float from the first
 * multiplyTwoFloats-- multiplies both floats
 * divideTwoFloats-- divides the first float from the second.  Calls the validate divisor to ensure the divisor is never zero.  
 *  
 * The Main method will execute these and print out the results 
 * 
 * 
 * @author michael
 * @date 9/9/2020
 */

public class Calculator {
	/*
	 * The getUserChoice displays a menu for users to select an operation to run. 
	 * It provides re-prompts users for out of range selections as well as provides exception handling.  
	 * It requires two parameters an integer for choice and a Scanner object. 
	 * It returns an integer for choice, which will be consumed by the executeUserChoiceMethod.  
	 */
	
	public static int getUserChoice(int userChoice, Scanner getInput) {	 
		//Provides the choices for the user to select within the program.
		System.out.println("Welcome to Michael Wagner's Handy Calculator \n"); 
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Exit\n");
				
		//The for-loop will continue asking the user until a valid choice is received.  
		//The program will check first if the input is between 1 and 5.  This will be done through a nested if Statement.  
		//the program will then catch any exceptions occurring if the input is not an Integer. Exception handling is through the Try-Catch. 
		for(int i=0;i<=1;i++) {
		//Ask the user for their choice. 
			System.out.println("What would you like to do?");
			try {
				userChoice=getInput.nextInt(); 
				//Throw an exception if NOT between a valid choice from menu above (so between 1 and 5)		
					if(userChoice<1||userChoice>5) {
						System.out.println("You have not entered a number between 1 and 5.  Try again"); 
						i--; 
					}			
					else{
						i++; 
					}
				}
		//Throw an exception if NOT an integer 
			catch (InputMismatchException e) {
				System.out.println("You have not entered a number between 1 and 5.  Try again: "+e.getMessage());
				getInput.next(); //This clears the getInput object
				i--; 
			}
		}				
		//If the userChoice is valid return the value. 	
		return userChoice; 
	}

	/*
	 * The executeUserChoice receives three parameters:  the User choice for which operation to run, a float array, and a Scanner Object. 
	 * Within the program, the user choice is selected in the getUserChoice method.  
	 * The method uses a switch since the options are discrete and mutually exclusive. (Addition, Subtraction, Multiplication, and Division) 
	 * It executes methods to capture the floats (promptFloat) as well as perform the calculations for each (ie: addTwoFloats, subtractTwoFloats, etc). 
	 * It does not return any values, but does print out the results of the calculation.  
	*/
	public static void executeUserChoice(int userChoice, float[] floatArray, Scanner getInput) {
		switch(userChoice) {
		case 1: //Addition Flow.  Executes the addTwoFloats method in the print statement. 
			System.out.println("Please enter two floats to add, separated by a space: "); 
			promptFloat(floatArray, getInput); 
			System.out.printf("Result of adding %.2f and %.2f is %.2f \n", floatArray[0], floatArray[1], addTwoFloats(floatArray));
			break; 
		case 2: //Subtraction Flow.  Executes the subtractTwoFloats method in the print statement.
			System.out.println("Please enter two floats to subtract, separated by a space: ");
			promptFloat(floatArray, getInput);		
			System.out.printf("Result of subtracting %.2f from %.2f is %.2f \n", floatArray[1], floatArray[0], subtractTwoFloats(floatArray));
			break; 
		case 3: //Multiplication Flow.  Executes the multiplyTwoFloats method in the print statement.
			System.out.println("Please enter two floats to multiply, separated by a space: ");
			promptFloat(floatArray, getInput); 
			System.out.printf("Result of multiplying %.2f by %.2f is %.2f \n", floatArray[0], floatArray[1], multiplyTwoFloats(floatArray));
			break; 
		case 4: //Division Flow.  Executes the divideTwoFloats method in the print statement.
			System.out.println("Please enter two floats to divide, separated by a space: ");
			promptFloat(floatArray, getInput);
			validateDivisor(floatArray, getInput); 
			System.out.printf("Result of dividing %.2f by %.2f is %.2f \n", floatArray[0], floatArray[1], divideTwoFloats(floatArray));
			break; 
		}
	}
	
	/*
	 * The promptFloat method allows the user to enter two floats.  
	 * If the user does not enter in two floats, it throws an exception, and uses a recursive statement for the user to re-enter both floats again. 
	 * It requires two parameters-- a float array and a Scanner object.  
	 * It returns the modified floatArray to be consumed within the executeUserChoice method.  
	 */
	
	public static float[] promptFloat(float[] floatArray, Scanner getInput) {
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

	public static float[] validateDivisor(float[] floatArray, Scanner getInput) {
		if(floatArray[1]==0) {//Only executes if the divisor is zero. Critical to avoid unlimited recursion. 
			System.out.println("You can't divide by zero please re-enter both floats: "); 
			promptFloat(floatArray, getInput); //calls promptFloat for the user to re-enter
			validateDivisor(floatArray, getInput); //recursively calls its itself to validate the divisor is correct.  
		} 
		return floatArray; 
	}
	
	/*
	 * The promptEnterKey validates the user enters in the enter key. 
	 * If the user does not, it throws an error.  
	 */
	
	public static void promptEnterKey() {
		System.out.println("Press enter to continue .... \n"); 
		try {
			int read=System.in.read(new byte[2]); 
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * The addTwoFloats method adds the value of two floats.  
	 * It requires one parameter-- a floatArray object, and returns a float of the two values added
	 */
	public static float addTwoFloats(float[] floatArray) { 
		float result = floatArray[0]+floatArray[1]; 
		return result; 
	} 
	/*
	 * The subtractTwoFloats method subtracts the value of two floats.  
	 * It requires one parameter-- a floatArray object, and returns a float of the second value subtracted from the first. 
	 */
	public static float subtractTwoFloats(float[] floatArray) {
		float result = floatArray[0]-floatArray[1]; 
		return result;
	}
	
	/*
	 * The multiplyTwoFloats method multiplies the value of two floats.  
	 * It requires one parameter-- a floatArray object, and returns a float of the two values multiplied together. 
	 */
	public static float multiplyTwoFloats(float[] floatArray) {
		float result = floatArray[0]*floatArray[1]; 
		return result;
	}
	
	/*
	 * The divideTwoFloats method adds the value of two floats.  
	 * It requires one parameter-- a floatArray object, and returns a float of the the first value divided by the second value.  
	 */
	public static float divideTwoFloats(float[] floatArray) {
		float result = floatArray[0]/floatArray[1]; 
		return result;
	}
	
	public static void main(String[] args) {
		Scanner getInput=new Scanner(System.in);  //Scanner object to capture the user input. 
		int userChoice=0; //choice for the user to select within the menu
		float[] floatArray=new float[2]; //float array to capture the values

		while (userChoice!=5) {//The value of 5 is the exit choice for the program.  As long as this value does not equal 5, the program should execute.  
			userChoice=getUserChoice(userChoice, getInput); //captures the userChoice for what operation to run in the program. Explicitly set to the variable due to scoping.   
			if(userChoice==5) { 
				System.out.println("Thank you for using Michael Wagner's Handy Calculator"); //displays a message thanking them for using.  
				}	
			else {
				executeUserChoice(userChoice, floatArray, getInput); //executes the operation against the user's choice.  
				promptEnterKey(); //prompts the user to continue
				}
			}
		}
	}
