package ma.emsi.todo_pfa.service;

import java.util.Date;
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
	public boolean add(Task task, int userId){
		
		if(userRepo.findById(userId).isEmpty())
			return false;
	
		AppUser user = userRepo.findById(userId).get();
		
		if(user == null)
			return false;
		
		Task newTask = taskRepo.save(task);
		
		if(newTask == null)
			return false;
		
		user.addTask(newTask);
		userRepo.save(user);
		
		return true;
	}

	@Override
	public boolean isDone(int task_id, boolean done, String username) {
		
		if(taskRepo.findById(task_id).isEmpty())
			return false;
		
		Task task = taskRepo.findById(task_id).get();
		
		if(task.isDone() == done)
			return false;
		
		task.setDone(done);
		task.setLastUpdateDate(new Date());
		task.setLastUpdateDesc("modifiée par " + username);
		taskRepo.save(task);
		
		return true;
	}
	
}
