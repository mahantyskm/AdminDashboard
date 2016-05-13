package com.indusmed.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.indusmed.base.DashboardClaim;

public class ClaimRowMapper implements RowMapper<DashboardClaim> {

    public DashboardClaim mapRow(ResultSet rs, int rowNum) throws SQLException {

        if (rs == null) {
            return null;
        }

        DashboardClaim claim = new DashboardClaim();
        claim.setBatchNumber(rs.getString("batchNumber"));
        claim.setPatientName(rs.getString("patientName"));
        claim.setInsuranceCardNumber(rs.getString("insuranceCardNumber"));
        claim.setMedicalRecordNumber(rs.getString("medicalRecordNumber"));
        claim.setClaimInvoiceNumber(rs.getString("claimInvoiceNumber"));
        claim.setClaimSerialNumber(rs.getString("claimSerialNumber"));
        claim.setClinicanName(rs.getString("clinicanName"));
        claim.setTransferDestination(rs.getString("transferDestination"));
        claim.setEncounterStartDate(rs.getString("encounterStartDate"));
        claim.setEncounterEndDate(rs.getString("encounterEndDate"));
        claim.setInvoiceAmount(rs.getDouble("invoiceAmount"));
        claim.setDiscountAmount(rs.getDouble("discountAmount"));
        claim.setCashPayment(rs.getDouble("cashPayment"));
        claim.setClaimId(rs.getString("claim_id"));
        claim.setPatientId(rs.getString("patient_id"));
        return claim;
    }
}
