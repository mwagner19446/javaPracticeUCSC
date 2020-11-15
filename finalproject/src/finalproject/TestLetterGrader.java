package finalproject;

//start notes at scores class.  Analytics class should be next. 
//review the previous homework solutions

public class TestLetterGrader {
	
	public static void main (String args[]) {
		if(args.length < 2) {//validates there are two arguments
			System.out.println("Usage: must have an input and output file.  Please update your arguments.");
		}//end if
		else {
			LetterGrader letterGrader=new LetterGrader(args[0], args[1]); //Creates new letterGrader object
			letterGrader.readScore(); //opens the input file and reads the score
			letterGrader.calcLetterGrade(); //calculates the LetterGrade
			letterGrader.printLetterGrade(); //Prints the LetterGrade
			letterGrader.displayAnalytics(); //calculates and displays the Analytics on the quizes and exams
			letterGrader.doCleanup();  //closes open threads and streams
		}//end else
	}// end main
} //end class TestLetterGrader
