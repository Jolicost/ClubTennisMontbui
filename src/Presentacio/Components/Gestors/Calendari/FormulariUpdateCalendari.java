package Presentacio.Components.Gestors.Calendari;

import Communicacio.Dades.Info;
import Presentacio.Components.Formularis.Inputs.Calendari.InputNomCalendari;

public class FormulariUpdateCalendari extends FormulariCalendari {

	private Info i;
	public FormulariUpdateCalendari(Info i){
		this.i = i;
	}
	@Override
	protected InputNomCalendari getNomInput() {
		return new InputNomCalendari(i.getAttribute("nom"));
	}

}
