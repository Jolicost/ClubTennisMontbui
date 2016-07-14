package Presentacio.Components.Gestors.Obertura;

import Communicacio.Dades.InfoObertura;
import Presentacio.Components.Formularis.Inputs.Temporals.DiaInput;
import Presentacio.Components.Formularis.Inputs.Temporals.IntervalInput;

public class FormulariOberturaUpdate extends FormulariObertura {

	private InfoObertura i;
	public FormulariOberturaUpdate(InfoObertura i){
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
