//CozzyStuddyBuddy

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class FileManager{
	
	public void saveTasks(ArrayList<Task> tasks){
		
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("tasks.txt"));
			
			for(Task task : tasks){
			writer.println(task.name + "," + task.subject + "," + task.dueDate + "," + task.priority + "," + task.completed);
			}
			
			writer.close();
		}
		catch(IOException e){ 
		
			System.out.println("Error saving tasks.");
		}
	}
	
	public void loadTasks(ArrayList<Task> tasks){
		
		File file = new File("tasks.txt");
		
		if(!file.exists()){
			return;
		}
		try{
			Scanner fileReader = new Scanner(file);
			
			while(fileReader.hasNextLine()){
				
				String line = fileReader.nextLine();
				String[] parts = line.split(",");
				
				Task task = new Task(parts[0], parts[1], parts[2], parts[3]);
				task.completed = Boolean.parseBoolean(parts[4]);
				tasks.add(task);
			}
			fileReader.close();
		}
		catch(IOException e){
			System.out.println("Error loading tasks.");
		}
	}
}