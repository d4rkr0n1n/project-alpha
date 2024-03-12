package com.d4rkr0n1n.poc.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.d4rkr0n1n.poc.model.Course;
import com.d4rkr0n1n.poc.model.CourseWithStudent;
@Repository
public interface CourseRepository extends CrudRepository<Course, UUID>{
  @Modifying
  @Query("INSERT INTO course (id, name, student_id) VALUES (:id, :name, :studentId)")
  void insertCourse(UUID id, String name, UUID studentId);

  @Query("SELECT a.*,b.* FROM course a join student b on a.student_id = b.id")
  List<CourseWithStudent> findAllCoursesWithStudents();
}
