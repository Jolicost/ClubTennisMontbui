package Presentacio.Components.Gestors.Franges.Reserves;

import Communicacio.Dades.Reserves.InfoReserva;
import Presentacio.Components.Formularis.Inputs.Temporals.DateInput;
import Presentacio.Components.Formularis.Inputs.Temporals.DateTimeLocalInput;
import Presentacio.Components.Gestors.Franges.FormulariFranjaUpdate;

public class FormulariReservaUpdate extends FormulariFranjaUpdate implements FormulariReserva {

	protected InfoReserva i;
	public FormulariReservaUpdate(InfoReserva i) {
		super(i);
		this.i = i;
	}
	@Override
	public DateInput getDataRealitzadaInput() {
		DateInput ret = new DateTimeLocalInput("dataRealitzada","dataRealitzada","Data Realitzada: ");
		ret.setInitialValue(i.getDataRealitzada().toLocalDateTime().toString());
		return ret;
	}
	
	@Override
	protected void createInputs() {
		super.createInputs();
		this.AddComponent(getDataRealitzadaInput());
	}

}
