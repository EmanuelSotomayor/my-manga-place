package com.my.manga.place.dev.dtos;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class APIError {
    private HttpStatus status;
    private List<ValidationErrorDTO> errorFields;
    private String actualDate;
    public APIError(){}
    public APIError(HttpStatus status, List<ValidationErrorDTO> errorFields){
        this.status = status;
        this.errorFields = errorFields;
        this.actualDate = this.getActualDate();
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public List<ValidationErrorDTO> getErrorFields() {
        return errorFields;
    }
    public void setErrorFields(List<ValidationErrorDTO> errorFields) {
        this.errorFields = errorFields;
    }
    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }
    public String getActualDate(){
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date.getTime());
    }

}