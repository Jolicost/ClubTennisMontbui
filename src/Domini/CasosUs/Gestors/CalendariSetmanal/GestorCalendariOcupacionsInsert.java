package Domini.CasosUs.Gestors.CalendariSetmanal;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Calendaris.CalendariOcupacions;
import Domini.Model.Calendaris.CalendariSetmanal;

public class GestorCalendariOcupacionsInsert extends GestorCalendariSetmanalInsert {

	@Override
	protected CalendariSetmanal get() throws BDExcepcio {
		return new CalendariOcupacions();
	}

}
