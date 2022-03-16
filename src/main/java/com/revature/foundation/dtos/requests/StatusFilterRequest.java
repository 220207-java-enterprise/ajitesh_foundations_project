package com.revature.foundation.dtos.requests;

public class StatusFilterRequest {
    private String status_id;

    public StatusFilterRequest(){
        super();
    }

    public StatusFilterRequest(String status_id){
        this.status_id = status_id;
    }

    public String getStatus_id(){return status_id;}
    public void setStatus_id(String status_id){this.status_id= status_id;}


    public String toString() {
        return "FilterRequest{" +
                "status_id='" + status_id+ '\'' +
                '}';
    }
}
