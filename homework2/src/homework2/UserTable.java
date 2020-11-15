package homework2;
import java.util.Scanner; 


//NOTE:  I didn't include any of the details about byte information from the beginning of 2.3. I assumed it was illustrative. 
public class UserTable {
	char yourInitial; 
	String firstName; 
	String lastName; 
	String city; 
	String zip; 
	
	// Add column for Zip Code
	// Declare four variables (decide data type):  First Name, Last Name, City, Zip
	// Ask user for values for these variables and display them instead of hardcoding Bill Clinton
	public static void main(String[] args) {
		Scanner readInput = new Scanner(System.in); 
		
		System.out.println(); 
		System.out.print("What is your first name? : ");
		String firstName= readInput.next(); 
		//char yourInitial = readInput.next().charAt(0); 
		System.out.print("What is your last name? : ");
		String lastName= readInput.next();
		
		System.out.print("What is your city? : ");
		String city= readInput.next();
		
		System.out.print("What is your zipcode? : ");
		String zip= readInput.next();
		
		
		//System.out.println("Hello Mr. "+yourInitial + "."); 
		System.out.println("Hello Mr. "+firstName); 
		
		readInput.nextLine(); 
	
		System.out.println(); 
		System.out.printf("5185 is a fun course.\n\n"); 
		
		System.out.printf("First Name\tLast Name\tCity     \tZip Code\n"); 
		System.out.printf("----------\t---------\t---------\t--------\n");
		System.out.printf(firstName+"  \t"+lastName+"  \t"+city+"  \t"+zip+"  \n");
		System.out.printf("\n"); 
		
		System.out.println();
		System.out.printf("How do you print double quotes?\n"); 
		System.out.printf("Who said\"Test Scores can be Used...\"\n");
	
	}
}
