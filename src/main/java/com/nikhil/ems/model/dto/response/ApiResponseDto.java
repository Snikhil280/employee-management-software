package com.nikhil.ems.model.dto.response;

import com.nikhil.ems.constants.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiResponseDto<T> {

  private String status;
  private String message;
  private T data;

  public ApiResponseDto(T data) {
    this.status = Message.SUCCESS_MESSAGE.messageCode;
    this.message = Message.SUCCESS_MESSAGE.message;
    this.data = data;
  }

}