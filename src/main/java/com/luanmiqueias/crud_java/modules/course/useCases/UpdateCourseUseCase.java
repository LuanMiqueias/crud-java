package com.luanmiqueias.crud_java.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanmiqueias.crud_java.exceptions.CourseNotFoundException;
import com.luanmiqueias.crud_java.modules.course.CourseEntity;
import com.luanmiqueias.crud_java.modules.course.CourseRepository;

@Service
public class UpdateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(UUID id, CourseEntity courseEntity) {
    var course = courseRepository.findById(id).orElseThrow(() -> {
      throw new CourseNotFoundException();
    });

    course.setName(courseEntity.getName());
    course.setCategory(courseEntity.getCategory());

    return this.courseRepository.save(course);
  }
}
