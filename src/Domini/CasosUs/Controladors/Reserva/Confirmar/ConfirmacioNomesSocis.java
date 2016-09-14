package Domini.CasosUs.Controladors.Reserva.Confirmar;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarLimitada;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarNomesSocis;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioAnticipada;

public class ConfirmacioNomesSocis extends ConfirmacioLimitada{

	public ConfirmacioNomesSocis() {
		super();
	}

	@Override
	protected InfoConfirmarLimitada crearInfoLimitada() {
		return new InfoConfirmarNomesSocis();
	}

	@Override
	protected IRestriccio crearRestriccio(Soci s) {
		return new RestriccioAnticipada(s,p);
	}

}
