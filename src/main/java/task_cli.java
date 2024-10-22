
public class task_cli {
	public static void main(String[] args ) {
		TaskManager taskManager = new TaskManager();
				
		if(args.length < 1) {
			System.out.println("引数が誤っています。");
			return ;
		}
		
		String command = args[0];
				
		switch(command) {
			case "add":
				if(args.length < 2) {
					System.out.println("add 引数が誤っています。");
					return ;
				}
				taskManager.addTask(args[1]);
				break;
				
			case "update":
				if(args.length < 3) {
					System.out.println("update 引数が誤っています。");
					return ;
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.updateTask(id, args[2]);
					}
				break;
			
			case "delete":
				if(args.length < 2) {
					System.out.println("update 引数が誤っています。");
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
					System.out.println("mark-in-progress 引数が誤っています。");
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.markTask(id, "in-progress");
				}
				
				break;
			
			case "mark-in-done":
				if(args.length < 2) {
					System.out.println("mark-in-done 引数が誤っています。");
				} else {
					int id = Integer.parseInt(args[1]);
					taskManager.markTask(id, "done");
				}
				
				break;
				
			default:
				System.out.println("default 引数が誤っています。" + command);
		}
		
	}
}
