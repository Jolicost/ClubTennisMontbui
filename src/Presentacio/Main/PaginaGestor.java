package Presentacio.Main;

import Communicacio.Xarxa.Domini.Entitats.Entitat;
import Communicacio.Xarxa.Domini.Entitats.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaCRUDUsuaris;
import Presentacio.Components.Gestors.Taules.Taula;

public class PaginaGestor extends PaginaPrincipal{

	@Override
	protected WebComponent getMainComponent() throws EntitatInvalida {
		String entitat =  (String) super.io.getParam("entitat");
		return FactoriaEntitats.getInstance().getEntitat(entitat).getGestorEntitat();
	}

}
