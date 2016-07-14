package Presentacio.Components.Gestors;

import Presentacio.Components.Gestors.Botons.BotonsCRUD;
import Presentacio.Components.Gestors.Botons.BotonsGestor;

public abstract class VistaCRUDEntitat extends VistaGestorEntitat {

	@Override
	protected BotonsGestor getBotons() {
		return new BotonsCRUD();
	}

}
