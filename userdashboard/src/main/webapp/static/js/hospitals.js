function displayHospital() {

	if ($("#entry").is(':checked')) {
		$("#hospitalDiv").slideDown();
	}
	if ($("#file").is(':checked')) {
		$("#fileUpload").slideDown();
	}
	resetDivs();
}

function resetDivs() {
	$("#doctorDiv").slideUp();
	$("#hospitalDiv").slideUp();
	$("#insuranceDiv").slideUp();
	$("#fileUpload").slideUp();
	document.getElementById("entry").checked = false;
	document.getElementById("file").checked = false;
}

function displayInsurance() {
	if ($("#entry").is(':checked')) {
		$("#insuranceDiv").slideDown();
	}
	if ($("#file").is(':checked')) {
		$("#fileUpload").slideDown();
	}
	resetDivs();
}

function displayDoctor() {
	if ($("#entry").is(':checked')) {
		$("#doctorDiv").slideDown();
	}
	if ($("#file").is(':checked')) {
		$("#fileUpload").slideDown();
	}
	resetDivs();
}

function addEntry() {
	$("#fileUpload").slideUp();
	if ($("#hospital").is(':checked')) {
		$("#hospitalDiv").slideDown();
	}
	if ($("#insuranceProvider").is(':checked')) {
		$("#insuranceDiv").slideDown();
	}
	if ($("#doctor").is(':checked')) {
		$("#doctorDiv").slideDown();
	}
}

function uploadFile() {
	$("#doctorDiv").slideUp();
	$("#hospitalDiv").slideUp();
	$("#insuranceDiv").slideUp();
	$("#fileUpload").slideDown();
}
