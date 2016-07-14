package Communicacio.Dades.Accions;

import java.util.List;

public class InfoAccioGrup extends InfoAccio {

	private List<InfoAccio> grup;

	public List<InfoAccio> getGrup() {
		return grup;
	}

	public void setGrup(List<InfoAccio> grup) {
		this.grup = grup;
	}
	
	public boolean EsGrup(){
		return true;
	}

	@Override
	public List<InfoAccio> getAccions() {
		return grup;
	}


}
