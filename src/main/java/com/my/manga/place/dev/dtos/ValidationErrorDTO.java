package com.my.manga.place.dev.dtos;
public class ValidationErrorDTO {
    private String field;
    private String message;
    public ValidationErrorDTO(){}
    public ValidationErrorDTO(String field, String message) {
        super();
        this.field = field;
        this.message = message;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}