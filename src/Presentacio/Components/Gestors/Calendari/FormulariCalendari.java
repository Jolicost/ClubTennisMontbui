package Presentacio.Components.Gestors.Calendari;

import Presentacio.Components.Formularis.Formulari;
import Presentacio.Components.Formularis.Inputs.Calendari.InputNomCalendari;

public abstract class FormulariCalendari extends Formulari {

	@Override
	protected String getDispatcher() {
		return "submit";
	}

	@Override
	protected void createInputs() {
		super.AddComponent(getNomInput());
	}
	
	protected abstract InputNomCalendari getNomInput();

}
