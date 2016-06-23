package com.epona.configuration;


public class HBaseConnectionException extends RuntimeException {

  public HBaseConnectionException() {
    super();
  }

  public HBaseConnectionException(String message) {
    super(message);
  }
}
