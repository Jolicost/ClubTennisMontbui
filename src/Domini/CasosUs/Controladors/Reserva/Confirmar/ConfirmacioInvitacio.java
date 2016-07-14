package Domini.CasosUs.Controladors.Reserva.Confirmar;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarInvitacio;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarLimitada;
import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioInvitacio;

public class ConfirmacioInvitacio extends ConfirmacioLimitada{

	public ConfirmacioInvitacio() {
		super();
	}

	@Override
	protected InfoConfirmarLimitada crearInfoLimitada() throws BDExcepcio {
		return new InfoConfirmarInvitacio();
	}

	@Override
	protected IRestriccio crearRestriccio(Soci s) {
		return new RestriccioInvitacio(s);
	}



}
