package com.it210_04_25.controller;

import com.it210_04_25.model.entity.Todo;
import com.it210_04_25.reponsitory.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String redirectToList() {
        return "redirect:/todos/list";
    }

    @GetMapping("/list")
    public String listTodo(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "listTodo";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "form";
    }

    @PostMapping("/form")
    public String addTodo(@Valid @ModelAttribute("todo") Todo todo,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        todoRepository.save(todo);
        return "redirect:/todos/list";
    }
}