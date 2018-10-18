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


	return bool;
}


function pulsoCampo(name){
	var field = "field_"+name;


	document.getElementById(field).style.color		  	  = "black";
	document.getElementById(field).fontWeight			  = "normal";
	document.getElementsByName(name)[0].style.color   	  = "black";
	document.getElementsByName(name)[0].style.fontWeight  = "normal";

}









