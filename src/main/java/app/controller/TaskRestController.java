package app.controller;

import app.services.Task;
import app.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskRestController {
    @Autowired
    private TaskService service;

    @GetMapping("/rest/task/list")
    public ResponseEntity<List<Task>> getTasks(){
        return new ResponseEntity<>(service.get(), HttpStatus.OK);
    }

    @GetMapping("/rest/task/{id}")
    public @ResponseBody Task getTask(@PathVariable("id")Long id ){
        return service.get(id);
    }

    @PostMapping("/rest/task/add")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody Task task){
        service.create(task);
    }

    @PutMapping("/rest/task/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Task task){
        service.update(task);
    }

    @DeleteMapping("/rest/task/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

}
