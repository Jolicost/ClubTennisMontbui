package Presentacio.Components.Gestors.Obertura;

import Communicacio.Dades.Info;
import Communicacio.Excepcions.DadaIncorrecta;
import Presentacio.Components.WebComponent;
import Presentacio.Components.Gestors.VistaGestorIndividual;

public class VistaUpdateObertura extends VistaGestorIndividual {


	@Override
	protected WebComponent getFormulari() {
		Info i = (Info) super.io.getParam("individual");
		try {
			return new FormulariOberturaUpdate(i.toInfoObertura());
		} catch (DadaIncorrecta e) {
			return new FormulariOberturaInsert();
		}
	}

}
