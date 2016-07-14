package Presentacio.Components.Gestors.Calendari;

import Presentacio.Components.Formularis.Inputs.Calendari.InputNomCalendari;

public class FormulariInsertCalendari extends FormulariCalendari {

	@Override
	protected InputNomCalendari getNomInput() {
		return new InputNomCalendari();
	}

}
