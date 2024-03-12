package com.d4rkr0n1n.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.d4rkr0n1n.poc.model.User;
import com.d4rkr0n1n.poc.service.AuthenticationService;

@Controller
@SessionAttributes("name")
public class UserController {

  private AuthenticationService authenticationService;

  public UserController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @RequestMapping(value = "/")
  public String index(ModelMap modelMap, SessionStatus status) {
    modelMap.addAttribute("spring", "mvc");
    modelMap.addAttribute("message", "Baeldung");
    status.setComplete();
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String login(@RequestParam String name, @RequestParam String password, ModelMap model) {
    if(authenticationService.authenticate(name, password)) {
      model.addAttribute("name", name);
      model.addAttribute("password", password);
      User user = new User(name);
      model.addAttribute("user", user);
      return "welcome";
    } else {
      model.addAttribute("error", "Invalid username or password");
      return "login";
    }
  }
}
