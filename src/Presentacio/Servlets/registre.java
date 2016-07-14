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
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Descriptors.Gestors.CasUsInsert;
import Domini.CasosUs.Descriptors.Invitat.CasUsRegistre;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaGestor;
import Presentacio.Main.PaginaHome;
import Presentacio.Main.PaginaRegistre;

/**
 * Servlet implementation class registre
 */
@WebServlet("/registre")
public class registre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registre() {
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
			
			CasUsRegistre cu = new CasUsRegistre();
			cu.setEntitat(FactoriaEntitats.getInstance().getUsuari());
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, cu).PopulateParameters(w);
			w.Create(new PaginaRegistre());
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
