//CozzyStuddyBuddy
import java.util.Scanner;
import java.util.ArrayList;

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
		
		//Task.java
		ArrayList<Task> tasks = new ArrayList<>();
		
		loadTasks(tasks);
		
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
			else if(choice == 4){//Edit Task
				editTask(input, tasks);
			}
			else if(choice == 5){//Delete Task
				deleteTask(input, tasks);
			}
			else if(choice == 6){//Exit
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
					displayTaskList(tasks);
				}
	}
	
	public static void displayTaskList(ArrayList<Task> tasks){
		
		for(int i = 0; i < tasks.size(); i++){
			Task task = tasks.get(i);
			String status;
			
			if(task.completed){
				status = "[X]";
			}
			else{
				status = "[ ]";
			}
			
			System.out.println((i + 1) + ". " + status + " " + task.name);
			System.out.println("	Subject: " + task.subject);
			System.out.println("	Due: " + task.dueDate);
		}
	}
	
	public static void addTask(Scanner input, ArrayList<Task> tasks){
		
		System.out.println();
		
		System.out.print("Task name: ");
		String taskName = input.nextLine();
				
		System.out.print("Subject: ");
		String subject = input.nextLine();
		
		System.out.print("Due Date (MM/DD/YYYY): ");
		String dueDate = input.nextLine();
				
		Task newTask = new Task(taskName, subject, dueDate);
				
		tasks.add(newTask);
		saveTasks(tasks);
				
		System.out.println("Task added successfully!");
	}
	
	public static void completeTask(Scanner input, ArrayList<Task> tasks){
		
		if(tasks.size() == 0){//no tasks found
			
			System.out.println("No tasks to complete!");
		}
		else{
			
			System.out.println("Which task did you complete? ");
					
			displayTaskList(tasks);
					
			System.out.print("Task Number: ");
			int taskNumber = input.nextInt();
			input.nextLine();
					
			Task selectedTask = tasks.get(taskNumber - 1);
					
			selectedTask.completed = true;
			saveTasks(tasks);
				
			System.out.println();
			System.out.println("Task completed!");
		}
	}	
	
	public static void editTask(Scanner input, ArrayList<Task> tasks){
		
		if(tasks.size() == 0){//no tasks found
			
			System.out.println();
			System.out.println("No tasks to edit!");
		}
		else{
			
			System.out.println();
			System.out.println("Which task would you like to edit? ");
			System.out.println();
			
			displayTaskList(tasks);
			
			System.out.println();
			System.out.print("Task Number: ");
			int taskNumber = input.nextInt();
			input.nextLine();
			
			//ask the user for new info to replace the old
			Task selectedTask = tasks.get(taskNumber - 1);
			
			System.out.print("New task name: ");
			String newName = input.nextLine();
			
			System.out.print("New subject: ");
			String newSubject = input.nextLine();
			
			//updating
			selectedTask.name = newName;
			selectedTask.subject = newSubject;
			saveTasks(tasks);
			
			System.out.println("Task updated!");
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
			displayTaskList(tasks);
			
			System.out.println();
			System.out.print("Task Number: ");
			int taskNumber = input.nextInt();
			input.nextLine();
				
			tasks.remove(taskNumber - 1);
			saveTasks(tasks);
			
			System.out.println();
			System.out.println("Task deleted!");
		}
	}
	
	public static void saveTasks(ArrayList<Task> tasks){
		
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("tasks.txt"));
			
			for(Task task : tasks){
			writer.println(task.name + "," + task.subject + "," + task.dueDate + "," + task.completed);
			}
			
			writer.close();
		}
		catch(IOException e){ 
		
			System.out.println("Error saving tasks.");
		}
	}
	
	public static void loadTasks(ArrayList<Task> tasks){
		
		File file = new File("tasks.txt");
		
		if(!file.exists()){
			return;
		}
		try{
			Scanner fileReader = new Scanner(file);
			
			while(fileReader.hasNextLine()){
				
				String line = fileReader.nextLine();
				String[] parts = line.split(",");
				
				Task task = new Task(parts[0], parts[1], parts[2]);
				task.completed = Boolean.parseBoolean(parts[3]);
				tasks.add(task);
			}
			fileReader.close();
		}
		catch(IOException e){
			System.out.println("Error loading tasks.");
		}
	}
}