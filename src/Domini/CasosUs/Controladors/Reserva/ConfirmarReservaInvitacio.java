package Domini.CasosUs.Controladors.Reserva;

import org.joda.time.DateTime;
import Dades.Excepcions.BDExcepcio;
import Domini.Transaccions.InsertarFranja.TrInvitacio;
import Domini.Transaccions.InsertarFranja.TrReserva;

public class ConfirmarReservaInvitacio extends ConfirmarReserva {

	public ConfirmarReservaInvitacio() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TrReserva crearTransaccio() throws BDExcepcio {
		return new TrInvitacio(super.getPista(), i, super.obtenirSoci(),DateTime.now());
	}

}
