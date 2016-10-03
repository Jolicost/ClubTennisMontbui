package Presentacio.Components.Gestors.Franges.Ocupacions;

import Communicacio.Dades.Reserves.InfoOcupacio;
import Presentacio.Components.Formularis.Inputs.Ocupacions.TipusOcupacioInput;
import Presentacio.Components.Gestors.Franges.FormulariFranjaUpdate;

public class FormulariOcupacioUpdate extends FormulariFranjaUpdate implements FormulariOcupacio {

	private InfoOcupacio i;
	public FormulariOcupacioUpdate(InfoOcupacio i){
		super(i);
		this.i = i;
	}
	@Override
	public TipusOcupacioInput getTipusInput() {
		return new TipusOcupacioInput(i.getTipus());
	}
	
	@Override
	protected void createInputs() {
		super.createInputs();
		this.AddComponent(getTipusInput());
	}

}
