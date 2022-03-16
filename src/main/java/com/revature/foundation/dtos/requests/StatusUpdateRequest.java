package com.revature.foundation.dtos.requests;


public class StatusUpdateRequest {
    private String status_id;
    private String reimb_id;

    public StatusUpdateRequest(){
        super();
    }
    public StatusUpdateRequest(String status_id, String reimb_id){
        this.status_id = status_id;
        this.reimb_id = reimb_id;
    }
    public String getStatus_id(){return status_id;}
    public void setStatus_id(String status_id){this.status_id=status_id;}
    public String getReimb_id(){return reimb_id;}
    public void setReimb_id(String reimb_id){this.reimb_id = reimb_id;}

    public String toString() {
        return "UpdateRequest{" +
                "status_id='" + status_id + '\'' +
                ", password='" + reimb_id + '\'' +
                '}';
    }
}
