import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

public class TaskManager {
	private static final String FILE_PATH = "tasks.json";
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static JSONArray loadTasks() {
		Path path = Paths.get(FILE_PATH);
		if(!Files.exists(path)) {
			return new JSONArray();
		}
		
		String content;
		try {
			content = new String(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
			return new JSONArray();
		}
		return new JSONArray(content);
	}
	
	public static void saveTasks(JSONArray tasks) {
		try {
			FileWriter file = new FileWriter(FILE_PATH);
			file.write(tasks.toString(4));
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addTask(String description) {
		JSONArray tasks = loadTasks();
		int id = tasks.length() + 1;
		Task task = new Task(id, description, "todo");
		tasks.put(task.toJSON());
		saveTasks(tasks);
		System.out.println("taskの追加に成功しました。 ID : " + id);
	}
	
	public void listTask(String filter) {
		JSONArray tasks = loadTasks();
		for(int i = 0; i < tasks.length(); i++) {
			JSONObject task = tasks.getJSONObject(i);
			if(filter == null) {
				System.out.println(task);
			} else {
				if(task.getString("status") == filter) {
					System.out.println(task);
				}
			}
			
		}
	}

	public void updateTask(int id, String newDescription) {
		JSONArray tasks = loadTasks();
		for(int i = 0; i < tasks.length(); i++) {
			JSONObject task = tasks.getJSONObject(i);
			if(task.getInt("id") == id) {
				task.put("description", newDescription);
				task.put("updatedAt", LocalDateTime.now().format(formatter));
				saveTasks(tasks);
				System.out.println("taskの更新に成功しました。 ID : " + id);
				return;
			}
		}
		
		System.out.println("指定されたIDのtaskが見つかりませんでした。 ID : " + id);
	}
	
	public void deleteTask(int id) {
		JSONArray tasks = loadTasks();
		for(int i = 0; i < tasks.length(); i++) {
			JSONObject task = tasks.getJSONObject(i);
			if(task.getInt("id") == id) {
				tasks.remove(i);
				saveTasks(tasks);
				System.out.println("taskの削除に成功しました。 ID : " + id);
				return;
			}
		}
		System.out.println("指定されたIDのtaskが見つかりませんでした。 ID : " + id);
	}

	public void markTask(int id, String newStatus) {
		JSONArray tasks = loadTasks();
		for(int i = 0; i < tasks.length(); i++) {
			JSONObject task = tasks.getJSONObject(i);
			if(task.getInt("id") == id) {
				task.put("status", newStatus);
				task.put("updatedAt", LocalDateTime.now().format(formatter));
				saveTasks(tasks);
				System.out.println("taskのステータスを" + newStatus + "に変更しました。 ID: " + id);
				return;
			}
		}
		
		System.out.println("指定されたIDのtaskが見つかりませんでした。 ID : " + id);
	}
}
