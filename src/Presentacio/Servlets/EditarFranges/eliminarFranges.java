package Presentacio.Servlets.EditarFranges;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Communicacio.Dades.InfoFranjaSetmanal;
import Communicacio.Identificacio.Identificacio;
import Communicacio.Identificacio.IdentificadorsWeb;
import Communicacio.Xarxa.FactoriaXarxa;
import Communicacio.Xarxa.Domini.Entitats.Constructors.FactoriaConstructors;
import Domini.CasosUs.Descriptors.editorFrangesSetmanals.CasUsEditarFrangesSetmanals;
import Domini.CasosUs.Descriptors.editorFrangesSetmanals.CasUsEliminarFrangesSetmanals;
import Domini.CasosUs.Descriptors.editorFrangesSetmanals.CasUsInsertarFranjaSetmanal;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Controladors.UseCaseWebBuilder;

/**
 * Servlet implementation class insertarFranja
 */
@WebServlet("/eliminarFranges")
public class eliminarFranges extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminarFranges() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Identificacio id = IdentificadorsWeb.getInstance().get(request);
		
		try {
			
			String s = request.getParameter("info");
			Gson g = new Gson();
			String[] ids;
			ids = g.fromJson(s,String[].class);
			Set<Integer> values = new HashSet<>();
			for (String f: ids){
				values.add(Integer.valueOf(f));
			}
			CasUsEliminarFrangesSetmanals cu = new CasUsEliminarFrangesSetmanals(values);
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
