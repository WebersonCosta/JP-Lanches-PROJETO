package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrador;
import model.DAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/adminTable", "/insert", "/select", "/update", "/delete" })

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
//	Pizza pizza = new Pizza();
	Administrador administrador = new Administrador();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/adminTable")) {
			administradores(request, response);
		} else if (action.equals("/insert")) {
			inserirAdmin(request, response);
		} else if (action.equals("/select")) {
			listarAdmin(request, response);
		} else if (action.equals("/update")) {
			editarAdmin(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	protected void administradores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Administrador> lista = dao.listarAdmin();
		request.setAttribute("administradores", lista);
		RequestDispatcher rd = request.getRequestDispatcher("admin-table.jsp");
		rd.forward(request, response);
	}

	protected void inserirAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			administrador.setNome(request.getParameter("nome"));
			administrador.setLogin(request.getParameter("usuario"));
			administrador.setSenha(request.getParameter("senha"));
			administrador.setCpf(request.getParameter("cpf"));
			dao.inserirAdmin(administrador);
			response.sendRedirect("adminTable");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void listarAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAdministrador = request.getParameter("idAdministrador");
		administrador.setIdAdministrador(idAdministrador);
		dao.selecionarAdmin(administrador);

		try {
			request.setAttribute("idAdministrador", administrador.getIdAdministrador());
			request.setAttribute("nome", administrador.getNome());
			request.setAttribute("usuario", administrador.getLogin());
			request.setAttribute("senha", administrador.getSenha());
			request.setAttribute("cpf", administrador.getCpf());
			RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void editarAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * System.out.println(request.getParameter("idAdmin"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("usuario"));
		 * System.out.println(request.getParameter("senha"));
		 * System.out.println(request.getParameter("cpf"));
		 */
		String idAdministrador = request.getParameter("idAdministrador");
		administrador.setIdAdministrador(idAdministrador);
		try {
			administrador.setIdAdministrador(idAdministrador);
			administrador.setNome(request.getParameter("nome"));
			administrador.setLogin(request.getParameter("usuario"));
			administrador.setSenha(request.getParameter("senha"));
			administrador.setCpf(request.getParameter("cpf"));
			dao.editarAdmin(administrador);
			response.sendRedirect("adminTable");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	/*
	 * protected void deletarAdmin(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { int idAdministrador =
	 * Integer.parseInt(request.getParameter("idAdministrador"));
	 * admin.setIdAdministrador(idAdministrador);
	 * 
	 * dao.deletarAdmin(admin); response.sendRedirect("main"); }
	 */
}
