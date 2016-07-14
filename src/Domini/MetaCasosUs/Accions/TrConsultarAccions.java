package Domini.MetaCasosUs.Accions;

import java.util.List;

import Communicacio.Dades.Accions.InfoAccio;

public abstract class TrConsultarAccions {

	
	
	public List<InfoAccio> consultarAccions(){
		Executar();
		return getResultat();
	}
	
	public List<InfoAccio> consultarAccionsUsuari(){
		return ConsultarAccionsUsuari();
	}
	protected List<InfoAccio> resultat;
	
	private void Executar(){
		resultat = this.ConsultarAccions();
	}
	
	protected abstract List<InfoAccio> ConsultarAccions();

	private List<InfoAccio> getResultat() {
		return resultat;
	}
	
	protected abstract List<InfoAccio> ConsultarAccionsUsuari();
}
