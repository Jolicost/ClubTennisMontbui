package Presentacio.Main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Components.RecursiveWebComponent;
import Presentacio.Components.WebComponent;

public abstract class Pagina extends RecursiveWebComponent{

	protected String title;
	protected WebComponent content;
	
	public Pagina(){
		super();
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public WebComponent getContent() {
		return content;
	}
	public void setContent(WebComponent content) {
		this.content = content;
	}
	
	protected void writeStart() throws IOException, ServletException{
		super.IncludeFile("/PageTemplate/header.jsp");
	}
	
	protected void writeEnd() throws IOException, ServletException{
		super.IncludeFile("/PageTemplate/header_end.jsp");
	}

	
	

}
