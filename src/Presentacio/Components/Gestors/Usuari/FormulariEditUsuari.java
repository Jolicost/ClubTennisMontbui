package Presentacio.Components.Gestors.Usuari;

import Presentacio.Components.WebComponent;
import Presentacio.Components.Formularis.Inputs.Usuari.PassInput;

public class FormulariEditUsuari extends FormulariUsuari {

	@Override
	protected WebComponent getPassInput() {
		return new PassInput();
	}

}
