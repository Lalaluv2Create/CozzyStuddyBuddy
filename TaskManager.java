//CozzyStuddyBuddy

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TaskManager{
	
	private ArrayList<Task> tasks;
	private FileManager fileManager;
	
	
	public TaskManager(){
		
		tasks = new ArrayList<>();
		fileManager = new FileManager();
		fileManager.loadTasks(tasks);
	}
	
	public void displayTaskList(){
		
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
			System.out.println("	Priority: "+ task.priority);
		}
	}
	
	public void viewTasks(){
		
		System.out.println();
		System.out.println("----- My Tasks ------");
		System.out.println();
				
		if(tasks.size() == 0){
			System.out.println("No tasks yet!");
		}
		else{
			displayTaskList();
		}
	}
	
	public void addTask(Scanner input){
		
		System.out.println();
		
		System.out.print("Task name: ");
		String taskName = input.nextLine();
				
		System.out.print("Subject: ");
		String subject = input.nextLine();
		
		System.out.print("Due Date (MM/DD/YYYY): ");
		String dueDate = input.nextLine();
		
		System.out.println("Priority Options:");
		System.out.println("1. High");
		System.out.println("2. Medium"); 
		System.out.println("3. Low");
		
		System.out.println("Choose Priority: ");
		int priorityChoice = input.nextInt();
		input.nextLine();
		
		String priority;
		
		if(priorityChoice == 1){
			priority = "High";
		}
		else if(priorityChoice == 2){
			priority = "Medium";
		}
		else{
			priority = "Low";
		}
				
		Task newTask = new Task(taskName, subject, dueDate, priority);
				
		tasks.add(newTask);
		fileManager.saveTasks(tasks);
				
		System.out.println("Task added successfully!");
	}
	
	public void completeTask(Scanner input){
		
		if(tasks.size() == 0){//no tasks found
			
			System.out.println("No tasks to complete!");
		}
		else{
			
			System.out.println("Which task did you complete? ");
					
			displayTaskList();
					
			System.out.print("Task Number: ");
			int taskNumber = input.nextInt();
			input.nextLine();
			
			if(taskNumber >= 1 && taskNumber <= tasks.size()){
				
				Task selectedTask = tasks.get(taskNumber - 1);
					
				selectedTask.completed = true;
				fileManager.saveTasks(tasks);
				
				System.out.println();
				System.out.println("Task completed!");
			}
			else{
				
				System.out.println();
				System.out.println("Invalid task number!");
			}
		}
	}	
	
	public void editTask(Scanner input){
		
		if(tasks.size() == 0){//no tasks found
			
			System.out.println();
			System.out.println("No tasks to edit!");
		}
		else{
			
			System.out.println();
			System.out.println("Which task would you like to edit? ");
			System.out.println();
			
			displayTaskList();
			
			System.out.println();
			System.out.print("Task Number: ");
			int taskNumber = input.nextInt();
			input.nextLine();
			
			if(taskNumber >= 1 && taskNumber <= tasks.size()){
				
				//ask the user for new info to replace the old
				Task selectedTask = tasks.get(taskNumber - 1);
			
				System.out.print("New task name: ");
				String newName = input.nextLine();
			
				System.out.print("New subject: ");
				String newSubject = input.nextLine();
			
				System.out.print("New due date (MM/DD/YYYY): ");
				String newDueDate = input.nextLine();
			
				System.out.println();
				System.out.println("Priority Options:");
				System.out.println("1. High");
				System.out.println("2. Medium"); 
				System.out.println("3. Low");
			
				System.out.print("Choose Priority: "); 
				int priorityChoice = input.nextInt();
				input.nextLine();
			
				String newPriority;
				if(priorityChoice == 1){
					newPriority = "High";
				}
				else if(priorityChoice == 2){
					newPriority = "Medium";
				}
				else{
					newPriority = "Low";
				}
			
				//updating
				selectedTask.name = newName;
				selectedTask.subject = newSubject;
				selectedTask.dueDate = newDueDate;
				selectedTask.priority = newPriority;
				fileManager.saveTasks(tasks);
			
				System.out.println("Task updated!");
				}
			else{
				
				System.out.println();
				System.out.println("Invalid task number!");
			}
		}
	}
	
	public void deleteTask(Scanner input){
		
		if(tasks.size() == 0){//no tasks found
			
			System.out.println();
			System.out.println("No tasks to delete!");
		}
		else{
			
			System.out.println();
			System.out.println("Which task would you like to delete? ");
			System.out.println();
			displayTaskList();
			
			System.out.println();
			System.out.print("Task Number: ");
			int taskNumber = input.nextInt();
			input.nextLine();
			
			if(taskNumber >= 1 && taskNumber <= tasks.size()){
				
				tasks.remove(taskNumber - 1);
				fileManager.saveTasks(tasks);
			
				System.out.println();
				System.out.println("Task deleted!");
			}
			else{
				
				System.out.println();
				System.out.println("Invalid task number!");
			}
		}
		
	}
}