package Presentacio.Components.Gestors;

import java.io.IOException;

import javax.servlet.ServletException;

public class VistaCRUDFranges extends VistaCRUDEntitat {

	@Override
	public void Include() throws IOException, ServletException {
		super.IncludeFile("Components/Calendari/calendariFranges.jsp");
	}
}
