package Domini.CasosUs.Actors;

import Domini.MetaCasosUs.Accions.TrConsultarAccions;
import Domini.MetaCasosUs.Accions.TrConsultarAccionsInvitat;
import Domini.Model.Rang.FactoriaRangs;

public class Invitat extends Actor{

	@Override
	protected int getRang() {
		return FactoriaRangs.getInstance().getNormal().getPermis();
	}

	@Override
	public String getRol() {
		return "invitat";
	}

	@Override
	protected TrConsultarAccions getAccionsMembre() {
		return new TrConsultarAccionsInvitat();
	}



}
