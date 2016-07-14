package Presentacio.Components.Footer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.ServletComponent;
import Presentacio.TagBuilder.FooterTag;

public class Footer extends ServletComponent{

	public Footer(){
		super("Components/Footer/footer.jsp");
	}
	
	
}
