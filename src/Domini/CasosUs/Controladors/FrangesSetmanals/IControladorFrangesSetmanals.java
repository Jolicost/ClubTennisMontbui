package Domini.CasosUs.Controladors.FrangesSetmanals;

import java.util.Set;

import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoFranjaSetmanal;

public interface IControladorFrangesSetmanals {
	public void Insert(InfoDiaSetmana info) throws Exception;

	public void Update(InfoFranjaSetmanal info) throws Exception;
	
	public void Delete(int IDFranja) throws Exception;
	
	public Set<InfoFranjaSetmanal> getAll() throws Exception;
	
	public InfoFranjaSetmanal get(int id) throws Exception;
}
