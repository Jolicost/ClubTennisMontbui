package Domini.CasosUs.Controladors.Reserva;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Interval;

import Communicacio.Dades.InfoSoci;
import Communicacio.Dades.Reserves.Participants.InfoTriarParticipants;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Resultats.Reserva.ResultatConfirmar;
import Domini.CasosUs.Resultats.Reserva.ResultatTriarParticipants;
import Domini.Model.Soci;
import Domini.Model.Esports.FactoriaEsports;
import Domini.Model.Esports.IEsport;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;
import Domini.Transaccions.Reserves.TrConsultarPossiblesParticipants;
import Factories.FactoriaControladors;

public class SeleccionarTipusReserva extends EstatFerReserva {

	public SeleccionarTipusReserva(int idPista, Interval i) {
		super();
		IdPista = idPista;
		this.i = i;
	}
	protected int IdPista;
	protected Interval i;
	@Override
	public void SeleccionarTipus(String tipus) throws Exception {
		if (tipus.equals(FactoriaTipusReserva.getInstance().getNomesSocis().getNom())){
			EstatTriarParticipants next = new EstatTriarParticipants(this.IdPista,this.i);
			
			TrConsultarPossiblesParticipants tr = new TrConsultarPossiblesParticipants(i);
			tr.Executar();

			Set<InfoSoci> socis = new HashSet<>();
			for (Soci s: tr.getResult()){
				if (s.getNumero() != super.getSoci()) socis.add(s.toInfo());
			}
			
			String esport = FactoriaControladors.getInstance().getCtrlPista().get(this.IdPista).getNomEsport();
			IEsport es = FactoriaEsports.getInstance().getEsport(esport);
			
			InfoTriarParticipants info = new InfoTriarParticipants();
			info.setSocis(socis);
			info.setMinim(es.getMinimJugadors());
			info.setMaxim(es.getMaximJugadors());
			
			super.resultat = new ResultatTriarParticipants(info);
			super.seguent = next;
		}
		else{
		ConfirmarReserva next = FactoriaTipusReserva.getInstance().getConfirmar(tipus);
		next.setI(i);
		next.setIdPista(IdPista);
		
		TrObtenirConfirmacio tr = FactoriaTipusReserva.getInstance().getConfirmacioReserva(tipus);
		tr.setIdPista(this.IdPista);
		tr.setInterval(this.i);
		tr.setNSoci(this.soci);
		tr.Executar();
		
		this.resultat = new ResultatConfirmar(tr.getResult());
		this.seguent = next;
		}
	}
	public int getIdPista() {
		return IdPista;
	}
	public void setIdPista(int idPista) {
		IdPista = idPista;
	}
	public Interval getI() {
		return i;
	}
	public void setI(Interval i) {
		this.i = i;
	}

}
