package Domini.CasosUs.Descriptors.Reservar;

import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Controladors.Reserva.ControladorReserves;
import Domini.CasosUs.Controladors.Reserva.FerReserva;
import Domini.Excepcions.ActorInvalid;

public class CasUsSeleccionarEsport extends CasUsReservar{
	
	protected String esport;
	
	public CasUsSeleccionarEsport(String esport){
		this.esport = esport;
	}
	@Override
	public void ferCasUs() throws Exception {

	}
	
	@Override
	protected void CridarCasUs(FerReserva main) throws Exception {
		main.SeleccionarEsport(esport);
	}
	@Override
	public boolean IsRoot() {
		return true;
	}
	@Override
	public ControladorCasUs getControladorCasUs() throws ActorInvalid {
		return new ControladorReserves(this.getActor());
	}
	
	
	
}
