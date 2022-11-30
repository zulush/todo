package ma.emsi.todo_pfa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.emsi.todo_pfa.controller.TaskController;
import ma.emsi.todo_pfa.entity.Task;
import ma.emsi.todo_pfa.repository.TaskRepository;

public class TaskServiceImpl implements TaskService {


	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	public List<Task> getAllTasks(){
		return taskRepo.findAll();
	}
	
	@Autowired
	public Task add(Task task, long userId){
		return taskRepo.save(task);
	}
	
}
