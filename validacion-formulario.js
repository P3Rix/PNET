function validarFormulario(formulario){
	var bool = true;

	var reDNI = /[0-9]{8}[a-zA-Z]/
	if (!(reDNI.test(formulario.dni.value))){
		formulario.dni.style.color = "red";
		bool = false;
	}
	
	
	return bool;
}