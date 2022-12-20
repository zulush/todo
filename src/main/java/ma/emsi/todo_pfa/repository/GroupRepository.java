package ma.emsi.todo_pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.todo_pfa.entity.Group;

public interface GroupRepository extends JpaRepository<Group,Integer>{

}
