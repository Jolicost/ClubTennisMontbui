package Presentacio.Components.Nav;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Components.SingleWebComponent;

public class Logo extends Header {

	public Logo(){
		super();
	}
	@Override
	protected void writeContent()
			throws IOException, ServletException {
		super.IncludeFile("Components/Misc/logo.jsp");
	}
	

}
