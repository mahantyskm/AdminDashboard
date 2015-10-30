package com.indusmed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indusmed.base.Constants;
import com.indusmed.base.DashboardBatch;
import com.indusmed.base.DashboardClaim;
import com.indusmed.base.DashboardPatient;
import com.indusmed.dao.DashboardServiceDaoImpl;
import com.indusmed.dao.IDashboardServiceDao;
import com.indusmed.request.AddClaimRequest;
import com.indusmed.request.AddNewBatchRequest;
import com.indusmed.request.AddNewPatientRequest;
import com.indusmed.request.FindBatchRequest;
import com.indusmed.request.SearchClaimRequest;
import com.indusmed.request.SearchPatientRequest;
import com.indusmed.request.UpdatePatientDetailsRequest;
import com.indusmed.response.AddClaimResponse;
import com.indusmed.response.AddNewBatchResponse;
import com.indusmed.response.AddNewPatientResponse;
import com.indusmed.response.FindBatchResponse;
import com.indusmed.response.SearchClaimResponse;
import com.indusmed.response.SearchPatientResponse;
import com.indusmed.response.UpdatePatientDetailsResponse;

@RestController
public class DashboardServiceController {
    @Autowired
    IDashboardServiceDao dashboardServiceDao;

    @RequestMapping("/addNewBatch")
    public AddNewBatchResponse addNewBatch(AddNewBatchRequest request) {
        AddNewBatchResponse response = new AddNewBatchResponse();
        int result = ((DashboardServiceDaoImpl) dashboardServiceDao).addNewBatch(request);
        if (result > 0) {
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_ADD_USER);
        }
        return response;
    }

    @RequestMapping("/addNewClaim")
    public AddClaimResponse addNewClaim(AddClaimRequest request) {
        AddClaimResponse response = new AddClaimResponse();
        int result = ((DashboardServiceDaoImpl) dashboardServiceDao).addNewClaim(request);
        if (result > 0) {
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_ADD_USER);
        }
        return response;
    }

    @RequestMapping("/addNewPatient")
    public AddNewPatientResponse addNewPatient(AddNewPatientRequest request) {
        AddNewPatientResponse response = new AddNewPatientResponse();
        int result = ((DashboardServiceDaoImpl) dashboardServiceDao).addNewPatient(request);
        if (result > 0) {
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_ADD_USER);
        }
        return response;
    }

    @RequestMapping("/updatePatient")
    public UpdatePatientDetailsResponse updatePatient(UpdatePatientDetailsRequest request) {
        UpdatePatientDetailsResponse response = new UpdatePatientDetailsResponse();
        int result = ((DashboardServiceDaoImpl) dashboardServiceDao).updatePatientDetails(request);
        if (result > 0) {
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_ADD_USER);
        }
        return response;
    }

    @RequestMapping("/searchPatient")
    public SearchPatientResponse searchPatient(SearchPatientRequest request) {
        SearchPatientResponse response = new SearchPatientResponse();
        List<DashboardPatient> patients = dashboardServiceDao.getPatients(request);

        if (patients != null) {
            response.setPatients(patients);
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_AUTENTICATE_USER);
        }
        return response;
    }

    @RequestMapping("/searchClaim")
    public SearchClaimResponse searchClaim(SearchClaimRequest request) {
        SearchClaimResponse response = new SearchClaimResponse();
        List<DashboardClaim> patients = dashboardServiceDao.getClaims(request);

        if (patients != null) {
            response.setClaims(patients);
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_AUTENTICATE_USER);
        }
        return response;
    }

    @RequestMapping("/findBatch")
    public FindBatchResponse findBatch(FindBatchRequest request) {
        FindBatchResponse response = new FindBatchResponse();
        DashboardBatch batch = dashboardServiceDao.getBatch(request);

        if (batch != null) {
            response.setBatch(batch);
            response.setSuccessful(true);
            response.setMessage(Constants.ADD_USER_SUCCESSFUL);
        } else {
            response.setSuccessful(false);
            response.setMessage(Constants.FAILED_TO_AUTENTICATE_USER);
        }
        return response;
    }

}
