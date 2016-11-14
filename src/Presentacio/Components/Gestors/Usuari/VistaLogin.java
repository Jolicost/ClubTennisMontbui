package Presentacio.Components.Gestors.Usuari;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;
import Presentacio.Components.Gestors.VistaIndividual;

public class VistaLogin extends VistaIndividual{

	@Override
	protected void createComponents() throws Exception {
		super.AddComponent(new FormulariLogin());
		super.AddComponent(new ForgotPasswordLink());
	}
	
	private class ForgotPasswordLink extends SingleWebComponent{

		@Override
		protected void writeContent() throws IOException, ServletException {
			super.Append("</br><p class=\" text small text-right\">"
					+ "<a href=\"/ContrasenyaOlvidada\" title=\"Recuperar Contrasenya\">He olvidat la contrasenya</a>"
					+ "</p>"
					);
		}
		
	}

}
