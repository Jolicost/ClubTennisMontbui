package Seguretat.Requests;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import Communicacio.Identificacio.Identificacio;
import Domini.CasosUs.Descriptors.CasUs;

public class ControlRegistre {

	private Map<String,Integer> comptes;
	private static final int Llindar = 5;
	
	public ControlRegistre(){
		comptes = new HashMap<>();
	}
	
	public void Request(CasUs cu,Identificacio id) throws ExcepcioPeticio{
		if (cu.esRegistre()){
			if (Get(id.getIdentificacio()) > Llindar) throw new MassesComptes();
		}
	}
	
	private int Get(String id){
		if (comptes.containsKey(id)) return comptes.get(id);
		else return 0;
	}
	
	private void Add(String id){
		if (comptes.containsKey(id)){
			comptes.put(id, comptes.get(id) + 1);
		}
		else comptes.put(id, 1);
	}
	private class Refresh extends TimerTask{

		@Override
		public void run() {
			comptes.clear();
		}
		
	}
}
