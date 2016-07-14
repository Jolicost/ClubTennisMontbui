package Presentacio.Servlets.Reservar;

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
import Domini.CasosUs.Descriptors.Reservar.CasUsSeleccionarEsport;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaHome;
import Presentacio.Main.PaginaRegistre;
import Presentacio.Main.PaginaSeleccionarFranja;

/**
 * Servlet implementation class Reservar
 */
@WebServlet("/reservar")
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservar() {
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
			String esport = request.getParameter("esport");
			CasUsSeleccionarEsport cu = new CasUsSeleccionarEsport(esport);
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, cu).PopulateParameters(w);
			w.Create(new PaginaSeleccionarFranja());
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
