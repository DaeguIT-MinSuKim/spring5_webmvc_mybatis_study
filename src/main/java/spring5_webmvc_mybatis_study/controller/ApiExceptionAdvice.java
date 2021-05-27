package spring5_webmvc_mybatis_study.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import spring5_webmvc_mybatis_study.error_response.ErrorResponse;
import spring5_webmvc_mybatis_study.exception.MemberNotFoundException;

@RestControllerAdvice("spring5_webmvc_mybatis_study.controller")
public class ApiExceptionAdvice {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoData(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
    }

}
