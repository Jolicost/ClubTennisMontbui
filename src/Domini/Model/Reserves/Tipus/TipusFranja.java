package Domini.Model.Reserves.Tipus;

import Domini.CasosUs.Gestors.Franges.GestorFranja;

public abstract class TipusFranja {


	public abstract String getNom();
	
	
	public abstract GestorFranja getGestorFranjaInsert();
	public abstract GestorFranja getGestorFranjaUpdate(int IDFranja);
}
