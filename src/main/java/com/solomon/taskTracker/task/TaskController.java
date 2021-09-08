package com.solomon.taskTracker.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/tasks")
@CrossOrigin(origins="http://localhost:4200/")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping("/tasks")
    public List<Task> allTasks(){
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getBookById(@PathVariable String id){
        return repository.findById(id);
    }

    @PostMapping("/tasks/addTask")
    public String addTask(@RequestBody Task task){
        repository.save(task);
        return task.toString() +" is added";
    }

    @DeleteMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable String id){
//        if (repository.findById(id) != null) {
//            repository.deleteById(id);
//            return "Task with id " + id + " has been deleted!";
//        }
//        else {
//            return "Task with id " + id + " isn't found";
//        }
        repository.deleteById(id);
        return "Task with id " + id + " has been deleted!";
    }


    @PutMapping("/tasks/edit/{id}")
    public Task editTask(@PathVariable String id, @RequestBody Task task){
        Optional<Task> taskData = repository.findById(id);

        if(taskData.isPresent()){
            Task editedTask = taskData.get();
            editedTask.set_id(task.get_id());
            editedTask.setText(task.getText());
            editedTask.setDay(task.getDay());
            editedTask.setReminder(task.getReminder());
            repository.save(editedTask);
            return editedTask;
        }
        return task;
    }


}
