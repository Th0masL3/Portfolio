package com.lecoingameover.belecoingameover.utils.exceptions;

public class DuplicateConsoleException extends RuntimeException {

  public DuplicateConsoleException() {}

  public DuplicateConsoleException(String message) {
    super(message);
  }

  public DuplicateConsoleException(Throwable cause) {
    super(cause);
  }

  public DuplicateConsoleException(String message, Throwable cause) {
    super(message, cause);
  }
}
