package no.rini.personal.TodoApp.service;

import no.rini.personal.TodoApp.model.Task;
import no.rini.personal.TodoApp.repositroy.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){return  taskRepository.findAll();}

    public Task getTask(Integer id){
        Optional<Task> foundTask = taskRepository.findById(id);
        return foundTask.orElse(null);
    }

    public String addTask(Task task){
        taskRepository.saveAndFlush(task);
        return "Task Added";
    }

    public String editTask(Task edittask,Integer id){
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            taskRepository.saveAndFlush(edittask);
            return "Task edited";
        }else{
            return "Task does not exist";
        }

    }

    public String deleteTask(Integer id){
        taskRepository.deleteById(id);
        return "Task deleted";
    }



}
