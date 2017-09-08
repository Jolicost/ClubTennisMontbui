package Domini.CasosUs.Resultats;

import java.util.Map;

import Communicacio.Dades.Info;

public class ResultatIndividual extends ResultatEntitat {


	public ResultatIndividual(Info i) {
		super();
		this.i = i;
	}

	protected Info i;

	public Info getI() {
		return i;
	}

	public void setI(Info i) {
		this.i = i;
	}
	
	
	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("individual",i);
		return pars;
	}
	
	
	
}
