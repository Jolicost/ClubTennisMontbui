package Domini.MetaCasosUs.Accions;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.InfoAccioVeureReservesPropies;

public class AccioPropiesReserves extends Accio{

	public AccioPropiesReserves() {
		super("Les meves reserves",0);
	}

	@Override
	protected InfoAccio crearInfo() {
		return new InfoAccioVeureReservesPropies();
	}

}
