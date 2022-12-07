package ma.emsi.todo_pfa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.emsi.todo_pfa.entity.Task;


public interface TaskRepository extends JpaRepository<Task,Long>{

	@Query(value = "SELECT t.* FROM task t, user_task ut WHERE t.task_id = ut.task_id and ut.user_id = ?1", nativeQuery = true)
	List<Task> getTasksByUserId(int userId);

}
