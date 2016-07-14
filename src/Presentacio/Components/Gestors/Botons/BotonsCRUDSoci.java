package Presentacio.Components.Gestors.Botons;

import Presentacio.Components.Gestors.Soci.BotoPujarSocis;
import Presentacio.TagBuilder.RowTag;

public class BotonsCRUDSoci extends BotonsCRUD{

	protected void createComponents() {
		super.createComponents();
		super.AddComponent(new BotoPujarSocis());
	}
}
