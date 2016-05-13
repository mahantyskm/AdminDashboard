package com.indusmed.base;

public class Constants {
    //Pages
    public static final String USER_LOGIN                         = "login";
    public static final String ADD_NEW_USER                       = "addNewUser";
    public static final String USER_HOME                          = "dashboard";
    public static final String TEMP_PAGE                          = "temp";
    // Data
    public static final String DASHBOARD_USER                     = "dashboard_user";

    // Messages
    public static final String FAILED_TO_ADD_USER                 = "Failed to add new user";
    public static final String ADD_USER_SUCCESSFUL                = "New user added successfully";
    public static final String FAILED_TO_AUTENTICATE_USER         = "Invalid username/password combination.";
    public static final String USER_AUTHENTICATION_SUCCESSFUL     = "Login successfull";

    //DB Constants
    public static final String SCHEMA                             = "indusmed";
    public static final String USERS_TABLE                        = "user_info";
    public static final String BATCH_TABLE                        = "batch_data";
    public static final String CLAIM_TABLE                        = "claim_info";
    public static final String PATIENTS_TABLE                     = "patient_details";
    public static final String ENCOUNTERS_TABLE                   = "encounter_type";
    public static final String PATIENT_INSURANCE_TABLE            = "health_insurance";
    //Dashboard_users columns
    public static final String DASHBOARD_USER_DATE_OF_BIRTH       = "creation_date";
    public static final String DASHBOARD_USER_FIRST_NAME          = "firstname";
    public static final String DASHBOARD_USER_LAST_NAME           = "lastname";
    public static final String DASHBOARD_USER_MIDDLE_NAME         = "middlename";
    public static final String DASHBOARD_USER_EMAIL               = "email";
    public static final String DASHBOARD_USER_IMAGE               = "image";
    public static final String DASHBOARD_USER_USERNAME            = "username";
    public static final String DASHBOARD_USER_PASSWORD            = "password";
    public static final String DASHBOARD_USER_ROLE                = "role";

    // batch_data columns
    public static final String DASHBOARD_BATCH_NUMBER             = "batchNumber";
    public static final String DASHBOARD_BATCH_INSURANCE_NAME     = "insuranceName";
    public static final String DASHBOARD_BATCH_INSURANCE_PACKAGE  = "insurancePackage";
    public static final String DASHBOARD_BATCH_FACILITY_NAME      = "facilityName";
    public static final String DASHBOARD_BATCH_ENCOUNTER_TYPE     = "batchEncounterType";
    public static final String DASHBOARD_BATCH_RECEIVED_BY_USER   = "receivedByUser";
    public static final String DASHBOARD_BATCH_DATE_TO            = "dateTo";
    public static final String DASHBOARD_BATCH_DATE_FROM          = "dateFrom";
    public static final String DASHBOARD_BATCH_CLAIM_COUNT        = "claimCount";
    public static final String DASHBOARD_BATCH_ACTUAL_CLAIM_COUNT = "actualClaimCount";
    public static final String DASHBOARD_BATCH_CLAIM_TOTAL_AMOUNT = "claimTotalAmount";
    public static final String DASHBOARD_BATCH_DATE_RECIEVED      = "dateRecieved";

    public static final String DASHBOARD_CLAIM_BATCH              = "batchNumber";
    public static final String DASHBOARD_CLAIM_PATIENT_NAME       = "patientName";
    public static final String DASHBOARD_CLAIM_INSURANCE_CARD     = "insuranceCardNumber";
    public static final String DASHBOARD_CLAIM_MRN                = "medicalRecordNumber";
    public static final String DASHBOARD_CLAIM_INVOICE            = "claimInvoiceNumber";
    public static final String DASHBOARD_CLAIM_SERIAL             = "claimSerialNumber";
    public static final String DASHBOARD_CLAIM_CLINICIAN          = "clinicanName";
    public static final String DASHBOARD_CLAIM_DESTINATION        = "transferDestination";
    public static final String DASHBOARD_CLAIM_ENCOUNTER_START    = "encounterStartDate";
    public static final String DASHBOARD_CLAIM_ENCOUNTER_END      = "encounterEndDate";
    public static final String DASHBOARD_CLAIM_INVOICE_AMOUNT     = "invoiceAmount";
    public static final String DASHBOARD_CLAIM_DISCOUNT_AMOUNT    = "discountAmount";
    public static final String DASHBOARD_CLAIM_CASH_PAYMENT       = "cashPayment";

    public static final String PATIENT_PREFIX                     = "IMGP";
    public static final String BATCH_PREFIX                       = "IMGB";
    public static final String CLAIM_PREFIX                       = "IMGC";
}
