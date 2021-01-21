/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Algaworks.osworks.Osworksapi.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.lang.NonNull;

/**
 *
 * @author VAMARAL
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue {
    private Integer status;
    private LocalDateTime time;
    private String title;
    private List<Issue.Field> fieldList;
    
    public static class Field{
        private String  nameCamp;
        private String message;

        public Field(String nameCamp, String message) {
            this.nameCamp = nameCamp;
            this.message = message;
        }
        
        
        
        public String getNameCamp() {
            return nameCamp;
        }

        public void setNameCamp(String nameCamp) {
            this.nameCamp = nameCamp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }
    
    
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
