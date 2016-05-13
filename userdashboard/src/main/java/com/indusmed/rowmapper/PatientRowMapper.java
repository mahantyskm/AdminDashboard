package com.indusmed.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.indusmed.base.DashboardPatient;

public class PatientRowMapper implements RowMapper<DashboardPatient>{

	public DashboardPatient mapRow(ResultSet rs, int rowNum) throws SQLException {

		if(rs == null){
			return null;
		}

		DashboardPatient patient = new DashboardPatient();
		patient.setFirstName(rs.getString("firstName"));
		patient.setLastName(rs.getString("lastName"));
		patient.setGender(rs.getString("gender"));
		patient.setPassport(rs.getString("passport"));
		patient.setSocialSecurity(rs.getString("socialSecurity"));
		patient.setDob(rs.getString("dob"));
		patient.setNationality(rs.getString("nationality"));
		patient.setHomePhone(rs.getString("homePhone"));
		patient.setOfficePhone(rs.getString("officePhone"));
		patient.setFax(rs.getString("fax"));
		patient.setMobile(rs.getString("mobile"));
		patient.setEmail(rs.getString("email"));
		patient.setPatientId(rs.getString("patient_id"));
		return patient;
	}
}
