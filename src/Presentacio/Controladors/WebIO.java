package Presentacio.Controladors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Communicacio.Identificacio.IdentificacioTomCat;
import Communicacio.Xarxa.FactoriaXarxa;
import Communicacio.Xarxa.Domini.Entitats.Entitat;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Vistes.Rols.Rol;

public class WebIO {
	
	private IdentificacioTomCat id;
	private List<String> errors;
	private List<String> success;
	private Map<String,Object> params;
	
	public WebIO(){
		params = new HashMap<>();
		errors = new LinkedList<>();
		success = new LinkedList<>();
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public List<String> getErrors(){return errors;}



	public Rol getRol(){return id.getRol();}
	
	public void AddError(String error){
		this.errors.add(error);
	}
	
	public void AddSuccess(String success){
		this.success.add(success);
	}
	
	public void setParam(String id,Object o){
		params.put(id, o);
	}
	
	public ResultatCasUs ferCasUs(CasUs cu) throws Exception{
		return FactoriaXarxa.getInstance().getControladorWeb().FerCasDUsIndividual(this.id, cu);
	}
	

	
	public boolean HasErrors(){return errors.size() > 0;}
	public IdentificacioTomCat getId() {
		return id;
	}
	public void setId(IdentificacioTomCat id) {
		this.id = id;
	}

	public List<String> getSuccess() {
		return this.success;
	}
}
