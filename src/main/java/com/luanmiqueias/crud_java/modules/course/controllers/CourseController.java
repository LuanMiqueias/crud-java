package com.luanmiqueias.crud_java.modules.course.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luanmiqueias.crud_java.enums.Status;
import com.luanmiqueias.crud_java.modules.course.CourseEntity;
import com.luanmiqueias.crud_java.modules.course.dto.CreateCourseDto;
import com.luanmiqueias.crud_java.modules.course.useCases.CreateCourseUseCase;
import com.luanmiqueias.crud_java.modules.course.useCases.DeleteCourseByIdUseCase;
import com.luanmiqueias.crud_java.modules.course.useCases.FindAllCoursesUseCase;
import com.luanmiqueias.crud_java.modules.course.useCases.UpdateCourseUseCase;
import com.luanmiqueias.crud_java.modules.course.useCases.UpdateStatusCourseUseCase;

@RestController
@RequestMapping("courses")
public class CourseController {

  @Autowired
  CreateCourseUseCase createCourseUseCase;

  @Autowired
  UpdateCourseUseCase updateCourseUseCase;

  @Autowired
  UpdateStatusCourseUseCase updateStatusCourseUseCase;

  @Autowired
  FindAllCoursesUseCase findAllCoursesUseCase;

  @Autowired
  DeleteCourseByIdUseCase deleteCourseByIdUseCase;

  @GetMapping("")
  public ResponseEntity<Object> getCourse() {
    var courses = this.findAllCoursesUseCase.execute();
    return ResponseEntity.ok().body(courses);
  }

  @PostMapping("")
  public CourseEntity createCourse(@RequestBody CourseEntity courseEntity) {
    return this.createCourseUseCase.execute(courseEntity);
  }

  @PatchMapping("{id}")
  public CourseEntity updateCourse(@PathVariable UUID id, @RequestBody CourseEntity courseEntity) {
    return this.updateCourseUseCase.execute(id, courseEntity);
  }

  @PutMapping("{id}/{status}")
  public CourseEntity updateStatusCourse(@PathVariable UUID id, @PathVariable Status status) {
    return this.updateStatusCourseUseCase.execute(id, status);
  }

}
