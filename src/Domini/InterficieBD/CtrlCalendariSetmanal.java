package Domini.InterficieBD;

import java.util.Set;

import Dades.Excepcions.BDExcepcio;
import Domini.Model.Calendaris.CalendariSetmanal;

public interface CtrlCalendariSetmanal {

	public CalendariSetmanal get(int id) throws BDExcepcio;
	public Set<CalendariSetmanal> getAll() throws BDExcepcio;
	public void Update(CalendariSetmanal c) throws BDExcepcio;
	public void Delete(CalendariSetmanal c) throws BDExcepcio;
	public void Insert(CalendariSetmanal c) throws BDExcepcio;
	public void Delete(int id) throws BDExcepcio;
	
}
