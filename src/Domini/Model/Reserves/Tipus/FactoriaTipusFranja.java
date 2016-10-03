package Domini.Model.Reserves.Tipus;

import java.util.HashMap;
import java.util.Map;

public class FactoriaTipusFranja {
	private static FactoriaTipusFranja instance = new FactoriaTipusFranja();
	public static FactoriaTipusFranja getInstance(){return instance;}

	private Map<String,TipusFranja> tipus;
	public FactoriaTipusFranja(){
		Map<String,TipusOcupacio> r = FactoriaTipusOcupacio.getInstance().getAllTipus();
		Map<String,TipusReserva> o = FactoriaTipusReserva.getInstance().getAllTipus();
		
		tipus = new HashMap<>();
		for (String s:r.keySet()) tipus.put(s, r.get(s));
		for (String s:o.keySet()) tipus.put(s, o.get(s));
		
		
	}
	public TipusFranja get(String nom) throws TipusReservaInvalid{
		if (tipus.containsKey(nom)){
			return tipus.get(nom);
		}
		else throw new TipusReservaInvalid();
	}
}
