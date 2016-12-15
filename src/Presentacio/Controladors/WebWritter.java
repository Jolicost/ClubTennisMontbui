package Presentacio.Controladors;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Communicacio.Identificacio.IdentificacioTomCat;
import Communicacio.Xarxa.FactoriaXarxa;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.TagBuilder.ComponentTag;
import Presentacio.Vistes.Rols.Rol;

public class WebWritter implements IWebWritter,IWebIO{

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private List<String> errors;
	private List<String> success;
	
	private IdentificacioTomCat id;
	
	@SuppressWarnings("unchecked")
	public WebWritter(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;

		
		
		
		if (request.getAttribute("errors") == null){
			errors = new LinkedList<>();
			request.setAttribute("errors",errors);
		}
		else{
			errors = (List<String>) (List<?>) request.getAttribute("errors"); 
		}
		if (request.getAttribute("success") == null){
			success = new LinkedList<>();
			request.setAttribute("success",success);
		}
		else{
			success = (List<String>) (List<?>) request.getAttribute("success"); 
		}
	}
	
	public void Finish(){
		request = null;
		response = null;
	}
	
	
	
	public void IncludeFile(String file) throws ServletException, IOException{
		request.getRequestDispatcher(file).include(request, response);
	}
	
	public void Append(String s) throws IOException{
		response.getWriter().append(s);
	}
	
	public void WriteTagStart(ComponentTag t) throws IOException, ServletException{
		t.writeStart(request, response);
	}
	
	public void WriteTagEnd(ComponentTag t) throws IOException, ServletException{
		t.writeEnd(request, response);
	}
	
	public void setBean(String name,Object o){
		request.setAttribute(name,o);
	}
	
	public Object getBean(String name){
		return request.getAttribute(name);
	}
	
	public void setRequestParam(String id,Object param){
		request.setAttribute(id, param);
	}
	public Object getRequestParam(String id){
		return request.getAttribute(id);
	}
	
	public void Forward(String file) throws IOException,ServletException{
		this.request.getRequestDispatcher(file).forward(request, response);
	}
	
	public void Clear() throws IOException,ServletException{
		response.resetBuffer();
	}

	@Override
	public void setParam(String id, Object o) {
		setRequestParam(id,o);
	}

	@Override
	public Object getParam(String id) {
		return getRequestParam(id);
	}

	public Rol getRol(){return id.getRol();}

	@Override
	public List<String> getErrors() {
		return errors;
	}

	@Override
	public List<String> getSuccess() {
		return success;
	}
	
	public IdentificacioTomCat getId() {
		return id;
	}
	public void setId(IdentificacioTomCat id) {
		this.id = id;
	}

	
	public void AddError(String error){
		this.errors.add(error);
	}
	
	public void AddSuccess(String success){
		this.success.add(success);
	}

	@Override
	public ResultatCasUs ferCasUs(CasUs cu) throws Exception {
		return FactoriaXarxa.getInstance().getControladorWeb().FerCasDUsIndividual(this.id, cu);
	}
	
}
