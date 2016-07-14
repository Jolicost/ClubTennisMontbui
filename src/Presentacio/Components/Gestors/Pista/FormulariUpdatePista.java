package Presentacio.Components.Gestors.Pista;

import Communicacio.Dades.Info;
import Presentacio.Components.Formularis.Inputs.Pista.InputNomCalendari;
import Presentacio.Components.Formularis.Inputs.Pista.InputNomPista;
import Presentacio.Components.Formularis.Inputs.Pista.InputTipusPista;

public class FormulariUpdatePista extends FormulariPista {

	private Info i;
	public FormulariUpdatePista(Info i){
		this.i = i;
	}
	@Override
	protected InputNomPista getInputNomPista() {
		return new InputNomPista(i.getAttribute("nom"));
	}
	
	protected void createInputs() {
		super.createInputs();
		super.AddComponent(new InputNomCalendari(i.getAttribute("calendari")));
	}

	@Override
	protected InputTipusPista getInputTipusPista() {
		return new InputTipusPista(i.getAttribute("pista"));
	}

}
