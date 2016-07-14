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
import Domini.CasosUs.Descriptors.Gestors.CasUsAfegirObertures;
import Domini.CasosUs.Descriptors.Gestors.CasUsAssignar;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaHome;
import Presentacio.Main.PaginaSelector;

/**
 * Servlet implementation class GestionarObertures
 */
@WebServlet("/AfegirObertures")
public class AfegirObertures extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfegirObertures() {
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
			
			CasUsAfegirObertures ao = new CasUsAfegirObertures();
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, ao).CreatePage(w);
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
