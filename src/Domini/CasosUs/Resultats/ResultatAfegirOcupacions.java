package Domini.CasosUs.Resultats;

import java.util.Map;
import java.util.Set;

import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Controladors.WebBuilder;
import Presentacio.Main.PaginaAfegirObertures;
import Presentacio.Main.PaginaAfegirOcupacions;

public class ResultatAfegirOcupacions extends ResultatEntitat {

	private Set<String> tipus;
	public ResultatAfegirOcupacions(Set<String> tipus){
		this.tipus = tipus;
	}
	@Override
	public void CreatePage(UseCaseWebBuilder w) throws Exception {
		this.PopulateParameters(w);
		w.Create(new PaginaAfegirOcupacions());
	}
	
	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("tipus",tipus);
		return pars;
	}
}
