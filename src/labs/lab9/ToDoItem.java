package labs.lab9;
import java.util.Date;

public class ToDoItem implements Comparable{
	private String name;
	private int priority;
	private String note;
	private boolean ifDeadLine;
	private Date deadLine;
	private boolean ifDone;
	
	public ToDoItem(String name, String priority, String note,boolean ifDeadLine, Date deadLine) {
		this.name = name;
		this.priority = Integer.valueOf(priority);
		this.note=note;
		this.ifDeadLine=ifDeadLine;
		this.deadLine=deadLine;
		this.ifDone=false;
		
	}
	//------------------------
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//------------------------
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = Integer.valueOf(priority);
	}
	
	//------------------------
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	//------------------------
	public boolean getIfDeadLine() {
		return ifDeadLine;
	}
	
	public void setIfDeadLine() {
		this.ifDeadLine = !ifDeadLine;
	}
	
	//------------------------
	public boolean getIfDone() {
		return ifDone;
	}
	
	public void setIfDone() {
		this.ifDone = !ifDone;
	}
	
	//------------------------
	public int getYear() {
		return deadLine.getYear();
	}
	
	public int getMonth() {
		return deadLine.getMonth();
	}
	
	public int getDay() {
		return deadLine.getDate();
	}
	
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	
	//------------------------
	@Override
	public int compareTo(Object o) {
		ToDoItem item = (ToDoItem)o;
		if (this.getIfDone()!=item.getIfDone() && this.getIfDone()) {
			return 1;
		}else if (this.getIfDone()!=item.getIfDone() && !this.getIfDone()){
			return -1;
		}else {
			if (this.getPriority()<item.getPriority()) {
				return -1;
			}else if (this.getPriority()>item.getPriority()) {
				return 1;
			}else {
				return this.getName().compareTo(item.getName());
			}
		}
			
		
	}

}
