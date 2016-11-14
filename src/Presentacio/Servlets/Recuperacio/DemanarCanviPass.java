package Presentacio.Servlets.Recuperacio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Identificacio.Identificacio;
import Communicacio.Identificacio.IdentificadorsWeb;
import Communicacio.Xarxa.FactoriaXarxa;
import Domini.CasosUs.Descriptors.Generals.CasUsCancelarReserva;
import Domini.MetaCasosUs.Recuperacio.CasUsDemanarCanvi;
import Presentacio.Controladors.UseCaseWebBuilder;

/**
 * Servlet implementation class DemanarCanviPass
 */
@WebServlet("/DemanarCanviPass")
public class DemanarCanviPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemanarCanviPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Identificacio id = IdentificadorsWeb.getInstance().get(request);
		UseCaseWebBuilder w = new UseCaseWebBuilder(request,response);
		

		try {
			
			CasUsDemanarCanvi cu = new CasUsDemanarCanvi(request.getParameter("email"));
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, cu).CreatePage(w);
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
