package com.d4rkr0n1n.poc.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4rkr0n1n.poc.model.Student;
import com.d4rkr0n1n.poc.repository.CourseRepository;
import com.d4rkr0n1n.poc.repository.StudentRepository;
import com.d4rkr0n1n.poc.service.StudentService;

import lombok.extern.java.Log;

@RestController
@Log
public class StudentController {

  private final CourseRepository courseRepository;
  private final StudentRepository studentRepository;

   public StudentController(CourseRepository courseRepository,StudentRepository studentRepository) {
     this.courseRepository = courseRepository;
     this.studentRepository = studentRepository;
   }
  @GetMapping("/test")
  public Student test() {
    //Insert data in Course Table
    
    Student student1 = new Student(UUID.randomUUID(),"John Doe", "Alpha1");
    Student student2 = new Student(UUID.randomUUID(),"Jane Doe", "Alpha2");
    studentRepository.insertStudent(student1.id(), student1.name(), student1.course());
    studentRepository.insertStudent(student2.id(), student2.name(), student2.course());
    courseRepository.insertCourse(UUID.randomUUID(), "Alpha1", student1.id());
    courseRepository.insertCourse(UUID.randomUUID(), "Alpha2", student2.id());


    return StudentService.testService();
  }

  @GetMapping("/test2")
  public Student test2() {
    //Insert data in Course Table
    log.info(courseRepository.findAllCoursesWithStudents().toString());

    return StudentService.testService();
  }
}
