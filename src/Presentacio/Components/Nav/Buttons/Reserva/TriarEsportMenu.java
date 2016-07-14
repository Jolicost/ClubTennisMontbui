package Presentacio.Components.Nav.Buttons.Reserva;

import Domini.Model.Esports.FactoriaEsports;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;
import Presentacio.Components.Nav.DropdownMenu;
import Presentacio.Components.Nav.Buttons.Managers.ManageSocisButton;
import Presentacio.Components.Nav.Buttons.Managers.ManageUsersButton;

public class TriarEsportMenu extends DropdownMenu{

	public TriarEsportMenu() {
		super("Reservar");
		super.AddItem(new TriarEsportButton("Tennis",FactoriaEsports.getInstance().getTennis()));
		super.AddItem(new TriarEsportButton("Frontennis",FactoriaEsports.getInstance().getFrontennis()));
	}

}
