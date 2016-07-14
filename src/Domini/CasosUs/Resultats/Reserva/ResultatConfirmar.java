package Domini.CasosUs.Resultats.Reserva;

import java.util.Map;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaConfirmarReserva;

public class ResultatConfirmar extends ResultatReserva {

	private InfoConfirmarReserva info;
	public ResultatConfirmar(InfoConfirmarReserva result) {
		info = result;
	}
	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("info",info);
		return pars;
	}
	@Override
	public void CreatePage(UseCaseWebBuilder w) throws Exception {
		PopulateParameters(w);
		w.Create(new PaginaConfirmarReserva());
	}

}
