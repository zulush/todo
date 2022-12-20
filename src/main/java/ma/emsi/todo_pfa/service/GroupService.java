package ma.emsi.todo_pfa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.emsi.todo_pfa.entity.Group;


public interface GroupService {

	boolean create(String name, int adminId, List<Integer> usersIds);
}
