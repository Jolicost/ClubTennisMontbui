package Presentacio.Main;

import Communicacio.Xarxa.Domini.Entitats.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.Usuari.VistaGestorUsuari;
import Presentacio.Components.Gestors.Usuari.VistaInsertUsuari;

public class PaginaInsertIndividual extends PaginaPrincipal{

	@Override
	protected WebComponent getMainComponent() throws EntitatInvalida {
		String entitat = (String) super.io.getParam("entitat");
		return FactoriaEntitats.getInstance().getEntitat(entitat).getInsertIndividual();
	}

}
