package com.chisimdi.restfulwebservices.exception;

import java.util.Date;

public class ApplicationError {
  private int code;
  private Date timestamp;
  private String message;
  private String details;

  public int getCode() {
    return code;
  }
  public void setCode(int code) {
    this.code = code;
  }
  public Date getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String getDetails() {
    return details;
  }
  public void setDetails(String details) {
    this.details = details;
  }
}