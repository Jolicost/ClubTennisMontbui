package Communicacio.Identificacio;

import org.joda.time.DateTime;

import Communicacio.Excepcions.Timeout;
import Domini.CasosUs.Sessio.CasUsSessio;

public class Sessio {
	private CasUsSessio cu;
	private DateTime expiracio;
	
	public Sessio(CasUsSessio cu){
		this.cu = cu;
		expiracio = DateTime.now().plusMinutes(20);
	}
	public CasUsSessio getCasUs(){return cu;}
	public CasUsSessio Request() throws Timeout{
		return getCasUs();
	}

	public void Connect() throws Timeout{
		if (DateTime.now().isAfter(expiracio)){
			throw new Timeout();
		}
		else{
			expiracio = DateTime.now().plusMinutes(20);
		}	
	}
	
}
