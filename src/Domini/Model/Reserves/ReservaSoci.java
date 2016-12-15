package Domini.Model.Reserves;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Duration;

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
	protected Set<Soci> jugadors;
	//TODO Config attribute
	
	private static final Duration lapseCancelacio = Duration.standardHours(8);
	public ReservaSoci(){
		jugadors = new HashSet<>();
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
	
	public boolean EsPagament(){return false;}
	public boolean EsNomesSocis(){return false;}
	public boolean EsRanking(){return false;}
	public boolean EsAnticipada(){return false;}
	public boolean EsInvitacio(){return false;}
	@Override
	protected InfoReserva crearInfoReserva() {
		InfoReservaSoci ret = crearInfoReservaSoci();
		ret.setNomSoci(this.propietari.getNomComplet());
		Set<String> participants = new HashSet<>();
		this.jugadors.forEach(j -> participants.add(j.getNomComplet()));
		ret.setParticipants(participants);
		return ret;
	}
	
	protected abstract InfoReservaSoci crearInfoReservaSoci();
	
	public boolean EsCancelable(DateTime cancelacio,Soci s){
		try{
			TestCancelar(cancelacio,s);
			return true;
		}
		catch(CancelacioInvalida c){
			return false;
		}
	}
	
	public void Cancelar(DateTime cancelacio,Soci s) throws CancelacioInvalida,BDExcepcio{
		TestCancelar(cancelacio,s);
		FactoriaControladors.getInstance().getCtrlFranja().delete(this.getID());
	}
	
	protected void TestCancelar(DateTime cancelacio,Soci s) throws CancelacioInvalida{
		if (!(s.equals(this.propietari)||this.getJugadors().contains(s))) throw new PropietariInvalid();
		
		if (!this.EstaActiva()) throw new ReservaExpirada();
		
		if (!this.getInici().isAfter(cancelacio.plus(ReservaSoci.lapseCancelacio))) throw new SuperaAntelacio();
	}
	
	public InfoFranja toInfo(Soci solicitant) throws DadaIncorrecta {
		InfoReservaSoci irs = this.toInfo().toInfoReservaSoci();
		irs.setCancelable(this.EsCancelable(DateTime.now(), solicitant));
		Set<String> participants = new HashSet<>();
		this.jugadors.forEach(j -> participants.add(j.getNomComplet()));
		irs.setParticipants(participants);
		return irs;
	}
	public Set<Soci> getJugadors() {
		return jugadors;
	}
	public void setJugadors(Set<Soci> jugadors) {
		this.jugadors = jugadors;
	}

	
}
