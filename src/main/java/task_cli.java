
public class task_cli {
	public static void main(String[] args ) {
		TaskManager taskManager = new TaskManager();
				
		if(args.length < 1) {
			System.out.println("arguments: [add] [update] [delete] [list] [mark-in-progress] [mark-in-done]");
			return ;
		}
		
		String command = args[0];
				
		switch(command) {
			case "add":
				if(args.length < 2) {
					System.out.println("Usage : add [description]");
					return ;
				}
				taskManager.addTask(args[1]);
				break;
				
			case "update":
				if(args.length < 3) {
					System.out.println("Usage : update [taskID] [description]");
					return ;
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.updateTask(id, args[2]);
					}
				break;
			
			case "delete":
				if(args.length < 2) {
					System.out.println("Usage : delete [taskID]");
					return ;
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.deleteTask(id);	
				}				
				break;
			
			case "list":
				if(args.length == 1) {
					taskManager.listTask(null);
					return;
				} else if (args.length == 2) {
					taskManager.listTask(args[1]);
				}
				
				break;
				
			case "mark-in-progress":
				if(args.length < 2) {
					System.out.println("Usage : mark-in-progress [taskID]");
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.markTask(id, "in-progress");
				}
				
				break;
			
			case "mark-in-done":
				if(args.length < 2) {
					System.out.println("Usage : mark-in-done [taskID]");
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.markTask(id, "done");
				}
				
				break;
				
			default:
				System.out.println("arguments: [add] [update] [delete] [list] [mark-in-progress] [mark-in-done]");
		}
		
	}
}
