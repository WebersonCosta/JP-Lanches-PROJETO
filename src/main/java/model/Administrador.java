package model;

public class Administrador {
	
	private String idAdministrador;
	private String nome;
	private String login;
	private String senha;
	private String cpf;
	
	
	public Administrador() {
		super();
	}


	public Administrador(String idAdministrador, String nome, String login, String senha, String cpf) {
		super();
		this.idAdministrador = idAdministrador;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
	}


	public String getIdAdministrador() {
		return idAdministrador;
	}


	public void setIdAdministrador(String idAdministrador) {
		this.idAdministrador = idAdministrador;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}