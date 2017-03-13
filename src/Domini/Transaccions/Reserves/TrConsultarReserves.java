package Domini.Transaccions.Reserves;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Excepcions.DadaIncorrecta;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Soci;
import Domini.Model.Reserves.ReservaSoci;
import Factories.FactoriaControladors;

public class TrConsultarReserves {

	private int soci;
	private SortedSet<InfoFranja> resultat;
	
	public TrConsultarReserves(int soci){
		this.soci = soci;
	}
	
	public void Executar() throws BDExcepcio, DadaIncorrecta {
		resultat = new TreeSet<>();
		Soci s = FactoriaControladors.getInstance().getCtrlSoci().get(soci);
		Predicate<ReservaSoci> p = rs -> rs.EstaActiva();
		for (ReservaSoci rs : s.getReservesParticipaCondicio(p)){
			resultat.add(rs.toInfo(s));
		}
	}

	public SortedSet<InfoFranja> getResultat() {
		return resultat;
	}
	
	
}
