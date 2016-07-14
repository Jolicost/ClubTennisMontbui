package Domini.CasosUs.Descriptors.Reservar;

import org.joda.time.Interval;

import Domini.CasosUs.Controladors.Reserva.FerReserva;

public class CasUsSeleccionarReserva extends CasUsReservar {

	protected int idPista;
	protected Interval interval;

	public CasUsSeleccionarReserva(int IDPista,Interval interval){
		this.idPista = IDPista;
		this.interval = interval;
	}

	@Override
	public void ferCasUs() throws Exception {

	}

	@Override
	protected void CridarCasUs(FerReserva main) throws Exception {
		main.SeleccionarFranja(idPista, interval);
	}
	
}
