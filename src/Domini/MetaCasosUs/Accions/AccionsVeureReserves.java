package Domini.MetaCasosUs.Accions;

import Domini.Model.Esports.FactoriaEsports;
import Domini.Model.Rang.FactoriaRangs;
import Domini.Model.Rang.Rang;

public class AccionsVeureReserves extends GrupAccions {

	@Override
	protected void crearMenu() {
		menu.add(new AccioPropiesReserves());
		menu.add(new AccioFrangesPistes());
	}

	@Override
	public int getMinRang() {
		return 0;
	}

	@Override
	protected String getNomGrup() {
		return "Veure Reserves";
	}

}
