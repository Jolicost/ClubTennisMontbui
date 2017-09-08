package Presentacio.Components.Gestors.Botons;

import Presentacio.Components.Gestors.Soci.BotoPujarSocis;

public class BotonsCRUDSoci extends BotonsCRUD{

	protected void createComponents() {
		super.createComponents();
		super.AddComponent(new BotoPujarSocis());
	}
}
