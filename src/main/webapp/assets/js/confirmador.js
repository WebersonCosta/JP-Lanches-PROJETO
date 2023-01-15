/**
 * 
 */
 function confirmar(idAdministrador){
	let resposta = confirm("confirmar a exclusão deste administrador ?")
	if(resposta === true){
		//alert(idAdministrador)
		window.location.href = "delete?idAdministrador=" + idAdministrador
	}
	
}
 