package com.d4rkr0n1n.poc.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
 
  public boolean authenticate(String username, String password) {
    return username.equals("d4rkr0n1n") && password.equals("a3th3r3al");
  }
}
