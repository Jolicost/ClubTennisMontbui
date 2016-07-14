package Domini.Model.Esports;

import java.util.HashMap;
import java.util.Map;

import Domini.Model.Pista;

public class FactoriaEsports {
	private static FactoriaEsports instance = new FactoriaEsports();
	public static FactoriaEsports getInstance(){return instance;}
	
	private IEsport fronto = new EFronto();
	private IEsport tennis = new ETennis();
	
	private Map<String,IEsport> esports;
	
	public FactoriaEsports(){
		esports = new HashMap<>();
		esports.put(fronto.getNomEsport(), fronto);
		esports.put(tennis.getNomEsport(), tennis);
	}
	
	public IEsport getEsport(String esport) throws EsportInvalid{
		if (esports.containsKey(esport)) return esports.get(esport);
		else throw new EsportInvalid();
	}
	
	public boolean PistaEsEsport(Pista p,String esport) throws EsportInvalid{
		return getEsport(esport).PistaEsEsport(p);
	}

	public String getFrontennis() {
		return fronto.getNomEsport();
	}

	public String getTennis() {
		return tennis.getNomEsport();
	}
}
