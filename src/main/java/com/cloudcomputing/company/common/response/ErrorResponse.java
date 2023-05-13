package com.cloudcomputing.company.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {

  private Integer code;
  private String message;

  @Builder
  public ErrorResponse(
      Integer code,
      String message
  ) {
    this.code = code;
    this.message = message;
  }
}