package Domini.MetaCasosUs.Accions;

import Communicacio.Dades.Accions.InfoAccio;
import Communicacio.Dades.Accions.InfoAccioGestor;

public class AccioGestorEntitat extends Accio {
	public AccioGestorEntitat(String nom, int rang,String entitat) {
		super(nom,rang);
		this.entitat = entitat;
	}

	private String entitat;

	@Override
	protected InfoAccio crearInfo() {
		InfoAccioGestor ret = new InfoAccioGestor(super.getNom(),entitat);
		return ret;
	}
}
