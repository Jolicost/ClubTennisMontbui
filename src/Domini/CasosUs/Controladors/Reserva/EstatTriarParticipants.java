package Domini.CasosUs.Controladors.Reserva;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Interval;

import Dades.Controladors.DTO.DTOConjuntSocis;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Controladors.Reserva.Confirmar.ConfirmacioNomesSocis;
import Domini.CasosUs.Resultats.Reserva.ResultatConfirmar;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Restriccions.IRestriccio;
import Domini.Model.Restriccions.RestriccioNomesSocis;
import Factories.FactoriaControladors;

public class EstatTriarParticipants extends SeleccionarTipusReserva {

	
	public EstatTriarParticipants(int idPista, Interval i) {
		super(idPista, i);
		
	}
	
	protected Pista p;


	public void TriarParticipants(Set<Integer> participants) throws Exception{
		p = FactoriaControladors.getInstance().getCtrlPista().get(super.IdPista);
		Set<Soci> socis = getSocis(participants);
		for (Soci s: socis) CheckParticipant(s,p);
		
		ConfirmarReservaNomesSocis c = new ConfirmarReservaNomesSocis();
		c.setSoci(this.soci);
		c.setI(this.i);
		c.setIdPista(this.IdPista);
		c.setParticipants(socis);
		
		super.seguent = c;
		
		ConfirmacioNomesSocis tr = new ConfirmacioNomesSocis();
		tr.setIdPista(this.IdPista);
		tr.setInterval(this.i);
		tr.setNSoci(this.soci);
		
		Set<String> nomsSocis = new HashSet<>();
		socis.forEach(s-> nomsSocis.add(s.getNomComplet()));
		tr.setParticipants(nomsSocis);
		
		tr.Executar();
		
		super.resultat = new ResultatConfirmar(tr.getResult());
	}
	
	protected void CheckParticipant(Soci participant,Pista p) throws NoPotReservar{
		IRestriccio r = new RestriccioNomesSocis(participant,p);
		r.Test(super.getI());
	}
	
	protected Set<Soci> getSocis(Set<Integer> ids) throws BDExcepcio{
		DTOConjuntSocis d = new DTOConjuntSocis(ids);
		d.executar();
		return d.getResult();
	}
}
