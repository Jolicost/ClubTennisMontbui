package Communicacio.Identificacio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class IdentificadorsWeb {
	private static IdentificadorsWeb instance = new IdentificadorsWeb();
	public static IdentificadorsWeb getInstance(){return instance;}
	private static final int time = 1000 * 3600;
	
	private Map<String,IdentificacioTomCat> ids;
	private Timer t;
	
	public IdentificadorsWeb(){
		ids = new HashMap<>();
		t = new Timer();
		t.schedule(new Timeout(),time);
	}
	
	public synchronized IdentificacioTomCat get(ServletRequest req){
		HttpServletRequest r = (HttpServletRequest) req;
		String sessionID = createId(r);
		if (ids.containsKey(sessionID)){
			return ids.get(sessionID);
		}
		else{
			IdentificacioTomCat t = new IdentificacioTomCat(sessionID);
			ids.put(sessionID,t);
			return t;
		}
	}
	
	
	private synchronized String createId(HttpServletRequest req){
		return req.getSession(true).getId();
	}
	
	private synchronized void Purge(){
		Iterator<String> it = ids.keySet().iterator();
		
		while(it.hasNext()){
			String s = it.next();
			if (ids.get(s).Expirada()){
				it.remove();
			}
		}

		t.schedule(new Timeout(),time);
		
	}
	
	private class Timeout extends TimerTask{

		@Override
		public void run() {
			Purge();
		}
		
		
	}
	
}
