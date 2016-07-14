package Domini.CasosUs.Controladors.Reserva;

import org.joda.time.Interval;

import Domini.CasosUs.Controladors.Reserva.Confirmar.TrObtenirConfirmacio;
import Domini.CasosUs.Resultats.Reserva.ResultatConfirmar;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

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
