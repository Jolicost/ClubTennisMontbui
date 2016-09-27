package Domini.Model.Reserves;

import org.joda.time.DateTime;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoReserva;

public abstract class Reserva extends Ocupacio {
	private DateTime dataRealitzada;

	
	public Reserva(){
		
	}
	public Reserva(DateTime data){
		dataRealitzada = data;
	}
	public DateTime getDataRealitzada() {
		return dataRealitzada;
	}

	public void setDataRealitzada(DateTime dataRealitzada) {
		this.dataRealitzada = dataRealitzada;
	}
	
	


	@Override
	protected InfoFranja crearInfo() {
		InfoReserva ret = crearInfoReserva();
		ret.setDataRealitzada(dataRealitzada);
		return ret;
	}
	
	protected abstract InfoReserva crearInfoReserva();
	

	
	
	
	
	
}
