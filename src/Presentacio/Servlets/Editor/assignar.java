package Presentacio.Servlets.Editor;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Communicacio.Dades.Info;
import Communicacio.Identificacio.Identificacio;
import Communicacio.Identificacio.IdentificadorsWeb;
import Communicacio.Xarxa.FactoriaXarxa;
import Domini.CasosUs.Descriptors.Gestors.CasUsAssignar;
import Domini.CasosUs.Descriptors.Gestors.CasUsGestionar;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaGestor;
import Presentacio.Main.PaginaHome;
import Presentacio.Main.PaginaSelector;

/**
 * Servlet implementation class assignar
 */
@WebServlet("/assignar")
public class assignar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Identificacio id = IdentificadorsWeb.getInstance().get(request);
		WebBuilder w = new WebBuilder(request,response);

		try {
			
			CasUsAssignar cu = new CasUsAssignar();
			cu.setEntitat(request.getParameter("entitat"));
			
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, cu).PopulateParameters(w);
			w.Create(new PaginaSelector());
		} catch (Exception e) {
			w.AddError(e.toString());
			w.Forward("index");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
