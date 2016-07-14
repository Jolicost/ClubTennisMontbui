package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.Tipus.InfoTipusInvitacio;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReservaInvitacio;
import Domini.CasosUs.Controladors.Reserva.EstatFerReserva;
import Domini.CasosUs.Controladors.Reserva.Confirmar.ConfirmacioInvitacio;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.ComprovarInvitacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;
import Domini.Transaccions.InsertarFranja.TrInvitacio;
import Domini.Transaccions.InsertarFranja.TrOcuparFranja;

public class ReservaInvitacio extends TipusReserva {

	@Override
	public String getNom() {
		return "invitacio";
	}

	@Override
	public ConfirmarReserva getConfirmar() {
		return new ConfirmarReservaInvitacio();
	}

	@Override
	public String getDescripcio() {
		return "Els socis disposen de 1 o dues reserves del tipus invitació al mes";
	}

	@Override
	protected InfoTipusReserva createInfo() {
		return new InfoTipusInvitacio();
	}

	@Override
	public TrComprovarTipus crearTransaccioComprovar() {
		return new ComprovarInvitacio();
	}

	@Override
	public TrObtenirConfirmacio crearTransaccioObtenirConfirmacio() {
		return new ConfirmacioInvitacio();
	}



}
