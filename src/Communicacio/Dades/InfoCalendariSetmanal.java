package Communicacio.Dades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.EntitatInvalida;

public class InfoCalendariSetmanal extends Info{
	public int id;
	public String nom;
	private Set<InfoFranjaSetmanal> franges;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<InfoFranjaSetmanal> getFranges() {
		return franges;
	}

	public void setFranges(Set<InfoFranjaSetmanal> franges) {
		this.franges = franges;
	}
	
	public InfoCalendariSetmanal toInfoCalendariSetmanal() throws DadaIncorrecta {
		return this;
	}

	@Override
	public Info Populate(Map<String, String[]> params)
			throws IllegalArgumentException, IllegalAccessException, EntitatInvalida {
		if (params.containsKey("id")) this.setId(Integer.valueOf(params.get("id")[0]));
		if (params.containsKey("nom")) this.setNom(params.get("nom")[0]);
		return this;
	}
	
	public List<String> getAttributeNames(){
		List<String> ret = new ArrayList<>();
		ret.add("id");
		ret.add("nom");
		return ret;
	}
	
	public List<String> getAttributeValues(){
		List<String> ret = new ArrayList<>();
		ret.add(String.valueOf(this.getId()));
		ret.add(this.getNom());
		return ret;
	}
	

	
}
