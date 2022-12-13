package ma.emsi.todo_pfa.service;

import ma.emsi.todo_pfa.entity.AppUser;
import ma.emsi.todo_pfa.model.UserModel;

public interface UserService {

	UserModel getByUsername(String username);

	boolean addTaskToUser(int task_id, int user_id);

	AppUser getUser(int i);

}
