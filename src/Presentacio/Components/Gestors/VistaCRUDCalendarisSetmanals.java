package Presentacio.Components.Gestors;

import Presentacio.Components.Gestors.Botons.BotonsCRUD;
import Presentacio.Components.Gestors.Botons.BotonsCRUDCalendariSetmanal;
import Presentacio.Components.Gestors.Botons.BotonsGestor;

public class VistaCRUDCalendarisSetmanals extends VistaCRUDEntitat {

	@Override
	protected BotonsGestor getBotons() {
		return new BotonsCRUDCalendariSetmanal();
	}
}
