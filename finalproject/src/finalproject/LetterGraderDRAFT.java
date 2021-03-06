/*
package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LetterGrader {
	String fileName1; 
	String fileName2; 
	File myFile1; 
	File myFile2;
	String [][]scores=new String[8][8]; 
	String [][] letterGrade=new String [8][2]; //maybe change this to KV
	int lineCount; 
	
	LetterGrader(String input, String output){
		//input_final.txt parameters
		fileName1 =input; 
		myFile1= new File(fileName1);
		
		//output_final.txt parameters
		fileName2 =output; 
		myFile2= new File(fileName2);
		
		System.out.println("Input will be read from: "+myFile1.getName());
		System.out.println("Input will be read from: "+myFile1.getAbsolutePath());
		System.out.println("Input will be read from: "+myFile2.getName());
		System.out.println("Input will be read from: "+myFile2.getAbsolutePath());
		System.out.println(" ");
	} //end LetterGrader constructor
		
	//readScore takes the files inputs and stores them in the right containers
	public void readScore(){
		Scanner readInput; 
		int scoreNumber; 
				
		//output_final.txt parameters
		myFile2= new File(this.fileName2);
				
		try {
			readInput = new Scanner(this.myFile1);
			StringTokenizer newLine= new StringTokenizer(readInput.nextLine(),","); //Creates a StringTokenizer object from the next line
			lineCount=1; 
			scoreNumber=0; 
			do{		
				//System.out.println("Student #: "+lineCount);
				while (newLine.hasMoreTokens()) {//iterate when there are more scores
					///if(isDigits(newLine.nextToken()))
					//scores[lineCount-1][scoreNumber]=Integer.parseInt(newLine.nextToken());
					scores[lineCount-1][scoreNumber]=newLine.nextToken();
					//System.out.println("ScoreNumber #: "+scoreNumber+" "+scores[lineCount-1][scoreNumber]);
					scoreNumber++; //iterate on scoreNumber
				}//end while hasMoreTokens()
				lineCount++;  //iterate on lineCount
				scoreNumber=0; //reset score number
				newLine= new StringTokenizer(readInput.nextLine(),","); //Creates a StringTokenizer object from the next line
			}
			while (readInput.hasNextLine());//end do-while hasNextLine()
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
		
		//System.out.println("The first student's first score is: "+scores[0][0]);
		//System.out.println("The fourth student's first score is: "+scores[5][0]);
		//System.out.println("Scores length is: "+scores.length); 

	}//end method readScore; 
		
	public void calcLetterGrade(){
		double rawScore; 
		for(int i=0; i<scores.length; i++) {//iterate through outer array
			letterGrade[i][0]=scores[i][0]; 
			rawScore=(Double.parseDouble(scores[i][1])*.10)+ //first quiz is weighted 10%
					 (Double.parseDouble(scores[i][2])*.10)+ //second quiz is weighted 10%
					 (Double.parseDouble(scores[i][3])*.10)+ //third quiz is weighted 10%
					 (Double.parseDouble(scores[i][4])*.10)+ //fourth quiz is weighted 10%
					 (Double.parseDouble(scores[i][5])*.20)+ //midterm 1 is weighted 20%
					 (Double.parseDouble(scores[i][6])*.15)+ //midterm 2 is weighted 15%
					 (Double.parseDouble(scores[i][7])*.25); //final is weighted 25% 
			//System.out.println("Student entered correctly:  "+letterGrade[i][0]); 

			if(rawScore>90) {
				letterGrade[i][1]="A"; 
			}
			else if(rawScore>80){
				letterGrade[i][1]="B";
			}
			else if(rawScore>70){
				letterGrade[i][1]="C";
			}
			else if(rawScore>60){
				letterGrade[i][1]="D";
			}
			else {
				letterGrade[i][1]="F";
				
			}	
			//System.out.println("Student: "+letterGrade[i][0]); 
			//System.out.println("Letter Grade is: "+letterGrade[i][1]);
			//System.out.println("Raw Score is: "+rawScore);
			rawScore=0;
		}
		
		//System.out.println("The first student's letterGrade is: "+letterGrade[0][1]);
		//System.out.println("The fourth student's LetterGrade is: "+letterGrade[5][1]);
		
	}//end method calcLetterGrade; 

	public void printGrade(){
		///write to the output file
		PrintWriter textPrintStream = null;
		try {//Create the objects from the files
			//readInput = new Scanner(new File(fileName1)); //Creates a Scanner object from the first file
			
			textPrintStream = new PrintWriter(new FileOutputStream(fileName2)); //Creates a TextStream for the second file
			lineCount=1; //resets lineCount to 1
			
			for(int i=0; i<letterGrade.length; i++) {
				String format="%-40s%s%n"; 
				String student= letterGrade[i][0]+":"; 
				String grade=letterGrade[i][1];
				textPrintStream.printf(format, student,grade); 
				}//end for loop
						
			}//end try 
		catch (FileNotFoundException e) { //no file
			System.out.println("Error opening the file " + 
										  fileName2 + "\n" +
					                      e.getMessage());
			System.exit(0);
		}//end catch
		textPrintStream.close();
		System.out.println(fileName2 + " has been written and closed");

	}//end method printGrade
	public void displayAverages(){
		//scores
		Double avgGrade[]=new Double[7]; 
		Double minGrade[]=new Double[7]; 
		Double maxGrade[]=new Double[7];
		Double gradeTotal; 
		
		for(int i=1; i<8; i++) {//there are 7 exams
			gradeTotal=0.0;
			 
			for (int j=0; j<scores.length; j++) {//iterate through each student 
				if(j==0) {
					minGrade[i-1]=Double.parseDouble(scores[j][i]);
					maxGrade[i-1]=Double.parseDouble(scores[j][i]);
				}
			
				gradeTotal+=Double.parseDouble(scores[j][i]); //Accumulates the aggregate temperature during the week.  Used to capture the average below.
				minGrade[i-1]=(minGrade[i-1]<Double.parseDouble(scores[j][i]))?minGrade[i-1]:Double.parseDouble(scores[j][i]); //Determine the min.  Replaces the Min value if the current value is lesser.  
				maxGrade[i-1]=(maxGrade[i-1]>Double.parseDouble(scores[j][i]))?maxGrade[i-1]:Double.parseDouble(scores[j][i]); //Determine the max.  Replaces the Max value if the current value is greater.
				
				if(j==scores.length-1) {
					avgGrade[i-1]=gradeTotal/scores.length; 
				}
			}//for loop for scores		
		} //end for loop for students
	
		System.out.println("Here is the class averages: "); 

		String format="%-15s%-8s%-8s%-8s%-8s%-8s%-8s%-8s%n"; 
		//String student= letterGrade[i][0]+":"; 
		//String grade=letterGrade[i][1];
		System.out.printf(format," ","Q1","Q2","Q3","Q4","Mid1","Mid2","Final"); 
		System.out.printf(format,"Average",avgGrade[0],avgGrade[1],avgGrade[2],avgGrade[3],avgGrade[4],avgGrade[5],avgGrade[6]);
		System.out.printf(format,"Minimum",minGrade[0],minGrade[1],minGrade[2],minGrade[3],minGrade[4],minGrade[5],minGrade[6]);
		System.out.printf(format,"Maximum",maxGrade[0],maxGrade[1],maxGrade[2],maxGrade[3],maxGrade[4],maxGrade[5],maxGrade[6]);
	}//end method createAverages
}//end LetterGrader class
*/