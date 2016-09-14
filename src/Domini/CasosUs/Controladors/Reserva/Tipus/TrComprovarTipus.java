package Domini.CasosUs.Controladors.Reserva.Tipus;

import org.joda.time.Interval;

import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Dades.Excepcions.BDExcepcio;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;
import Factories.FactoriaControladors;

public abstract class TrComprovarTipus {

	protected int soci;
	protected String esport;
	protected Interval franja;
	protected int IDPista;
	
	protected InfoTipusReserva resultat;
	
	protected Soci s;
	protected Pista p;
	
	public TrComprovarTipus(){

	}
	
	protected Soci getSoci() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlSoci().get(soci);
	}
	
	protected Pista getPista() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlPista().get(IDPista);
	}
	
	public void Executar() throws BDExcepcio, NoPotReservar{
		s = getSoci();
		p = getPista();
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

	public void setIDPista(int iDPista) {
		IDPista = iDPista;
	}


}
