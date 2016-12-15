package Presentacio.Controladors;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.TagBuilder.ComponentTag;

public class SimpleWebWritter extends WebWritter {

	public SimpleWebWritter(HttpServletRequest req, HttpServletResponse res) {
		super(req,res);

	}

	@Override
	public void IncludeFile(String file) throws ServletException, IOException {
		request.getRequestDispatcher(file).include(request, response);
	}

	@Override
	public void Append(String s) throws IOException {
		response.getWriter().append(s);
	}

	@Override
	public void WriteTagStart(ComponentTag t) throws IOException, ServletException {
		t.writeStart(request, response);
	}

	@Override
	public void WriteTagEnd(ComponentTag t) throws IOException, ServletException {
		t.writeEnd(request, response);
	}

}
