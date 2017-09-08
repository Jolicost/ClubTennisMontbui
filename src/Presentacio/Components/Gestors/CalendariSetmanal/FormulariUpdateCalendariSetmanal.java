package Presentacio.Components.Gestors.CalendariSetmanal;

import Communicacio.Dades.InfoCalendariOcupacions;
import Presentacio.Components.Formularis.Inputs.CalendariOcupacions.InputNomCalendariSetmanal;
import Presentacio.Components.Formularis.Inputs.CalendariOcupacions.InputTipusCalendariSetmanal;

public class FormulariUpdateCalendariSetmanal extends FormulariCalendariSetmanal{

	private InfoCalendariOcupacions i;
	
	public FormulariUpdateCalendariSetmanal(InfoCalendariOcupacions i){
		this.i = i;
	}
	
	@Override
	protected void createInputs() {
		super.AddComponent(new InputNomCalendariSetmanal(i.getNom()));
		super.AddComponent(new InputTipusCalendariSetmanal(i.getTipus()));
	}
	
}
