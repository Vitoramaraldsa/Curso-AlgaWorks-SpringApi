/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Algaworks.osworks.Osworksapi.exceptionhandler;

import com.Algaworks.osworks.Osworksapi.domain.exception.BusinessException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author VAMARAL
 */
@ControllerAdvice
public class ApiHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusiness(BusinessException ex, WebRequest request){
        var status = HttpStatus.BAD_REQUEST;
        var issue = new Issue();
        issue.setStatus(status.value());
        issue.setTitle(ex.getMessage());
        issue.setTime(LocalDateTime.now());
        
        return handleExceptionInternal(ex, issue, new HttpHeaders(), status, request);
       }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var issue = new Issue();
        var fields = new ArrayList<Issue.Field>();
        
        for (ObjectError Error : ex.getBindingResult().getAllErrors()) {
           String message = Error.getDefaultMessage();
           String nameField = ((FieldError) Error).getField();
           
           fields.add(new Issue.Field(nameField,message));
        }
        
        issue.setStatus(status.value());
        issue.setTitle("Campos inválidos ou em branco !");
        issue.setTime(LocalDateTime.now());
        issue.setFieldList(fields);
        
        
        return super.handleExceptionInternal(ex, issue, headers, status, request);
    }
    
}
