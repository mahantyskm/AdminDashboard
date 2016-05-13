package com.indusmed.response;

import java.util.List;

import com.indusmed.base.DashboardPatient;

public class SearchPatientResponse extends AbstractServiceResponse {
    private List<DashboardPatient> patients;

    public List<DashboardPatient> getPatients() {
        return patients;
    }

    public void setPatients(List<DashboardPatient> patients) {
        this.patients = patients;
    }
    
}
