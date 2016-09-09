package Domini.Model.Reserves;

import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.InfoReserva;
import Communicacio.Dades.Reserves.InfoReservaSoci;
import Communicacio.Excepcions.DadaIncorrecta;
import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.CancelarReserva.CancelacioInvalida;
import Domini.Excepcions.CancelarReserva.PropietariInvalid;
import Domini.Excepcions.CancelarReserva.ReservaExpirada;
import Domini.Excepcions.CancelarReserva.SuperaAntelacio;
import Domini.Model.Soci;
import Factories.FactoriaControladors;

public abstract class ReservaSoci extends Reserva{
	private Soci propietari;
	
	private static final int dies = 1;
//	private static final Duration lapseCancelacio = new Duration(dies * 24 * 60 * 60 * 1000);
	
	public ReservaSoci(){
		
	}
	public ReservaSoci(Soci propietari) {
		super();
		this.propietari = propietari;
	}
	
	public Soci getPropietari() {
		return propietari;
	}
	public void setPropietari(Soci propietari) {
		this.propietari = propietari;
	}


	
	public boolean MateixaSetmana(DateTime d){
		DateTime r = super.getInici();
		return r.getYear() == d.getYear() && r.getWeekOfWeekyear() == d.getWeekOfWeekyear();
	}
	
	public boolean MateixMes(DateTime d){
		DateTime r = super.getInici();
		return r.getYear() == d.getYear() && r.getMonthOfYear() == d.getMonthOfYear();
	}
	
	public boolean EsSenseReserva(){return false;}
	
	@Override
	protected InfoReserva crearInfoReserva() {
		InfoReservaSoci ret = crearInfoReservaSoci();
		ret.setNomSoci(this.propietari.getNomComplet());
		return ret;
	}
	
	protected abstract InfoReservaSoci crearInfoReservaSoci();
	
	public boolean EsCancelable(DateTime cancelacio,Soci s){
		return this.getInici().isAfter(cancelacio.plusDays(dies)) && s.equals(this.propietari) && this.EstaActiva();
	}
	
	public void Cancelar(DateTime cancelacio,Soci s) throws CancelacioInvalida,BDExcepcio{
		
		
		if (!s.equals(this.propietari)) throw new PropietariInvalid();
		
		if (!this.EstaActiva()) throw new ReservaExpirada();
		
		if (!this.getInici().isAfter(cancelacio.plusDays(dies))) throw new SuperaAntelacio();
		
		FactoriaControladors.getInstance().getCtrlFranja().delete(this.getID());
	}
	public InfoFranja toInfo(Soci solicitant) throws DadaIncorrecta {
		InfoReservaSoci irs = this.toInfo().toInfoReservaSoci();
		irs.setCancelable(this.EsCancelable(DateTime.now(), solicitant));
		return irs;
	}

	
}
