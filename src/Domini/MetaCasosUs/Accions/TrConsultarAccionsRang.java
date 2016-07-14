package Domini.MetaCasosUs.Accions;

import java.util.ArrayList;
import java.util.List;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.InfoAccioGrup;

public class TrConsultarAccionsRang extends TrConsultarAccions {
	
	
	public TrConsultarAccionsRang(int rang) {
		super();
		Rang = rang;
	}

	protected int Rang;

	@Override
	protected List<InfoAccio> ConsultarAccions() {
		List<InfoAccio> ret = new ArrayList<>();
		GrupAccions adm =   FactoriaAccions.getIntance().getAdministrar();
		if (adm.getMinRang() <= Rang){
			InfoAccioGrup administrar = new InfoAccioGrup();
			List<InfoAccio> accAdmn = new ArrayList<>();
			for (Accio a: adm.getMenu()){
				if (a.getRang() <= Rang)
					accAdmn.add(a.toInfo());
			}
			administrar.setGrup(accAdmn);
			administrar.setTitol(adm.getNomGrup());
			ret.add(administrar);
		}
		
		return ret;
	}
	
	@Override
	protected List<InfoAccio> ConsultarAccionsUsuari() {
		return new ArrayList<>();
	}
	
	

}
