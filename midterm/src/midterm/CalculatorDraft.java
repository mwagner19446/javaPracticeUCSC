package midterm;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException; 

//Next Step:  Decompose to "Get User Choice" and Execute User Choice"
//Next Step:  Need to add invalid choice for floats in functions-- asking them to re-add. Work on the promptFloat function 
//Next Step:  Why does this only run twice? I is incrementing
public class CalculatorDraft {

	public static int getUserChoice(int choice, Scanner getInput) {	 
		//Provides the choices for the user to select within the program.
		System.out.println("Welcome to Michael Wagner's Handy Calculator \n"); 
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Exit\n");
				
		//The for-loop will continue asking the user until a valid choice is recieved.  
		//The program will check first if the input is between 1 and 5.  This will be done through a nested if Statement.  
		//the program will then catch any exceptions occurring if the input is not an Integer. Exception handling is through the Try-Catch. 
		for(int i=0;i<=1;i++) {
		//Ask the user for their choice. 
			System.out.println("What would you like to do?");
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

	public static void executeUserChoice(int choice, float[] floatArray, Scanner getInput) {
		if(choice==1) {
			System.out.println("Please enter two floats to add, separated by a space: ");
			promptFloat(floatArray, getInput); 
			System.out.printf("Result of adding %.2f and %.2f is %.2f \n", floatArray[0], floatArray[1], addTwoFloats(floatArray[0], floatArray[1])); 
	 
		}
		if(choice==2) {
			System.out.println("Please enter two floats to subtract, separated by a space: ");
			promptFloat(floatArray, getInput);
			
			System.out.printf("Result of subtracting %.2f from %.2f is %.2f \n", floatArray[1], floatArray[0], subtractTwoFloats(floatArray[0], floatArray[1])); 
		}
		if(choice==3) {
			System.out.println("Please enter two floats to multiply, separated by a space: ");
			promptFloat(floatArray, getInput); 
			
			System.out.printf("Result of multiplying %.2f by %.2f is %.2f \n", floatArray[0], floatArray[1], multiplyTwoFloats(floatArray[0], floatArray[1])); 					
		}
		if(choice==4) {
			System.out.println("Please enter two floats to divide, separated by a space: ");
			
			promptFloat(floatArray, getInput);
			validateDivisor(floatArray, getInput); 
			
			System.out.printf("Result of dividing %.2f by %.2f is %.2f \n", floatArray[0], floatArray[1], divideTwoFloats(floatArray[0], floatArray[1]));
		}
		if(choice==5) {
			System.out.println("Thank you for using Michael Wagner's Handy Calculator"); 
		}
	}
	
	public static float[] promptFloat(float[] floatArray, Scanner getInput) {
		for (int i=0;i<floatArray.length;i++) {
			try {
				floatArray[i]=getInput.nextFloat();
			}
			catch(InputMismatchException e) {
				System.out.println("You have entered invalid floats please re-enter: "); 
				getInput.next();// This clears getInput holder; allowing the user to enter in something new
				i--; 
			}
		}
		return floatArray; 
	}
	

	public static float[] validateDivisor(float[] floatArray, Scanner getInput) {
		if(floatArray[1]==0) {
			System.out.println("You can't divide by zero please re-enter both floats: "); 
			promptFloat(floatArray, getInput); 
		} 
		return floatArray; 
	}
	
	public static void promptEnterKey() {
		System.out.println("Please press enter to continue \n"); 
		try {
			int read=System.in.read(new byte[2]); 
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static float addTwoFloats(float float1, float float2) { 
		float result = float1+float2; 
		return result; 
	} 
	
	public static float subtractTwoFloats(float float1, float float2) {
		float result = float1-float2; 
		return result;
	}
	
	public static float multiplyTwoFloats(float float1, float float2) {
		float result = float1*float2; 
		return result;
	}
	
	public static float divideTwoFloats(float float1, float float2) {
		float result = float1/float2; 
		return result;
	}
	
	public static void main(String[] args) {
		Scanner getInput=new Scanner(System.in); 
		int choice=0;
		float[] floatArray=new float[2]; 

		choice=getUserChoice(choice, getInput);
		System.out.printf("Debug: Choice = %d\n", choice); 
		executeUserChoice(choice, floatArray, getInput); 
		System.out.printf("Debug: Choice = %d\n", choice);
	/*	
		for(int i=0; i<=1; i++) {
			System.out.println("Welcome to Michael Wagner's Handy Calculator \n"); 
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Exit\n");
			
			System.out.println("What would you like to do?");

			try {
				selection = getInput.nextInt();
				if(selection<1||selection>5) {
					System.out.println("You have entered an invalid choice, please re-enter your choice: "); 
					i--; 
				}
				if(selection==1) {
					System.out.println("Please enter two floats to add, separated by a space: ");
				
					//float1=getInput.nextFloat(); 
					//float2=getInput.nextFloat();
					
					//float1=promptFloat();
					//float2=promptFloat();
					floatArray=promptFloat(floatArray, getInput); 
					
					System.out.printf("Result of adding %.2f and %.2f is %.2f \n", floatArray[0], floatArray[1], addTwoFloats(floatArray[0], floatArray[1])); 
			 
				}
				if(selection==2) {
					System.out.println("Please enter two floats to subtract, separated by a space: ");
					float1=getInput.nextFloat(); 
					float2=getInput.nextFloat(); 
					
					System.out.printf("Result of subtracting %.2f from %.2f is %.2f \n", float2, float1, subtractTwoFloats(float1, float2)); 
				}
				if(selection==3) {
					System.out.println("Please enter two floats to multiply, separated by a space: ");
					float1=getInput.nextFloat(); 
					float2=getInput.nextFloat(); 
					
					System.out.printf("Result of multiplying %.2f by %.2f is %.2f \n", float1, float2, multiplyTwoFloats(float1, float2)); 					
				}
				if(selection==4) {
					System.out.println("Please enter two floats to divide, separated by a space: ");
					//float1=getInput.nextFloat(); 
					//float2=getInput.nextFloat(); 
					
					promptFloat(floatArray, getInput);
					validateDivisor(floatArray, getInput); 
					
					System.out.printf("Result of dividing %.2f by %.2f is %.2f \n", floatArray[0], floatArray[1], divideTwoFloats(floatArray[0], floatArray[1]));
				}
				if(selection==5) {
					System.out.println("Thank you for using Michael Wagner's Handy Calculator");
					i--; 
				}
				else {
					i++; 
				}
			}
			catch(InputMismatchException e){
				System.out.println("You have entered an invalid choice, please re-enter your choice: "); 
				getInput.next();// This clears getInput holder; allowing the user to enter in something new 
				i--;
			}
		*/	
			promptEnterKey(); 	
		//	i--; 
		}
	}

