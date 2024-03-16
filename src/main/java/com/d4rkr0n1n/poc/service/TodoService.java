package com.d4rkr0n1n.poc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.d4rkr0n1n.poc.model.Todo;

@Service
public class TodoService {
  private static List<Todo> todos = new ArrayList<>();

  static {
    todos.add(new Todo(1, "d4rkr0n1n", "Learn Java from scratch", LocalDate.now().plusDays(1), false));
    todos.add(new Todo(2, "alpha", "Learn Spring Boot from scratch", LocalDate.now().plusDays(2), false));
    todos.add(new Todo(3, "bravo", "Learn React from scratch", LocalDate.now().plusDays(3), false));
    todos.add(new Todo(4, "charlie", "Learn React from scratch", LocalDate.now().plusDays(4), false));
  }

  public List<Todo> getTodos() {
    return todos;
  }

  public List<Todo> getTodosByUsername(String username) {
    return getTodos().stream().filter(todo -> todo.username().equals(username)).toList();
  }

  public void addTodo(String username,String description, LocalDate targetDate, boolean done) {
    todos.add(new Todo(todos.size() + 1, username, description, targetDate, done));
  }
}
