package Domini.CasosUs.Controladors.Reserva.Confirmar;

import org.joda.time.Interval;

import Communicacio.Dades.Reserves.Confirmar.InfoConfirmarReserva;
import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Factories.FactoriaControladors;

public abstract class TrObtenirConfirmacio {

	public TrObtenirConfirmacio() {
		super();
		
	}
	protected int IdPista;
	protected Interval interval;
	protected int NSoci;
	
	protected InfoConfirmarReserva result;
	
	protected Pista p;
	protected Soci s;
	
	public int getIdPista() {
		return IdPista;
	}
	public void setIdPista(int idPista) {
		IdPista = idPista;
	}
	public Interval getInterval() {
		return interval;
	}
	public void setInterval(Interval interval) {
		this.interval = interval;
	}
	public InfoConfirmarReserva getResult() {
		return result;
	}
	
	protected Pista getPista() throws BDExcepcio{
		return p;
	}
	
	protected Soci getSoci() throws BDExcepcio{
		return s;
	}
	
	
	public void Executar() throws BDExcepcio, NoPotReservar{
		p = FactoriaControladors.getInstance().getCtrlPista().get(IdPista);
		s = FactoriaControladors.getInstance().getCtrlSoci().get(NSoci);
		
		this.result = crearInfo();
		this.result.setEsport(getPista().getNomEsport());
		this.result.setInterval(this.interval);
		this.result.setIdPista(this.IdPista);
		this.result.setNomPista(p.getNom());
	}

	protected abstract InfoConfirmarReserva crearInfo() throws BDExcepcio, NoPotReservar;
	public int getNSoci() {
		return NSoci;
	}
	public void setNSoci(int nSoci) {
		NSoci = nSoci;
	}

}
