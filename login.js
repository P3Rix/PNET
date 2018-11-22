function validateAdmin(form){

	if (form.user.value == "admin" && form.password.value == "admin")
		return true;
	else{ 
		alert("Login incorrecto");
		return false;
	}
}