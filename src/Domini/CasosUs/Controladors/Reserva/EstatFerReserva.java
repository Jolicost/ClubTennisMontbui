package Domini.CasosUs.Controladors.Reserva;

import java.util.Set;

import org.joda.time.Interval;

import Domini.CasosUs.Resultats.ResultatCasUs;

public abstract class EstatFerReserva {

	protected ResultatCasUs resultat;
	protected EstatFerReserva seguent;
	protected int soci;
	
	public ResultatCasUs getResultat(){
		return resultat;
	}
	
	public EstatFerReserva getSeguentEstat(){
		return seguent;
	}
	
	public void SeleccionarEsport(String esport) throws Exception{
		throw new EstatInvalid();
	}
	public void SeleccionarFranja(int IDPista,Interval i) throws Exception{
		throw new EstatInvalid();
	}
	public void ObtenirHoraris(Interval franja) throws Exception{
		throw new EstatInvalid();
	}
	public void SeleccionarTipus(String tipus) throws Exception{
		throw new EstatInvalid();
	}
	public void TriarParticipants(Set<Integer> participants) throws Exception{
		throw new EstatInvalid();
	}
	public void Confirmar()throws Exception{
		throw new EstatInvalid();
	}

	public int getSoci() {
		return soci;
	}

	public void setSoci(int soci) {
		this.soci = soci;
	}
	
	public boolean TeSeguent(){
		return true;
	}
}
