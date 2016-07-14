package Domini.CasosUs.Controladors.Reserva.Tipus;

import Communicacio.Dades.Reserves.Tipus.InfoTipusInvitacio;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioInvitacio;

public class ComprovarInvitacio extends TrComprovarTipus {

	public ComprovarInvitacio() {
		super();
	}

	@Override
	protected IRestriccio getRestriccioQuota() {
		return new RestriccioInvitacio(s);
	}

	@Override
	protected InfoTipusReserva crearResultat() {
		return new InfoTipusInvitacio();
	}

}
