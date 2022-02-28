package com.revature.foundation.models;

import java.util.Objects;

public class Reimbursement {
    private String id;
    private double amount;
    private String description;
    private String author_id;
    private String resolver_id;
    private ReimbursementStatus status;
    private ReimbursementType type;

    public Reimbursement() {
        super();
    }

    public Reimbursement(double amount,String description, String author_id) {
        this.amount = amount;
        this.description = description;
        this.author_id = author_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getResolver_id() {
        return resolver_id;
    }

    public void setResolver_id(String resolver_id) {
        this.resolver_id = resolver_id;
    }

    public ReimbursementStatus getReimbursementStatus() {
        return status;
    }

    public void setReimbursementStatus(ReimbursementStatus status) {
        this.status = status;
    }

    public ReimbursementType getReimbursementType() {
        return type;
    }

    public void setReimbursementType(ReimbursementType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement reimbursement = (Reimbursement) o;
        return Objects.equals(id, reimbursement.id) && Objects.equals(amount, reimbursement.amount) && Objects.equals(description, reimbursement.description) && Objects.equals(author_id, reimbursement.author_id) && Objects.equals(resolver_id, reimbursement.resolver_id) && Objects.equals(status, reimbursement.status) && Objects.equals(type, reimbursement.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, description, author_id, resolver_id, status, type);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id='" + id + '\'' +
                ", amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", author_id='" + author_id + '\'' +
                ", resolver_id='" + resolver_id + '\'' +
                ", Reimbursement_status='" + status + '\'' +
                ", Reimbursement_type='" + type+ '\'' +
                '}';
    }

}
