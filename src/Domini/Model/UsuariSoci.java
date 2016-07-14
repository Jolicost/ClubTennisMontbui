package Domini.Model;

import Communicacio.Dades.InfoUsuari;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Actors.Registrat;

public class UsuariSoci extends Usuari {
	private Soci s;

	public UsuariSoci(){}
	public Soci getS() {
		return s;
	}
	
	
	public UsuariSoci(String correu, String pass) {
		super(correu,pass);
	}

	public void setS(Soci s) {
		this.s = s;
	}

	public UsuariSoci(Soci s) {
		super();
		this.s = s;
	}
	
	
	public InfoUsuari toInfo(){
		InfoUsuari ret = super.toInfo();
		ret.setNsoci(String.valueOf(this.s.getNumero()));
		return ret;
	}

	public boolean EsSoci(){return true;}
	public UsuariSoci toUsuariSoci(){return this;}
	public Soci getSoci(){return this.s;}
	
	protected Registrat crearRegistrat() throws BDExcepcio{
		 Domini.CasosUs.Actors.Soci ret = new Domini.CasosUs.Actors.Soci(this.getS().getNumero(),this.getCorreu());
		 return ret;
	}
	
}
