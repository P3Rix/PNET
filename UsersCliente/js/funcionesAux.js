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


var check_list = ["getUsers", "deleteUsers", "getUser", "putUser", "deleteUser"]

function checkPressed(checkID){

	for (check in check_list){ //Ponemos el resto de botones a false
		if (check_list[check] != checkID)
			document.getElementById(check_list[check]).checked = false;
	}

	if (document.getElementById(checkID).checked == true){
		if(checkID == 'getUsers' || checkID == 'deleteUsers')
			window[checkID]();
		else if(document.getElementById('telefono').value != "")
			window[checkID](document.getElementById('telefono').value , 'telephone');
		else if(document.getElementById('DNI').value != "")
			window[checkID](document.getElementById('DNI').value, 'DNI');
		else{ 
			document.getElementById(checkID).checked = false;
			alert('Rellene el campo DNI o el campo telefono');		
		}
	}
}




function borrar(id){

	document.getElementById(id).value = "";

}