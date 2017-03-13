package Presentacio.Components.Gestors.CalendariSetmanal;

import Presentacio.Components.Formularis.Formulari;
import Presentacio.Components.Formularis.Inputs.CalendariOcupacions.InputNomCalendariSetmanal;
import Presentacio.Components.Formularis.Inputs.CalendariOcupacions.InputTipusCalendariSetmanal;

public class FormulariCalendariSetmanal extends Formulari {

	@Override
	protected String getDispatcher() {
		return "submit";
	}

	@Override
	protected void createInputs() {
		super.AddComponent(new InputNomCalendariSetmanal());
		super.AddComponent(new InputTipusCalendariSetmanal());
	}

}
