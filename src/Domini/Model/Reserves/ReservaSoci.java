package Domini.Model.Reserves;

import java.util.Set;

import org.joda.time.DateTime;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoReserva;
import Communicacio.Dades.Reserves.InfoReservaSoci;
import Domini.Model.Soci;

public abstract class ReservaSoci extends Reserva{
	private Soci propietari;
	
	
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

	
}
