package Communicacio.Dades.PujarSocis;

import java.util.Map;

import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Domini.CasosUs.Controladors.PujarSocis.SociNoIndividual;
import Domini.CasosUs.Controladors.PujarSocis.SociNoMembre;
import Domini.CasosUs.Controladors.PujarSocis.TitularNoTrobat;
import Domini.Excepcions.SociNoTitular;
import Domini.Model.Soci;
import Domini.Model.Quotes.Individual;
import Domini.Model.Quotes.Membre;
import Domini.Model.Quotes.Titular;

public class InfoPujarSoci extends Info{

	private int numero;
	private String nom;
	private String cognoms;
	private String dni;
	private LocalDate naixement;
	private LocalDate alta;
	private InfoQuota quota;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public LocalDate getNaixement() {
		return naixement;
	}
	public void setNaixement(LocalDate naixement) {
		this.naixement = naixement;
	}
	public LocalDate getAlta() {
		return alta;
	}
	public void setAlta(LocalDate alta) {
		this.alta = alta;
	}
	
	public boolean EsTitular(){
		return quota.EsTitular();
	}
	public boolean EsIndividual() {
		return quota.EsIndividual();
	}
	public boolean EsMembre() {
		return quota.EsMembre();
	}
	public Titular crearTitular() throws SociNoTitular {
		return quota.crearTitular();
	}
	
	public Membre crearMembre(Map<Integer,Titular> titulars) throws SociNoMembre,TitularNoTrobat, SociNoTitular{
		return quota.crearMembre(titulars);
	}
	
	public Soci crearSoci(){
		Soci s = new Soci();
		s.setNumero(this.getNumero());
		s.setNom(this.getNom());
		s.setCognoms(this.getCognoms());
		s.setDni(this.getDni());
		s.setNaixement(this.getNaixement());
		s.setAlta(this.getAlta());
		return s;
	}
	public Individual crearIndividual() throws SociNoIndividual {
		return quota.crearIndividual();
	}
	public InfoQuota getQuota() {
		return quota;
	}
	public void setQuota(InfoQuota quota) {
		this.quota = quota;
	}

}
