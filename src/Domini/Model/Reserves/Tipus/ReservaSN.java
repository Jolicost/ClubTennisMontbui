package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReservaSN;
import Domini.CasosUs.Controladors.Reserva.Confirmar.ConfirmacioSenseReserva;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;

public class ReservaSN extends TipusReserva {

	@Override
	public String getNom() {
		return "Sense reserva";
	}

	@Override
	public ConfirmarReserva getConfirmar() {
		return new ConfirmarReservaSN();
	}

	@Override
	public String getDescripcio() {
		return "Aquest tipus de reserva nomes funciona 30 minuts abans";
	}
	
	public boolean EsSeleccionable(){
		return false;
	}

	@Override
	protected InfoTipusReserva createInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrComprovarTipus crearTransaccioComprovar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrObtenirConfirmacio crearTransaccioObtenirConfirmacio() {
		return new ConfirmacioSenseReserva();
	}

}
