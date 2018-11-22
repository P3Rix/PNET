function validarFormulario(formulario){
	var bool = true;

	var reDNI  = /[0-9]{8}[a-zA-Z]/;
	var reNombre = /^[a-zA-Z]{2,25}/;
	var reNumero = /[0-9]+/;
	var reApellido = /[a-zA-Z]+ [a-zA-Z]+/;
	var reLetras = /[a-zA-Z]+/;

	if (!(reDNI.test(formulario.dni.value))){
		formulario.dni.style.color = "red";
		formulario.dni.style.fontWeight  = "bold";

		document.getElementById('field_dni').style.color = "red";
		document.getElementById('field_dni').fontWeight  = "bold";
		
		bool = false;
	}
	if ((reNumero.test(formulario.nombre.value)) || !reNombre.test(formulario.nombre.value)){
		formulario.nombre.style.color = "red";
		formulario.nombre.style.fontWeight  = "bold";

		document.getElementById('field_nombre').style.color = "red";
		document.getElementById('field_nombre').fontWeight  = "bold";

		bool = false;
	}
	if (!reApellido.test(formulario.apellidos.value) || reNumero.test(formulario.apellidos.value)){ 
		formulario.apellidos.style.color = "red";
		formulario.apellidos.style.fontWeight  = "bold";

		document.getElementById('field_apellidos').style.color = "red";
		document.getElementById('field_apellidos').fontWeight  = "bold";

		bool = false;
	}

	if (reLetras.test(formulario.telefono.value)){ 
		formulario.telefono.style.color = "red";
		formulario.telefono.style.fontWeight  = "bold";

		document.getElementById('field_telefono').style.color = "red";
		document.getElementById('field_telefono').fontWeight  = "bold";

		bool = false;
	}
	
	if(bool)
		postUser(formulario);
	console.log(bool);
	return bool;
}


function pulsoCampo(name){
	var field = "field_"+name;


	document.getElementById(field).style.color		  	  = "black";
	document.getElementById(field).fontWeight			  = "normal";
	document.getElementsByName(name)[0].style.color   	  = "black";
	document.getElementsByName(name)[0].style.fontWeight  = "normal";

}





function fechaMaxima(fechainicio, obj){
	obj.min = "2018-11-2" + (parseInt(fechainicio[9]));
}


function texto(cual) {
	switch (cual){

		case "normal":
			document.getElementById('par_precios').innerHTML = "<p>Con el abono normal, tendrás acceso a todas las conferencias e instalaciones.</p><h2>"
			+ "Precio por días</h2><ul><li>Un día: 50€</li><li>Dos días: 90€</li><li>Tres días: 130€</li></ul>";
		break;

		case "vip":
			document.getElementById('par_precios').innerHTML = "<p>Con el abono VIP, tendrás acceso a todas las conferencias e instalaciones. Además, tendrás ventajas tales como "
			+ "sitio reservado en posiciones privilegiadas en todas las conferencias.</p><h2>"
			+ "Precio por días</h2><ul><li>Un día: 65€</li><li>Dos días: 110€</li><li>Tres días: 150€</li></ul>";
		break;

		case "platinum":
			document.getElementById('par_precios').innerHTML = "<p>Con el abono Platinum, tendrás acceso a todas las conferencias e instalaciones. Además, tendrás ventajas tales como "
			+ "sitio reservado en posiciones privilegiadas en todas las conferencias y la posibilidad de probar productos de las compañias asistentes que aún no están disponibles para el público.</p><h2>"
			+ "Precio por días</h2><ul><li>Un día: 80€</li><li>Dos días: 145€</li><li>Tres días: 195€</li></ul>";
		break;


	}
}


