package kybmig.ssm.controller;

import kybmig.ssm.Utility;
import kybmig.ssm.model.TodoModel;
import kybmig.ssm.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ModelAndView add(String content) {
        TodoModel todo = service.add(content);
        Utility.log("todo add id %s", todo.getId());
        return new ModelAndView("redirect:/todo");
    }

    @GetMapping("/delete")
    public String deleteMapper(int id) {
        service.deleteById(id);
        return "redirect:/todo";
    }


    @GetMapping("/edit")
    public ModelAndView edit(int id) {
        TodoModel todo = service.findById(id);

        ModelAndView m = new ModelAndView("todo_edit");
        m.addObject("todo", todo);
        return m;
    }

    @PostMapping("/update")
    public String updateMapper(int id, String content) {
        service.update(id, content);
        return "redirect:/todo";
    }

    @GetMapping({"/", ""})
    public ModelAndView index() {
        Utility.log("todo index");
        List<TodoModel> todos = service.all();
        ModelAndView m = new ModelAndView("todo_index");
        m.addObject("todos", todos);
        return m;
    }
}
