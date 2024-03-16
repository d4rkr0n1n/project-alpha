package com.d4rkr0n1n.poc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4rkr0n1n.poc.client.IpTest;
import com.d4rkr0n1n.poc.util.JsonUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ResponseController {

  private final IpTest ipTest;

  @GetMapping(value = "/resttest", produces = "application/json")
  public String test() {
    return JsonUtils.toJson(ipTest.getAnything());
  }

}
