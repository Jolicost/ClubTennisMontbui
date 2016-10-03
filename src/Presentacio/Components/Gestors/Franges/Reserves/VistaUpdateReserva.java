package Presentacio.Components.Gestors.Franges.Reserves;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.DadaIncorrecta;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.Franges.Ocupacions.FormulariOcupacioInsert;

public class VistaUpdateReserva extends VistaGestorIndividual {

	@Override
	protected WebComponent getFormulari() {
		Info i = (Info) super.io.getParam("individual");
		try {
			return new FormulariReservaUpdate(i.toInfoReserva());
		} catch (DadaIncorrecta e) {
			return new FormulariOcupacioInsert();
		}
	}

}
