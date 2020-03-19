package no.rini.personal.TodoApp.api;

import no.rini.personal.TodoApp.model.Task;
import no.rini.personal.TodoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @Autowired
    TaskService taskService;

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping(value = "/sayHello/{name}",produces = "application/json")
    public ResponseEntity<String> sayHello (@PathVariable("name") String name){
        return ResponseEntity.ok("Hello " + name);
    }

    @GetMapping(value = "/getAllTasks", produces = "application/json")
    public ResponseEntity<?> getAllTasks(){return ResponseEntity.ok(taskService.getAllTasks());}

    @PostMapping(value = "/addTask",produces = "application/json",consumes = "application/json")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.addTask(task));
    }

    @PutMapping(value = "/editTask{id}")
    public ResponseEntity<String> editTask(@Valid @RequestBody Task edittask, @PathVariable("id") Integer id){
        tasks.removeIf((Task task) -> edittask.getId().equals(id));
        tasks.add(edittask);
        return ResponseEntity.ok(taskService.editTask(edittask,id));
    }

    @DeleteMapping(value = "/deleteTask/{id}")
    public ResponseEntity<String> deleteTask(@Valid @RequestBody Task deletetask,@PathVariable("id") Integer id){
        tasks.removeIf((Task task)-> deletetask.getId().equals(id));
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}
