/*
 *
 * Purpose: The purpose of this program is to help students calculate
 * their current grade within a course and find out the average score
 * they need in order to get a certain letter grade.
 *
 */


import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		
		// set scanner
		Scanner keyboard = new Scanner(System.in);
		
		// String responses
		String desiredGrade;
		String exam1Response;
		String exam2Response;
		String finalExamResponse;
		String labResponse;
		String projectResponse;
		String participationResponse;
		String quizResponse;
		String finalGrade;
		
		// initialize score weights and additional copies
		int weightExam1, weightExam1Copy;
		int weightExam2, weightExam2Copy;
		int weightFinalExam, weightFinalExamCopy;
		int weightLabs, weightLabsCopy;
		int weightProjects, weightProjectsCopy;
		int weightParticipations, weightParticipationsCopy;
		int weightQuizzes, weightQuizzesCopy;
		
		// initialize scores
		int exam1;
		int exam2;
		int finalExam;
		int labs;
		int projects;
		int participations;
		int quizzes;
		
		// double total score, total score copy
		// double current grade, current grade copy
		// total score weight
		double totalScore;
		double totalWeight;
		double currentGrade;
		double currentGrade1;
		double needScore;
		double totalScoreCopy;
		
		// print grading scale
		System.out.println("Grading Scale:");
		System.out.println("A\t90 - 100");
		System.out.println("B\t80 - 89");
		System.out.println("C\t70 - 79");
		System.out.println("D\t60 - 69");
		System.out.println("F\tbelow 60");
		
		// desired course question
		// desired grade input
		System.out.print("What letter grade do you want to achieve for the course?");
		desiredGrade = keyboard.nextLine();
		
		// "if statement" where checks if letter grades are any of the above listed: A,B,C,D,F
		// enter the percentage weights
		if (desiredGrade.equalsIgnoreCase("A") || desiredGrade.equalsIgnoreCase("B") || desiredGrade.equalsIgnoreCase("C")
				|| desiredGrade.equalsIgnoreCase("C") || desiredGrade.equalsIgnoreCase("D") || desiredGrade.equalsIgnoreCase("F")) {
			System.out.println("Enter percentage weights below.");
			System.out.print("Exam 1:\t\t\t");
			weightExam1 = keyboard.nextInt();
			System.out.print("Exam 2:\t\t\t");
			weightExam2 = keyboard.nextInt();
			System.out.print("Final Exam:\t\t");
			weightFinalExam = keyboard.nextInt();
			System.out.print("Labs:\t\t\t");
			weightLabs = keyboard.nextInt();
			System.out.print("Projects:\t\t");
			weightProjects = keyboard.nextInt();
			System.out.print("Participation:\t\t");
			weightParticipations = keyboard.nextInt();
			System.out.print("Quizzes:\t\t");
			weightQuizzes = keyboard.nextInt();
			
			// set copies to the original input
			// the copies will be used in the later process "if statements" to meet output condition
			weightExam1Copy = weightExam1;
			weightExam2Copy = weightExam2;
			weightFinalExamCopy = weightFinalExam;
			weightLabsCopy  = weightLabs;
			weightProjectsCopy = weightProjects;
			weightParticipationsCopy = weightParticipations;
			weightQuizzesCopy = weightQuizzes;
			
			// "if statement" used to validate the score weights to be 100 or not
			if (weightExam1 + weightExam2 + weightFinalExam + weightLabs 
					+ weightProjects + weightParticipations + weightQuizzes != 100) {
				System.out.print("Weights don't add up to 100, program exiting...");
				keyboard.close();
			}
			
			// "else if" when score weights equal to 100
			else if (weightExam1 + weightExam2 + weightFinalExam + weightLabs 
					+ weightProjects + weightParticipations + weightQuizzes == 100){
			//input exam 1 score
			System.out.print("Do you know your exam 1 score?");
			
			exam1Response = keyboard.next();
				if (exam1Response.equalsIgnoreCase("y") || exam1Response.equalsIgnoreCase("yes")) {
					
					System.out.print("Score received on exam 1: ");
					exam1 = keyboard.nextInt();
					
					System.out.print("Do you know your exam 2: ");
					
					exam2Response = keyboard.next();
						//"yes or y" then continue input
						if (exam2Response.equalsIgnoreCase("y") || exam2Response.equalsIgnoreCase("yes")) {
							System.out.print("Score received on exam 2: ");
							exam2 = keyboard.nextInt();
							
							System.out.print("Do you know your final exam score?");
							
							finalExamResponse = keyboard.next();
								//"yes or y" then continue input
								if (finalExamResponse.equalsIgnoreCase("y") || finalExamResponse.equalsIgnoreCase("yes")) {
									System.out.print("Score received on final exam: ");
									finalExam = keyboard.nextInt();
								}
								// sets exam scores to 100 used for later process to help establish condition
								// score weights will be 0, this will cancel out the correlated exam scores
								else {
									finalExam = 100;
									weightFinalExam = 0;
								}
						}
						else {
							exam2 = 100;
							finalExam = 100;
							weightExam2 = 0;
							weightFinalExam = 0;
						}						
				}
				else {
					exam1 = 100;
					exam2 = 100;
					finalExam = 100;
					weightExam1 = 0;
					weightExam2 = 0;
					weightFinalExam = 0;
				}
			
			// input lab average
			System.out.print("Do you know your lab average?");
			labResponse = keyboard.next();
				if (labResponse.equalsIgnoreCase("y") || labResponse.equalsIgnoreCase("yes")) {
					System.out.print("Average lab grade:");
					labs = keyboard.nextInt();
				}
				else {
					labs = 100;
					weightLabs = 0;
				}
			
			// input project average
			System.out.print("Do you know your project average?");
			projectResponse = keyboard.next();
				if (projectResponse.equalsIgnoreCase("y") || projectResponse.equalsIgnoreCase("yes")) {
					System.out.print("Average project grade:");
					projects = keyboard.nextInt();
				}
				else {
					projects = 100;
					weightProjects = 0;
				}
			// input participation average
			System.out.print("Do you know your participation average?");
			participationResponse = keyboard.next();
				if (participationResponse.equalsIgnoreCase("y") || participationResponse.equalsIgnoreCase("yes")) {
					System.out.print("Average participation grade:");
					participations = keyboard.nextInt();
					}
				else{
						participations = 100;
						weightParticipations = 0;
					}
			// input quiz average
			System.out.print("Do you know your quiz average?");
			quizResponse = keyboard.next();
				if (quizResponse.equalsIgnoreCase("y") || quizResponse.equalsIgnoreCase("yes")) {
					System.out.print("Average quiz grade: ");
					quizzes = keyboard.nextInt();
					}
				else {
						quizzes = 100;
						weightQuizzes = 0;
					}
			
			// total score = score weights * exam scores
			totalScore = (weightExam1*exam1) + (weightExam2*exam2) + (weightFinalExam*finalExam) + (weightLabs*labs)
							+ (weightProjects*projects) + (weightParticipations*participations) + (weightQuizzes*quizzes);
			
			// total weight = sum of all score weights
			totalWeight = weightExam1 + weightExam2 + weightFinalExam  + weightLabs
					+ weightProjects + weightParticipations + weightQuizzes;
			
			// current grade is total score / total weight
			currentGrade = (totalScore / totalWeight);
			
			// additional total score copy created
			totalScoreCopy = (weightExam1Copy*exam1) + (weightExam2Copy*exam2) + (weightFinalExamCopy*finalExam) + (weightLabsCopy*labs)
					+ (weightProjectsCopy*projects) + (weightParticipationsCopy*participations) + (weightQuizzesCopy*quizzes);
			
			System.out.printf("Current grade score:%.2f", currentGrade);
			System.out.println("");
			
			// current grade conditions equals to final grade (A,B,C,D,F)
			if(currentGrade >= 90 & currentGrade <= 100.00) {
				finalGrade = "A";
				System.out.println("Your current letter grade:" + finalGrade);
			}
			else if(currentGrade >= 80 & currentGrade <= 89.99) {
				finalGrade = "B";
				System.out.println("Your current letter grade:" + finalGrade);
			}
			else if(currentGrade >= 70 & currentGrade <= 79.99) {
				finalGrade = "C";
				System.out.println("Your current letter grade:" + finalGrade);
			}
			else if(currentGrade >= 60 & currentGrade <= 69.99) {
				finalGrade = "D";
				System.out.println("Your current letter grade:" + finalGrade);
			}
			else {
				finalGrade = "F";
				System.out.println("Your current letter grade:" + finalGrade);
			}
			
		// "if statement" to compare desired grade to final grade
		// set conditions to 3 different output
		// 1st condition: if (accumulated total score / 100) ">" minimum score weight
		// 2nd condition: if (total score / 100) "<" minimum grade
		// 3rd condition: (minimum grade - total score) / (100 - total score weight)
		if(desiredGrade.equalsIgnoreCase(finalGrade)) {
				System.out.print("Congratulations! You recieved the " + desiredGrade + " that you wanted!");	
			}
		
			else if (desiredGrade.equalsIgnoreCase("A")){
				
				if (totalScore/100 >= totalWeight*.9) {
					System.out.println("You will receive at least a grade of A.");
				}
				
				else if (totalScoreCopy/100 < 90) {
					System.out.print("Unfortunately, a grade of A is not possible");
				}
				else {
					needScore = ((90*100) - totalScore) / (100 - totalWeight);
					System.out.print("In order to receive a grade of A, you need to score an average greater than or equal to ");
					System.out.printf("%.2f", needScore);
					System.out.print(" in the rest of the grade items");
				}
			}
		
			else if (desiredGrade.equalsIgnoreCase("B")){
				
				if (totalScore/100 >= totalWeight*.8) {
					System.out.println("You will receive at least a grade of B.");
				}
			
				else if (totalScoreCopy/100 < 80) {
					System.out.print("Unfortunately, a grade of B is not possible");
				}
				else {
					needScore = ((80*100) - totalScore) / (100 - totalWeight);
					System.out.print("In order to receive a grade of B, you need to score an average greater than or equal to ");
					System.out.printf("%.2f", needScore);
					System.out.print(" in the rest of the grade items");
				}
			}
		
			else if (desiredGrade.equalsIgnoreCase("C")){
				
				if (totalScore/100 >= totalWeight*.7) {
					System.out.println("You will receive at least a grade of C.");
				}
				
				else if (totalScoreCopy/100 < 70) {
					System.out.print("Unfortunately, a grade of C is not possible");
				}
				
				else {
				needScore = ((70*100) - totalScore) / (100 - totalWeight);
				System.out.print("In order to receive a grade of C, you need to score an average greater than or equal to ");
				System.out.printf("%.2f", needScore);
				System.out.print(" in the rest of the grade items");
				}
			}
				
			else if (desiredGrade.equalsIgnoreCase("D")){
				
				if (totalScore/100 >= totalWeight*.6) {
					System.out.println("You will receive at least a grade of D.");
				}
				
				else if (totalScoreCopy/100 < 60) {
					System.out.print("Unfortunately, a grade of D is not possible");
				}
				else {
					needScore = ((60*100) - totalScore) / (100 - totalWeight);
					System.out.print("In order to receive a grade of D, you need to score an average greater than or equal to ");
					System.out.printf("%.2f", needScore);
					System.out.print(" in the rest of the grade items");
				}
			}
		}
	}	
		// letter grade not correlating to above listed (A,B,C,D,F)
		else {
			System.out.print("The input is invalid");
		}
	}
}