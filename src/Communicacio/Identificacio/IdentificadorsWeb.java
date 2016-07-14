package Communicacio.Identificacio;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;

public class IdentificadorsWeb {
	private static IdentificadorsWeb instance = new IdentificadorsWeb();
	public static IdentificadorsWeb getInstance(){return instance;}
	
	private Map<String,IdentificacioTomCat> ids;
	
	public IdentificadorsWeb(){ids = new HashMap<>();}
	
	public IdentificacioTomCat get(ServletRequest req){
		String sessionID = req.getRemoteAddr();
		if (ids.containsKey(sessionID)){
			return ids.get(sessionID);
		}
		else{
			IdentificacioTomCat t = new IdentificacioTomCat(req);
			ids.put(sessionID,t);
			return t;
		}
	}
	
}
