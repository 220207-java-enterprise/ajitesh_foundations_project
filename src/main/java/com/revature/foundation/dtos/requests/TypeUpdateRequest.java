package com.revature.foundation.dtos.requests;

public class TypeUpdateRequest {
    private String type_id;
    private String reimb_id;

    public TypeUpdateRequest(){
        super();
    }
    public TypeUpdateRequest(String type_id, String reimb_id){
        this.type_id = type_id;
        this.reimb_id = reimb_id;
    }
    public String getType_id(){return type_id;}
    public void setType_id(String type_id){this.type_id=type_id;}
    public String getReimb_id(){return reimb_id;}
    public void setReimb_id(String reimb_id){this.reimb_id = reimb_id;}

    public String toString() {
        return "UpdateRequest{" +
                "stype_id='" + type_id + '\'' +
                ", password='" + reimb_id + '\'' +
                '}';
    }
}
