package com.revature.foundation.dtos.responses;

import com.revature.foundation.models.AppUser;

public class UpdateUserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String role_id;


    public UpdateUserResponse(){super();}

    public UpdateUserResponse(AppUser appUser) {
        this.id = appUser.getId();
        this.firstName = appUser.getFirstName();
        this.lastName = appUser.getLastName();
        this.email = appUser.getEmail();
        this.username = appUser.getUsername();
        this.password = appUser.getPassword();
        this.role_id = appUser.getRole().getId();
    }

    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    public String getRole_id(){return role_id;}
    public void setRole_id(String role_id){this.role_id = role_id;}

    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
