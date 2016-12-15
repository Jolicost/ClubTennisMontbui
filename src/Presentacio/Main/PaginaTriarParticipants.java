package Presentacio.Main;

import Presentacio.Components.ServletComponent;
import Presentacio.Components.WebComponent;

public class PaginaTriarParticipants extends PaginaPrincipal{

	@Override
	protected WebComponent getMainComponent() throws Exception {
		return new ServletComponent("Components/TriarParticipants/TriarParticipants.jsp");
	}

}
