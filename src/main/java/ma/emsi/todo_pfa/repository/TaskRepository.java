package ma.emsi.todo_pfa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.todo_pfa.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

	List<Task> getTasksByUserId();

}
