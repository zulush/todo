package ma.emsi.todo_pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emsi.todo_pfa.entity.AppUser;
import ma.emsi.todo_pfa.entity.Task;
import ma.emsi.todo_pfa.repository.TaskRepository;
import ma.emsi.todo_pfa.repository.UserRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepo;
	@Autowired
	UserRepository userRepo;
	
	
	
	@Override
	public List<Task> getUserTasks(int userId){
		return taskRepo.getTasksByUserId(userId);
	}
	
	@Override
	public Task add(Task task, int userId){
		AppUser user = userRepo.findById(userId).get();
		
		if(user == null)
			return null;
		
		Task newTask = taskRepo.save(task);
		
		if(newTask == null)
			return null;
		
		user.addTask(newTask);
		userRepo.save(user);
		
		return newTask;
	}
	
}
