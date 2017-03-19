package Presentacio.Servlets.EditarFranges;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Communicacio.Dades.InfoFranjaSetmanal;
import Communicacio.Identificacio.Identificacio;
import Communicacio.Identificacio.IdentificadorsWeb;
import Communicacio.Xarxa.FactoriaXarxa;
import Communicacio.Xarxa.Domini.Entitats.Constructors.FactoriaConstructors;
import Domini.CasosUs.Descriptors.editorFrangesSetmanals.CasUsEditarFrangesSetmanals;
import Domini.CasosUs.Descriptors.editorFrangesSetmanals.CasUsInsertarFranjaSetmanal;
import Domini.CasosUs.Descriptors.editorFrangesSetmanals.CasUsUpdateFranjaSetmanal;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Controladors.UseCaseWebBuilder;

/**
 * Servlet implementation class insertarFranja
 */
@WebServlet("/updateFranja")
public class updateFranja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateFranja() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UseCaseWebBuilder w = new UseCaseWebBuilder(request, response);
		Identificacio id = IdentificadorsWeb.getInstance().get(request);
		
		try {
			InfoFranjaSetmanal i = new InfoFranjaSetmanal();
			i = FactoriaConstructors.getInstance().getJSON().construir(i, request);
			CasUsUpdateFranjaSetmanal cu = new CasUsUpdateFranjaSetmanal(i);
			ResultatCasUs r = FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, cu);
			response.getWriter().append(r.jsonEncode());
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().append(e.toString());
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
