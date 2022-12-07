package ma.emsi.todo_pfa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.emsi.todo_pfa.entity.Task;

public interface TaskService {

	Task add(Task task, int userid);

	List<Task> getUserTasks(int userId);

}
