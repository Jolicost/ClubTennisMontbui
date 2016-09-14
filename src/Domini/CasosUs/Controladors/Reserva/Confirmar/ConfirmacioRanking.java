package Domini.CasosUs.Controladors.Reserva.Confirmar;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarLimitada;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarRanking;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioRanking;

public class ConfirmacioRanking extends ConfirmacioLimitada {

	@Override
	protected InfoConfirmarLimitada crearInfoLimitada() throws BDExcepcio {
		return new InfoConfirmarRanking();
	}

	@Override
	protected IRestriccio crearRestriccio(Soci s) {
		return new RestriccioRanking(s,p);
	}

}
