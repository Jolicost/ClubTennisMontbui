package Domini.Model.Reserves;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.ReadableInstant;

import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.Reserves.InfoFranja;
import Domini.Model.Pista;

public abstract class Franja {
	private int ID;
	private Interval lapse;
	private Pista pista;
	
	
	public Franja(){}
	public Franja(Interval lapse, Pista pista) {
		super();
		this.lapse = lapse;
		this.pista = pista;
	}
	
	public Interval getLapse() {
		return lapse;
	}
	public void setLapse(Interval lapse) {
		this.lapse = lapse;
	}
	public Pista getPista() {
		return pista;
	}
	public void setPista(Pista pista) {
		this.pista = pista;
	}
	

	
	public DateTime getInici(){
		return lapse.getStart();
	}
	
	
	public boolean EstaActiva(){
		return DateTime.now().isBefore(getFinal());
	}
	
	private DateTime getFinal() {
		return lapse.getEnd();
	}
	public boolean Intersecciona(Interval i){
		return lapse.overlaps(i);
	}
	
	public boolean EsFronto(){
		return pista.EsFronto();
	}
	public boolean EsTennis() {
		return pista.EsTennis();
	}
	
	public boolean EsOcupada(){
		return false;
	}
	public boolean EsLliure(){
		return false;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public boolean EsOcupacioClub(){
		return false;
	}

	
	

	public InfoFranja toInfo(){
		InfoFranja ret = crearInfo();
		ret.setInterval(lapse);
		ret.setIdFranja(ID);
		ret.setIdPista(pista.getIDPista());
		ret.setNomPista(pista.getNom());
		ret.setEsport(pista.getNomEsport());
		return ret;
	}
	
	protected abstract InfoFranja crearInfo();
}
