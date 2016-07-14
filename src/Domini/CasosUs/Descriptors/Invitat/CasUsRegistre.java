package Domini.CasosUs.Descriptors.Invitat;

import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Domini.CasosUs.Descriptors.Gestors.CasUsInsert;
import Domini.CasosUs.Gestors.Accions.FactoriaAccions;
import Domini.CasosUs.Gestors.Usuaris.GestorUsuariNormal;
import Domini.Model.Rang.FactoriaRangs;

public class CasUsRegistre extends CasUsInsert{

	public CasUsRegistre(){
		super.setEntitat(FactoriaEntitats.getInstance().getUsuari());
		super.setGestor(new GestorUsuariNormal(FactoriaAccions.getInstance().getInsert()));
	}

	@Override
	public boolean IsRoot() {
		return true;
	}
	
	public int getRang(){
		return FactoriaRangs.getInstance().getNormal().getPermis();
	}

}
