package homework2;
import java.util.Scanner;

public class ScannerPi {
	public static void main(String[] args) {
		int radius; 
		double area; 
		double pi=3.142; 
		Scanner readInput = new Scanner(System.in); 
		
		//System.out.println(""); 
		System.out.print("Enter the radius: "); 
		radius=readInput.nextInt(); 
		System.out.print("Enter Pi (Pi= 3.14): ");
		pi=readInput.nextDouble(); 
		
		area=pi*radius*radius; 
		
		System.out.print("The area is: "); 
		System.out.println(area);	
	}
}
