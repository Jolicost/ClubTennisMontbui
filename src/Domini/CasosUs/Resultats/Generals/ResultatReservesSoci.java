package Domini.CasosUs.Resultats.Generals;

import java.io.IOException;
import java.util.Map;
import java.util.SortedSet;

import javax.servlet.ServletException;

import Communicacio.Dades.Reserves.InfoFranja;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaVeureReserves;

public class ResultatReservesSoci extends ResultatCasUs {

	private SortedSet<InfoFranja> reserves;
	public ResultatReservesSoci(SortedSet<InfoFranja> reserves){
		this.reserves = reserves;
	}

	
	
	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("reserves", reserves);
		return pars;
	}
	
	@Override
	public void CreatePage(UseCaseWebBuilder w) throws Exception {
		this.PopulateParameters(w);
		w.Create(new PaginaVeureReserves());
	}
	
	
}
