package ma.emsi.todo_pfa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.emsi.todo_pfa.controller.TaskController;
import ma.emsi.todo_pfa.entity.Task;

public class TaskServiceImpl implements TaskService {

	private static List<Task> tasks;
	private static long cmp = 0;
	
	static {
		tasks = new ArrayList<Task>();
		tasks.add(new Task(++cmp, "Task created by Backend for testing", new Date(), false, "just created", new Date()));
	}


	@Autowired
	public List<Task> getAllTasks(){
		return tasks;
	}
	
	@Autowired
	public Task add(Task task, long userId){
		tasks.add(task);
		return tasks.get(tasks.size()-1);
	}
	
}
