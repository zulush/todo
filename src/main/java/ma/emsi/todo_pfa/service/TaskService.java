package ma.emsi.todo_pfa.service;

import java.util.List;

import ma.emsi.todo_pfa.entity.Task;

public interface TaskService {

	Task add(Task task, long userid);

	List<Task> getUserTasks(long userId);

}
