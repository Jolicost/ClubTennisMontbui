package Presentacio.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Communicacio.Identificacio.Identificacio;
import Communicacio.Identificacio.IdentificadorsWeb;
import Communicacio.Xarxa.FactoriaXarxa;
import Dades.Excepcions.BDExcepcio;
import Dades.Excepcions.NoExisteix;
import Domini.Excepcions.ContrasenyaIncorrecta;

/**
 * Servlet implementation class submit_login
 */
@WebServlet("/submit_login")
public class submit_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submit_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Identificacio id = IdentificadorsWeb.getInstance().get(request);
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		boolean success = false;
		try {
			FactoriaXarxa.getInstance().getControladorWeb().Login(id,email, pass);
			response.sendRedirect("index");
			success = true;
		} catch (ContrasenyaIncorrecta e){
			request.getSession().setAttribute("error", "Contrasenya Incorrecta");
		} catch (NoExisteix e){
			request.getSession().setAttribute("error", "L'usuari no existeix");			
		} catch (BDExcepcio e) {
			request.getSession().setAttribute("error",e.toString());	
		} finally {
			if (!success) request.getRequestDispatcher("login").forward(request,response);
		}
		
		
		
	}

}
