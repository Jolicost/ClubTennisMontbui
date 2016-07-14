package Presentacio.Vistes.Rols;

public class RolFactory {
	private static RolFactory instance = new RolFactory();
	public static RolFactory getInstance(){return instance;}
	
	private Admin ad = new Admin();
	private Invitat in = new Invitat();
	private Soci so = new Soci();
	private Usuari us = new Usuari();
	
	private Rol[] rols = {ad,in,so,us};

	
	public Rol get(String rolName){
		if (rolName == null) return in;
		for (Rol r: rols){
			if (r.Matches(rolName)) return r;
		}
		return in;
	}
}
