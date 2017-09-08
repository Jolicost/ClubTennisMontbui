package Domini.Transaccions.Reserves;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Predicate;

import org.joda.time.DateTime;

import Domini.Excepcions.CancelarReserva.ReservaInexistent;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;
import Factories.FactoriaControladors;

public class TrCancelarReserva {
	public TrCancelarReserva(int soci, int idFranja) {
		super();
		this.soci = soci;
		this.idFranja = idFranja;
	}
	private int soci;
	private int idFranja;
	
	public void Executar() throws Exception{
		Soci s = FactoriaControladors.getInstance().getCtrlSoci().get(soci);
		Predicate<ReservaSoci> p = rs -> rs.getID() == idFranja;
		
		Set<ReservaSoci> reserves = s.getReservesParticipaCondicio(p);
		
		try{
			ReservaSoci cancelar = reserves.iterator().next();
			cancelar.Cancelar(DateTime.now(), s);
		}
		catch(NoSuchElementException e){
			throw new ReservaInexistent();
		}

	}
	
	

}
