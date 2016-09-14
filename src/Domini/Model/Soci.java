package Domini.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;

import Communicacio.Dades.InfoSoci;
import Domini.Excepcions.NoPotReservar;
import Domini.Excepcions.SociNoTitular;
import Domini.Model.Quotes.Individual;
import Domini.Model.Quotes.Quota;
import Domini.Model.Quotes.Titular;
import Domini.Model.Reserves.ReservaSoci;

public class Soci implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private String dni;
	private String nom;
	private String cognoms;
	private String telefon;
	private String adreca;
	private LocalDate naixement;
	private LocalDate alta;
	protected Set<ReservaSoci> reserves;
	private Quota q;
	
	 
	public Soci(){
		
		reserves = new HashSet<>();
		q = new Individual();
		q.setPropietari(this);
	}

	public void afegirReserva(ReservaSoci r){
		reserves.add(r);
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Quota getQ() {
		return q;
	}
	public void setQ(Quota q) {
		this.q = q;
	}
	
	public String getCognoms() {
		return cognoms;
	}
	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}
	
	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public String getAdreca() {
		return adreca;
	}


	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}


	public LocalDate getNaixement() {
		return naixement;
	}


	public void setNaixement(LocalDate naixement) {
		this.naixement = naixement;
	}
	
	public InfoSoci toInfo(){
		InfoSoci ret = new InfoSoci();
		ret.setDni(this.getDni());
		ret.setNumero(this.getNumero());
		ret.setCognoms(this.getCognoms());
		ret.setNaixament(this.getNaixement());
		ret.setNom(this.getNom());
		ret.setCognoms(this.getCognoms());
		ret.setQuota(this.getQ().toString());
		ret.setTelefon(this.getTelefon());
		ret.setAdreca(this.getAdreca());
		return ret;
	}
	@Override
	public boolean equals(Object obj) {
		return numero == ((Soci)obj).numero;
	}
	@Override
	public String toString() {
		return String.valueOf(this.getNumero());
	}
	


	
	public void Populate(InfoSoci is){
		setNumero(is.getNumero());
		setNom(is.getNom());
		setCognoms(is.getCognoms());
		setDni(is.getDni());
		this.setTelefon(is.getTelefon());
		this.setAdreca(is.getAdreca());
		this.setNaixement(is.getNaixament());
	}

	public Set<ReservaSoci> getReservesCondicio(Predicate<ReservaSoci> cond) {
		Set<ReservaSoci> ret = new HashSet<>();
		for (ReservaSoci rs : this.q.ObtenirReserves()) {
			if (cond.test(rs)) {
				ret.add(rs);
			}
		}
		return ret;
	}
	
	public boolean ReservaExistix(Predicate<ReservaSoci> cond){
		for (ReservaSoci rs : this.q.ObtenirReserves()) if (cond.test(rs)) return true;
		return false;
	}
	
	public int getMaxReservesSetmana(){
		return q.getReservesSetmana();
	}
	public int getMaxInvitacionsMes(){
		return q.getInvitacionsMes();
	}

	public Set<ReservaSoci> getReserves() {
		return reserves;
	}

	public void setReserves(Set<ReservaSoci> reserves) {
		this.reserves = reserves;
	}

	public String getNomComplet() {
		return this.getNom() + " " + this.getCognoms();
	}
	
	public boolean MateixDni(String dni){
		return Utils.DniCheck.Check(this.dni, dni);
	}

	
	public boolean QuotaCompleix(Predicate<Quota> p){
		return p.test(this.q);
	}


	public boolean EsTitular(){
		Predicate<Quota> p = q ->q.EsTitular();
		return QuotaCompleix(p);
	}
	
	public Titular getTitular() throws SociNoTitular{
		return q.getTitular();
	}
	
	public Set<Soci> getMembres() throws SociNoTitular{
		return q.getMembres();
	}
	
	public void canviarQuota(Quota q){
		this.q = q;
		q.setPropietari(this);
	}

	public LocalDate getAlta() {
		return alta;
	}

	public void setAlta(LocalDate alta) {
		this.alta = alta;
	}
	
	public boolean JugaRanking(){
		return false;
	}
	
	
	
}
