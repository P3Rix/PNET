var campos = ["ID", "Nombre", "Apellidos", "Fecha de nacimiento",
"DNI", "Telefono", "E-mail", "Tipo de inscripcion",
"Fecha de inicio", "Fecha de fin"]; 

function formatJSON(dataset){

	var lista = "<ul class = \"outputText\">";

	for (i = 0 ; i < dataset.length ; i++){
		lista = lista + "Usuario " + (i+1) + "<br>";
		j = 0
		for (key in dataset[0]){
			lista = lista + "<li>" + campos[j] + ": ";
			lista = lista + dataset[i][key] + " ";
			lista = lista + "</li>";
			j++;
		}
		lista = lista + "<br><br>";
	}
	lista = lista + "</ul>";

	return lista;
}


var check_list = ["getUsers_admin", "deleteUsers_admin", "getUser_admin", "putUser_admin", "deleteMovie_admin"]

function checkPressed(checkID, form){

	for (check in check_list){
		if (check_list[check] != checkID)
			document.getElementById(check_list[check]).checked = false;
	}

	if (document.getElementById(checkID).checked == true)
		window[checkID](form);
}


function getUsers_admin(){
	getUsers();
}


function deleteUsers_admin(){
	deleteUsers();
}


function getUser_admin(form){
	getUser();
}


function putUser_admin(){

}


function deleteMovie_admin(){

}

