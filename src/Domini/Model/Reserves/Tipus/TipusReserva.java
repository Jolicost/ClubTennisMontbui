package Domini.Model.Reserves.Tipus;

import org.joda.time.Interval;

import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.ConfirmarReserva;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;
import Domini.CasosUs.Gestors.Accions.FactoriaAccions;
import Domini.CasosUs.Gestors.Franges.GestorFranja;
import Domini.CasosUs.Gestors.Franges.GestorReserva;

public abstract class TipusReserva extends TipusFranja {
	
	
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

	@Override
	public GestorFranja getGestorFranjaInsert() {
		return new GestorReserva(FactoriaAccions.getInstance().getInsert());
	}

	@Override
	public GestorFranja getGestorFranjaUpdate(int IDFranja) {
		return new GestorReserva(FactoriaAccions.getInstance().getUpdate(),IDFranja);
	}
	

}
