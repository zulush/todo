package ma.emsi.todo_pfa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emsi.todo_pfa.entity.AppUser;
import ma.emsi.todo_pfa.entity.Task;
import ma.emsi.todo_pfa.model.UserModel;
import ma.emsi.todo_pfa.repository.TaskRepository;
import ma.emsi.todo_pfa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TaskRepository taskRepo;
	
	@Override
	public UserModel getByUsername(String username) {
		AppUser user = userRepo.getByUsername(username);
		
		if (user != null) {
			UserModel userModel = new UserModel(user.getUserId(), user.getUsername());
			return userModel;
		}
		
		return null;
	}

	@Override
	public boolean addTaskToUser(int task_id, int user_id) {
		
		if(userRepo.findById(user_id).isEmpty() || taskRepo.findById(task_id).isEmpty())
			return false;
		
		AppUser user = userRepo.findById(user_id).get();
		Task task = taskRepo.findById(task_id).get();
		
		if(user.getTasks().contains(task))
			return false;
		
		user.addTask(task);
		
		userRepo.save(user);
		
		return true;
	}

	@Override
	public AppUser getUser(int user_id) {
		if(userRepo.findById(user_id).isPresent())
			return userRepo.findById(user_id).get();

		return null;
	}

}
