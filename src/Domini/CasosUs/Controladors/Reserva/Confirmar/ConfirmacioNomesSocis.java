package Domini.CasosUs.Controladors.Reserva.Confirmar;

import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarLimitada;
import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarNomesSocis;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioNomesSocis;

public class ConfirmacioNomesSocis extends ConfirmacioLimitada{

	public ConfirmacioNomesSocis() {
		super();
		participants = new HashSet<>();
	}


	@Override
	protected InfoConfirmarLimitada crearInfoLimitada() {
		InfoConfirmarLimitada ret = new InfoConfirmarNomesSocis();
		return ret;
	}

	@Override
	protected IRestriccio crearRestriccio(Soci s) {
		return new RestriccioNomesSocis(s,p);
	}


}
