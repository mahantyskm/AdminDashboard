package com.indusmed.request;

import org.springframework.web.multipart.MultipartFile;

public class AddAdditionalDataRequest extends AbstractServiceRequest {
    private String eClaimIDHospital;
    private String eClaimIDInsurance;
    private String eClaimIDDoctor;
    private String hospitalName;
    private String selectionType;
    
    public String getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(String selectionType) {
        this.selectionType = selectionType;
    }

    public String geteClaimIDHospital() {
        return eClaimIDHospital;
    }

    public void seteClaimIDHospital(String eClaimIDHospital) {
        this.eClaimIDHospital = eClaimIDHospital;
    }

    public String geteClaimIDInsurance() {
        return eClaimIDInsurance;
    }

    public void seteClaimIDInsurance(String eClaimIDInsurance) {
        this.eClaimIDInsurance = eClaimIDInsurance;
    }

    public String geteClaimIDDoctor() {
        return eClaimIDDoctor;
    }

    public void seteClaimIDDoctor(String eClaimIDDoctor) {
        this.eClaimIDDoctor = eClaimIDDoctor;
    }

    private String insuranceName;
    private String doctorName;

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

}
