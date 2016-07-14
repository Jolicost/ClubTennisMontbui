package Domini.MetaCasosUs.Accions;

import java.util.ArrayList;
import java.util.List;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.InfoAccioGrup;
import Communicacio.Dades.Accions.InfoAccioIndividual;

public class TrConsultarAccionsSoci extends TrConsultarAccionsMembre {

	@Override
	protected List<InfoAccio> ConsultarAccions() {
		List<InfoAccio> ret = new ArrayList<>();
		GrupAccions grup = FactoriaAccions.getIntance().getReservar();
		if (grup.getMenu().size() > 0){
			InfoAccioGrup g = new InfoAccioGrup();
			g.setTitol(grup.getNomGrup());
			List<InfoAccio> accions = new ArrayList<>();
			for (Accio a: grup.getMenu()){
				accions.add(a.toInfo());
			}
			g.setGrup(accions);
			ret.add(g);
		}
		
		InfoAccioIndividual veure = new InfoAccioIndividual();
		veure.setTitol("Veure Reserves");
		veure.setDispacher("VeureReserves");
		ret.add(veure);
		
		
		return ret;
	}

}
