package com.indusmed.request;

public class AddClaimRequest extends AbstractServiceRequest {

    private String batchNumber;
    private String patientName;
    private String insuranceCardNumber;
    private String medicalRecordNumber;
    private String claimInvoiceNumber;
    private String claimSerialNumber;
    private String clinicanName;
    private String transferDestination;
    private String encounterStartDate;
    private String encounterEndDate;
    private double invoiceAmount;
    private double discountAmount;
    private double cashPayment;
    private String patientId;
    
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getInsuranceCardNumber() {
        return insuranceCardNumber;
    }

    public void setInsuranceCardNumber(String insuranceCardNumber) {
        this.insuranceCardNumber = insuranceCardNumber;
    }

    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(String medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getClaimInvoiceNumber() {
        return claimInvoiceNumber;
    }

    public void setClaimInvoiceNumber(String claimInvoiceNumber) {
        this.claimInvoiceNumber = claimInvoiceNumber;
    }

    public String getClaimSerialNumber() {
        return claimSerialNumber;
    }

    public void setClaimSerialNumber(String claimSerialNumber) {
        this.claimSerialNumber = claimSerialNumber;
    }

    public String getClinicanName() {
        return clinicanName;
    }

    public void setClinicanName(String clinicanName) {
        this.clinicanName = clinicanName;
    }

    public String getTransferDestination() {
        return transferDestination;
    }

    public void setTransferDestination(String transferDestination) {
        this.transferDestination = transferDestination;
    }

    public String getEncounterStartDate() {
        return encounterStartDate;
    }

    public void setEncounterStartDate(String encounterStartDate) {
        this.encounterStartDate = encounterStartDate;
    }

    public String getEncounterEndDate() {
        return encounterEndDate;
    }

    public void setEncounterEndDate(String encounterEndDate) {
        this.encounterEndDate = encounterEndDate;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(double cashPayment) {
        this.cashPayment = cashPayment;
    }

}
