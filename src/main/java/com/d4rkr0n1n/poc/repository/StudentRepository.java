package com.d4rkr0n1n.poc.repository;

import java.util.UUID;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.d4rkr0n1n.poc.model.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, UUID>{

  @Modifying
  @Query("INSERT INTO student (id, name, course) VALUES (:id, :name, :course)")
  void insertStudent(UUID id, String name, String course);
  
}
