package Presentacio.TagBuilder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullTag extends ComponentTag {

	public void writeStart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

	}
	
	public void writeEnd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

	}
}
