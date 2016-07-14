package Domini.Model;

import Communicacio.Dades.InfoUsuari;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Actors.Actor;
import Domini.CasosUs.Actors.Registrat;
import Domini.Model.Rang.FactoriaRangs;
import Domini.Model.Rang.Rang;
import Domini.Model.Rang.RangInvalid;
import Domini.Model.Rang.RangType;

public class Usuari {
	private String correu;
	private String pass;
	private String nom;
	private String cognoms;
	private String dni;
	private RangType rang;
	
	public Usuari(){}
	public Usuari(String correu, String pass) {
		super();
		this.correu = correu;
		this.pass = pass;
	}
	
	public String getCorreu() {
		return correu;
	}
	public void setCorreu(String correu) {
		this.correu = correu;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCognoms() {
		return cognoms;
	}
	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public RangType getRang() {
		return rang;
	}
	public void setRang(RangType rang) {
		this.rang = rang;
	}
	
	
	public void setRangOriginal(Rang rang){
		setRang(rang.toRangType());
	}
	
	public Rang getRangOriginal(){
		return getRang().toRang();
	}
	
	public InfoUsuari toInfo(){
		InfoUsuari ret = new InfoUsuari();
		ret.setEmail(this.correu);
		ret.setNom(this.nom);
		ret.setCognoms(this.getCognoms());
		ret.setDni(this.getDni());
		ret.setPassword(this.getPass());
		ret.setRang(this.getRang().toString());
		ret.setNsoci(null);
		return ret;
	}
	
	public void fillInfo(InfoUsuari u) throws RangInvalid{
		this.setCorreu(u.getEmail());
		this.setNom(u.getNom());
		this.setCognoms(u.getCognoms());
		this.setPass(u.getPassword());
		this.setDni(u.getDni());
		this.setRangOriginal(FactoriaRangs.getInstance().getRang(u.getRang()));
	}
	

	
	public boolean EsSoci(){return false;}
	public Soci getSoci(){return null;}
	public boolean EsAdmin(){return rang.toRang().EsAdmin();}
	public UsuariSoci toUsuariSoci(){return null;}
	
	public Actor crearActor() throws BDExcepcio{
		Registrat r = crearRegistrat();
		r.setCorreu(this.getCorreu());
		return r;
	}
	
	protected Registrat crearRegistrat() throws BDExcepcio{
		return new Domini.CasosUs.Actors.Usuari(this.correu);
	}
	
	
}
