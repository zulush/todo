package ma.test.pdfGeneratorTest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.test.pdfGeneratorTest.entity.Task;

@RestController() @RequestMapping("/task")
public class TaskController {

	@GetMapping("/personal")
	public List<Task> personalTask() {
		
		List<Task> tasks = new ArrayList<Task>();
		
		tasks.add(new Task(1, "établir le Product Backlog", new Date(), false, "crée par Mohamed Z", new Date()));
		tasks.add(new Task(2, "fixer la date du Sprint Planning Meeting", new Date(), false, "crée par Mohamed Z", new Date()));
		tasks.add(new Task(3, "établir le Sprint backlog", new Date(), false, "crée par Mohamed Z", new Date()));
		
		return tasks;
	}
	
}
