package Domini.CasosUs.Resultats.FrangesSetmanals;

import java.util.Set;

import Communicacio.Dades.InfoFranjaSetmanal;

public class ResultatUpdateFranja extends ResultatFrangesSetmanals {

	public ResultatUpdateFranja(Set<InfoFranjaSetmanal> taula){
		super.setConjunt(taula);
	}
}
