package Presentacio.Controladors;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Communicacio.Identificacio.IdentificadorsWeb;
import Presentacio.Components.WebComponent;

public class WebBuilder {

	protected WebWritter ww;
	
	
	private Queue<WebComponent> addedComponents;
	
	public WebBuilder(HttpServletRequest request,HttpServletResponse response){
		CreateWritter(request,response);
		CreateDomain(request);
		addedComponents = new LinkedList<>();
	}
	
	public WebBuilder(HttpServletRequest request, HttpServletResponse response, String error) {
		CreateWritter(request,response);
		CreateDomain(request);
		ww.AddError(error);
		addedComponents = new LinkedList<>();
	}

	protected void CreateWritter(HttpServletRequest request,HttpServletResponse response){
		ww = new WebWritter(request,response);
	}
	
	protected void CreateDomain(HttpServletRequest request){
		ww.setId(IdentificadorsWeb.getInstance().get(request));
		
		String s = (String) request.getSession().getAttribute("error");
		if (s != null) {
			AddError(s);
		}
		request.getSession().setAttribute("error",null);
	}

	
	public void SetRequestParam(String id,Object o){
		ww.setRequestParam(id, o);
	}
	
	public void AddError(String error){
		ww.AddError(error);
	}
	
	public void AddSuccess(String success){
		ww.AddSuccess(success);
	}
	
	protected IWebIO getDomain(){
		return ww;
	}
	
	
	
	protected void Write(WebComponent w) throws IOException, ServletException{
		w.Include();
		ww.Finish();
	}
	
	protected void Build(WebComponent w) throws Exception{
		InitWebComponent(w);
		if (w.HasChilds()){
			for (WebComponent c: w.createChilds()){
				Build(c);
			}
			
		}
		addedComponents.add(w);
	}
	
	protected void InitWebComponent(WebComponent w){
		w.setWritter(ww);
		w.setDomain(ww);
	}
	
	protected void InitContent(){
		while (!addedComponents.isEmpty()){
			addedComponents.poll().InitContent();
		}
	}
	
	public void Create(WebComponent w) throws Exception{
		this.ww.Clear();
		Build(w);
		InitContent();
		Write(w);
		
	}
	
	public void Forward(String page) throws IOException, ServletException{
		this.ww.Forward(page);
	}
	
}
