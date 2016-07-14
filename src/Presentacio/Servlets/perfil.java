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
import Domini.CasosUs.Descriptors.Generals.CasUsConsultarPerfil;
import Presentacio.Components.ServletComponent;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaPerfil;

/**
 * Servlet implementation class perfil
 */
@WebServlet("/Perfil")
public class perfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public perfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebBuilder w = new WebBuilder(request, response);
		Identificacio id = IdentificadorsWeb.getInstance().get(request);
		CasUsConsultarPerfil cu = new CasUsConsultarPerfil();
		try {
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUsIndividual(id,cu).PopulateParameters(w);
			w.Create(new PaginaPerfil());
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
