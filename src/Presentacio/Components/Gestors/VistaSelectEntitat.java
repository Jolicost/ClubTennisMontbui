package Presentacio.Components.Gestors;

import Presentacio.Components.Gestors.Botons.BotonsGestor;
import Presentacio.Components.Gestors.Botons.BotonsSelector;

public abstract class VistaSelectEntitat extends VistaGestorEntitat{

	@Override
	protected BotonsGestor getBotons() {
		return new BotonsSelector();
	}

}
