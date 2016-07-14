package Domini.CasosUs.Controladors.Reserva;

import org.joda.time.Interval;

import Domini.CasosUs.Actors.Soci;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.Excepcions.ActorInvalid;

public class FerReserva {
	
	protected Soci actor;
	protected EstatFerReserva estat;
	
	public FerReserva(Soci actor){
		this.actor = actor;
		estat = new EstatSeleccionarEsport();
		estat.setSoci(actor.getNumero());
	}
	public void SeleccionarEsport(String esport) throws Exception{
		estat.SeleccionarEsport(esport);
	}
	public void SeleccionarFranja(int IDPista,Interval i) throws Exception{
		estat.SeleccionarFranja(IDPista, i);
	}
	public void ObtenirHoraris(Interval franja) throws Exception{
		estat.ObtenirHoraris(franja);
	}
	public void SeleccionarTipus(String tipus) throws Exception{
		estat.SeleccionarTipus(tipus);
	}
	public void Confirmar() throws Exception{
		estat.Confirmar();
	}
	
	public ResultatCasUs getResultat(){
		return estat.getResultat();
	}

	protected Soci getSoci() throws ActorInvalid{
		return actor.getSoci();
	}
	
	public void SeguentEstat(){
		if (estat.TeSeguent()){
			estat = estat.getSeguentEstat();
			estat.setSoci(actor.getNumero());
		}
	}
	


}
