package Domini.MetaCasosUs.Accions;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.InfoAccioVeureFrangesPistes;

public class AccioFrangesPistes extends Accio{


	public AccioFrangesPistes() {
		super("Totes",0);
	}

	@Override
	protected InfoAccio crearInfo() {
		return new InfoAccioVeureFrangesPistes();
	}

}
