package Domini.Model.Reserves.Tipus;

import org.joda.time.Interval;

import Communicacio.Dades.Reserves.Tipus.InfoTipusInvitacio;
import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReservaInvitacio;
import Domini.CasosUs.Controladors.Reserva.Confirmar.ConfirmacioInvitacio;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.ComprovarInvitacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;

public class ReservaInvitacio extends TipusReserva {

	@Override
	public String getNom() {
		return "Invitacio";
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

	public Interval getIntervalPertanyent(Interval i)  {
		return new Interval(
				i.getStart().dayOfMonth().withMinimumValue().millisOfDay().withMinimumValue(),
				i.getStart().dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue());
	}



}
