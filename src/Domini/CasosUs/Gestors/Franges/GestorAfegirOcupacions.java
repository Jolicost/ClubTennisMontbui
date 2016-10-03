package Domini.CasosUs.Gestors.Franges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.joda.time.Interval;
import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoOcupacions;
import Communicacio.Excepcions.EntitatInvalida;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Pista;
import Domini.Model.Reserves.Franja;
import Domini.Model.Reserves.Ocupacio;
import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;
import Factories.FactoriaControladors;

public class GestorAfegirOcupacions extends GestorOcupacionsPista {

	public GestorAfegirOcupacions(int idPista) {
		super(idPista);
	}
	
	private Map<Integer,Set<InfoDiaSetmana>> mapDiaSetmana(InfoDiaSetmana[] info){
		Map<Integer,Set<InfoDiaSetmana>> ret = new HashMap<>();
		for (InfoDiaSetmana i: info){
			if (ret.containsKey(i.getDiaSetmana())){
				ret.get(i.getDiaSetmana()).add(i);
			}
			else {
				Set<InfoDiaSetmana> dia = new HashSet<>();
				dia.add(i);
				ret.put(i.getDiaSetmana(),dia);
			}
		}
		return ret;
	}
	
	public void AfegirOcupacions(InfoDiaSetmana[] ids,LocalDate inici,LocalDate fi,String tipus) throws BDExcepcio, EntitatInvalida{

		Pista p = super.getPista();
		Map<Integer,Set<InfoDiaSetmana>> dies = this.mapDiaSetmana(ids);
		
		Set<Franja> toInsert = new HashSet<>();
		while (inici.isBefore(fi)){
			int Ndia = inici.getDayOfWeek();
			if (dies.containsKey(Ndia)){
				for (InfoDiaSetmana i:dies.get(Ndia)){
					Interval in = new Interval(inici.toDateTime(i.getInici()),inici.toDateTime(i.getFi()));
					Ocupacio o = FactoriaTipusOcupacio.getInstance().getOcupacio(tipus);
					o.setLapse(in);
					p.AfegirFranja(o);
					toInsert.add(o);
				}				
			}
			inici = inici.plusDays(1);
		}
		
		for (Franja j: toInsert){
			FactoriaControladors.getInstance().getCtrlFranja().Insert(j);
		}

	}
	
	
	
	@Override
	public void Submit(Info i) throws Exception {
		InfoOcupacions ic = i.toInfoOcupacions();
		AfegirOcupacions(ic.getDies(),ic.getInici(),ic.getFi(),ic.getTipus());
	}

	
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getOcupacions();
	}
	
	
}
