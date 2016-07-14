package Presentacio.Components.Gestors.Ocupacions;

import Presentacio.Components.Formularis.Inputs.Ocupacions.TipusOcupacioInput;
import Presentacio.Components.Formularis.Inputs.Temporals.DiaInput;
import Presentacio.Components.Formularis.Inputs.Temporals.IntervalInput;

public class FormulariOcupacioInsert extends FormulariOcupacio {

	@Override
	protected IntervalInput getIntervalInput() {
		return new IntervalInput();
	}

	@Override
	protected DiaInput getDiaInput() {
		return new DiaInput();
	}

	@Override
	protected TipusOcupacioInput getTipusInput() {
		return new TipusOcupacioInput();
	}

}
