package Domini.MetaCasosUs.Accions;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.InfoAccioReservar;

public class AccioReservar extends Accio {
	public AccioReservar(String nom, int rang,String esport) {
		super(nom,rang);
		this.esport = esport;
	}

	private String esport;

	@Override
	protected InfoAccio crearInfo() {
		InfoAccioReservar ret = new InfoAccioReservar(super.getNom(),esport);
		return ret;
	}
}
