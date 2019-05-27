package com.stackroute.exceptions;

public class trackAlreadyExistException extends Exception {
  private String message;

  public trackAlreadyExistException(){}
  public trackAlreadyExistException(String message)
  {
    super(message);
    this.message=message;
  }
}
