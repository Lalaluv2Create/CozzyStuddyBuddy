//CozzyStuddyBuddy
public class Task{
	
	String name;
	String subject;
	String dueDate;
	String priority;
	boolean completed;
	
	Task(String taskName, String taskSubject, String dueDate, String priority){
		this.name = taskName;
		this.subject = taskSubject;
		this.dueDate = dueDate;
		this.priority = priority;
		completed = false;
	}
	
	void checkStatus(){
		if(completed == true){
			System.out.println("Task finished!");
		}
		else{
			System.out.println("Keep going!");
		}
	}
}