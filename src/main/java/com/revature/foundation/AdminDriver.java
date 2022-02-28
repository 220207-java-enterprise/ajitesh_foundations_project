package com.revature.foundation;


import com.revature.foundation.daos.ReimbursementDAO;
import com.revature.foundation.models.Reimbursement;

public class AdminDriver {

    public static void main(String[] args) {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setId("1234");
        ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
        reimbursementDAO.update_status(reimbursement);
    }

}
