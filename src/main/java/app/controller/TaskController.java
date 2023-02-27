package app.controller;

import app.services.Task;
import app.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.logging.Logger;


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

    @PostMapping("/task/add")
    public RedirectView save(@ModelAttribute Task task){
        task.setId((long) service.size() + 1);
        service.create(task);
        return new RedirectView("/Spring_web_MVC_modern_war/index");
    }
}
