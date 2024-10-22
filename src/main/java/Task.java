import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

public class Task {
	int id;
	String description;
	String status;
	String createdAt;
	String updatedAt;
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	
	Task(int id, String description, String status) {
		this.id = id;
		this.description = description;
		this.status = status;
		this.createdAt = LocalDateTime.now().format(formatter);
		this.updatedAt = this.createdAt;
	}
	
	JSONObject toJSON() {
		JSONObject taskObject = new JSONObject();
		taskObject.put("id", id);
		taskObject.put("description", description);
		taskObject.put("status", status);
		taskObject.put("createdAt", createdAt);
		taskObject.put("updatedAt", updatedAt);
		return taskObject;

	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
