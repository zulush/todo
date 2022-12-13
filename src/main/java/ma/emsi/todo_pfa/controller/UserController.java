package ma.emsi.todo_pfa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.todo_pfa.entity.AppUser;
import ma.emsi.todo_pfa.model.UserModel;
import ma.emsi.todo_pfa.service.UserService;


@RestController() @RequestMapping("/user") @CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userSer;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/search")
	public ResponseEntity<UserModel> getByUsername(@RequestParam(name ="username") String username) {
		
		UserModel user = userSer.getByUsername(username);
		if(user != null)
			return ResponseEntity.ok(user);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/add_task")
	public ResponseEntity<Object> addTaskToUser(@RequestParam(name ="task_id") int task_id, @RequestParam(name ="user_id") int user_id){
		
		if(userSer.addTaskToUser(task_id, user_id))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
