package Domini.CasosUs.Gestors.Obertures;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.joda.time.Interval;
import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoObertures;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Calendari;

public class GestorAfegirObertures extends GestorObertures{

	public GestorAfegirObertures(int idCalendari) {
		super(idCalendari);
	}
	
	private Map<Integer,InfoDiaSetmana> mapDiaSetmana(InfoDiaSetmana[] info){
		Map<Integer,InfoDiaSetmana> ret = new HashMap<>();
		for (InfoDiaSetmana i: info){
			ret.put(i.getDiaSetmana(), i);
		}
		return ret;
	}
	
	public void AfegirObertures(InfoDiaSetmana[] ids,LocalDate inici,LocalDate fi) throws BDExcepcio{
		Map<Integer,InfoDiaSetmana> oberts = mapDiaSetmana(ids);
		
		Calendari c = super.getCalendari();
		
		while (inici.isBefore(fi)){
			int Ndia = inici.getDayOfWeek();
			if (oberts.containsKey(Ndia)){
				InfoDiaSetmana dia = oberts.get(Ndia);
				Interval i = new Interval(inici.toDateTime(dia.getInici()),inici.toDateTime(dia.getFi()));
				c.AfegirObertura(inici, i);	
			}			
			inici = inici.plusDays(1);
		}
		
		super.updateCalendari(c);
	}

	@Override
	public void Submit(Info i) throws Exception {
		InfoObertures io = i.toInfoObertures();
		this.AfegirObertures(io.getDies(),io.getInici(),io.getFi());
	}
	
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getHoraris();
	}

}
