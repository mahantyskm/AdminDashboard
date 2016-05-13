package com.indusmed.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.indusmed.base.DashboardPatient;

public class PatientInsuranceRowMapper implements RowMapper<DashboardPatient>{

	public DashboardPatient mapRow(ResultSet rs, int rowNum) throws SQLException {

		if(rs == null){
			return null;
		}

		DashboardPatient patient = new DashboardPatient();
		patient.setCompanyId(rs.getString("companyId"));
        patient.setInsuranceNumber(rs.getString("insuranceNumber"));
        patient.setPackageName(rs.getString("packageName"));
        patient.setStartDate(rs.getString("startDate"));
        patient.setEndDate(rs.getString("endDate"));
        patient.setLicenceNumber(rs.getString("licenceNumber"));
        patient.setAdmissionType(rs.getString("admissionType"));
        patient.setPolicyNumber(rs.getString("policyNumber"));
        patient.setPolicyHolderType(rs.getString("policyHolderType"));
        patient.setPrincipalInsuranceNumber(rs.getString("principalInsuranceNumber"));
        patient.setNotes(rs.getString("notes"));
        patient.setCardCoverage(rs.getString("cardCoverage"));
		return patient;
	}
}
