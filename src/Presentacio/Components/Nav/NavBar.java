package Presentacio.Components.Nav;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domini.CasosUs.Descriptors.Generals.CasUsCrearMenuPrincipal;
import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.ServletComponent;
import Presentacio.Components.SingleWebComponent;
import Presentacio.Components.Nav.Main.MenuPrincipal;
import Presentacio.TagBuilder.NavigationalBar;
import Presentacio.TagBuilder.TagFactory;

public class NavBar extends ServletComponent {

	public NavBar(){
		super("Components/NavBar/MenuPrincipal.jsp");	
	}

	
}
