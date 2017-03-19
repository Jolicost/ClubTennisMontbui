package Domini.CasosUs.Resultats;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;

import Communicacio.Dades.Info;
import Presentacio.Controladors.UseCaseWebBuilder;
import Presentacio.Main.PaginaGestor;

public class ResultatConjunt extends ResultatEntitat {

	public ResultatConjunt(){
		
	}
	
	public ResultatConjunt(Set<Info> conjunt) {
		super();
		this.conjunt = conjunt;
	}

	protected Set<? extends Info> conjunt;

	public Set<? extends Info> getConjunt() {
		return conjunt;
	}

	public void setConjunt(Set<? extends Info> conjunt) {
		this.conjunt = conjunt;
	}
	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("taula", conjunt);
		return pars;
	}

	@Override
	public void CreatePage(UseCaseWebBuilder w) throws IOException, ServletException, Exception {
		this.PopulateParameters(w);
		w.Create(new PaginaGestor());
	}
	
	
}
