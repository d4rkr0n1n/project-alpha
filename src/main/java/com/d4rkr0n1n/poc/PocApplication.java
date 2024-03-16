package com.d4rkr0n1n.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PocApplication {

  public static void main(String[] args) {
    SpringApplication.run(PocApplication.class, args);
  }

}
