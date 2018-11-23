var campos = ["ID", "Nombre", "Apellidos", "Fecha de nacimiento",
"DNI", "Teléfono", "E-mail", "Tipo de inscripción",
"Fecha de inicio", "Fecha de fin"]; 

function formatJSON(dataset){

	var lista = "<ul>";

	for (i = 0 ; i < dataset.length ; i++){
		lista = lista + "Usuario " + i + "<br>";
		j = 0
		for (key in dataset[0]){
			lista = lista + "<li>" + campos[j] + ": ";
			lista = lista + dataset[i][key] + " ";
			lista = lista + "</li>";
			j++;
		}

	}
	lista = lista + "</ul>";

	return lista;
}


var check_list = ["getUsers", "deleteUsers", "getUser", "putUser", "deleteMovie"]

function checkPressed(checkID){

	for (check in check_list){
		if (check_list[check] != checkID)
			document.getElementById(check_list[check]).checked = false;
	}

	if (document.getElementById(checkID).checked == true)
		window[checkID]();
}