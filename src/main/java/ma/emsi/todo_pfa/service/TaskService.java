package ma.emsi.todo_pfa.service;

import java.util.List;

import ma.emsi.todo_pfa.entity.Task;

public interface TaskService {

	List<Task> getAllTasks();

	Task add(Task task, long userid);

}
