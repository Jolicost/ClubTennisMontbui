package Presentacio.Components.Nav.Buttons.Reserva;

import Domini.Model.Esports.FactoriaEsports;
import Presentacio.Components.Nav.DropdownMenu;

public class TriarEsportMenu extends DropdownMenu{

	public TriarEsportMenu() {
		super("Reservar");
		super.AddItem(new TriarEsportButton("Tennis",FactoriaEsports.getInstance().getTennis()));
		super.AddItem(new TriarEsportButton("Frontennis",FactoriaEsports.getInstance().getFrontennis()));
	}

}
