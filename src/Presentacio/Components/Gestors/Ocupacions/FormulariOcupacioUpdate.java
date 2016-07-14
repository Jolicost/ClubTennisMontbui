package Presentacio.Components.Gestors.Ocupacions;

import Communicacio.Dades.InfoObertura;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Presentacio.Components.Formularis.Inputs.Ocupacions.TipusOcupacioInput;
import Presentacio.Components.Formularis.Inputs.Temporals.DiaInput;
import Presentacio.Components.Formularis.Inputs.Temporals.IntervalInput;

public class FormulariOcupacioUpdate extends FormulariOcupacio {

	private InfoOcupacio i;
	public FormulariOcupacioUpdate(InfoOcupacio i){
		this.i = i;
	}
	@Override
	protected IntervalInput getIntervalInput() {
		String inici = i.getInterval().getStart().toLocalTime().toString();
		String fi = i.getInterval().getEnd().toLocalTime().toString();
		return new IntervalInput(inici,fi);
	}

	@Override
	protected DiaInput getDiaInput() {
		return new DiaInput(i.getDia().toString());
	}
	@Override
	protected TipusOcupacioInput getTipusInput() {
		return new TipusOcupacioInput(i.getTipus());
	}

}
