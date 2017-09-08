package Domini.CasosUs.Controladors.Reserva;

import org.joda.time.DateTime;
import Dades.Excepcions.BDExcepcio;
import Domini.Transaccions.InsertarFranja.TrPagament;
import Domini.Transaccions.InsertarFranja.TrReserva;

public class ConfirmarReservaPagament extends ConfirmarReserva {

	public ConfirmarReservaPagament() {
		super();
	}

	@Override
	protected TrReserva crearTransaccio() throws BDExcepcio {
		TrPagament ret = new TrPagament(super.getPista(), i, super.obtenirSoci(), DateTime.now());
		return ret;
	}

}
