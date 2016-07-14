package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Dades.Excepcions.NoExisteix;
import Domini.Model.Usuari;
import Domini.Model.UsuariSoci;

public interface CtrlUsuariSoci {
	public UsuariSoci get(String correu) throws BDExcepcio;
	public void Insert(UsuariSoci u) throws BDExcepcio;
	public void Update(UsuariSoci u) throws BDExcepcio;
	public void Delete(String correu) throws BDExcepcio;
	public void Delete(UsuariSoci usuarisoci) throws BDExcepcio;
	public void Delete(Usuari u) throws BDExcepcio;
	public Set<UsuariSoci> getAll() throws BDExcepcio;

}
