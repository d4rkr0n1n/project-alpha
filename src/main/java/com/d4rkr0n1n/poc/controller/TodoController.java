package com.d4rkr0n1n.poc.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.d4rkr0n1n.poc.model.Todo;
import com.d4rkr0n1n.poc.service.TodoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todo")
@SessionAttributes("name")
public class TodoController {

  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/list")
  public String listAllTodos(ModelMap model) {
    var name = model.getAttribute("name");
    if (name != null) {
      model.addAttribute("todos", todoService.getTodosByUsername(name.toString()));
    } else {
      model.addAttribute("todos", todoService.getTodos());
    }

    return "listTodos";
  }

  @GetMapping("/add")
  public String showNewTodoPage(ModelMap model) {
    model.addAttribute("todo", new Todo());
    return "todo";
  }

  @PostMapping("/add")
  public String addNewTodo(ModelMap model, @Valid @ModelAttribute Todo todo, BindingResult result) {
    System.out.println("Error: " + result.getAllErrors());
    var username = model.getAttribute("name");
    todo.setUsername(username == null ? "anonymous" : username.toString());
    todo.setTargetDate(LocalDate.now().plusYears(1));
    todo.setDone(false);
    todoService.addTodo(todo);
    if (result.hasErrors()) {
      return showNewTodoPage(model);
    } else {
      return "redirect:/todo/list";
    }
  }

  @GetMapping("/logout")
  public String logout(SessionStatus status) {
    status.setComplete();
    return "redirect:login";
  }
}
