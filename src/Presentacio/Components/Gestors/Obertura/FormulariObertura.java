package Presentacio.Components.Gestors.Obertura;

import Presentacio.Components.Formularis.Formulari;
import Presentacio.Components.Formularis.Inputs.Temporals.DiaInput;
import Presentacio.Components.Formularis.Inputs.Temporals.IntervalInput;
import Presentacio.TagBuilder.DesktopColumnTag;

public abstract class FormulariObertura extends Formulari {

	@Override
	protected String getDispatcher() {
		return "submit";
	}

	@Override
	protected void createInputs() {
		this.AddComponent(getIntervalInput());
		this.AddComponent(getDiaInput());
	}
	
	protected abstract IntervalInput getIntervalInput();
	protected abstract DiaInput getDiaInput();
}
