package Presentacio.Components.Gestors.Franges;

import Communicacio.Dades.Reserves.InfoFranja;
import Presentacio.Components.Formularis.Inputs.Temporals.DiaInput;
import Presentacio.Components.Formularis.Inputs.Temporals.IntervalInput;

public abstract class FormulariFranjaUpdate extends FormulariFranja {

	protected InfoFranja i;
	
	public FormulariFranjaUpdate(InfoFranja i){
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
}
