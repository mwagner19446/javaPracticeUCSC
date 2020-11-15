package amazonInterviewPrep;
import java.util.Scanner; 
import java.util.Random; 


public class randomInteviewQuestion {
	public static void main (String[] args) {
		Random generator = new Random(); 
		int question = 0; 
		char answer = 'y'; 
		Scanner input1 = new Scanner(System.in); //Scanner object		
				
		while (answer=='y') {
			question = generator.nextInt(2);
			switch(question) {
				case 0: 
					System.out.println("Why do you want this role?");
					break; 
				case 1: 
					System.out.println("Tell me about yourself");
					break; 
				}
			System.out.println("Continue? Type 'y' for yes:\n");
			answer = input1.nextLine().charAt(0);
		}
	}
}
