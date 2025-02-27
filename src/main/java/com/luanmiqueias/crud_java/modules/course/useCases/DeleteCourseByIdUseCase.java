package com.luanmiqueias.crud_java.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanmiqueias.crud_java.exceptions.CourseNotFoundException;
import com.luanmiqueias.crud_java.modules.course.CourseEntity;
import com.luanmiqueias.crud_java.modules.course.CourseRepository;

@Service
public class DeleteCourseByIdUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public void execute(UUID id) {
    CourseEntity course = courseRepository.findById(id).orElseThrow(() -> {
      throw new CourseNotFoundException();
    });

    this.courseRepository.deleteById(course.getId());
  }
}
