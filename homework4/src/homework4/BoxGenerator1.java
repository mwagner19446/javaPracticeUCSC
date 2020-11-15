package homework4;
import java.util.Scanner; 

/**
 * This is a solution for Homework#4 
 * 
 * 	To make it easier to read, the requirements for BoxLoop have been broken into three different classes: 
 * 	BoxGenerator1:  4.2, 4.5, and 4.6.  
 *  4.2:  Use a while loop
 *  4.5:  Ask the user for height, width and characters
 *  4.6:  Ask the user to continue
 *  
 * @author michael
 *
 */

public class BoxGenerator1 {
	
	public static void main(String[] args){
		int h,v,i,j; 	//h and v are the lengths of the length and the vertical of the box, respectively.  The user will enter these values in the initial prompt.  i and j are the iterators used.  	
		char hVal='-';  //By Default the value is '-'.  The user will be asked to modify. 
		char vVal='|';  //By Default the value is '|'.  The user will be asked to modify. 
		char cont='y'; //By Default, the value is 'y'.  If the user does not want to continue, they will enter something else, exiting the program.
		
		Scanner readInput=new Scanner(System.in);
		/*
		 * There are five sections of the code: 
		 * Section 1: User prompt to capture information.  The is captured in an outer while loop.  The user will select 'y' if they want to continue.   
		 * Section 2: Create the top horizontal line.  
		 * Section 3: Creates the body of the horizontal line. There is a nested while for the border and the interior  
		 * Section 4: Create the bottom horizontal line
		 * Section 5: User is prompted to continue.  If they do not select 'y' the while condition exits.  
		 */
		
		
		//Section 1: Created a while loop to prompt the user to continue	
		while (cont=='y') {
			i=0; //i is set to 0 to ensure the proper iteration. 
			j=0; //i is set to 0 to ensure the proper iteration. 
			System.out.println("How long should the box be? NOTE:  Must be greater than 2"); 
			h=readInput.nextInt(); 
			System.out.println("How tall should the box be? NOTE:  Must be greater than 2");
			v=readInput.nextInt(); 
			System.out.println("What should the horizontal character be?"); 
			hVal=readInput.next().charAt(0); 
			System.out.println("What should the vertical character be?"); 
			vVal=readInput.next().charAt(0);
		//Section 2: Creates the top horizontal line	
			while (i++<h) {
				System.out.print(hVal); 
			}
			System.out.println(' ');
			i=0; //i is reset to 0 to ensure nested method iterates properly if executed a second time. 
		//Section 3: Creates the body of the box	
			while (j++<v-2) { //iterates v-2.  This accounts for the two characters representing the edges of the box. 
				System.out.print(vVal);
				while(i++<h-2) {
					System.out.print(' ');
					}
				System.out.println(vVal); 
				i=0; //i is reset to 0 to ensure nested method iterates properly if executed a second time.
			}
		//Section 4: Creates the bottom horizontal line	
			while (i++<h) {
				System.out.print(hVal); 
			}
			System.out.println(' '); // creates a new line.  
		//Section 5: Prompts the user to continue
			System.out.println("Do you want to continue?  Press 'y' if yes."); 
			cont=readInput.next().charAt(0); //Exits if the user enters anything but 'y'
		}
	}	
}