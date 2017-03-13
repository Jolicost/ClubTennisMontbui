package Communicacio.Dades;

import java.util.List;
import java.util.Map;

import Communicacio.Excepcions.DadaIncorrecta;
import Communicacio.Excepcions.EntitatInvalida;

public class InfoCalendariOcupacions extends InfoCalendariSetmanal {

	public String tipus;

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	@Override
	public InfoCalendariOcupacions toInfoCalendariOcupacions() throws DadaIncorrecta {
		return this;
	}

	@Override
	public Info Populate(Map<String, String[]> params) throws IllegalArgumentException, IllegalAccessException, EntitatInvalida{
		super.Populate(params);
		if (params.containsKey("tipus")) this.setTipus(params.get("tipus")[0]);
		return this;
	}
	
	public List<String> getAttributeNames(){
		List<String> ret = super.getAttributeNames();
		ret.add("tipus");
		return ret;
	}
	
	public List<String> getAttributeValues(){
		List<String> ret = super.getAttributeValues();
		ret.add(this.getTipus());
		return ret;
	}
}
