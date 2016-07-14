package Domini.CasosUs.Controladors.Reserva.Tipus;

import org.joda.time.Interval;

import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;
import Factories.FactoriaControladors;

public abstract class TrComprovarTipus {

	protected int soci;
	protected String esport;
	protected Interval franja;
	
	protected InfoTipusReserva resultat;
	
	protected Soci s;
	
	public TrComprovarTipus(){

	}
	
	protected Soci getSoci() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlSoci().get(soci);
	}
	
	public void Executar() throws BDExcepcio, NoPotReservar{
		s = getSoci();
		this.resultat = crearResultat();
		IRestriccio quota = getRestriccioQuota();
		int restants = quota.Test(this.franja);
		resultat.setRestants(restants);
	}
	
	protected abstract IRestriccio getRestriccioQuota();
	protected abstract InfoTipusReserva crearResultat();
	
	public InfoTipusReserva getResultat(){
		return resultat;
	}

	public String getEsport() {
		return esport;
	}

	public void setEsport(String esport) {
		this.esport = esport;
	}

	public Interval getFranja() {
		return franja;
	}

	public void setFranja(Interval franja) {
		this.franja = franja;
	}

	public void setSoci(int soci) {
		this.soci = soci;
	}


}
