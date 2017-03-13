package Presentacio.Components.Gestors.Franges.Ocupacions;

import Presentacio.Components.Formularis.Inputs.Ocupacions.TipusOcupacioInput;
import Presentacio.Components.Gestors.Franges.FormulariFranjaInsert;

public class FormulariOcupacioInsert extends FormulariFranjaInsert implements FormulariOcupacio {


	@Override
	public TipusOcupacioInput getTipusInput() {
		return new TipusOcupacioInput();
	}
	
	@Override
	protected void createInputs() {
		super.createInputs();
		this.AddComponent(getTipusInput());
	}

}
