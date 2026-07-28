public class Task{
	
	String name;
	String subject;
	boolean completed;
	
	void checkStatus(){
		if(completed == true){
			System.out.println("Task finished!");
		}
		else{
			System.out.println("Keep going!");
		}
	}
}