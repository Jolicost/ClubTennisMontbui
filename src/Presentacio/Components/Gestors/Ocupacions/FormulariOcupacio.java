package Presentacio.Components.Gestors.Ocupacions;

import Presentacio.Components.Formularis.Formulari;
import Presentacio.Components.Formularis.Inputs.Ocupacions.TipusOcupacioInput;
import Presentacio.Components.Formularis.Inputs.Temporals.DiaInput;
import Presentacio.Components.Formularis.Inputs.Temporals.IntervalInput;

public abstract class FormulariOcupacio extends Formulari {

	@Override
	protected String getDispatcher() {
		return "submit";
	}

	@Override
	protected void createInputs() {
		this.AddComponent(getIntervalInput());
		this.AddComponent(getDiaInput());
		this.AddComponent(getTipusInput());
	}
	
	protected abstract IntervalInput getIntervalInput();
	protected abstract DiaInput getDiaInput();
	protected abstract TipusOcupacioInput getTipusInput();
}
