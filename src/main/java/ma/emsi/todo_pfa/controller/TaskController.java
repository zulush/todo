package ma.emsi.todo_pfa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.todo_pfa.entity.Task;
import ma.emsi.todo_pfa.service.TaskService;

@RestController() @RequestMapping("/task") @CrossOrigin(origins = "*")
public class TaskController {
	
	@Autowired
	TaskService taskSer;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/personal")
	public List<Task> personalTask() {
		
		return taskSer.getAllTasks();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/personal")
	public ResponseEntity<Object> addTask(@RequestParam(name ="name") String name, @RequestParam(name="deadline") Date deadline) {
		
		try {
			if(taskSer.add(new Task(0, name, deadline, false, "crée par frontend or mobile Dev", new Date()), 0) == null)
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
