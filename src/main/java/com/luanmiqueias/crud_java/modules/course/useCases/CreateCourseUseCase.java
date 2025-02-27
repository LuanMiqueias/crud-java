package com.luanmiqueias.crud_java.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanmiqueias.crud_java.modules.course.CourseEntity;
import com.luanmiqueias.crud_java.modules.course.CourseRepository;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(CourseEntity courseEntity) {
    return this.courseRepository.save(courseEntity);
  }
}
