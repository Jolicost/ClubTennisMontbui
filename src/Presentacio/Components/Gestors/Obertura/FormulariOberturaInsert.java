package Presentacio.Components.Gestors.Obertura;

import Presentacio.Components.Formularis.Inputs.Temporals.DiaInput;
import Presentacio.Components.Formularis.Inputs.Temporals.IntervalInput;

public class FormulariOberturaInsert extends FormulariObertura {

	@Override
	protected IntervalInput getIntervalInput() {
		return new IntervalInput();
	}

	@Override
	protected DiaInput getDiaInput() {
		return new DiaInput();
	}

}
