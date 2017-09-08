package Presentacio.Controladors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Main.Pagina;

public class UseCaseWebBuilder extends WebBuilder {

	public UseCaseWebBuilder(HttpServletRequest request, HttpServletResponse response, String error) {
		super(request, response, error);
	}

	public UseCaseWebBuilder(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	

	
	public void Create(Pagina p) throws Exception{
		super.Create(p);
	}

}
