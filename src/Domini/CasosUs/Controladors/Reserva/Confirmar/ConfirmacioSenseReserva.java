package Domini.CasosUs.Controladors.Reserva.Confirmar;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarSenseReserva;
import Dades.Excepcions.BDExcepcio;

public class ConfirmacioSenseReserva extends TrObtenirConfirmacio {

	public ConfirmacioSenseReserva()  {
		super();
	}

	@Override
	protected InfoConfirmarReserva crearInfo() {
		return new InfoConfirmarSenseReserva();
	}

}
