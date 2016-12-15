package Presentacio.Controladors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Components.WebComponent;

public class SimpleWebBuilder extends WebBuilder{

	public SimpleWebBuilder(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void Create(WebComponent w) throws Exception {
		Build(w);
		InitContent();
		w.Include();
	}
	
	protected void CreateWritter(HttpServletRequest request,HttpServletResponse response){
		ww = new SimpleWebWritter(request,response);
	}

}
