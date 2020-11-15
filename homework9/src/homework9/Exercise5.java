package homework9;
import java.io.*; 
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.InputMismatchException;

/**
 * This is a solution for HW#9	
 * The class has two static methods and a main method. 
 
 * The processCLArguments static method accepts the stored Eclipse arguments and prints out file details. 
 * The processInputOutputFiles static method reads information from the first argument, prints to the console and to the file in the second argument   
 * 
 * The Main method will execute both arguments. 
 * 
 * @author michael
 * @date 10/15/2020
 */
/*
 * Short description: The processCLArguments provide details about the Command Line Arguments.  
 * <p>
 * Long description: The processCLArguments provide details about the Command Line Arguments. It provide the filename and filepath.   
 * NOTE:  I've modified the code to practice working the File Object.   
 * <p>
 * It is referenced by: {@link #main} method  
 * It references:   No other methods.
 * <p>
 * @param NONE.  The Command Line Arguments. 
 * @return NONE.  (void method) 
 */
public class Exercise5 {
	public static void processCLArguments(String[] args) {
		if(args.length < 2) {
			System.out.println("Usage: java Exercise5 inputFile outputFile");
		}//end if
		else {
			//input_final.txt parameters
			String fileName1 =args[0]; 
			File myFile1= new File(fileName1);
			
			//output_final.txt parameters
			String fileName2 =args[1]; 
			File myFile2= new File(fileName2);
			
			System.out.println("Input will be read from: "+myFile1.getName());
			System.out.println("Input will be read from: "+myFile1.getAbsolutePath());
			System.out.println("Input will be read from: "+myFile2.getName());
			System.out.println("Input will be read from: "+myFile2.getAbsolutePath());
			System.out.println(" ");
			
		}//end else
	}//end processCLArguments method

	
	/*
	 * Short description: The processInputOutputFiles provide reads from a file and write to the console and output file.   
	 * <p>
	 * Long description: The processInputOutputFiles provide reads from a file and write to the console and output file.   
	 * <p>
	 * It is referenced by: {@link #main} method  
	 * It references:   No other methods.
	 * <p>
	 * @param NONE.  The Command Line Arguments. 
	 * @return NONE.  (Void method) 
	 */	
	public static void processInputOutputFiles(String[] args) {
		//input_final.txt parameters
		String fileName1 =args[0]; 
		File myFile1= new File(fileName1);

		//output_final.txt parameters
		String fileName2 =args[1]; 
		File myFile2= new File(fileName2);

		Scanner readInput;
		int lineCount; 
		
		try {
			readInput = new Scanner(new File(fileName1));
			lineCount=1; 
			
			while (readInput.hasNextLine()) {		
				System.out.println("Student #: "+lineCount+" "+readInput.nextLine());
				lineCount++;  
			}//end while
		}//end try
		
		catch (FileNotFoundException e) {//File Not Found
			System.out.println("File: " + fileName1 + "not found");
		} // end catch
		catch (IOException e) {//IO Exception
			System.out.println("Error Reading from file: "+ fileName1 + e.getMessage());
		} // end catch
		catch (Exception e) {//General Exception
			System.out.println(e);
		} // end catch
		
		
		///write to the output file
		PrintWriter textPrintStream = null;
		try {//Create the objects from the files
			readInput = new Scanner(new File(fileName1)); //Creates a Scanner object from the first file
			textPrintStream = new PrintWriter(new FileOutputStream(fileName2)); //Creates a TextStream for the second file
			lineCount=1; //resets lineCount to 1
			
			while (readInput.hasNextLine()) {	//iterate while there are more lines	
				StringTokenizer newLine= new StringTokenizer(readInput.nextLine(),","); //Creates a StringTokenizer object from the next line. 
				textPrintStream.print("Student #"+lineCount+" is: "+"\""+newLine.nextToken()+"\""); //Prints the Student Name				
				textPrintStream.print(" whose raw scores are "); 
					while(newLine.hasMoreTokens()) { //iterate while there are more scores
						textPrintStream.print(newLine.nextToken()+ ":"); //prints out all the scores
					}//end while
				textPrintStream.print("\n");
				lineCount++;  
				}//end while
			}//end try 
		catch (FileNotFoundException e) { //no file
			System.out.println("Error opening the file " + 
										  fileName2 + "\n" +
					                      e.getMessage());
			System.exit(0);
		}//end catch
		textPrintStream.close();
		System.out.println(fileName2 + " has been written and closed");
		
	}//end processInputOutputFiles method
	
	public static void main(String[] args) {
		processCLArguments(args); //Identifies files from the CommandLine
		processInputOutputFiles(args); //Processes the files
	}//end main method
}//end class
