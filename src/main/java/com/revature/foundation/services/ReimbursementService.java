package com.revature.foundation.services;

import com.revature.foundation.dtos.requests.ReimbursementRequest;
import com.revature.foundation.dtos.responses.ReimbursementResponse;
import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.models.ReimbursementStatus;
import com.revature.foundation.models.ReimbursementType;
import com.revature.foundation.daos.ReimbursementDAO;
import com.revature.foundation.util.exceptions.AuthenticationException;
import com.revature.foundation.util.exceptions.InvalidRequestException;
import com.revature.foundation.util.exceptions.ResourceConflictException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class ReimbursementService {

    private ReimbursementDAO reimbursementDAO;

    public ReimbursementService(ReimbursementDAO reimbursementDAO){
        this.reimbursementDAO = reimbursementDAO;
    }

    public List<ReimbursementResponse> getAllReimbursements(){
        return reimbursementDAO.getAll().stream().map(ReimbursementResponse::new).collect(Collectors.toList());
    }

    public Reimbursement register_reimbursement(ReimbursementRequest reimbursementRequest) throws IOException{
        Reimbursement reimbursement = reimbursementRequest.extractReimbursement();

        reimbursement.setId(UUID.randomUUID().toString());
        reimbursement.setReimbursementStatus(new ReimbursementStatus("7c3521f5-ff75-4e8a-9913-01d15ee4dc9e","PENDING"));
        reimbursement.setResolver_id("3363b6d7-6592-45fc-bcff-8f968a26a514");
        reimbursement.setAuthor_id("b9616166-c655-47d0-b247-b51b25c6879f");
        reimbursement.setReimbursementType(new ReimbursementType("7c3521f5-ff75-4e8a-9913-01d15ee4dc9d","OTHER"));

        reimbursementDAO.save(reimbursement);
        return reimbursement;
    }



}
