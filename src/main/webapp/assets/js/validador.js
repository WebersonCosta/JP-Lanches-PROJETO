/**
 * 
 */
 
 function validar (){
	let nome = frmAdmin.nome.value
	let usuario = frmAdmin.usuario.value
	let senha = frmAdmin.senha.value
	let cpf = frmAdmin.cpf.value
	
	if(nome === ""){
		alert('Preencha o campo Nome')
		frmAdmin.nome.focus()
		return false
	}else if(usuario === ""){
		alert('Preencha o campo Usuario')
		frmAdmin.usuario.focus() 
		return false
	}else if(senha === ""){
		alert('Preencha o campo Senha')
		frmAdmin.senha.focus()
		return false
	}else if(cpf === ""){
		alert('Preencha o campo CPF')
		frmAdmin.cpf.focus()
		return false
	}else{
		document.forms[frmAdmin].submit()
	}
}
 