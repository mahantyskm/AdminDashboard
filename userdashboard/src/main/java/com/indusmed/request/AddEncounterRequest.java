package com.indusmed.request;

public class AddEncounterRequest extends AbstractServiceRequest {
    private String encounterType;
    private String startType;
    private String endType;
    private String startDate;
    private String endDate;
    private String transferSource;
    private String transferDestination;
    private String pastHistory;
    private String chiefComplaints;
    private String mainSymptoms;
    private String physicalExam;
    private String clinicianNameLicence;
    private String preAuthNumber;
    private String claimId;
    
    public String getEncounterType() {
        return encounterType;
    }
    public void setEncounterType(String encounterType) {
        this.encounterType = encounterType;
    }
    public String getStartType() {
        return startType;
    }
    public void setStartType(String startType) {
        this.startType = startType;
    }
    public String getEndType() {
        return endType;
    }
    public void setEndType(String endType) {
        this.endType = endType;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getTransferSource() {
        return transferSource;
    }
    public void setTransferSource(String transferSource) {
        this.transferSource = transferSource;
    }
    public String getTransferDestination() {
        return transferDestination;
    }
    public void setTransferDestination(String transferDestination) {
        this.transferDestination = transferDestination;
    }
    public String getPastHistory() {
        return pastHistory;
    }
    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }
    public String getChiefComplaints() {
        return chiefComplaints;
    }
    public void setChiefComplaints(String chiefComplaints) {
        this.chiefComplaints = chiefComplaints;
    }
    public String getMainSymptoms() {
        return mainSymptoms;
    }
    public void setMainSymptoms(String mainSymptoms) {
        this.mainSymptoms = mainSymptoms;
    }
    public String getPhysicalExam() {
        return physicalExam;
    }
    public void setPhysicalExam(String physicalExam) {
        this.physicalExam = physicalExam;
    }
    public String getClinicianNameLicence() {
        return clinicianNameLicence;
    }
    public void setClinicianNameLicence(String clinicianNameLicence) {
        this.clinicianNameLicence = clinicianNameLicence;
    }
    public String getPreAuthNumber() {
        return preAuthNumber;
    }
    public void setPreAuthNumber(String preAuthNumber) {
        this.preAuthNumber = preAuthNumber;
    }
    public String getClaimId() {
        return claimId;
    }
    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }
    
}
