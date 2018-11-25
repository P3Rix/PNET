var campos = ["ID", "Nombre", "Apellidos", "Fecha de nacimiento",
"DNI", "Telefono", "E-mail", "Tipo de inscripcion",
"Fecha de inicio", "Fecha de fin"]; 
var global_DNI;


function formatJSON(dataset, numeracionUsuario = true){

	var lista = "<table id = \"outputBox\">";

	j = 0;
	lista += "<tr>";
	for (key in dataset[0]){
		if(j != 0)
		{
			
			lista = lista + "<th>" + campos[j];
			lista = lista + "</th>";
			
		}
		j++;
	}
	lista += "</tr>";

	for (i = 0 ; i < dataset.length ; i++){	
		j = 0;
		if(j!=0)
		{
			lista = lista + "<tr>";
		}
		for (key in dataset[0]){
			if (j != 0){
				lista = lista + "<td>";
				lista = lista + dataset[i][key] + " ";
				lista = lista + "</td>";
			}
			if (campos[j] == "DNI")
				global_DNI = dataset[i][key];
			j++;
		}
		lista = lista + "</tr>";
	}
	lista = lista + "</table>";


	return lista;
}

function formatJSONuser(dataset, numeracionUsuario = true){

	var lista = "<ul class = \"outputText\">";

	for (i = 0 ; i < dataset.length ; i++){
		if (numeracionUsuario)	
			lista = lista + "Usuario " + (i+1) + "<br>";
		j = 0;
		for (key in dataset[0]){
			if (j != 0){
			lista = lista + "<li>" + campos[j] + ": ";
			lista = lista + dataset[i][key] + " ";
			lista = lista + "</li>";
			}
			if (campos[j] == "DNI")
				global_DNI = dataset[i][key];
			j++;
		}
		lista = lista + "<br><br>";
	}
	lista = lista + "</ul>";

	return lista;
}


var check_list = ["getUsers", "deleteUsers", "getUser", "putUser_admin", "deleteUser"];

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



function putUser_admin(key){

	var userToChange = 	getUser(key, true);

}

function html_putUser(data){

	lista = formatJSONuser(data, false);
	lista = "<h3>Datos del usuario a cambiar</h3>" + lista;
	document.getElementById("putUserDiv").style.visibility = "visible";
	lista = lista + formHTML(data);
	return lista;
}

function borrar(id){

	document.getElementById(id).value = "";

}





function formHTML(data)
{
	var lista=[] , i = 0;

	for (key in data[0]){
		lista[i] = data[0][key];
		i++;
	}

var formularioHTML =
"<div id = \"formulario_put\">"
+"          <form id = \"formulario\" method=\"post\" action = \"#\" onsubmit = \"return putUser(this, '"+ global_DNI + "')\">"
+"            <label for = \"nombre\" id = \"field_nombre\"  >Nombre: </label>"
+"            <input value = '"+ lista[1] + "' type=\"text\" name = \"nombre\" id = \"nombre\"/>"
+"            <br>"
+"            <label for = \"apellidos\" id = \"field_apellidos\" >Apellidos: </label>"
+"            <input value = '"+ lista[2] + "' type = \"text\" name = \"apellidos\" id = \"apellidos\"/>"
+"            <br>"
+"            <label for = \"fecha\" id = \"field_fecha\" >Fecha de nacimiento: </label>"
+"            <input value = '"+ lista[3] + "' type=\"date\" name = \"fecha\" id = \"fecha\"/>"
+"            <br>"
+"            <label for= \"dni\" id = \"field_dni\" >DNI: </label>"
+"            <input value = '"+ lista[4] + "' type = \"text\" name = \"dni\" id = \"dni\"/>"
+"            <br>"
+"            <label for = \"telefono\" id = \"field_telefono\" >Tlf de contacto: </label>"
+"            <input value = '"+ lista[5] + "' type=\"text\" name = \"telefono\" id = \"telefono\"/>"
+"            <br>"
+"            <label for= \"email\" id = \"field_email\" >E-mail: </label>"
+"            <input value = '"+ lista[6] + "' type = \"email\" name = \"email\" id = \"email\"/>"
+"            <br>"
+"            <label for = \"inscripciones\">Tipo de inscripcion: </label>"
+"            <select name=\"carlist\" form=\"formulario\" id = \"inscripciones\" value = '"+ lista[7] + "'>"
+"              <option value=\"1\">Entrada normal</option>"
+"              <option value=\"2\">Entrada VIP</option>"
+"              <option value=\"3\">Entrada Platinum</option>"
+"            </select>"
+"            <br>"
+"            <label for = \"fecha_ini\">Fecha inicio: </label>"
+"            <input type = \"date\" name =\"fecha_ini\" id = \"fecha_ini\" min=\"2018-11-23\" max = \"2018-11-25\" value = '"+ lista[8] + "'/>"
+"            <br>"
+"            <label for = \"fecha_fin\">Fecha fin: </label>"
+"            <input type = \"date\" name =\"fecha_fin\" id = \"fecha_fin\" value = '"+ lista[9] + "'/>"
+"            <input id = \"boton_enviar\" type=\"submit\" value=\"MODIFICAR USUARIO\"/>"
+"          </form>"
+"        </div>";
return formularioHTML;
}
