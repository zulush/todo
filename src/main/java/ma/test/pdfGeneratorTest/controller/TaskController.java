package ma.test.pdfGeneratorTest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.test.pdfGeneratorTest.entity.Task;

@RestController() @RequestMapping("/task")
public class TaskController {

	static List<Task> tasks = new ArrayList<Task>();
	static int count = 4;
	
	static{
		TaskController.tasks.add(new Task(1, "établir le Product Backlog", new Date(), false, "crée par Mohamed Z", new Date()));
		TaskController.tasks.add(new Task(2, "fixer la date du Sprint Planning Meeting", new Date(), false, "crée par Mohamed Z", new Date()));
		TaskController.tasks.add(new Task(3, "établir le Sprint backlog", new Date(), false, "crée par Mohamed Z", new Date()));
	}
	
	
	@GetMapping("/personal")
	public List<Task> personalTask() {
		
		return tasks;
	}
	
	
	@PostMapping("/personal")
	public ResponseEntity<Object> addTask(@RequestBody Task newTask) {
		
		try {
			newTask.setLastUpdateDate(new Date());
			
			tasks.add(newTask);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
