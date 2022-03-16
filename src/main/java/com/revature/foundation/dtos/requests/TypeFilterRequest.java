package com.revature.foundation.dtos.requests;

public class TypeFilterRequest {
    private String type_id;

    public TypeFilterRequest(){
        super();
    }

    public TypeFilterRequest(String type_id){
        this.type_id = type_id;
    }

    public String getType_id(){return type_id;}
    public void setType_id(String type_id){this.type_id=type_id;}


    public String toString() {
        return "FilterRequest{" +
                "type_id='" + type_id + '\'' +
                '}';
    }
}
