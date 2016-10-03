package Domini.Model.Reserves.Tipus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Communicacio.Dades.Reserves.InfoOcupacio;
import Communicacio.Excepcions.EntitatInvalida;
import Domini.Model.Reserves.Ocupacio;

public class FactoriaTipusOcupacio {
	private static FactoriaTipusOcupacio instance = new FactoriaTipusOcupacio();
	
	private Map<String,TipusOcupacio> tipus;
	
	private TipusOcupacio cursets = new OcupacioCursets();
	private TipusOcupacio manteniment = new OcupacioManteniment();
	private TipusOcupacio altres = new OcupacioAltres();
	
	public FactoriaTipusOcupacio(){
		tipus = new HashMap<>();
		Init();
	}
	
	private void Init(){
		tipus.put(cursets.getNom(), cursets);
		tipus.put(manteniment.getNom(), manteniment);
		tipus.put(altres.getNom(), altres);
	}
	
	public TipusOcupacio get(String nom) throws EntitatInvalida{
		if (tipus.containsKey(nom)){
			return tipus.get(nom);
		}
		else throw new EntitatInvalida();
	}
	public Ocupacio getOcupacio(String nom) throws EntitatInvalida{
		return get(nom).getTipusOcupacio();
	}
	
	public InfoOcupacio createInfo(String nom) throws EntitatInvalida{
		return get(nom).getInfoOcupacio();
	}
	
	public String getAltres(){return altres.getNom();}
	public String getCursets(){return cursets.getNom();}
	public String getManteniment(){return manteniment.getNom();}
	
	public Set<String> getAll(){
		Set<String> ret = new HashSet<>();
		tipus.values().forEach(v -> ret.add(v.getNom()));
		return ret;
	}
	
	public Map<String,TipusOcupacio> getAllTipus(){
		return tipus;
	}

	public static FactoriaTipusOcupacio getInstance() {
		return instance;
	}
}
