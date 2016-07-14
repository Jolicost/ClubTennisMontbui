package Domini.Model.Reserves.Tipus;

import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;

public abstract class TipusReserva {
	
	
	public abstract String getNom();
	
	public abstract ConfirmarReserva getConfirmar();
	
	public abstract String getDescripcio();
	

	
	public InfoTipusReserva getInfo(){
		InfoTipusReserva ret = createInfo();
		return ret;
	}
	
	public boolean EsSeleccionable(){
		return true;
	}
	
	protected abstract InfoTipusReserva createInfo();
	
	public abstract TrComprovarTipus crearTransaccioComprovar();
	
	public abstract TrObtenirConfirmacio crearTransaccioObtenirConfirmacio();
}
