package com.luanmiqueias.crud_java.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanmiqueias.crud_java.enums.Status;
import com.luanmiqueias.crud_java.exceptions.CourseNotFoundException;
import com.luanmiqueias.crud_java.modules.course.CourseEntity;
import com.luanmiqueias.crud_java.modules.course.CourseRepository;

@Service
public class UpdateStatusCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(UUID id, Status status) {
    CourseEntity course = courseRepository.findById(id).orElseThrow(() -> {
      throw new CourseNotFoundException();
    });

    course.setActive(status);
    return this.courseRepository.save(course);
  }
}
