package Presentacio.TagBuilder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RowTag extends CustomTag {

	public RowTag(){
		super.appendAttribute("class", "row");
	}
	
	
	public void writeStart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.getWriter().append("<div class=\"container\">\n");
		response.getWriter().append("<" + super.buildComponentTag() + ">\n");
	}
	
	public void writeEnd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.getWriter().append("</div>\n");
		response.getWriter().append("</" + getComponentTag() + ">\n");
	}


}
