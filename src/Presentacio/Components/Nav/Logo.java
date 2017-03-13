package Presentacio.Components.Nav;

import java.io.IOException;

import javax.servlet.ServletException;

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
