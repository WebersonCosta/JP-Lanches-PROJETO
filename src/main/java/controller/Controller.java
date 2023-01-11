package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrador;
import model.DAO;
import model.Pizza;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns={"/Controller", "/main", "/insert", "/select", "/update", "/delete"})

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Locale ptBr = new Locale("pt","BR");
	DAO dao = new DAO();
	Pizza pizza = new Pizza();
	Administrador admin = new Administrador();
	
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);	
		if(action.equals("/main")) {
			administradores(request, response);
		}else if(action.equals("/insert")) {
			inserirAdmin(request, response);
		}else {
			response.sendRedirect("index.html");
		}
		
	}
	protected void administradores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin-table.jsp");
	}
	/*
	protected void administradores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Administrador> lista = null;
		lista = dao.listarAdmin();
		
		request.setAttribute("administradores", lista);
		RequestDispatcher rd = request.getRequestDispatcher("admin-table.jsp");
		rd.forward(request, response);
	}
	*/
	protected void inserirAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("usuario"));
		System.out.println(request.getParameter("senha"));
		System.out.println(request.getParameter("cpf"));*/
		try {
			admin.setNome(request.getParameter("nome"));
			admin.setLogin(request.getParameter("usuario"));
			admin.setSenha(request.getParameter("senha"));
			admin.setCpf(request.getParameter("cpf"));
			dao.inserirAdmin(admin);
			response.sendRedirect("admin-table.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	/*
	protected void listarAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
		admin.setIdAdministrador(idAdministrador);
		
		try {
			request.setAttribute("idAdministrador", admin.getIdAdministrador());
			request.setAttribute("nome", admin.getNome());
			request.setAttribute("login", admin.getLogin());
			request.setAttribute("senha", admin.getSenha());	
			request.setAttribute("cpf", admin.getCpf());
			RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	protected void editarAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
		admin.setIdAdministrador(idAdministrador);
		try {
			admin.setIdAdministrador(idAdministrador);
			admin.setNome(request.getParameter("nome"));
			admin.setLogin(request.getParameter("login"));
			admin.setSenha(request.getParameter("senha"));
			admin.setCpf(request.getParameter("cpf"));
			dao.editarAdmin(admin);
			response.sendRedirect("main");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	protected void deletarAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
		admin.setIdAdministrador(idAdministrador);
		
		dao.deletarAdmin(admin);
		response.sendRedirect("main");
	}
	*/
}
