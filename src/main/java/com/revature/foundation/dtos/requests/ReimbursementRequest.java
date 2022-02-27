package com.revature.foundation.dtos.requests;

import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.ReimbursementType;

public class ReimbursementRequest {
    private double amount;
    private String description;
    private ReimbursementType type;

    public ReimbursementRequest(){ super();}

    public ReimbursementRequest(double amount, String description, ReimbursementType type){
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public double getAmount(){return amount;}

    public void setAmount(double amount){this.amount = amount;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description=description;}

    public ReimbursementType getType(){return type;}

    public void setType(ReimbursementType type) {this.type = type;}

    public Reimbursement extractReimbursement() {
        return new Reimbursement(amount, description, type);
    }

    public String toString() {
        return "ReimbursementRequest{" +
                "amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", type_id='" + type.getId() + '\'' +
                ", type_name='" + type.getTypeName() + '\'' +
                '}';
    }

}
