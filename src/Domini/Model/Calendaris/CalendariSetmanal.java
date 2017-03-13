package Domini.Model.Calendaris;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Interval;
import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoCalendariSetmanal;
import Communicacio.Dades.InfoFranjaSetmanal;
import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.EntitatInvalida;
import Domini.Model.Reserves.Franja;

public abstract class CalendariSetmanal {
	private int idCalendari;
	private String nom;
	protected Set<FranjaSetmanal> franges;
	public CalendariSetmanal(){
		franges = new HashSet<>();
	}
	public int getIdCalendari() {
		return idCalendari;
	}
	public void setIdCalendari(int idCalendari) {
		this.idCalendari = idCalendari;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<FranjaSetmanal> getFranges() {
		return franges;
	}
	public void setFranges(Set<FranjaSetmanal> franges) {
		this.franges = franges;
	}
	public Set<Interval> crearFranges(LocalDate dia){
		Set<Interval> ret = new HashSet<>();
		for (FranjaSetmanal f: this.franges){
			if (f.mateixDiaSetmana(dia)){
				ret.add(f.crearInterval(dia));
			}
		}
		return ret;
	}
	
	public Franja crearFranja() throws CalendariSetmanalInvalid,EntitatInvalida{
		throw new CalendariSetmanalInvalid();
	}
	public Info toInfo() {
		InfoCalendariSetmanal ret = crearInfo();
		ret.setId(this.idCalendari);
		ret.setNom(this.nom);
		ret.setFranges(crearInfoFranges());
		return ret;
	}
	
	protected Set<InfoFranjaSetmanal> crearInfoFranges(){
		Set<InfoFranjaSetmanal> ret = new HashSet<>();
		for (FranjaSetmanal fs : this.franges) ret.add(fs.toInfo());
		return ret;
	}
	protected abstract InfoCalendariSetmanal crearInfo();
	
	public void populate(InfoCalendariSetmanal info) throws DadaIncorrecta {
		if (info.getId() != 0) this.setIdCalendari(info.getId());
		if (info.getNom() != null) this.setNom(info.getNom());
	}
	public boolean add(FranjaSetmanal e) {
		return franges.add(e);
	}
	
	protected FranjaSetmanal find(int id) throws FranjaSetmanalNoExistent{
		for (FranjaSetmanal f: this.franges){
			if (f.getId() == id){
				return f;
			}
		}
		throw new FranjaSetmanalNoExistent();
	}

	public void UpdateFranjaSetmanal(InfoFranjaSetmanal i) throws FranjaSetmanalNoExistent, DadaIncorrecta{
		FranjaSetmanal f = find(i.getId());
		f.populate(i);
	}
	
	public void Delete(int idFranja) throws FranjaSetmanalNoExistent{
		this.franges.remove(find(idFranja));
	}
	
	public InfoFranjaSetmanal buscarFranja(int id) throws FranjaSetmanalNoExistent{
		return this.find(id).toInfo();
	}
	
	public Set<InfoFranjaSetmanal> getFrangesInfo(){
		Set<InfoFranjaSetmanal> ret = new HashSet<>();
		for (FranjaSetmanal f: this.franges){
			ret.add(f.toInfo());
		}		
		return ret;
	}
	

}
