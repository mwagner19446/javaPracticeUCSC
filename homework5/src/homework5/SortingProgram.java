package homework5;
import java.util.Scanner; 
import java.util.InputMismatchException; 

/**
 * 
 * This is a solution for HW#5
 * The class displays a menu with five options numbered 1-5 and asks the user to select an option.  
 * The requirements: 
 * 1) If choice is between 1 and 5, thank the use for their choice
 * 2) If choice is less than 1, ask them to enter again
 * 3) If choice is more than 5, ask them to enter again
 * 4) If the choice is NOT an integer, ask them to enter again.  
 * 
 * @author michael
 * @date	9/7/2020
 *
 */

public class SortingProgram {
	static int choice; //This stores the choice the user makes from the Menu.  The selections would be 1 through 5.
	
	public static void main(String[] args){
		
		Scanner getInput=new Scanner(System.in); //Create scanner object to capture the input from the console. 
		
		//The System Outputs welcome the user to the program and share the menu
		System.out.println("Welcome to sorting program"); 
		System.out.println("1. Title"); 
		System.out.println("2. Rank");
		System.out.println("3. Date");
		System.out.println("4. Stars");
		System.out.println("5. Likes");
		
		/*The 'for' loop will continue asking the user until they recieve a valid answer.
		 * The program will check first if the input is between 1 and 5.  (Reqs 2 and 3 above)
		 * The program will then catch any exceptions occurring if the input is not an Integer (Req 4 above) 
		 * 
		 */
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
		//If the choice is valid, thank the user and display back their choice. 
		System.out.printf("You entered valid choice: %d \n", choice);
		System.out.println("Thank you for giving your choice");	
	}
}
