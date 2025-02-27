package com.luanmiqueias.crud_java.exceptions;

public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException() {
    super("Curso não existe");
  }
}
