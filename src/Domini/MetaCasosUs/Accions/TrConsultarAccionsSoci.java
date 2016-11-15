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
		ret.add(grup.crearInfoGrup());
		
		GrupAccions veure = FactoriaAccions.getIntance().getVeureReserves();
		ret.add(veure.crearInfoGrup());
		
		return ret;
	}

}
