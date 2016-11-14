package Domini.MetaCasosUs.Recuperacio.Claus;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import Domini.MetaCasosUs.Recuperacio.Excepcions.ClauInexistent;
import Domini.MetaCasosUs.Recuperacio.Excepcions.ErrorGeneracioClau;
import Domini.MetaCasosUs.Recuperacio.Excepcions.ExcepcioRecuperacioContrasenya;

public class SistemaClaus implements ISistemaClausVolatils {

	private Map<String,String> keys;
	
	private static final int ExpirationTime = 5 * 60 * 1000;
	
	public SistemaClaus(){
		keys = new HashMap<>();
	}
	@Override
	public synchronized String RequestKey(String correu) throws ExcepcioRecuperacioContrasenya {
		String key = null;
		int i = 0;
		do{
			key = generateKey();
		} while (keys.containsKey(key) && ++i < 10);
		
		if (i == 10) throw new ErrorGeneracioClau();
		
		keys.put(key, correu);
		new Timer().schedule(new Expire(key),ExpirationTime);
		return key;
	}

	@Override
	public synchronized String getRequesterEmail(String key) throws ExcepcioRecuperacioContrasenya {
		if (keys.containsKey(key)) return keys.get(key);
		else throw new ClauInexistent();
	}
	
	private synchronized void KeyExpires(String key){
		keys.remove(key);
	}
	
	private String generateKey(){
		return new KeyGenerator().generate();
	}
	
	
	private class Expire extends TimerTask{

		private String key;
		public Expire(String key){this.key = key;}
		@Override
		public void run() {
			KeyExpires(key);
		}
		
	}


	@Override
	public void removeKey(String key) throws ExcepcioRecuperacioContrasenya {
		KeyExpires(key);
	}

}
