package Domini.Model;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoHorari;
import Communicacio.Dades.InfoLapse;
import Communicacio.Dades.InfoPista;
import Communicacio.Dades.Reserves.InfoLliure;
import Domini.Excepcions.PistaTancada;
import Domini.Model.Reserves.Franja;
import Domini.Model.Restriccions.Filtre.FiltreRestriccions;
import Domini.Model.Restriccions.Pistes.IRestriccionsPistes;
import Utils.IntervalUtils;

public abstract class Pista {
	private int IDPista;
	private String nom;
	private Set<Franja> franges;
	private Calendari horari;
	
	public Pista(int iD, Set<Franja> franges, Calendari horari) {
		super();
		IDPista = iD;
		this.franges = franges;
		this.horari = horari;
	}
	public Pista(){
		franges = new HashSet<>();
		horari = new Calendari();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getIDPista() {
		return IDPista;
	}
	public void setIDPista(int iD) {
		IDPista = iD;
	}
	public Set<Franja> getFranges() {
		return franges;
	}
	public void setFranges(Set<Franja> franges) {
		this.franges = franges;
	}
	public Calendari getHorari() {
		return horari;
	}
	public void setHorari(Calendari horari) {
		this.horari = horari;
	}
	
	public Set<Franja> getOcupacions(){
		Set<Franja> ret = new HashSet<>();
		for (Franja f: franges) if (f.EsOcupada()) ret.add(f);
		return ret;
	}
	
	public Set<Franja> getOcupacionsClub(){
		Set<Franja> ret = new HashSet<>();
		for (Franja f: franges) if (f.EsOcupacioClub()) ret.add(f);
		return ret;
	}
	
	public Info toInfo(){
		InfoPista ret = new InfoPista();
		ret.setId(this.IDPista);
		ret.setNom(this.getNom());
		ret.setTipus(this.getTipus());
		if (getHorari() != null) ret.setCalendari(this.getHorari().getNom());
		return ret;
	}
	
	protected abstract String getTipus();
	
	public Interval ObtenirOpertura(LocalDate dia) throws PistaTancada{
		return horari.ObtenirOpertura(dia);
	}
	
	public Set<Franja> getFrangesOcupades(){
		Set<Franja> ret = new HashSet<>();
		for (Franja f : franges){
			if (f.EsOcupada()) ret.add(f);
		}
		return ret;
	}
	
	public Set<Franja> getFrangesLliures(){
		Set<Franja> ret = new HashSet<>();
		for (Franja f : franges){
			if (f.EsLliure()) ret.add(f);
		}
		return ret;
	}
	
	public Set<Interval> IntervalsFranges(){
		Set<Interval> ret = new HashSet<>();
		for (Franja j: franges) ret.add(j.getLapse());
		return ret;
	}
	
	public Set<Interval> IntervalsLliures(){
		Set<Interval> ret = new HashSet<>();
		for (Franja j: getFrangesLliures()) ret.add(j.getLapse());
		return ret;
	}
	
	public boolean EstaOcupada(Interval date){
		for (Franja i : getFrangesOcupades()) if (i.Intersecciona(date)) return true;
		return false;
	}
	

	public void AfegirFranja(Franja f){
		franges.add(f);
		f.setPista(this);
	}

	
	
	public InfoHorari ObtenirInfo(Interval i,Soci s){
		//Set<Interval> IntervalObert = horari.getOberturesDies(i);
		//Set<Interval> IntervalAssignat = IntervalUtils.Intersaction(IntervalObert, IntervalsFranges());
		//Set<Interval> IntervalDisponible = IntervalUtils.Difference(IntervalObert, IntervalsFranges());
		//Set<Interval> IntervalsDividits = IntervalUtils.Split(IntervalDisponible, getTempsReserva());
		
		Set<Interval> IntervalDisponible = new HashSet<>();
		Map<LocalDate,Interval> obertures_dies = horari.getObertura();
		
		Map<LocalDate,Set<Interval>> ocupacions_dies = IntervalUtils.SplitByDay(IntervalsFranges());

		for (LocalDate dia:obertures_dies.keySet()){
			Interval obert = obertures_dies.get(dia);
			if (i.overlaps(obert)){
				if (ocupacions_dies.containsKey(dia)){
					Set<Interval> ocupat = ocupacions_dies.get(dia);
					
					IntervalDisponible.addAll(IntervalUtils.Difference(obert,ocupat));
				}
				else{
					IntervalDisponible.add(obertures_dies.get(dia));
				}
			}
		}
		
		
		Set<Interval> IntervalsDividits = IntervalUtils.Split(IntervalDisponible, getTempsReserva());
		FiltreRestriccions f = new FiltreRestriccions(s,this, IntervalsDividits);
		f.Executar();
		IntervalsDividits = f.getResultat();
		
		SortedSet<InfoLapse> disponibilitat = new TreeSet<>();
		
		SortedSet<InfoLliure> InfoDisponibles = new TreeSet<>();
		

		for (Interval y: IntervalsDividits) InfoDisponibles.add(new InfoLliure(y));
		for (Interval y: IntervalsLliures()) InfoDisponibles.add(new InfoLliure(y));
		
		
		InfoHorari ret = new InfoHorari();
		ret.setIDPista(this.getIDPista());
		ret.setNomPista(this.getNom());
		
		disponibilitat.addAll(InfoDisponibles);
		//disponibilitat.addAll(getInfoOcupacions(i));

		ret.setDisponibilitats(disponibilitat);
		return ret;
	}
	
	protected abstract Duration getTempsReserva();
	public boolean EsFronto(){return false;}
	public boolean EsTennis(){return false;}
	
	public abstract IRestriccionsPistes getRestriccions();
	

	public void SetHorariObertura(LocalDate dia, Interval i) {
		horari.SetHorariObertura(dia, i);
	}
	public void AfegirHoraris(Map<LocalDate, Interval> horaris) {
		horari.AfegirHoraris(horaris);
	}
	
	public double getPreu(Duration dur){
		return getPreuPerHora() * (double) dur.getStandardMinutes() / 60;
	}
	
	protected abstract double getPreuPerHora();
	
	public void Populate(InfoPista p){
		this.setNom(p.getNom());
	}
	
	public abstract String getNomEsport();

	public Set<Franja> getFrangesCondicio(Predicate<Franja> p) {
		Set<Franja> ret = new HashSet<>();
		for (Franja f: this.franges){
			if (p.test(f)) ret.add(f);
		}
		return ret;
	}
	
	
}
