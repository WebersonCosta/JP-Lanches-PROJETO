package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	// ArrayList<Pizza> pizzaLista = new ArrayList<>();

	// Connection attributes
	private String drive = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/bdprojetopizzaria?userTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

	// Connection method
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(drive);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println("Método de conexão ");
			System.out.println(e);
			return null;
		}
	}

	// Test connection method
	/*
	 * public void testarConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 * 
	 * 
	 * /* PIZZA
	 */
	/*
	 * public void inserirPizza(Pizza pizza) { String sql =
	 * "INSERT INTO pizza(saborPizza, precoPizza, ingredientePizza)" +
	 * "VALUE(?,?,?)"; try { Connection con = conectar(); PreparedStatement pstm =
	 * con.prepareStatement(sql); pstm.setString(1, pizza.getSaborPizza());
	 * pstm.setDouble(2, pizza.getPrecoPizza()); pstm.setString(3,
	 * pizza.getIngredientePizza()); pstm.execute(); pstm.close(); } catch
	 * (Exception e) { System.out.println("Método de inserir pizza");
	 * System.out.println(e); } }
	 * 
	 * public ArrayList<Pizza> listarPizza() { String sql = "SELECT * FROM pizza";
	 * try { Connection con = conectar(); PreparedStatement pstm =
	 * con.prepareStatement(sql); ResultSet rs = pstm.executeQuery(sql); while
	 * (rs.next()) { int idPizza = rs.getInt(1); String saborPizza =
	 * rs.getString(2); Double precoPizza = rs.getDouble(3); String ingredientePizza
	 * = rs.getString(4); pizzaLista.add(new Pizza(idPizza, saborPizza, precoPizza,
	 * ingredientePizza)); } con.close(); } catch (Exception e) {
	 * System.out.println("Método de listar pizza "); System.out.println(e); }
	 * return pizzaLista; }
	 * 
	 * public void selecionarPizza(Pizza pizza) { String sql =
	 * "SELECT * FROM pizza WHERE idPizza = ?"; try { Connection con = conectar();
	 * PreparedStatement pstm = con.prepareStatement(sql); pstm.setInt(1,
	 * pizza.getIdPizza()); ResultSet rs = pstm.executeQuery(sql); while (rs.next())
	 * { pizza.setIdPizza(rs.getInt("idPizza"));
	 * pizza.setSaborPizza(rs.getString("saborPreco"));
	 * pizza.setPrecoPizza(rs.getDouble("precoPizza"));
	 * pizza.setIngredientePizza(rs.getString("ingredientePizza")); } con.close(); }
	 * catch (Exception e) { System.out.println("Método de selecionar pizza ");
	 * System.out.println(e); } }
	 * 
	 * public void editarPizza(Pizza pizza) { String sql =
	 * "UPDATE pizza SET saborPizza=?, precoPizza=?, ingredientePizza=? WHERE idPizza=?"
	 * ;
	 * 
	 * try { Connection con = conectar(); PreparedStatement pstm =
	 * con.prepareStatement(sql); pstm.setString(1, pizza.getSaborPizza());
	 * pstm.setDouble(2, pizza.getPrecoPizza()); pstm.setString(3,
	 * pizza.getIngredientePizza()); pstm.setInt(4, pizza.getIdPizza());
	 * pstm.executeUpdate(); con.close(); } catch (Exception e) {
	 * System.out.println("Método de editar pizza "); System.out.println(e); } }
	 * 
	 * public void deletarPizza(Pizza pizza) { String sql =
	 * "DELETE FROM pizza WHERE idPizza =?";
	 * 
	 * try { Connection con = conectar(); PreparedStatement pstm =
	 * con.prepareStatement(sql); pstm.setInt(1, pizza.getIdPizza());
	 * pstm.executeUpdate(); con.close(); } catch (Exception e) {
	 * System.out.println("Método de deletar pizza "); System.out.println(e); }
	 * 
	 * }
	 * 
	 * /* ADMINISTRADOR
	 */

	public void inserirAdmin(Administrador admin) {
		String create = "INSERT INTO administrador(nome, login, senha, cpf)" + "VALUE(?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(create);
			pstm.setString(1, admin.getNome());
			pstm.setString(2, admin.getLogin());
			pstm.setString(3, admin.getSenha());
			pstm.setString(4, admin.getCpf());
			pstm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Método de inserir admin");
			System.out.println(e);
		}
	}

	public ArrayList<Administrador> listarAdmin() {
		ArrayList<Administrador> administradores = new ArrayList<>();
		String read = "SELECT * FROM administrador ORDER BY nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idAdministrador = rs.getString(1);
				String nome = rs.getString(2);
				String login = rs.getString(3);
				String senha = rs.getString(4);
				String cpf = rs.getString(5);
				administradores.add(new Administrador(idAdministrador, nome, login, senha, cpf));
			}
			con.close();
			return administradores;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Método de listar admin");
			return null;
		}
	}

	/*
	 * public void selecionarAdmin(Administrador admin) { String sql =
	 * "SELECT * FROM administrador WHERE idAdministrador = ?"; try { Connection con
	 * = conectar(); PreparedStatement pstm = con.prepareStatement(sql);
	 * pstm.setString(1, admin.getIdAdministrador()); ResultSet rs =
	 * pstm.executeQuery(sql); while (rs.next()) {
	 * admin.setIdAdministrador(rs.getString("idAdministrador"));
	 * admin.setNome(rs.getString("nome")); admin.setLogin(rs.getString("login"));
	 * admin.setSenha(rs.getString("senha")); admin.setCpf(rs.getString("cpf")); }
	 * con.close(); } catch (Exception e) {
	 * System.out.println("Método de selecionar admin "); System.out.println(e); } }
	 * 
	 * public void editarAdmin(Administrador admin) { String sql =
	 * "UPDATE administrador SET nome=?, login?, senha=?, cpf=? WHERE idAdministrador=?"
	 * ;
	 * 
	 * try { Connection con = conectar(); PreparedStatement pstm =
	 * con.prepareStatement(sql); pstm.setString(1, admin.getNome());
	 * pstm.setString(2, admin.getLogin()); pstm.setString(3, admin.getSenha());
	 * pstm.setString(4, admin.getCpf()); pstm.setString(5,
	 * admin.getIdAdministrador()); pstm.executeUpdate(); con.close(); } catch
	 * (Exception e) { System.out.println("Método de editar admin ");
	 * System.out.println(e); } }
	 * 
	 * public void deletarAdmin(Administrador admin) { String sql =
	 * "DELETE FROM administrador WHERE idAdministrador =?";
	 * 
	 * try { Connection con = conectar(); PreparedStatement pstm =
	 * con.prepareStatement(sql); pstm.setString(1, admin.getIdAdministrador());
	 * pstm.executeUpdate(); con.close(); } catch (Exception e) {
	 * System.out.println("Método de deletar admin "); System.out.println(e); } }
	 */
}