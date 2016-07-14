package Presentacio.Components.Footer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Components.SingleWebComponent;

public class Test extends SingleWebComponent{

	

	public Test() {
		super();
	}

	@Override
	protected void writeContent()
			throws IOException, ServletException {
		super.Append("<p>Que Tingueu un bon dia!</p>\n");
		
	}
	
	

}
