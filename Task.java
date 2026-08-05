public class Task{
	
	String name;
	String subject;
	String dueDate;
	boolean completed;
	
	Task(String taskName, String taskSubject, String dueDate){
		this.name = taskName;
		this.subject = taskSubject;
		this.dueDate = dueDate;
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