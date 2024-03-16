package com.d4rkr0n1n.poc.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.d4rkr0n1n.poc.service.TodoService;


@Controller
@RequestMapping("/todo")
@SessionAttributes("name")
public class TodoController {

  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/list")
  public String listAllTodos(ModelMap model, SessionStatus status) {
    var name = model.getAttribute("name");
    if (name != null) {
      model.addAttribute("todos", todoService.getTodosByUsername(name.toString()));
    } else {
      model.addAttribute("todos", todoService.getTodos());
    }

    return "listTodos";
  }

  @GetMapping("/add")
  public String showNewTodoPage() {
    return "todo";
  }

  @PostMapping("/add")
  public String addNewTodo(@RequestParam String description,ModelMap model, SessionStatus status) {
    var username = model.getAttribute("name");
    LocalDate targetDate = LocalDate.now().plusYears(1);
    boolean done =false;
    if (username != null) {
      todoService.addTodo(username.toString(), description, targetDate, done);
    }
    return "redirect:/todo/list";
  }

  @GetMapping("/logout")
  public String logout(SessionStatus status) {
    status.setComplete();
    return "redirect:login";
  }
}
