package Presentacio.Components.Gestors.Pista;

import Presentacio.Components.Formularis.Formulari;
import Presentacio.Components.Formularis.Inputs.Pista.InputNomPista;
import Presentacio.Components.Formularis.Inputs.Pista.InputTipusPista;
import Presentacio.TagBuilder.CenteredDesktopColumnTag;

public abstract class FormulariPista extends Formulari {

	@Override
	protected String getDispatcher() {
		return "submit";
	}

	@Override
	protected void createInputs() {
		super.AddComponent(getInputNomPista());
		super.AddComponent(getInputTipusPista());
	}
	
	protected abstract InputNomPista getInputNomPista();
	protected abstract InputTipusPista getInputTipusPista();

}
