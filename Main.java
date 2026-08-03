//CozzyStuddyBuddy
import java.util.Scanner;
import java.util.ArrayList;


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
		
		//Task.java
		ArrayList<Task> tasks = new ArrayList<>();
		
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
			System.out.println("4. Delete Task");
			System.out.println("5. Exit");
			System.out.println();
			System.out.println("------");
			
			int choice = input.nextInt();
			input.nextLine();
			
			if(choice == 1){//Viewing Task
				
				viewTasks(tasks);
			}
			else if(choice == 2){//Adding Task
			
				addTask(input, tasks);
			}
			else if(choice == 3){//Complete Task
				
				completeTask(input, tasks);
				
			}
			else if(choice == 4){//Delete Task
				
				deleteTask(input, tasks);
			}
			else if(choice == 5){//Exit
				running = false;
			}
			else{
				System.out.println("Not Viable Option");
			}
		}	
	}
	
	public static void viewTasks(ArrayList<Task> tasks){
		
		System.out.println();
				System.out.println("----- My Tasks ------");
				System.out.println();
				
				if(tasks.size() == 0){
					System.out.println("No tasks yet!");
				}
				else{
					for(int i = 0; i < tasks.size(); i++){
						
						Task task = tasks.get(i);
						String status;
					
						if(task.completed){
							status = "[X]";
						}
						else{
							status = "[ ]";
						}
						System.out.println((i + 1) + ". " + status + " " + task.name + " (" + task.subject + ")");
					}
				}
	}
	
	public static void addTask(Scanner input, ArrayList<Task> tasks){
		
		System.out.println();
		
		System.out.print("Task name: ");
		String taskName = input.nextLine();
				
		System.out.print("Subject: ");
		String subject = input.nextLine();
				
		Task newTask = new Task(taskName, subject);
				
		tasks.add(newTask);
				
		System.out.println("Task added successfully!");
	}
	
	public static void completeTask(Scanner input, ArrayList<Task> tasks){
		
		if(tasks.size() == 0){//no tasks found
			
			System.out.println("No tasks to complete!");
		}
		else{
			
			System.out.println("Which task did you complete? ");
					
			for(int i = 0; i < tasks.size(); i++){		
				System.out.println((i + 1) + ". " + tasks.get(i).name);
			}
					
			System.out.print("Task Number: ");
			int taskNumber = input.nextInt();
			input.nextLine();
					
			Task selectedTask = tasks.get(taskNumber - 1);
					
			selectedTask.completed = true;
				
			System.out.println();
			System.out.println("Task completed!");
		}
	}	
	public static void deleteTask(Scanner input, ArrayList<Task> tasks){
		
		if(tasks.size() == 0){//no tasks found
			
			System.out.println();
			System.out.println("No tasks to delete!");
		}
		else{
			
			System.out.println();
			System.out.println("Which task would you like to delete? ");
			System.out.println();
			for(int i = 0; i < tasks.size(); i++){
				System.out.println((i + 1) + ". " + tasks.get(i).name);
			}
			
			System.out.println();
			System.out.print("Task Number: ");
			int taskNumber = input.nextInt();
				
			tasks.remove(taskNumber - 1);
			System.out.println();
			System.out.println("Task deleted!");
		}
	}
}