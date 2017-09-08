package Domini.CasosUs.Gestors.CalendariSetmanal;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Calendaris.CalendariSetmanal;
import Factories.FactoriaControladors;

public class GestorCalendariOcupacionsUpdate extends GestorCalendariSetmanalUpdate{

	public GestorCalendariOcupacionsUpdate(int id) {
		super(id);
	}

	@Override
	protected CalendariSetmanal get() throws BDExcepcio {
		return FactoriaControladors.getInstance().getCtrlCalendariOcupacions().get(super.idCalendari);
	}

}
