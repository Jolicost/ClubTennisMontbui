package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.InfoOcupacio;
import Domini.CasosUs.Gestors.Accions.FactoriaAccions;
import Domini.CasosUs.Gestors.Franges.GestorFranja;
import Domini.CasosUs.Gestors.Franges.GestorOcupacio;
import Domini.Model.Reserves.Ocupacio;

public abstract class TipusOcupacio extends TipusFranja {

	@Override
	public GestorFranja getGestorFranjaInsert() {
		return new GestorOcupacio(FactoriaAccions.getInstance().getInsert());
	}

	@Override
	public GestorFranja getGestorFranjaUpdate(int IDFranja) {
		return new GestorOcupacio(FactoriaAccions.getInstance().getUpdate(),IDFranja);
	}
	
	public abstract Ocupacio getTipusOcupacio();
	public abstract InfoOcupacio getInfoOcupacio();

}
