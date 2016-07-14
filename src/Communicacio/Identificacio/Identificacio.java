package Communicacio.Identificacio;

import Communicacio.Excepcions.Timeout;
import Domini.CasosUs.Actors.Invitat;
import Domini.CasosUs.Sessio.CasUsSessio;
import Presentacio.Vistes.Rols.Rol;
import Presentacio.Vistes.Rols.RolFactory;

public abstract class Identificacio {

	private Sessio s;
	
	public Identificacio(){
		s = new Sessio(new CasUsSessio(new Invitat()));
	}
	public abstract String getIdentificacio();
	
	public void setCasUs(CasUsSessio s){
		this.s = new Sessio(s);
	}
	
	public void Logout(){
		s = new Sessio(new CasUsSessio(new Invitat()));
	}
	
	public CasUsSessio getSessio(){
		try {
			return s.Request();
		} catch (Timeout e) {
			s = new Sessio(new CasUsSessio(new Invitat()));
			return s.getCasUs();
		}
	}
	
	public void Connection(){
		try{
			s.Connect();
		}catch (Timeout e){
			s = new Sessio(new CasUsSessio(new Invitat()));
		}
	}

	@Override
	public boolean equals(Object obj) {
		Identificacio id = (Identificacio) obj;
		return id.getIdentificacio().equals(this.getIdentificacio()) && id.getClass().equals(this.getClass());
	}
	
	private String ObtenirRol(){return s.getCasUs().ObtenirRol();}
	
	public Rol getRol(){
		return RolFactory.getInstance().get(ObtenirRol());
	}

}
