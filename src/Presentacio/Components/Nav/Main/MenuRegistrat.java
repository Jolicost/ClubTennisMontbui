package Presentacio.Components.Nav.Main;

import Presentacio.Components.Nav.MenuItem;
import Presentacio.Components.Nav.Buttons.Reserva.TriarEsportMenu;
import Presentacio.Components.Nav.Buttons.Reserva.VeureReservesMenu;

public class MenuRegistrat extends MenuPrincipal {

	@Override
	protected void createComponents() {
		super.createComponents();
		super.AddComponent(new TriarEsportMenu());
		super.AddComponent(new VeureReservesMenu());
	}

}
