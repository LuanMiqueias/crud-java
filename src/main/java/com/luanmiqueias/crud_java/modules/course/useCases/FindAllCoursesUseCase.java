package com.luanmiqueias.crud_java.modules.course.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanmiqueias.crud_java.modules.course.CourseEntity;
import com.luanmiqueias.crud_java.modules.course.CourseRepository;

@Service
public class FindAllCoursesUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public List<CourseEntity> execute() {
    return this.courseRepository.findAll();
  }
}
