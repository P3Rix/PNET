var campos = ["Nombre", "Apellidos", "Fecha de nacimiento",
"DNI", "Teléfono", "E-mail", "Tipo de inscripción",
"Fecha de inicio", "Fecha de fin"]; 

function formatJSON(dataset){

	var lista = "<ul>";

	for (i = 0 ; i < dataset.length ; i++){
		lista = lista + "<li>" + campos[i] + ": ";

		for (j = 0 ; j < dataset[i].length ; j++){
			lista = lista + dataset[i] + " ";
		}

		lista = lista + "</li>";
	}
	lista = lista + "</ul>";

	return lista;
}