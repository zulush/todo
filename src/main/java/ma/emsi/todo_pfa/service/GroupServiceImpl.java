package ma.emsi.todo_pfa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emsi.todo_pfa.entity.AppUser;
import ma.emsi.todo_pfa.entity.Group;
import ma.emsi.todo_pfa.repository.GroupRepository;
import ma.emsi.todo_pfa.repository.UserRepository;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepo;
	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public boolean create(String name, int adminId, List<Integer> usersIds) {
		
		if(name.isEmpty())
			return false;
		
		if(userRepo.findById(adminId).isEmpty())
			return false;
		AppUser admin = userRepo.findById(adminId).get();
		
		List<AppUser> users = new ArrayList<AppUser>();
		
		for(Integer userId: usersIds) {
			if(userRepo.findById(userId).isEmpty())
				return false;
			users.add(userRepo.findById(userId).get());	
		}
		
		Group newGroup = new Group();
		newGroup.setName(name);
		groupRepo.save(newGroup);
		
		
		
		newGroup.setAdmin(admin);
		newGroup.setMembers(users);
		
		return groupRepo.save(newGroup) != null;
	}


	@Override
	public List<Group> getUserGroupes(int userId) {
		
		List<Group> groups = new ArrayList<Group>();
		
		for(Group g: groupRepo.findAll()) {
			if(g.getAdmin().getUserId() == userId)
				groups.add(g);
			else {
				for(AppUser u: g.getMembers()) {
					if(u.getUserId() == userId)
						groups.add(g);
				}
			}
		}
		
		return groups;
	}

}
