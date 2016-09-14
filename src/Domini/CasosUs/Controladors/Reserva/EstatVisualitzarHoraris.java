package Domini.CasosUs.Controladors.Reserva;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Communicacio.Dades.Reserves.Tipus.InfoTipusReserva;
import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Controladors.Reserva.Tipus.TrComprovarTipus;
import Domini.CasosUs.Resultats.Reserva.ResultatConfirmar;
import Domini.CasosUs.Resultats.Reserva.ResultatHorariEsport;
import Domini.CasosUs.Resultats.Reserva.ResultatTriarTipus;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;
import Domini.Transaccions.Horaris.TrConsultarHorarisEsport;

public class EstatVisualitzarHoraris extends EstatFerReserva {

	private String esport;
	public EstatVisualitzarHoraris(String esport){
		this.esport = esport;
	}
	
	public void SeleccionarFranja(int IDPista,Interval i) throws Exception{
		boolean Anticipada = i.getStart().isBefore(DateTime.now().plusMinutes(15));
		if (Anticipada){
			
			ConfirmarReserva next = new ConfirmarReservaSN();
			next.setI(i);
			next.setIdPista(IDPista);
			
			TrObtenirConfirmacio tr = FactoriaTipusReserva.getInstance().getSenseReserva().crearTransaccioObtenirConfirmacio();
			tr.setIdPista(IDPista);
			tr.setInterval(i);
			tr.setNSoci(this.soci);
			tr.Executar();
			super.resultat = new ResultatConfirmar(tr.getResult());
			super.seguent = next;
		}
		else{
			Set<InfoTipusReserva> res = new HashSet<>();
			
			for (TrComprovarTipus  tr : FactoriaTipusReserva.getInstance().getTransaccionsSeleccionables()){
				tr.setEsport(this.esport);
				tr.setFranja(i);
				tr.setIDPista(IDPista);
				tr.setSoci(this.soci);
				try{
					tr.Executar();
					res.add(tr.getResultat());
				}
				catch (NoPotReservar e){
					
				}
				
				super.resultat = new ResultatTriarTipus(res);
				super.seguent = new SeleccionarTipusReserva(IDPista, i);
			}
			
			
		}
	}
	
	public void ObtenirHoraris(Interval franja) throws Exception{
		TrConsultarHorarisEsport tr = new TrConsultarHorarisEsport(esport,franja, soci);
		tr.Executar();
		super.resultat = new ResultatHorariEsport(tr.getResult());
		super.seguent = this;
	}

}
