package com.d4rkr0n1n.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.d4rkr0n1n.poc.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/list-todos")
  public String listAllTodos(ModelMap model, SessionStatus status) {
    status.setComplete();
    var name = model.getAttribute("name");
    if (name != null) {
      model.addAttribute("todos", todoService.getTodosByUsername(name.toString()));
    } else {
      model.addAttribute("todos", todoService.getTodos());
    }

    return "listTodos";
  }

}
