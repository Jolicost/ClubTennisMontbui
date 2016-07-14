package Presentacio.Controladors;

import java.util.List;

import Communicacio.Xarxa.FactoriaXarxa;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Presentacio.Vistes.Rols.Rol;

public interface IWebIO {

	public void setParam(String id,Object o);
	public Object getParam(String id);
	
	public Rol getRol();
	public List<String> getErrors();
	public List<String> getSuccess();
	
	public ResultatCasUs ferCasUs(CasUs cu) throws Exception;
}
