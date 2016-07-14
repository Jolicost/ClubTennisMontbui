package Domini.CasosUs.Descriptors.Generals;

import Communicacio.Dades.PujarSocis.InfoPlantillaSocis;
import Domini.CasosUs.Controladors.PujarSocis.TrPujarSocis;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Descriptors.Gestors.CasUsGestor;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Resultats.ResultatEntitat;
import Domini.CasosUs.Resultats.ResultatEscriptura;
import Domini.Excepcions.CasUsInvalid;
import Domini.Model.Rang.FactoriaRangs;

public class CasUsPujarSocis extends CasUsGestor {

	public CasUsPujarSocis(InfoPlantillaSocis info){
		this.socis  = info;
	}
	private InfoPlantillaSocis socis;

	public InfoPlantillaSocis getSocis() {
		return socis;
	}

	public void setSocis(InfoPlantillaSocis socis) {
		this.socis = socis;
	}

	@Override
	protected ResultatEntitat RealitzarCasUs() throws Exception {
		TrPujarSocis tr = new TrPujarSocis(socis.getSetSocis());
		tr.Executar();
		return new ResultatEscriptura();
	}

	@Override
	protected String getDescriptorGestor() {
		return null;
	}
	
	public Gestor getChild(Gestor g) throws Exception{
		return g;
	}

	public int getRang(){
		return FactoriaRangs.getInstance().getAdmin().getPermis();
	}
	
	
	
}
