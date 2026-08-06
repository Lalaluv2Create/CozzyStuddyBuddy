//CozzyStuddyBuddy
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main{
	
	public static void main(String[] args){
		
		//Welcome Screen
		Scanner input = new Scanner(System.in);
		
		String appName = "Cozzy Studdy Buddy";
		
		System.out.println("Welcome to " + appName + "!");
		System.out.print("Enter your name: ");
		String studentName = input.nextLine();
		
		System.out.println("Hello, " + studentName + "!");
		
		System.out.print("What is your gpa? ");
		
		double gpa = input.nextDouble();
		input.nextLine();
		System.out.println("GPA: " + gpa);
		
		TaskManager taskManager = new TaskManager();
		
		//Menu 
		boolean running = true;
		while(running){
			System.out.println();
			System.out.println("------");
			System.out.println("Choose an option: ");
			System.out.println();
			System.out.println("1. View Tasks");
			System.out.println("2. Add Task");
			System.out.println("3. Complete Task");
			System.out.println("4. Edit Task");
			System.out.println("5. Delete Task");
			System.out.println("6. Exit");
			System.out.println();
			System.out.println("------");
			
			if(input.hasNextInt()){
				
				int choice = input.nextInt();
				input.nextLine();
			
				if(choice == 1){//Viewing Task
					taskManager.viewTasks();
				}
				else if(choice == 2){//Adding Task
					taskManager.addTask(input);
				}
				else if(choice == 3){//Complete Task	
					taskManager.completeTask(input);
				}
				else if(choice == 4){//Edit Task
					taskManager.editTask(input);
				}
				else if(choice == 5){//Delete Task
					taskManager.deleteTask(input);
				}
				else if(choice == 6){//Exit
					running = false;
				}
				else{
					System.out.println("Not Viable Option");
				}
			}
			else{
				System.out.println("Please enter a number:");
				input.nextLine();
			}
		}	
	}
}