package Domini.CasosUs.Resultats.Reserva;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;

import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaSeleccionarTipus;

public class ResultatTriarTipus extends ResultatReserva{

	public ResultatTriarTipus(Set<InfoTipusReserva> tipus) {
		super();
		this.tipus = tipus;
	}

	private Set<InfoTipusReserva> tipus;

	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("tipus",tipus);
		return pars;
	}

	
	
	public void CreatePage(UseCaseWebBuilder w) throws Exception{
		PopulateParameters(w);
		w.Create(new PaginaSeleccionarTipus());
	}

}
