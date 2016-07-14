package Presentacio.Components.Gestors.Ocupacions;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.DadaIncorrecta;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaGestorIndividual;

public class VistaUpdateOcupacio extends VistaGestorIndividual {


	public VistaUpdateOcupacio(){
	}

	@Override
	protected WebComponent getFormulari() {
		Info i = (Info) super.io.getParam("individual");
		try {
			return new FormulariOcupacioUpdate(i.toInfoOcupacio());
		} catch (DadaIncorrecta e) {
			return new FormulariOcupacioInsert();
		}
	}

}
