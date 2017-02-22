
package com.indusmed.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.indusmed.base.Constants;
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
import com.indusmed.rowmapper.BatchRowMapper;
import com.indusmed.rowmapper.ClaimRowMapper;
import com.indusmed.rowmapper.PatientInsuranceRowMapper;
import com.indusmed.rowmapper.PatientRowMapper;

public class DashboardServiceDaoImpl extends JdbcDaoSupport implements IDashboardServiceDao {

    @Override
    public int addNewBatch(AddNewBatchRequest request) {
        String sql = "insert into "
                + Constants.BATCH_TABLE
                + " (batchNumber,insuranceName,insurancePackage,facilityName,batchEncounterType,receivedByUser,dateRecieved,dateTo,dateFrom,claimCount,actualClaimCount,claimTotalAmount) values(?,?,?,?,?,?,?,?,?,?,?,?)";

        int result = 0;
        try {
            result = getJdbcTemplate().update(
                    sql,
                    new Object[] {
                            request.getBatchNumber(),
                            request.getInsuranceName(),
                            request.getInsurancePackage(),
                            request.getFacilityName(),
                            request.getBatchEncounterType(),
                            request.getReceivedByUser(),
                            request.getDateRecieved(),
                            request.getDateTo(),
                            request.getDateFrom(),
                            request.getClaimCount(),
                            request.getActualClaimCount(),
                            request.getClaimTotalAmount(), });
        } catch (Exception e) {
            System.out.println("Ecxeption while adding batch");
        }
        return result;
    }

    @Override
    public DashboardBatch getBatch(FindBatchRequest request) {
        String sql = "select * from " + Constants.BATCH_TABLE + " where " + Constants.DASHBOARD_BATCH_NUMBER + " = ?";
        DashboardBatch batch = null;
        try {
            batch = getJdbcTemplate().queryForObject(sql, new Object[] { request.getBatchNumber() }, new BatchRowMapper());
        } catch (Exception e) {
            System.out.println("Ecxeption while querying for username");
        }
        return batch;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int addNewClaim(AddClaimRequest request) {

        int result = 0;
        int result2 = 0;
        try {
            int id = 1;//getJdbcTemplate().queryForInt("select max(id) from " + Constants.CLAIM_TABLE);
            System.out.println("Loaded Value : " + id);
            String claimId = Constants.CLAIM_PREFIX + (id + 1);
            String sql = "insert into "
                    + Constants.CLAIM_TABLE
                    + " (batchNumber,patientName,insuranceCardNumber,medicalRecordNumber,claimInvoiceNumber,claimSerialNumber,clinicanName,encounterStartDate,encounterEndDate,invoiceAmount,discountAmount,cashPayment,transferDestination,claim_id,patient_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            result = getJdbcTemplate().update(
                    sql,
                    new Object[] {
                            request.getBatchNumber(),
                            request.getPatientName(),
                            request.getInsuranceCardNumber(),
                            request.getMedicalRecordNumber(),
                            request.getClaimInvoiceNumber(),
                            request.getClaimSerialNumber(),
                            request.getClinicanName(),
                            request.getEncounterStartDate(),
                            request.getEncounterEndDate(),
                            request.getInvoiceAmount(),
                            request.getDiscountAmount(),
                            request.getCashPayment(),
                            request.getTransferDestination(),
                            claimId,
                            request.getPatientId() });

        //if claim successfully added then update batch table also

            if (result == 1) {
                String sql2 = "update " + Constants.BATCH_TABLE + " set actualClaimCount = actualClaimCount + 1 and claimTotalAmount = claimTotalAmount +  1 where batchNumber = '"
                        + request.getBatchNumber() + "'";
                result2 = getJdbcTemplate().update(sql2);
            }
        } catch (Exception e) {
            System.out.println("Ecxeption while adding claim.: " + e.getMessage());
        }
        return result2;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int addNewPatient(AddNewPatientRequest request) {

        int result = 0;
        try {

            int id = 1;//getJdbcTemplate().queryForObject("select max(id) from " + Constants.PATIENTS_TABLE);
            System.out.println("Loaded Value : " + id);
            String patientId = Constants.PATIENT_PREFIX + (id + 1);

            String sql = "insert into " + Constants.PATIENTS_TABLE
                    + " (firstName,lastName,gender,passport,socialSecurity,dob,nationality,homePhone,officePhone,fax,mobile,email,patient_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            result = getJdbcTemplate().update(
                    sql,
                    new Object[] {
                            request.getFirstName(),
                            request.getLastName(),
                            request.getGender(),
                            request.getPassport(),
                            request.getSocialSecurity(),
                            request.getDob(),
                            request.getNationality(),
                            request.getHomePhone(),
                            request.getOfficePhone(),
                            request.getFax(),
                            request.getMobile(),
                            request.getEmail(),
                            patientId });

            System.out.println("Inserted patient details");

            if (result == 1) {

                result = 0;

                String insuranceSql = "insert into "
                        + Constants.PATIENT_INSURANCE_TABLE
                        + " (companyId,insuranceNumber,licenceNumber,startDate,endDate,packageName,admissionType,policyHolderType,policyNumber,cardCoverage,notes,principalInsuranceNumber,patient_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                result = getJdbcTemplate().update(
                        insuranceSql,
                        new Object[] {
                                request.getCompanyId(),
                                request.getInsuranceNumber(),
                                request.getLicenceNumber(),
                                request.getStartDate(),
                                request.getEndDate(),
                                request.getPackageName(),
                                request.getAdmissionType(),
                                request.getPolicyHolderType(),
                                request.getPolicyNumber(),
                                request.getCardCoverage(),
                                request.getNotes(),
                                request.getPrincipalInsuranceNumber(),
                                patientId });
            }

        } catch (Exception e) {
            System.out.println("Ecxeption while getting Max count : " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<DashboardPatient> getPatientsById(SearchPatientRequest request) {

        if (request.getSearchItem().equals("*")) {
            return getAllPatients();
        }

        List<DashboardPatient> patientsList = null;
        try {
            String sql = "select * from " + Constants.PATIENTS_TABLE + " where  firstName = ? or patient_id = ?";

            patientsList = getJdbcTemplate().query(sql, new PatientRowMapper(), new Object[] { request.getSearchItem(), request.getSearchItem() });

            for (DashboardPatient patient : patientsList) {
                String insuranceSql = "select * from " + Constants.PATIENT_INSURANCE_TABLE + " where  patient_id = ?";
                DashboardPatient insurance = getJdbcTemplate().queryForObject(insuranceSql, new Object[] { patient.getPatientId() }, new PatientInsuranceRowMapper());

                if (insurance != null) {
                    patient.setCompanyId(insurance.getCompanyId());
                    patient.setInsuranceNumber(insurance.getInsuranceNumber());
                    patient.setPackageName(insurance.getPackageName());
                    patient.setStartDate(insurance.getStartDate());
                    patient.setEndDate(insurance.getEndDate());
                    patient.setLicenceNumber(insurance.getLicenceNumber());
                    patient.setAdmissionType(insurance.getAdmissionType());
                    patient.setPolicyNumber(insurance.getPolicyNumber());
                    patient.setPolicyHolderType(insurance.getPolicyHolderType());
                    patient.setPrincipalInsuranceNumber(insurance.getPrincipalInsuranceNumber());
                    patient.setNotes(insurance.getNotes());
                    patient.setCardCoverage(insurance.getCardCoverage());
                }
            }
        } catch (Exception e) {
            System.out.println("Ecxeption while querying for username: " + e.getMessage());
        }
        return patientsList;
    }

    public List<DashboardPatient> getAllPatients() {

        List<DashboardPatient> claimsList = null;
        try {
            String sql = "select * from " + Constants.PATIENTS_TABLE;

            claimsList = getJdbcTemplate().query(sql, new PatientRowMapper());

            for (DashboardPatient claim : claimsList) {
                String insuranceSql = "select * from " + Constants.PATIENT_INSURANCE_TABLE + " where  patient_id = ?";
                DashboardPatient insurance = getJdbcTemplate().queryForObject(insuranceSql, new Object[] { claim.getPatientId() }, new PatientInsuranceRowMapper());

                if (insurance != null) {
                    claim.setCompanyId(insurance.getCompanyId());
                    claim.setInsuranceNumber(insurance.getInsuranceNumber());
                    claim.setPackageName(insurance.getPackageName());
                    claim.setStartDate(insurance.getStartDate());
                    claim.setEndDate(insurance.getEndDate());
                    claim.setLicenceNumber(insurance.getLicenceNumber());
                    claim.setAdmissionType(insurance.getAdmissionType());
                    claim.setPolicyNumber(insurance.getPolicyNumber());
                    claim.setPolicyHolderType(insurance.getPolicyHolderType());
                    claim.setPrincipalInsuranceNumber(insurance.getPrincipalInsuranceNumber());
                    claim.setNotes(insurance.getNotes());
                    claim.setCardCoverage(insurance.getCardCoverage());
                }
            }
        } catch (Exception e) {
            System.out.println("Ecxeption while querying for username: " + e.getMessage());
        }

        return claimsList;
    }

    @Override
    public List<DashboardClaim> getClaims(SearchClaimRequest request) {

        if (request.getSearchItem().equals("*")) {
            return getAllClaims();
        }

        List<DashboardClaim> claimsList = null;
        try {
            String sql = "select * from " + Constants.CLAIM_TABLE + " where  claim_id = ?";

            claimsList = getJdbcTemplate().query(sql, new ClaimRowMapper(), request.getSearchItem());

        } catch (Exception e) {
            System.out.println("Ecxeption while querying for username: " + e.getMessage());
        }

        return claimsList;
    }

    public List<DashboardClaim> getAllClaims() {

        List<DashboardClaim> claimsList = null;
        try {
            String sql = "select * from " + Constants.CLAIM_TABLE;

            claimsList = getJdbcTemplate().query(sql, new ClaimRowMapper());

        } catch (Exception e) {
            System.out.println("Ecxeption while querying for username: " + e.getMessage());
        }

        return claimsList;
    }

    @Override
    public int updatePatientDetails(UpdatePatientDetailsRequest request) {

        int result = 0;
        try {

            String sql = "update "
                    + Constants.PATIENTS_TABLE
                    + " set firstName = ?,lastName = ?,gender  = ?,passport = ?,socialSecurity = ?,dob = ?,nationality = ?,homePhone = ?,officePhone = ?,fax = ?,mobile = ?,email = ? where patient_id = ?";

            result = getJdbcTemplate().update(
                    sql,
                    new Object[] {
                            request.getFirstName(),
                            request.getLastName(),
                            request.getGender(),
                            request.getPassport(),
                            request.getSocialSecurity(),
                            request.getDob(),
                            request.getNationality(),
                            request.getHomePhone(),
                            request.getOfficePhone(),
                            request.getFax(),
                            request.getMobile(),
                            request.getEmail(),
                            request.getPatientId() });

            System.out.println("Updated patient details");

            if (result == 1) {

                result = 0;

                String insuranceSql = "update "
                        + Constants.PATIENT_INSURANCE_TABLE
                        + " set companyId = ?,insuranceNumber = ?,licenceNumber = ?,startDate = ?,endDate = ?,packageName = ?,admissionType = ?,policyHolderType = ?,policyNumber = ?,cardCoverage = ?,notes = ?,principalInsuranceNumber = ? where patient_id = ?";
                result = getJdbcTemplate().update(
                        insuranceSql,
                        new Object[] {
                                request.getCompanyId(),
                                request.getInsuranceNumber(),
                                request.getLicenceNumber(),
                                request.getStartDate(),
                                request.getEndDate(),
                                request.getPackageName(),
                                request.getAdmissionType(),
                                request.getPolicyHolderType(),
                                request.getPolicyNumber(),
                                request.getCardCoverage(),
                                request.getNotes(),
                                request.getPrincipalInsuranceNumber(),
                                request.getPatientId() });
            }

        } catch (Exception e) {
            System.out.println("Ecxeption while getting Max count : " + e.getMessage());
        }
        return result;
    }

    @Override
    public int addNewEncounter(AddEncounterRequest request) {
        String sql = "insert into "
                + Constants.ENCOUNTERS_TABLE
                + " (encounterType,startType,endType,startDate,endDate,transferSource,transferDestination,pastHistory,chiefComplaints,mainSymptoms,physicalExam,clinicianNameLicence,preAuthNumber,claim_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        int result = 0;
        try {
            result = getJdbcTemplate().update(
                    sql,
                    new Object[] {
                            request.getEncounterType(),
                            request.getStartType(),
                            request.getEndType(),
                            request.getStartDate(),
                            request.getEndDate(),
                            request.getTransferSource(),
                            request.getTransferDestination(),
                            request.getPastHistory(),
                            request.getChiefComplaints(),
                            request.getMainSymptoms(),
                            request.getPhysicalExam(),
                            request.getClinicianNameLicence(),
                            request.getPreAuthNumber(),
                            request.getClaimId() });
        } catch (Exception e) {
            System.out.println("Ecxeption while adding encounter: " + e.getMessage());
        }
        return result;
    }

    @Override
    public int addAdditionalDetails(AddAdditionalDataRequest request) {
        int count = 0;
        if (request.getSelectionType().equalsIgnoreCase("doctor")) {
            count = addDoctorDetails(request);
        }
        if (request.getSelectionType().equalsIgnoreCase("hospital")) {
            count = addHospitalDetails(request);
        }
        if (request.getSelectionType().equalsIgnoreCase("insurance")) {
            count = addInsuranceFacilityDetails(request);
        }
        return count;
    }

    public int addHospitalDetails(AddAdditionalDataRequest request) {
        String sql = "insert into hospitals (eclaimId,hospitalName)values (?,?)";
        int count = 0;
        try {

            if (!request.getFile().isEmpty()) {
                System.out.println("File not null");
                byte[] bytes = request.getFile().getBytes();
                InputStream file = new ByteArrayInputStream(bytes);
                Workbook workbook = new XSSFWorkbook(file);
                Sheet firstSheet = workbook.getSheetAt(0);
                Iterator<Row> iterator = firstSheet.iterator();
                while (iterator.hasNext()) {
                    Row nextRow = iterator.next();
                    count += getJdbcTemplate().update(sql, new Object[] { nextRow.getCell(0).toString(), nextRow.getCell(1).toString() });
                    System.out.println("Eclaim: " + nextRow.getCell(0) + "  Name: " + nextRow.getCell(1));
                }

                workbook.close();
            } else {
                count = getJdbcTemplate().update(sql, new Object[] { request.geteClaimIDHospital(), request.getHospitalName() });
                System.out.println("Eclaim: " + request.geteClaimIDHospital() + "  Name: " + request.getHospitalName());
            }
        } catch (Exception ex) {
            System.out.println("Failed to add hospitals  with cause: " + ex.getMessage());
        }
        return count;
    }

    public int addInsuranceFacilityDetails(AddAdditionalDataRequest request) {
        String sql = "insert into insurance_providers (eclaimId,insuranceProviderName)values (?,?)";
        int count = 0;
        try {
            if (!request.getFile().isEmpty()) {
                byte[] bytes = request.getFile().getBytes();
                InputStream file = new ByteArrayInputStream(bytes);
                Workbook workbook = new XSSFWorkbook(file);
                Sheet firstSheet = workbook.getSheetAt(0);
                Iterator<Row> iterator = firstSheet.iterator();
                while (iterator.hasNext()) {
                    Row nextRow = iterator.next();
                    count += getJdbcTemplate().update(sql, new Object[] { nextRow.getCell(0).toString(), nextRow.getCell(1).toString() });
                    System.out.println("Eclaim: " + nextRow.getCell(0) + "  Name: " + nextRow.getCell(1));
                }
                workbook.close();
            } else {
                count = getJdbcTemplate().update(sql, new Object[] { request.geteClaimIDInsurance(), request.getInsuranceName() });
                System.out.println("Eclaim: " + request.geteClaimIDInsurance() + "  Name: " + request.getInsuranceName());
            }
        } catch (Exception ex) {
            System.out.println("Failed to add hospitals  with cause: " + ex.getMessage());
        }
        return count;
    }

    public int addDoctorDetails(AddAdditionalDataRequest request) {
        String sql = "insert into doctors (eclaimId,doctorName)values (?,?)";
        int count = 0;
        try {
            if (!request.getFile().isEmpty()) {
                byte[] bytes = request.getFile().getBytes();
                InputStream file = new ByteArrayInputStream(bytes);
                Workbook workbook = new XSSFWorkbook(file);
                Sheet firstSheet = workbook.getSheetAt(0);
                Iterator<Row> iterator = firstSheet.iterator();
                while (iterator.hasNext()) {
                    Row nextRow = iterator.next();
                    count += getJdbcTemplate().update(sql, new Object[] { nextRow.getCell(0).toString(), nextRow.getCell(1).toString() });
                    System.out.println("Eclaim: " + nextRow.getCell(0) + "  Name: " + nextRow.getCell(1));
                }
                workbook.close();
            } else {
                count = getJdbcTemplate().update(sql, new Object[] { request.geteClaimIDDoctor(), request.getDoctorName() });
                System.out.println("Eclaim: " + request.geteClaimIDDoctor() + "  Name: " + request.getDoctorName());
            }
        } catch (Exception ex) {
            System.out.println("Failed to add hospitals  with cause: " + ex.getMessage());
        }
        return count;
    }

    @Override
    public List<DashboardPatient> getPatientsByName(SearchPatientRequest request) {
        List<DashboardPatient> patientsList = null;
        try {
            String sql = "select * from " + Constants.PATIENTS_TABLE + " where  firstName like ?";

            patientsList = getJdbcTemplate().query(sql, new PatientRowMapper(), new Object[] { "%" + request.getSearchItem() + "%" });

            for (DashboardPatient patient : patientsList) {
                String insuranceSql = "select * from " + Constants.PATIENT_INSURANCE_TABLE + " where  patient_id = ?";
                DashboardPatient insurance = getJdbcTemplate().queryForObject(insuranceSql, new Object[] { patient.getPatientId() }, new PatientInsuranceRowMapper());

                if (insurance != null) {
                    patient.setCompanyId(insurance.getCompanyId());
                    patient.setInsuranceNumber(insurance.getInsuranceNumber());
                    patient.setPackageName(insurance.getPackageName());
                    patient.setStartDate(insurance.getStartDate());
                    patient.setEndDate(insurance.getEndDate());
                    patient.setLicenceNumber(insurance.getLicenceNumber());
                    patient.setAdmissionType(insurance.getAdmissionType());
                    patient.setPolicyNumber(insurance.getPolicyNumber());
                    patient.setPolicyHolderType(insurance.getPolicyHolderType());
                    patient.setPrincipalInsuranceNumber(insurance.getPrincipalInsuranceNumber());
                    patient.setNotes(insurance.getNotes());
                    patient.setCardCoverage(insurance.getCardCoverage());
                }
            }
        } catch (Exception e) {
            System.out.println("Ecxeption while querying for username: " + e.getMessage());
        }
        return patientsList;
    }
}
