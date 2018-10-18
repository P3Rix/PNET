function validarFormulario(formulario){
	var bool = true;

	var reDNI  = /[0-9]{8}[a-zA-Z]/;
	var reNombre = /^[a-zA-Z]{2,25}/;
	var reNumero = /[0-9]+/;
	var reApellido = /[a-zA-Z]+ [a-zA-Z]+/;

	if (!(reDNI.test(formulario.dni.value))){
		formulario.dni.style.color = "red";
		formulario.dni.style.fontWeight  = "bold";

		bool = false;
	}
	if ((reNumero.test(formulario.nombre.value)) || !reNombre.test(formulario.nombre.value)){
		formulario.nombre.style.color = "red";
		formulario.nombre.style.fontWeight  = "bold";

		bool = false;
	}
	if (!reApellido.test(formulario.apellidos.value) || reNumero.test(formulario.apellidos.value)){ 
		formulario.apellidos.style.color = "red";
		formulario.apellidos.style.fontWeight  = "bold";

		bool = false;
	}


	return bool;
}