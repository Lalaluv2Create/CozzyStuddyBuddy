import java.util.Scanner;


public class Main{
	
	public static void main(String[] args){
		
		//welcome screen
		Scanner input = new Scanner(System.in);
		
		String appName = "Cozzy Studdy Buddy";
		
		System.out.println("Welcome to " + appName + "!");
		System.out.print("Enter your name: ");
		String studentName = input.nextLine();
		
		System.out.println("Hello, " + studentName + "!");
		
		System.out.print("What is your gpa? ");
		
		double gpa = input.nextDouble();
		System.out.println("GPA: " + gpa);
		
		System.out.print("How many tasks do you have today? ");
		int taskCount = input.nextInt();
		
		//task name, subject
		Task homework = new Task(Finish Java project, Computer Science);

		homework.checkStatus();
	}
}