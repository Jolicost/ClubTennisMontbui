package Presentacio.Servlets;

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
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Descriptors.Generals.CasUsCancelarReserva;
import Domini.CasosUs.Descriptors.Invitat.CasUsRegistre;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaRegistre;

/**
 * Servlet implementation class cancelarReserva
 */
@WebServlet("/cancelarReserva")
public class cancelarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancelarReserva() {
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
			
			CasUsCancelarReserva cu = new CasUsCancelarReserva();
			InfoFranja i = new InfoFranja();
			i.setIdFranja(Integer.valueOf(request.getParameter("idFranja")));
			cu.setDada(i);
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
		doGet(request,response);
	}

}
