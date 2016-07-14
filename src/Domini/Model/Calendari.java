package Domini.Model;




import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.joda.time.Interval;
import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoCalendari;
import Communicacio.Dades.InfoObertura;
import Dades.Excepcions.NoExisteix;
import Domini.Excepcions.PistaTancada;

public class Calendari {
	
	private int id;
	private String nom;
	private Map<LocalDate,Interval> obertura;

	public Calendari(){
		obertura = new HashMap<>();
	}
	public Interval ObtenirOpertura(LocalDate dia) throws PistaTancada {
		if (obertura.containsKey(dia)) return obertura.get(dia);
		else throw new PistaTancada();
	}
	public Set<Interval> ObtenirObertures(){
		return (Set<Interval>) obertura.values();
	}
	
	public Info getInfoObertura(LocalDate dia) throws NoExisteix{
		if (obertura.containsKey(dia)) {
			InfoObertura ret = new InfoObertura();
			ret.setDia(dia);
			ret.setInterval(obertura.get(dia));
			return ret;
		}
		else throw new NoExisteix();
	}
	
	public Set<Interval> getOberturesDies(Interval dies){
		Set<Interval> obertures = new HashSet<>();
		LocalDate inici = dies.getStart().toLocalDate();
		LocalDate fi = dies.getEnd().toLocalDate();
		while (!inici.isAfter(fi)){
			if (this.obertura.containsKey(inici)){
				obertures.add(this.obertura.get(inici));
			}
			inici = inici.plusDays(1);
		}
		return obertures;
	}
	
	public void BorrarObertura(LocalDate dia){
		if (obertura.containsKey(dia)) obertura.remove(dia);
	}
	public void AfegirObertura(LocalDate dia,Interval i){
		obertura.put(dia, i);
	}
	public Set<Info> getInfoObertures(){
		Set<Info> ret = new HashSet<>();
		for (LocalDate d: obertura.keySet()){
			InfoObertura io = new InfoObertura();
			io.setDia(d);
			io.setInterval(obertura.get(d));
			ret.add(io);
		}
		return ret;
	}
	
	public void SetHorariObertura(LocalDate dia,Interval i){
		obertura.put(dia, i);
	}

	public void AfegirHoraris(Map<LocalDate, Interval> horaris){
		this.obertura.putAll(horaris);
	}

	public void setHorarisObertura(Map<LocalDate, Interval> horaris) {
		this.obertura = horaris;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<LocalDate, Interval> getObertura() {
		return obertura;
	}
	public void setObertura(Map<LocalDate, Interval> obertura) {
		this.obertura = obertura;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Info toInfo(){
		InfoCalendari ret = new InfoCalendari();
		ret.setId(this.getId());
		ret.setNom(this.getNom());
		return ret;
	}

	public void Populate(InfoCalendari ic){
		this.setNom(ic.getNom());
	}
	
}
