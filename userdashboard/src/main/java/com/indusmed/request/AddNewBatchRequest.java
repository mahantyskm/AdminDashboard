package com.indusmed.request;

public class AddNewBatchRequest extends AbstractServiceRequest {
    private String batchNumber;
    private String insuranceName;
    private String insurancePackage;
    private String facilityName;
    private String batchEncounterType;
    private String receivedByUser;
    private String dateTo;
    private String dateFrom;
    private int claimCount;
    private int actualClaimCount;
    private int claimTotalAmount;
    private String dateRecieved;
    
    public String getDateRecieved() {
        return dateRecieved;
    }
    public void setDateRecieved(String dateRecieved) {
        this.dateRecieved = dateRecieved;
    }
    public String getBatchNumber() {
        return batchNumber;
    }
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }
    public String getInsuranceName() {
        return insuranceName;
    }
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }
    public String getInsurancePackage() {
        return insurancePackage;
    }
    public void setInsurancePackage(String insurancePackage) {
        this.insurancePackage = insurancePackage;
    }
    public String getFacilityName() {
        return facilityName;
    }
    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
    public String getBatchEncounterType() {
        return batchEncounterType;
    }
    public void setBatchEncounterType(String batchEncounterType) {
        this.batchEncounterType = batchEncounterType;
    }
    public String getReceivedByUser() {
        return receivedByUser;
    }
    public void setReceivedByUser(String receivedByUser) {
        this.receivedByUser = receivedByUser;
    }
    public String getDateTo() {
        return dateTo;
    }
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
    public String getDateFrom() {
        return dateFrom;
    }
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }
    public int getClaimCount() {
        return claimCount;
    }
    public void setClaimCount(int claimCount) {
        this.claimCount = claimCount;
    }
    public int getActualClaimCount() {
        return actualClaimCount;
    }
    public void setActualClaimCount(int actualClaimCount) {
        this.actualClaimCount = actualClaimCount;
    }
    public int getClaimTotalAmount() {
        return claimTotalAmount;
    }
    public void setClaimTotalAmount(int claimTotalAmount) {
        this.claimTotalAmount = claimTotalAmount;
    }
    
}
