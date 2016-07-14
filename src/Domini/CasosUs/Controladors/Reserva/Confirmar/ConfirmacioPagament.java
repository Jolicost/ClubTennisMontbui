package Domini.CasosUs.Controladors.Reserva.Confirmar;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarLimitada;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarPagament;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioAnticipada;

public class ConfirmacioPagament extends ConfirmacioLimitada{


	public ConfirmacioPagament()  {
		super();
	}



	@Override
	protected InfoConfirmarLimitada crearInfoLimitada() throws BDExcepcio {
		InfoConfirmarPagament ret = new InfoConfirmarPagament();
		ret.setPreu(super.getPista().getPreu(super.interval.toDuration()));
		return ret;	
	}



	@Override
	protected IRestriccio crearRestriccio(Soci s) {
		return new RestriccioAnticipada(s);
	}

}
