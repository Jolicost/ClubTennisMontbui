package Presentacio.Main;

import Communicacio.Dades.Info;
import Communicacio.Xarxa.Domini.Entitats.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.Usuari.FormulariGestorUsuari;
import Presentacio.Components.Gestors.Usuari.VistaGestorUsuari;

public class PaginaGestorIndividual extends PaginaPrincipal{

	@Override
	protected WebComponent getMainComponent() throws EntitatInvalida {
		String entitat = (String) super.io.getParam("entitat");
		return FactoriaEntitats.getInstance().getEntitat(entitat).getGestorIndividual();
	}

}
