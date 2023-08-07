package com.my.manga.place.dev.dtos;

public class UserRolSimpleDTO {
    private String userEmail;
    private String rolName;
    public UserRolSimpleDTO(){}
    public UserRolSimpleDTO(String userEmail, String rolName) {
        this.userEmail = userEmail;
        this.rolName = rolName;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }
    @Override
    public String toString() {
        return "UserRolSimpleDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", rolName='" + rolName + '\'' +
                '}';
    }

}
