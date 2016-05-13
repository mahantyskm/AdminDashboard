package com.indusmed.dao;

import java.util.List;

import com.indusmed.base.DashboardBatch;
import com.indusmed.base.DashboardClaim;
import com.indusmed.base.DashboardPatient;
import com.indusmed.request.AddClaimRequest;
import com.indusmed.request.AddEncounterRequest;
import com.indusmed.request.AddAdditionalDataRequest;
import com.indusmed.request.AddNewBatchRequest;
import com.indusmed.request.AddNewPatientRequest;
import com.indusmed.request.FindBatchRequest;
import com.indusmed.request.SearchClaimRequest;
import com.indusmed.request.SearchPatientRequest;
import com.indusmed.request.UpdatePatientDetailsRequest;

public interface IDashboardServiceDao {
    public int addNewBatch(AddNewBatchRequest request);
    public DashboardBatch getBatch(FindBatchRequest request);
    public List<DashboardPatient> getPatientsById(SearchPatientRequest request);
    public List<DashboardPatient> getPatientsByName(SearchPatientRequest request);
    public List<DashboardClaim> getClaims(SearchClaimRequest request);
    public int addNewClaim(AddClaimRequest request);
    public int addNewPatient(AddNewPatientRequest request);
    public int addNewEncounter(AddEncounterRequest request);
    public int updatePatientDetails(UpdatePatientDetailsRequest request);
    public int addAdditionalDetails(AddAdditionalDataRequest request);
}
