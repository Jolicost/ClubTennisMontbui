package Presentacio.Components.Gestors.Franges;

import Presentacio.Components.Formularis.Inputs.Temporals.DiaInput;
import Presentacio.Components.Formularis.Inputs.Temporals.IntervalInput;

public abstract class FormulariFranjaInsert extends FormulariFranja{

	@Override
	protected IntervalInput getIntervalInput() {
		return new IntervalInput();
	}

	@Override
	protected DiaInput getDiaInput() {
		return new DiaInput();
	}
}
