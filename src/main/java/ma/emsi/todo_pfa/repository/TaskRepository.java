package ma.emsi.todo_pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.todo_pfa.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
