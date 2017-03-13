package Domini.CasosUs.Controladors.Reserva.Confirmar;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarLimitada;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva;
import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;

public abstract class ConfirmacioLimitada extends TrObtenirConfirmacio {

	public ConfirmacioLimitada(){
		super();
	}

	@Override
	protected InfoConfirmarReserva crearInfo() throws BDExcepcio, NoPotReservar {
		InfoConfirmarLimitada ret = crearInfoLimitada();
		IRestriccio r = crearRestriccio(super.getSoci());
		
		ret.setQuotaActual(r.Test(super.interval));
		return ret;
	}
	
	protected abstract InfoConfirmarLimitada crearInfoLimitada() throws BDExcepcio;
	
	protected abstract IRestriccio crearRestriccio(Soci s);
}
