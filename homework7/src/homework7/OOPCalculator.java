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
 *  @author michael
 *  @date 9/25/20
 *  
**/

public class OOPCalculator {
	
	public boolean runCalc=true; //Public boolean to drive whether the calc should continue to run
	private String userChoice; //choice for the user to select within the menu
	private String validChoice = "12345aAsSmMdDxX";  //valid choices from the menu
	private float[] floatArray; //float array to capture the values
	private Scanner getInput; //Scanner object to capture inputs
	
	/*
	 * The constructor class creates the OOPCalculator Object.  
	 * It does not require any parameters, but does instantiate the userChoice value, a floatArray to capture details, as well as Scanner object. 
	 *
	 * @param NONE
	 */	
	public OOPCalculator() {
		userChoice="0"; //choice for the user to select within the menu
		floatArray=new float[2]; //float array to capture the values
		getInput=new Scanner(System.in);
	}; 
	
	/*
	 * Short description: The printMenu Function prints out the options for the user to select. 
	 * <p>
	 * Long description: The printMenu method prints out the options for the user to select.  
	 * It is referenced by: {@link #getUserChoice} method. 
	 * It references: No other methods.  
	 * <p>
	 * @param NONE
	 * @return NONE.  Static method. 
	 */	
	private static void printMenu() {
		//Provides the choices for the user to select within the program.
		System.out.println("Welcome to Michael Wagner's Handy Calculator\n"); 
		System.out.println("1. Addition (1 or A)");
		System.out.println("2. Subtraction (2 or S)");
		System.out.println("3. Multiplication (3 or M)");
		System.out.println("4. Division (4 or D)");
		System.out.println("5. Exit (5 or X)\n");
	}

	/*
	 * Short description: The getUserChoice method captures the operation to be executed. 
	 * <p>
	 * Long description: The getUserChoice method captures the operation to be executed.
	 * It provides re-prompts users for out of range selections.  
	 * <p>
	 * It is referenced by: No other methods.  
	 * It references: {@link #printMenu} method  
	 * <p>
	 * @param NONE.  (Accesses the object attribute for userChoice and Scanner object)
	 * @return NONE.  (Static method.  Updates the class value for userChoice directly) 
	 */
	public void getUserChoice() {	 
		boolean tryAgain=false; //instantiated as false; loop below will execute again if switched to true. 
		//Ask the user for their choice. 
		do {
			printMenu(); //Prints the menu
			System.out.println("What would you like to do?");
			userChoice=getInput.nextLine(); 
			//Throw an exception if NOT between a valid choice from the validChoice String (so containing these values: 12345aAsSmMdDxX)		 
			if(!validChoice.contains(userChoice)) {
				System.out.println("You have not entered a valid entry. \n");
				System.out.println("Press enter to continue .... \n");
				tryAgain=true;
				getInput.nextLine();//clean the buffer 
				}
			else {
				tryAgain=false; 
				}
		}
		while(tryAgain); //executes if true
	}

	/*
	 * Short description: The executeUserChoice method executes the mathematical operation.  
	 * <p>
	 * Long description: The executeUserChoice method executes the mathematical operation.
	 * It uses a switch statement since there are a discrete number of options that are mutually exclusive (Addition, Subtraction, Multiplication, and Division)
	 * It also updates the updateRunCalc method to update the runCalc boolean if an option to exit was selected.
	 * <p>
	 * It is referenced by: No other methods.  
	 * It references: {@link #updateRunCalc} method  
	 * <p>
	 * @param NONE.  (Accesses the object attribute for userChoice and Scanner object)
	 * @return NONE.  (Static method.  Prints out the results) 
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
	}

	/*
	 * Short description: The promptEnterKey validates the user enters in the enter key. If the user does not, it throws an error.  
	 * <p>
	 * It is referenced by: No other methods.  
	 * It references: No other methods.  
	 * <p>
	 * @param NONE.  
	 * @return NONE.   
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
	 * 
	 * It is referenced by: {@link #executeUserChoice} method
	 * It references:  NONE
	 *
	 * @param:  userChoice 
	 * @return:  NONE (Static method.  Updates the runCalc boolean)
	 */
	
	private void updateRunCalc(String userChoice) {
		if (userChoice.equals("5")||userChoice.equals("x")||userChoice.equals("X"))
			runCalc=false; 
	}; 
	
	
	/*
	 * Short description: The promptFloat method allows the user to enter two floats.   
	 * <p>
	 * Long description: The promptFloat method allows the user to enter two floats, validating correct entry.   
	 * If the user does not enter in two floats, it throws an exception, and uses a recursive statement for the user to re-enter both floats again.
	 * <p>
	 * It is referenced by: {@link #executeUserChoice} as well as the {@link #validateDivisor} (within error path)  
	 * It references: NONE
	 * <p>
	 * @param floatArray:	A two entry array of floats. 
	 * @param getInput: 	A scanner object  	
	 * @return floatArray:  Modified within the method. 
	 */		
	private float[] promptFloat(float[] floatArray, Scanner getInput) {
		boolean tryAgain=true; //instantiated as true; exit path requires false.  
		do {
			if(getInput.hasNextFloat()) {
				floatArray[0] = getInput.nextFloat();
				if(getInput.hasNextFloat()) {
					floatArray[1] = getInput.nextFloat();
					tryAgain=false; //set to false, ensures exit path.  
					}
				else {
					System.out.println("You have entered invalid floats please re-enter: ");
					}	
				}
			else{
				System.out.println("You have entered invalid floats please re-enter: ");
			}
		getInput.nextLine();//clear the buffer	
		}
		while (tryAgain); // will re-execute if tryAgain not switched to false. 
		return floatArray; 
	}
	
	
	
	/*
	 * Short description: The validateDivisor method validates whether the divisor is 0.    
	 * <p>
	 * Long description: The validateDivisor method is only used within the divisor operations. 
	 * It checks whether the divisor is 0, and if it is, it displays a message and prompts the user to re-enter both floats.  
	 * It calls the promptFloatArray to have the user re-enter, and then call itself re-cursively validate.
	 * <p>
	 * It is referenced by: {@link #executeUserChoice} method (within the Division path)   
	 * It references: {@link #promptFloat} method
	 * <p>
	 * @param floatArray:	A two entry array of floats. 
	 * @param getInput: 	A scanner object  	
	 * @return floatArray:  Modified within the method. 
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
