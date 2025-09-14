package com.nikhil.ems.constants;

public enum Message {

  OPTIMISTIC_LOCKING_EXCEPTION("ERR_001",
      "Oops! This request seems outdated. Please refresh the page and try again."),
  USER_NOT_FOUND_EXCEPTION("ERR_002", "User not found. Please check the provided details."),
  INVALID_LOGIN_CREDENTIALS("ERR_003", "Invalid login credentials. Please try again."),

  SUCCESS_MESSAGE("SUCCESS", "Successful response."),
  FAILURE_MESSAGE("FAILURE", "Failed to get response.");

  public final String messageCode;
  public final String message;

  Message(String messageCode, String message) {
    this.messageCode = messageCode;
    this.message = message;
  }
}
