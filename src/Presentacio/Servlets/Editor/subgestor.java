package Presentacio.Servlets.Editor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Communicacio.Identificacio.Identificacio;
import Communicacio.Identificacio.IdentificadorsWeb;
import Communicacio.Xarxa.FactoriaXarxa;
import Domini.CasosUs.Descriptors.Gestors.CasUsSubGestor;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaGestor;
import Presentacio.Main.PaginaHome;

/**
 * Servlet implementation class Gestor
 */
@WebServlet("/subgestor")
public class subgestor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subgestor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String entitat = request.getParameter("entitat");
		Identificacio id = IdentificadorsWeb.getInstance().get(request);
		WebBuilder w = new WebBuilder(request,response);

		try {
			CasUsSubGestor cu = new CasUsSubGestor();
			cu.setEntitat(entitat);
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, cu).PopulateParameters(w);
			w.Create(new PaginaGestor());
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
