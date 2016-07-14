package Presentacio.Components.Gestors.Pista;

import Presentacio.Components.Formularis.Inputs.Pista.InputNomPista;
import Presentacio.Components.Formularis.Inputs.Pista.InputTipusPista;

public class FormulariInsertPista extends FormulariPista {

	@Override
	protected InputNomPista getInputNomPista() {
		return new InputNomPista();
	}

	@Override
	protected InputTipusPista getInputTipusPista() {
		return new InputTipusPista();
	}

}
