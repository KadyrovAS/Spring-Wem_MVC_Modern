package app.controller;

import app.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping("/index")
    public String getTask(Model model){
        model.addAttribute("list", service.get());
        return "index";
    }

    @GetMapping("/task/add")
    public String getAddView(){
        return "add";
    }

}
