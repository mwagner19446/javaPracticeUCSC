package homework5;
import java.util.Scanner; 
import java.util.InputMismatchException; 

/**
 * This is a solution for HW#5
 * The class displays a prompt asking the user to enter two floats. 
 * If the user does not enter a float for both the values an error will be generated.  
 * 
 * Additional requirements: <--We dont' have this yet. 
 * Though not explicit, it is implied that that the entries should be stateless.  
 * That is, if a user enters a valid float for their first entry and not the second entry, the entire submission shoudl be cleared.  
 * 
 * @author michael
 * @date 9/7/2020
 *
 */

public class TwoFloatPromptDraft {
	public static float float1;  
	public static float float2;
	
	public static void main(String[] args){
	//float[] floatArray= new float[2]; //Creates an array of float; with two empty elements. 
 
	Scanner getInput=new Scanner(System.in); //Creates a Scanner object to capture the user input. 
	
	//System Request Two Floats
	System.out.println("Welcome to the get two floats program");
	System.out.println("Enter two floats separated by a space: "); 
	//The for-loop iterates through the floatArray to capture the answers.  Exception Handling for non Floats-- Float 1
/*
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
*/
	
	try{
		float1=getInput.nextFloat();
	}
	catch(InputMismatchException e){
		System.out.println("You have entered an invalid input.  Try again");
		getInput.next(); //Clear out the input
	}
	//Exception Handling for non Floats-- Float 2
	try{
		float2=getInput.nextFloat();
	}
	catch(InputMismatchException e){
		System.out.println("You have entered an invalid input.  Try again");
		getInput.next(); //Clear out the input
	} 
	//float2=getInput.nextFloat();	
	System.out.printf("You have entered two valid floats: %.2f and %.2f\n", float1, float2); 	
	}
}
