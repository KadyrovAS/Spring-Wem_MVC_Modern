package app.controller;

import app.services.Task;
import app.services.TaskService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


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

    @GetMapping("/task/delete")
    public RedirectView delete(@RequestParam("id") Long id){
        service.delete(id);
        return new RedirectView("/Spring_web_MVC_modern_war/index");
    }

    @GetMapping(value = "/task/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        Task task = service.get(id);
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/task/edit")
    public RedirectView taskEdit(@ModelAttribute Task task){
        Log log = LogFactory.getLog(Class.class);
        log.info("ERROR !!!!");
        service.update(task);
        return new RedirectView("/Spring_web_MVC_modern_war/index");
    }
}
