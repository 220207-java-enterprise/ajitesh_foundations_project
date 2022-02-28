package com.revature.foundation.servlets;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundation.dtos.requests.LoginRequest;
import com.revature.foundation.dtos.requests.StatusUpdateRequest;
import com.revature.foundation.dtos.requests.TypeUpdateRequest;
import com.revature.foundation.dtos.responses.Principal;
import com.revature.foundation.dtos.responses.StatusUpdateResponse;
import com.revature.foundation.dtos.responses.TypeUpdateResponse;
import com.revature.foundation.models.AppUser;
import com.revature.foundation.models.Reimbursement;
import com.revature.foundation.services.ReimbursementService;
import com.revature.foundation.services.UserService;
import com.revature.foundation.util.exceptions.AuthenticationException;
import com.revature.foundation.util.exceptions.InvalidRequestException;
import com.revature.foundation.util.exceptions.ResourceConflictException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class TypeServlet extends HttpServlet {
    private final ReimbursementService reimbursementService;
    private final ObjectMapper mapper;

    public TypeServlet(ReimbursementService reimbursementService, ObjectMapper mapper) {
        this.reimbursementService = reimbursementService;
        this.mapper = mapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        try {

            TypeUpdateRequest typeUpdateRequest = mapper.readValue(req.getInputStream(), TypeUpdateRequest.class);
            Reimbursement reimbursement = reimbursementService.update_type(typeUpdateRequest);
            resp.setStatus(201); // CREATED
            resp.setContentType("application/json");
            String payload = mapper.writeValueAsString(new TypeUpdateResponse(reimbursement));
            writer.write(payload);

        } catch (InvalidRequestException | DatabindException e) {
            e.printStackTrace();
            resp.setStatus(400); // BAD REQUEST
        } catch (ResourceConflictException e) {
            resp.setStatus(409); // CONFLICT
        } catch (Exception e) {
            e.printStackTrace(); // include for debugging purposes; ideally log it to a file
            resp.setStatus(500);
        }
    }


}
