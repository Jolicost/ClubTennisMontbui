package Presentacio.TagBuilder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlFileTag extends ComponentTag {

	private String title;
	public HtmlFileTag(String title){
		this.title = title;
	}
	public void writeStart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("pagename", title);
		request.getRequestDispatcher("PageTemplate/header.jsp").include(request, response);
	}
	
	public void writeEnd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("PageTemplate/header_end.jsp").include(request, response);
	}
	
}
