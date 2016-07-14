package Domini.CasosUs.Controladors.Reserva;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import Domini.CasosUs.Resultats.Reserva.ResultatHorariEsport;
import Domini.Transaccions.Horaris.TrConsultarHorarisEsport;

public class EstatSeleccionarEsport extends EstatFerReserva {
	
	public void SeleccionarEsport(String esport) throws Exception{
		Interval i = new Interval(DateTime.now(),DateTime.now().plusWeeks(1));
		TrConsultarHorarisEsport tr = new TrConsultarHorarisEsport(esport,i, soci);
		tr.Executar();
		super.resultat = new ResultatHorariEsport(tr.getResult());
		super.seguent = new EstatVisualitzarHoraris(esport);
	}
}
