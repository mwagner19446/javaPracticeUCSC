package homework5;
import java.util.Scanner; 
import java.util.InputMismatchException; 

/**
 * This is a solution for HW#5
 * The class displays a prompt asking the user to enter two floats. 
 * If the user does not enter a float for both the values an error will be generated.  
 * 
 * NOTE:  If the user enters a string and a float, the method will iterate over the string.  
 * There doesn't seem to be a way to make this stateless without using the collections library, which I've avoided for now. 
 * The approach I've provided does match up with the example (failure if there are two non-floats)-- although not nessesarily with the spirit of the requirement. 
 *  
 * @author michael
 * @date 9/7/2020
 *
 */

public class TwoFloatPrompt {
	
	public static void main(String[] args){
	float[] floatArray= new float[2]; //Creates an array of float; with two empty elements.  
	Scanner getInput=new Scanner(System.in); //Creates a Scanner object to capture the user input. 
	
	//System Request Two Floats
	System.out.println("Welcome to the get two floats program");
	System.out.println("Enter two floats separated by a space: "); 
	//The for-loop iterates through the floatArray to capture the answers.  Exception Handling for non Floats-- Float 1
	for(int i=0;i<floatArray.length;i++) {
		try{
			floatArray[i]=getInput.nextFloat();
		}
		catch(InputMismatchException e){
			System.out.println("You have entered an invalid input.  Try again");
			getInput.next(); //Clear out the input
			i--; 
		}
	}
	System.out.printf("You have entered two valid floats: %.2f and %.2f\n", floatArray[0],floatArray[1]);	
	}
}
