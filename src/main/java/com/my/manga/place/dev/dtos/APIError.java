package com.my.manga.place.dev.dtos;
import org.springframework.http.HttpStatus;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class APIError {
    private HttpStatus status;
    private List<ValidationErrorDTO> errorFields;
    private Calendar date;
    public APIError(){}
    public APIError(HttpStatus status, List<ValidationErrorDTO> errorFields){
        this.status = status;
        this.errorFields = errorFields;
        this.date = this.getDate();
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
    public void setDate(Calendar date) {
        this.date = date;
    }
    public Calendar getDate(){
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        return Calendar.getInstance();
    }

}