package Domini.MetaCasosUs.Accions;

import Domini.Model.Esports.FactoriaEsports;
import Domini.Model.Rang.FactoriaRangs;
import Domini.Model.Rang.Rang;

public class AccionsReservar extends GrupAccions{

	
	
	public AccionsReservar(){
		super();
	}
	
	protected void crearMenu(){
		Rang normal = FactoriaRangs.getInstance().getNormal();
		menu.add(new AccioReservar("Tennis",normal.getPermis(),FactoriaEsports.getInstance().getTennis()));
		menu.add(new AccioReservar("Frontennis",normal.getPermis(),FactoriaEsports.getInstance().getFrontennis()));
	}
	
	

	@Override
	public int getMinRang() {
		return FactoriaRangs.getInstance().getNormal().getPermis();
	}

	@Override
	protected String getNomGrup() {
		return "Reservar";
	}
	
}
