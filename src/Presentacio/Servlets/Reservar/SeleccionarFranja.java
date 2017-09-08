package Presentacio.Servlets.Reservar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.Interval;

import Communicacio.Dades.Reserves.InfoReservar;
import Communicacio.Identificacio.Identificacio;
import Communicacio.Identificacio.IdentificadorsWeb;
import Communicacio.Xarxa.FactoriaXarxa;
import Domini.CasosUs.Descriptors.Reservar.CasUsSeleccionarReserva;
import Presentacio.Controladors.UseCaseWebBuilder;

/**
 * Servlet implementation class SeleccionarFranja
 */
@WebServlet("/SeleccionarFranja")
public class SeleccionarFranja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionarFranja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UseCaseWebBuilder w = new UseCaseWebBuilder(request, response);
		try {
			InfoReservar ir = new InfoReservar();
			String json = request.getParameter("franja");
			ir = ir.toInfo(json).toInfoReservar();
			Interval i = new Interval(ir.getInici(),ir.getFi());
			CasUsSeleccionarReserva cus = new CasUsSeleccionarReserva(ir.getIDPista(),i);
			Identificacio id = IdentificadorsWeb.getInstance().get(request);
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, cus).CreatePage(w);
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
