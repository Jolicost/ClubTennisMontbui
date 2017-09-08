package Presentacio.Components.Reserves;

import java.io.IOException;
import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;

public class VistaSeleccionarFranja extends SingleWebComponent {


	@Override
	protected void writeContent() throws IOException, ServletException {
		super.IncludeFile("Components/Calendari/calendari.jsp");
	}

}
