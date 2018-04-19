function capturaEventoClick(e) {
	var id = e.target.id;
	var oElem1 = document.getElementById(id);
	var nombre = oElem1.value;
	var oInput = document.querySelector("#texto"+nombre);
	var oHidden = document.querySelector("#hidden"+nombre);
	
	if (oElem1.checked == true) {
		// cambiar a no checked, desactivar campo input
		oInput.disabled=false;
		oHidden.disabled=false;
		
	} else {
		// cambiar a checked, activar campo input
		oInput.value="";
		oInput.disabled=true;
		oHidden.disabled=true;
	}
	
}

function desactivaCamposInput() {
	//var elementos = document.querySelectorAll("input.js-input");
	var elementos = document.querySelectorAll("input.js-input");
	
	for(var x = 0; x < elementos.length; x++) {
		elementos[x].disabled = true;
	}
	
	elementos = document.querySelectorAll("input[type='hidden']");
	for(var x = 0; x < elementos.length; x++) {
		elementos[x].disabled = true;
	}
}

function asignarEventoClickcamposCheck() {
	//var elementos = document.querySelectorAll(".js-check");
	var elementos = document.querySelectorAll("input[type='checkbox']");
	
	for(var x = 0; x < elementos.length; x++) {
		var id = elementos[x].value;
		document.getElementById("check"+id).addEventListener('click',capturaEventoClick);
	}
}

window.onload = function() {
	// desactivar todos los campos input.text
	desactivaCamposInput();
	// asignar evento a todos los campos input.checkbox
	asignarEventoClickcamposCheck()
}