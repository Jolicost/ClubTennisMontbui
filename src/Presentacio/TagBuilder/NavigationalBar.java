package Presentacio.TagBuilder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NavigationalBar extends ComponentTag {

	public NavigationalBar(){
		super.setAttribute("class","navbar");
		super.appendAttribute("class", "navbar-default");
	}
	protected String getComponentTag(){
		return "nav";
	};
	
	public void writeStart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		super.writeStart(request, response);
		response.getWriter().append("<div class=\"container-fluid\">\n");
	}
	
	public void writeEnd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.getWriter().append("</div>\n");
		super.writeEnd(request, response);
	}

}
