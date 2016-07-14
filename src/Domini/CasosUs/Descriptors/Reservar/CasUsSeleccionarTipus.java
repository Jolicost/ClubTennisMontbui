package Domini.CasosUs.Descriptors.Reservar;

import Domini.CasosUs.Controladors.Reserva.FerReserva;

public class CasUsSeleccionarTipus extends CasUsReservar {

	
	protected String tipus;
	public CasUsSeleccionarTipus(String tipus){
		this.tipus = tipus;
	}
	@Override
	protected void CridarCasUs(FerReserva main) throws Exception {
		main.SeleccionarTipus(tipus);
	}
}
