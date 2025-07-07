import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		Scanner input = new
		Scanner(System.in);
		
		System.out.println("====CGPA CALCULATOR====");
		
		System.out.println("Enter School Grading System:");
		System.out.println("1. 5-point grading Scale (A = 5,  B = 4, C = 3, D = 2, E = 1, F = 0)");
		System.out.println("2. 4-point grading Scale (A = 4, B = 3, C = 2, D = 1, F = 0)");
		int gradingSystem = input.nextInt();
		input.nextLine(); //clear enter key
		
		System.out.println("Enter number of courses");
		int n = input.nextInt();  
		
		int totalGradePoint = 0;
		int totalUnit = 0;
		
		String[] courseNames = new String [n];
		int [] courseUnits = new int[n];
		int[] courseScores = new int[n];
		int[] courseGradePoints = new int[n];
		String[] courseLetterGrades = new String[n];
		for (int i = 0; i < n; i++) {
		    System.out.println ("Courses " + (1 + i));
		    
		    
		     System.out.println("Course name: "); 
		     input.nextLine(); // flush the newline first
		    String name = input.nextLine(); //now collect the actual name
		    
		    System.out.println("Course unit: ");
		    int unit = input.nextInt();
		    
		    
		    System.out.println("Score: ");
		    int score = input.nextInt();
		
		int gradePoint;
		String letterGrade;
		
		if(gradingSystem == 1) {
		    // 5-point grading scale
		if (score >= 70) {
		   gradePoint = 5;
		   letterGrade = "A";}
		   else if (score >= 60) {
		       gradePoint = 4;
		       letterGrade = "B"; }
		   else if (score >= 50) {
		       gradePoint = 3; 
		       letterGrade = "C"; }
		   else if (score >= 45) {
		       gradePoint = 2;
		       letterGrade = "D"; }
		   else if (score >= 40) {
		       gradePoint = 1;
		       letterGrade = "E"; }
		       else {
		           gradePoint = 0;
		           letterGrade = "F";	}
		
		} 
		else if (gradingSystem == 2) {
		// 4-point grading
		
			if (score >= 70) {
		   gradePoint = 4;
		   letterGrade = "A"; }
		   else if (score >= 60) {
		       gradePoint = 3;
		       letterGrade = "B"; }
		   else if (score >= 50) {
		       gradePoint = 2;
		       letterGrade = "C"; }
		   
		   else if (score >= 45) {
		       gradePoint = 1;
		       letterGrade = "D";}
		   
		       
		       else{
		           gradePoint = 0;
		           letterGrade = "F";}
		
		}
		else {
		 System.out.println ("Invalid Grading System Selected!");
		 return; // stop the program
		}
		System.out.println("Grade Point: " + gradePoint);
		System.out.println("Letter Grade: " + letterGrade);
		
		courseNames[i] = name;
courseUnits[i] = unit;
courseScores[i] = score;
courseGradePoints[i] = gradePoint;
courseLetterGrades[i] = letterGrade;
		
		 totalGradePoint += gradePoint * unit;
		totalUnit += unit;
		
		}
		
		if (totalUnit == 0) {
    System.out.println("Total units cannot be zero. Please check your inputs.");
    return;
}


		double CGPA = (double) totalGradePoint / totalUnit;
		
		System.out.println("\n==== RESULT TABLE ====");
System.out.printf("%-5s %-20s %-6s %-6s %-13s %-10s\n", "No", "Course", "Unit", "Score", "Grade Point", "Letter");

for (int i = 0; i < n; i++) {
    System.out.printf("%-5d %-15s %-6d %-6d %-13d %-10s\n", 
        (i + 1),
        courseNames[i],
        courseUnits[i],
        courseScores[i],
        courseGradePoints[i],
        courseLetterGrades[i]
    );
} 
		
		DecimalFormat df = new
		DecimalFormat("0.00");
		System.out.println("Total Grade Points: " + totalGradePoint);
		System.out.println("Total Units: " + totalUnit);
		
		System.out.println ("YOUR CGPA is: " + df.format (CGPA));
	
	
		if (gradingSystem == 1) {
    if (CGPA >= 4.5) System.out.println("Class: First Class");
    else if (CGPA >= 3.5) System.out.println("Class: Second Class Upper");
    else if (CGPA >= 2.5) System.out.println("Class: Second Class Lower");
    else if (CGPA >= 1.5) System.out.println("Class: Third Class");
    else System.out.println("Class: Pass/Fail");
}	

if (gradingSystem ==2 ) {
    if (CGPA >= 3.5) System.out.println("Class: First Class");
    else if (CGPA >= 3.0) System.out.println("Class: Second Class Upper");
    else if (CGPA >= 2.0) System.out.println("Class: Second Class Lower");
    else if (CGPA >= 1.0) System.out.println("Class: Third Class");
    else System.out.println("Class: Fail");
}
	}
}