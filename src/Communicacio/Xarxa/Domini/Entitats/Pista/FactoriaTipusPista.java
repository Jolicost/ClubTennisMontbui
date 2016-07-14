package Communicacio.Xarxa.Domini.Entitats.Pista;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Domini.Model.Pista;

public class FactoriaTipusPista {
	private static FactoriaTipusPista instance = new FactoriaTipusPista();
	public static FactoriaTipusPista getInstance(){return instance;}
	
	private EntitatTipusPista tennis = new EntitatTennis();
	private EntitatTipusPista frontennis = new EntitatFrontennis();
	private Map<String,EntitatTipusPista> values;
	public FactoriaTipusPista(){
		values = new HashMap<>();
		values.put(tennis.getNomPista(), tennis);
		values.put(frontennis.getNomPista(), frontennis);
	}
	public EntitatTipusPista getEntitat(String nom){
		return values.get(nom);
	}
	
	public Pista crearPista(String tipus){
		return getEntitat(tipus).crearPista();
	}
	
	public Set<String> getAllTipus(){
		return values.keySet();
	}
}
