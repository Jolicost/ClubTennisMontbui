package Presentacio.Components.Gestors;

import Presentacio.Components.Gestors.Botons.BotonsCRUDSoci;
import Presentacio.Components.Gestors.Botons.BotonsGestor;

public class VistaCRUDSocis extends VistaCRUDEntitat {

	@Override
	protected BotonsGestor getBotons() {
		return new BotonsCRUDSoci();
	}
}
