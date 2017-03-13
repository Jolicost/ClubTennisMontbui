package Presentacio.Servlets.Editor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Communicacio.Dades.Info;
import Communicacio.Identificacio.Identificacio;
import Communicacio.Identificacio.IdentificadorsWeb;
import Communicacio.Xarxa.FactoriaXarxa;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Descriptors.Gestors.CasUsSubmit;
import Presentacio.Controladors.UseCaseWebBuilder;

/**
 * Servlet implementation class submit
 */
@WebServlet("/submit")
public class submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Identificacio id = IdentificadorsWeb.getInstance().get(request);
		UseCaseWebBuilder w = new UseCaseWebBuilder(request,response);
		try{
			CasUsSubmit cu = new CasUsSubmit();
			String entitat = FactoriaXarxa.getInstance().getControladorWeb().getEntitatGestor(id);
			
			Info i = FactoriaEntitats.getInstance().construir(request, entitat);
			cu.setDada(i);
			FactoriaXarxa.getInstance().getControladorWeb().FerCasDUs(id, cu).CreatePage(w);
			
		} catch (Exception e){
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
