package Domini.CasosUs.Descriptors.Reservar;

import org.joda.time.Interval;

import Domini.CasosUs.Controladors.Reserva.FerReserva;

public class CasUsConsultarHoraris extends CasUsReservar {



	protected Interval interval;
 
	public CasUsConsultarHoraris(Interval interval){
		this.interval = interval;
	}
	public void ferCasUs() throws Exception{

	}
	@Override
	protected void CridarCasUs(FerReserva main) throws Exception {
		main.ObtenirHoraris(interval);
	}
}
