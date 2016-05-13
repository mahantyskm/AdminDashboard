package com.indusmed.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.indusmed.base.Constants;
import com.indusmed.base.DashboardBatch;

public class BatchRowMapper implements RowMapper<DashboardBatch>{

	public DashboardBatch mapRow(ResultSet rs, int rowNum) throws SQLException {
	 
		if(rs == null){
			return null;
		}

		DashboardBatch batch = new DashboardBatch();
		batch.setBatchNumber(rs.getString(Constants.DASHBOARD_BATCH_NUMBER));
		batch.setInsuranceName(rs.getString(Constants.DASHBOARD_BATCH_INSURANCE_NAME));
		batch.setInsurancePackage(rs.getString(Constants.DASHBOARD_BATCH_INSURANCE_PACKAGE));
		batch.setFacilityName(rs.getString(Constants.DASHBOARD_BATCH_FACILITY_NAME));
		batch.setBatchEncounterType(rs.getString(Constants.DASHBOARD_BATCH_ENCOUNTER_TYPE));
		batch.setReceivedByUser(rs.getString(Constants.DASHBOARD_BATCH_RECEIVED_BY_USER));
		batch.setDateRecieved(rs.getString(Constants.DASHBOARD_BATCH_DATE_RECIEVED));
		batch.setDateFrom(rs.getString(Constants.DASHBOARD_BATCH_DATE_FROM));
		batch.setDateTo(rs.getString(Constants.DASHBOARD_BATCH_DATE_TO));
		batch.setClaimCount(rs.getInt(Constants.DASHBOARD_BATCH_CLAIM_COUNT));
		batch.setActualClaimCount(rs.getInt(Constants.DASHBOARD_BATCH_ACTUAL_CLAIM_COUNT));
		batch.setClaimTotalAmount(rs.getInt(Constants.DASHBOARD_BATCH_CLAIM_TOTAL_AMOUNT));
		return batch;
	}
}
