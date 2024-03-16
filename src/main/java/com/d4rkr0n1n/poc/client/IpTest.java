package com.d4rkr0n1n.poc.client;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "response", url = "https://httpbin.org")
public interface IpTest {

  @GetMapping("/anything")
  HashMap<String,Object> getAnything();

}
