package Presentacio.Components.Reserves;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;
import Presentacio.Components.WebComponent;

public class VistaSeleccionarFranja extends SingleWebComponent {


	@Override
	protected void writeContent() throws IOException, ServletException {
		super.IncludeFile("Components/Calendari/calendari.jsp");
	}

}
