package Domini.CasosUs.Resultats.Reserva;

import java.util.Map;
import java.util.Set;

import Communicacio.Dades.InfoHorari;

public class ResultatHorariEsport extends ResultatReserva {
	public ResultatHorariEsport() {

	}

	public ResultatHorariEsport(Set<InfoHorari> resultat) {
		super();
		this.resultat = resultat;
	}

	private Set<InfoHorari> resultat;

	public Set<InfoHorari> getResultat() {
		return resultat;
	}

	public void setResultat(Set<InfoHorari> resultat) {
		this.resultat = resultat;
	}

	protected Map<String,Object> createParameters(){
		Map<String,Object> pars = super.createParameters();
		pars.put("disponibilitats",resultat);
		return pars;
	}

	
}
