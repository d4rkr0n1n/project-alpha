package com.d4rkr0n1n.poc.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4rkr0n1n.poc.model.SimpleObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/v1/simple")
@Log
public class SimpleObjectController {

  @GetMapping("/test")
  public SimpleObject test() throws JsonProcessingException {
    var simpleObject = new SimpleObject("test", LocalDateTime.now());

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    SimpleModule simpleModule = new SimpleModule();

    mapper.registerModule(simpleModule);

    var testObj = mapper.writeValueAsString(simpleObject);
    System.out.println("Object to Json String" + testObj);

    var testObj2 = mapper.readValue(testObj, SimpleObject.class);
    System.out.println("Json String to Object" + testObj2);
    System.out.println(Timestamp.valueOf(testObj2.timeStamp()));

    System.out.println("Object to Json String" + mapper.writeValueAsString(testObj2));
    log.info("Object to Json String" + mapper.writeValueAsString(testObj2));
    return simpleObject;
  }

}
