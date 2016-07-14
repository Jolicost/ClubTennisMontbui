package Presentacio.Components.Gestors;

import java.io.IOException;

import javax.servlet.ServletException;

public class VistaCRUDOcupacions extends VistaCRUDEntitat{

	@Override
	public void Include() throws IOException, ServletException {
		super.IncludeFile("Components/Calendari/calendariOcupacions.jsp");
	}
}
