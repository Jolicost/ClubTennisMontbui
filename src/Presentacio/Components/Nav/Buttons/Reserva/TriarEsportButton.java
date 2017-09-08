package Presentacio.Components.Nav.Buttons.Reserva;

import Presentacio.Components.Nav.MenuItem;

public class TriarEsportButton extends MenuItem {

	public TriarEsportButton(String nom,String esport) {
		super(nom,"reservar?esport=" + esport);		
	}

}
