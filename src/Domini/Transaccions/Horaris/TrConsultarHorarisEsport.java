package Domini.Transaccions.Horaris;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Interval;

import Communicacio.Dades.InfoHorari;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Esports.FactoriaEsports;
import Factories.FactoriaControladors;

public class TrConsultarHorarisEsport {
	
	private String esport;
	private Interval interval;
	private int nsoci;
	
	private Set<InfoHorari> result;
	public TrConsultarHorarisEsport(String esport,Interval interval,int nsoci){
		this.esport = esport;
		this.interval = interval;	
		this.nsoci = nsoci;
	}
	public void Executar() throws Exception{
		result = new HashSet<>();
		Set<Pista> pistes = FactoriaControladors.getInstance().getCtrlPista().getAll();
		Soci s = FactoriaControladors.getInstance().getCtrlSoci().get(nsoci);
		for (Pista p:pistes){
			if (FactoriaEsports.getInstance().getEsport(esport).PistaEsEsport(p)){
				result.add(p.ObtenirInfo(interval,s));		
			}
		}
	}
	
	public Set<InfoHorari> getResult(){
		return result;
	}

}
