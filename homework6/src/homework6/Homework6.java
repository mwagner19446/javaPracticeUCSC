package homework6;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;



/**
 * This is a solution for HW#6
 * The class has three static methods and a main method. 
 * The getUserChoice static method captures the user choice for a menu.  It requires parameters an integer for choice and a Scanner object. 
 * The getTwoFloats static method captures two floats.  It requires parameters for a float array with two elements and a Scanner object. 
 * The promptEnterkey static method prompts the user to enter the enter key and throws an exception if they do not.  (This will be used in the midterm)
 * 
 * The Main method will execute these and print out the results 
 * 
 * DESIGN NOTE: For the getTwoFloats
 * If the user enters a string and a float, I struggled with how to make the next entry stateless. 
 * I debated using the collections library to delete the element, however I used a recursive statement instead.  
 * 
 * 
 * @author michael
 * @date 9/9/2020
 */

public class Homework6 {
	
	/*The getUserChoice method recieves an integer and a Scanner object.  
	 * It returns an integer. 
	 * It prompts the user to enter an integer and returns an error if the integer is not in the correct range or if there is an exception. 
	*/
	public static int getUserChoice(int choice, Scanner getInput) {	 
		//Provides the choices for the user to select within the program.
		System.out.println("Welcome to sorting program"); 
		System.out.println("1. Title"); 
		System.out.println("2. Rank");
		System.out.println("3. Date");
		System.out.println("4. Stars");
		System.out.println("5. Likes");
		
		
		//The for-loop will continue asking the user until a valid choice is recieved.  
		//The program will check first if the input is between 1 and 5.  This will be done through a nested if Statement.  
		//the program will then catch any exceptions occurring if the input is not an Integer. Exception handling is through the Try-Catch. 
		for(int i=0;i<=1;i++) {
		//Ask the user for their choice. 
			System.out.println("Enter your choice between 1 and 5 only: ");
			try {
				choice=getInput.nextInt(); 
				//Throw an exception if NOT between a valid choice from menu above (so between 1 and 5)		
					if(choice<1||choice>5) {
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
		//If the choice is valid return the value. 	
		return choice; 
	}

	/*The getTwoFloats method recieves a float array and a Scanner object.  
	 * It returns a modified float array. 
	 * It prompts the user to enter in two floats and throws an exception if no float is provided.  
	 * This is done via a "Try-Catch"
	*/
	public static float[] getTwoFloats(float[] floatArray, Scanner getInput) {
		int error=0;// tracks the number of errors with the array.  Ensures the recursive statement of getTwoFloats is only executed once. 
			//Provides the choices for the user to select within the program.
			System.out.println("Welcome to the get two floats program");
			System.out.println("Enter two floats separated by a space: "); 
			//For-loop iterates through the Float Array and throws an exception if not a float.  
			for(int i=0;i<floatArray.length;i++) {
				try{
					floatArray[i]=getInput.nextFloat();
				}
				catch(InputMismatchException e){
					System.out.println("You have entered an invalid input.  Try again");
					getInput.next(); //Clear out the input
					error++; 
				}
			}
			if (error>0)// If there were errors; re-executes the getTwoFloats Recursively
				getTwoFloats(floatArray, getInput); //recursion
			return floatArray; //Returns the float array if there were no issues. 
	}
	/*
	 * The promptEnterKey static method prompts the user to enter to continue and throws an error if they do not.  
	 */
	
	public static void promptEnterKey() {
		System.out.println("Please press enter to continue \n"); 
		try {
			int read=System.in.read(new byte[2]); 
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
		
	//The Main method executes the three static methods. 
	public static void main(String[] args) {
		int choice=0;//This stores the choice the user makes from the Menu.  The selections would be 1 through 5.
		float[] floatArray= new float[2]; //Float Array for the getTwoFloats
		Scanner getInput=new Scanner(System.in); //Scanner object to capture the user input in both programs
		
		//Executes and prints the menu choice
		getUserChoice(choice, getInput);
		System.out.printf("You entered valid choice: %d \n", choice);
		System.out.println("Thank you for giving your choice\n");
		
		
		//Executes and prints the get two floats
		getTwoFloats(floatArray, getInput); 
		System.out.printf("You have entered %.2f and %.2f successfully! \n", floatArray[0],floatArray[1]);
		
		//Prompts the user to press enter.
		promptEnterKey();

	}
}
