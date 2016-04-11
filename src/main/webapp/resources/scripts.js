$(".submit-button").click(function() {

	if (isValueNull("id") || isValueNull("name") || isValueNull("surname")) {
		$(".error-alert").addClass("alert alert-info").html("Lütfen tüm alanları doldurunuz.");
	} else {
		$("#form").submit();
	}

});

function isValueNull(name) {
	var value = $("input[name='" + name + "']").val();
	if (value == "") {
		return true;
	}
}

function deleteUser(id, name) {
	if (confirm(name + " adlı kişi silinecektir,Onaylıyor musunuz ?")) {
		$(".btn-danger").attr("href", "deletePerson?id=" + id);
	}
}

