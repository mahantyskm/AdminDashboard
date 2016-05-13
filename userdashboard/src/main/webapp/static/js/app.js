function addNewUser() {

	var jsonData = convertFormToJSON("#addnewuserform");
	alert("JSON: " + JSON.stringify(jsonData));
	makeRequest("/addNewUser", jsonData);
}

function addNewUserCallBack(data) {
	if (data["successful"]) {
		$("#messageBox").html("User created successfully!");
		showProgressBar("#modalAlert");
	}
}

function searchPatientsByName() {
	var searchItem = $("#patientName").val();
	var json = {};
	json["searchItem"] = searchItem;
	makeRequest("/searchPatientsByName", json);
}

function searchPatientsByNameCallback(data) {
	if (data["successful"]) {

		var patients = data["patients"];
		allPatients = patients;
		var searchResultBox = $("#patientSuggestion");
		var resultString = "";
		for ( var patient in patients) {
			resultString += "<li onclick='javascript:setPatientData(this.value)'>";
			resultString += patients[patient]["firstName"] + " "
					+ patients[patient]["lastName"];
			resultString += "</li>";
		}

		searchResultBox.html(resultString);
		searchResultBox.toggle();

	} else {
		$("#messageBox").html("Patient not found.");
		showProgressBar("#modalAlert");
		resetForm("searchpatientform");
	}
}

function setPatientData(data) {
	$("#patientName").val(allPatients[data]["firstName"]+" "+allPatients[data]["lastName"]);
	$("#patientId").val(allPatients[data]["patientId"]);
	$("#patientSuggestion").toggle();
}

function logout() {
	makeRequest("/logout", null);
}

function logoutCallback(data) {
	if (data["successful"]) {
		location.href = "/";
	}
}
function checkLogin() {

	var jsonData = convertFormToJSON("#loginform");
	if ($("#loginform").valid()) {
		makeRequest("/login", jsonData);
	}
}

function checkLoginCallback(data) {
	if (data["successful"]) {
		location.href = "/home.html";
	} else {
		$("#messageBox").html("Incorrect username/password combination!");
		showProgressBar("#modalAlert");
	}
}

function addNewBatch() {

	var jsonData = convertFormToJSON("#addnewbatchform");

	if ($("#addnewbatchform").valid()) {
		makeRequest("/addNewBatch", jsonData);
	}
}

function addNewBatchCallback(data) {
	if (data["successful"]) {
		$("#messageBox").html("Batch Added Successfully.");
		showProgressBar("#modalAlert");
	} else {
		$("#messageBox").html("Failed to add batch.");
		showProgressBar("#modalAlert");
	}
	resetForm("addnewbatchform");
}

function findBatch() {

	var jsonData = convertFormToJSON("#findBatchForm");

	if ($("#findBatchForm").valid()) {
		makeRequest("/findBatch", jsonData);
	}
}
function findBatchCallback(data) {
	if (data["successful"]) {
		var batch = data["batch"];

		$("#batchTotalAmount").val(batch["claimTotalAmount"]);
		$("#batchTotalCount").val(batch["claimCount"]);
		$("#actualBatchCount").val(batch["actualClaimCount"]);
	} else {
		$("#messageBox").html("Batch not found.");
		showProgressBar("#modalAlert");
	}
}

function addClaim() {

	var jsonData = convertFormToJSON("#addNewClaimForm");
	jsonData["batchNumber"] = $("#batchNumber").val();
	if ($("#addNewClaimForm").valid()) {
		makeRequest("/addNewClaim", jsonData);
	}
}
function addClaimCallback(data) {
	if (data["successful"]) {
		$("#messageBox").html("Claim Added Successfully.");
		showProgressBar("#modalAlert");
	} else {
		$("#messageBox").html("Failed to add claim.");
		showProgressBar("#modalAlert");
	}
	resetForm("addNewClaimForm");
}

function addNewPatient() {
	var jsonData = convertFormToJSON("#addnewpatientform");
	// jsonData["batchNumber"] = $("#batchNumber").val();
	if ($("#addnewpatientform").valid()) {
		makeRequest("/addNewPatient", jsonData);
	}
}

function addNewPatientCallback(data) {
	if (data["successful"]) {
		$("#messageBox").html("Patient Added Successfully.");
		showProgressBar("#modalAlert");
	} else {
		$("#messageBox").html("Failed to add patient.");
		showProgressBar("#modalAlert");
	}
	resetForm("addnewpatientform");
}

function searchPatients() {

	var jsonData = convertFormToJSON("#searchpatientform");
	if ($("#searchpatientform").valid()) {
		makeRequest("/searchPatientsByID", jsonData);
	}
}

var allPatients;
function searchPatientsCallback(data) {
	if (data["successful"]) {

		var patients = data["patients"];
		allPatients = patients;

		var table = "<table class=\"table table-hover\">" + "<tr>"
				+ "<th>ID</th>" + "<th>Name</th>" + "<th>DOB</th>"
				+ "<th>Nationality</th>" + "<th>Social Security</th>"
				+ "<th>Action</th>" + "</tr>";
		for ( var patient in patients) {
			table += "<tr>";
			table += "<td>" + patients[patient]["patientId"] + "</td>"
			table += "<td>" + patients[patient]["firstName"] + " "
					+ patients[patient]["lastName"] + "</td>"
			table += "<td>" + patients[patient]["dob"] + "</td>"
			table += "<td>" + patients[patient]["nationality"] + "</td>"
			table += "<td>" + patients[patient]["socialSecurity"] + "</td>"
			table += "<td><a class=\"label label-success\" href=\"javascript:editPatient("
					+ patient + ")\">Edit</a></td>"
			table += "</tr>";
		}
		table += "</table>";
		$("#tableWrapper").html(table);
		$("#patientResultList").slideDown();

	} else {
		$("#messageBox").html("Patient not found.");
		showProgressBar("#modalAlert");
		resetForm("searchpatientform");
	}

}

function addEncounterDetails() {
	var jsonData = convertFormToJSON("#searchclaimform");
	jsonData["claimId"] = $("#hiddenClaimId").val();
	if ($("#searchclaimform").valid()) {
		makeRequest("/addEncounterDetails", jsonData);
	}
}

function addEncounterDetailsCallback(data) {
	if (data["successful"]) {
		$("#messageBox").html("Encounter details added successfully.");
		showProgressBar("#modalAlert");
	} else {
		$("#messageBox").html("Failed to add encounter details.");
		showProgressBar("#modalAlert");
	}
	resetForm("searchclaimform");
}
function addAdditionalDataCallback(data) {
	if (data["successful"]) {
		$("#messageBox").html(data["count"] + " record(s) added successfully.");
		showProgressBar("#modalAlert");
	} else {
		$("#messageBox").html("Failed to add additional details.");
		showProgressBar("#modalAlert");
	}
	resetForm("addAdditionalData");
}

function searchPatient() {
	var searchItem = $("#patientId").val();
	var json = {};
	json["searchItem"] = searchItem;
	makeRequest("/searchPatientByID", json);
}

function searchPatientCallback(data) {
	var patient = data["patients"][0];
	$("#patientName").val(patient["firstName"] + " " + patient["lastName"]);
	$("#isuranceCardNumber").val(patient["insuranceNumber"]);
}

function searchClaim() {
	var jsonData = convertFormToJSON("#searchclaimform");
	if ($("#searchclaimform").valid()) {
		makeRequest("/searchClaim", jsonData);
	}
}

var allClaims;

function searchClaimCallback(data) {
	if (data["successful"]) {

		var claims = data["claims"];
		allClaims = claims;

		var table = "<table class=\"table table-hover\">" + "<tr>"
				+ "<th>ID</th>" + "<th>Name</th>" + "<th>MRN</th>"
				+ "<th>Start Date</th>" + "<th>End Date</th>"
				+ "<th>Encounter</th>" + "<th>Diagnosis</th>"
				+ "<th>Activity</th>" + "</tr>";
		for ( var claim in claims) {
			table += "<tr>";
			table += "<td>" + claims[claim]["claimId"] + "</td>"
			table += "<td>" + claims[claim]["patientName"] + "</td>"
			table += "<td>" + claims[claim]["medicalRecordNumber"] + "</td>"
			table += "<td>" + claims[claim]["encounterStartDate"] + "</td>"
			table += "<td>" + claims[claim]["encounterEndDate"] + "</td>"
			table += "<td><a class=\"label label-success\" href=\"javascript:editEncounter('"
					+ claims[claim]["claimId"] + "')\">Edit</a></td>"
			table += "<td><a class=\"label label-success\" href=\"javascript:editDiagnosis('"
					+ claims[claim]["claimId"] + "')\">Edit</a></td>"
			table += "<td><a class=\"label label-success\" href=\"javascript:editActivity('"
					+ claims[claim]["claimId"] + "')\">Edit</a></td>"
			table += "</tr>";
		}
		table += "</table>";
		$("#tableWrapper").html(table);
		$("#claimsResultList").slideDown();

	} else {
		$("#messageBox").html("Claim not found.");
		showProgressBar("#modalAlert");
		resetForm("searchclaimform");
	}

}

function addAdditionalData(jsonData) {

	/*
	 * var jsonData = convertFormToJSON("#addAdditionalData"); var tempData =
	 * $("#fileUpload")[1];
	 * 
	 * alert(tempData);
	 */
	if ($("#addAdditionalData").valid()) {
		makeRequest("/addAdditionalData", jsonData);
	}
}

function editEncounter(claim) {
	$("#claimsResultList").slideUp();
	$("#encounter_box").slideDown();
	$("#hiddenClaimId").val(claim);
}

function editDiagnosis(claim) {

}

function editActivity(claim) {

}
function editPatient(id) {
	$("#patientResultList").slideUp();
	fillPatientData(id, allPatients);
}

function editClaim(id) {
	$("#claimsResultList").slideUp();
	fillPatientData(id, allPatients);
}

function updatePatientDetails() {
	var jsonData = convertFormToJSON("#searchpatientform");

	if ($("#searchpatientform").valid()) {
		makeRequest("/updatePatient", jsonData);
	}
}

function updatePatientDetailsCallback(data) {
	if (data["successful"]) {
		$("#messageBox").html("Patient details updated successfully.");
		showProgressBar("#modalAlert");
	} else {
		$("#messageBox").html("Failed to update patient details.");
		showProgressBar("#modalAlert");
	}
	resetForm("searchpatientform");
	$("#details_box").slideUp();
}

$().ready(function() {

	checkSession();
});

function checkSession() {
	makeRequest("/getUserFromSession", null)
}

function checkSessionCallback(data) {
	if (data["successful"]) {
		var user = data["user"];
		setUserData(user);
	} else {
		var loc = location.href;
		var str = loc.substring(loc.lastIndexOf('/'));

		if (str.length > 1) {
			location.href = "/";
		}
	}

}
function setUserData(user) {
	$("#topmenutitle").html(user["firstname"] + " " + user["lastname"]);
	$("#leftmenutitle").html(user["firstname"] + " " + user["lastname"]);
	$("#profiletitle").html(user["firstname"] + " " + user["lastname"]);
	$("#userName").html(user["firstname"] + " " + user["lastname"]);
}
function setGender(gender) {
	$("#gender").val(gender);
}

function setDropdown(value, item) {
	$(item).val(value);
}

function makeRequest(operation, parameters) {
	$.ajax({
		type : "POST",
		url : operation,
		dataType : "json",
		data : parameters,
		success : function(resp) {
			if (resp) {
				callBack(operation, resp);
			}
		},
	});
}

function callBack(operation, data) {
	if (operation == "/addNewUser") {
		addNewUserCallBack(data);
	}
	if (operation == "/login") {
		checkLoginCallback(data);
	}
	if (operation == "/getUserFromSession") {
		checkSessionCallback(data);
	}
	if (operation == "/logout") {
		logoutCallback(data);
	}
	if (operation == "/addNewBatch") {
		addNewBatchCallback(data);
	}
	if (operation == "/findBatch") {
		findBatchCallback(data);
	}
	if (operation == "/addNewClaim") {
		addClaimCallback(data);
	}
	if (operation == "/addNewPatient") {
		addNewPatientCallback(data);
	}
	if (operation == "/searchPatientByID") {
		searchPatientCallback(data);
	}
	if (operation == "/searchPatientsByID") {
		searchPatientsCallback(data);
	}
	if (operation == "/updatePatient") {
		updatePatientDetailsCallback(data);
	}
	if (operation == "/searchClaim") {
		searchClaimCallback(data);
	}
	if (operation == "/addEncounterDetails") {
		addEncounterDetailsCallback(data);
	}
	if (operation == "/addAdditionalData") {
		addAdditionalDataCallback(data);
	}
	if (operation == "/searchPatientsByName") {
		searchPatientsByNameCallback(data);
	}
}

function convertFormToJSON(form) {
	var array = $(form).serializeArray();
	var json = {};

	$.each(array, function() {
		json[this.name] = this.value || '';
	});

	return json;
}

function showProgressBar(name) {
	var progressDiv = $(name);
	progressDiv.modal();
}

function hideProgressBar(name) {
	var progressDiv = $(name);
	progressDiv.modal('hide');
}

function resetForm(form) {
	document.getElementById(form).reset();
}

function fillPatientData(id, patient) {
	$("#firstName").val(patient[id]["firstName"]);
	$("#lastName").val(patient[id]["lastName"]);
	$("#gender").val(patient[id]["gender"]);
	$("#passport").val(patient[id]["passport"]);
	$("#socialSecurity").val(patient[id]["socialSecurity"]);
	$("#dob").val(patient[id]["dob"]);
	$("#nationality").val(patient[id]["nationality"]);
	$("#homePhone").val(patient[id]["homePhone"]);
	$("#officePhone").val(patient[id]["officePhone"]);
	$("#fax").val(patient[id]["fax"]);
	$("#mobile").val(patient[id]["mobile"]);
	$("#email").val(patient[id]["email"]);
	$("#companyId").val(patient[id]["companyId"]);
	$("#insuranceNumber").val(patient[id]["insuranceNumber"]);
	$("#packageName").val(patient[id]["packageName"]);
	$("#startDate").val(patient[id]["startDate"]);
	$("#endDate").val(patient[id]["endDate"]);
	$("#licenceNumber").val(patient[id]["licenceNumber"]);
	$("#admissionType").val(patient[id]["admissionType"]);
	$("#policyNumber").val(patient[id]["policyNumber"]);
	$("#policyHolderType").val(patient[id]["policyHolderType"]);
	$("#principalInsuranceNumber").val(patient[id]["principalInsuranceNumber"]);
	$("#notes").val(patient[id]["notes"]);
	$("#cardCoverage").val(patient[id]["cardCoverage"]);
	$("#hiddenPatientId").val(patient[id]["patientId"]);
	$("#details_box").slideDown();
}