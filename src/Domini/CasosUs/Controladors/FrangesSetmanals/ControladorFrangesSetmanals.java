package Domini.CasosUs.Controladors.FrangesSetmanals;

import java.util.Set;

import Communicacio.Dades.InfoDiaSetmana;
import Communicacio.Dades.InfoFranjaSetmanal;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Actors.Actor;
import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Descriptors.editorFrangesSetmanals.CasUsFrangesSetmanals;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.Excepcions.ActorInvalid;
import Domini.Model.Calendaris.CalendariSetmanal;
import Domini.Model.Calendaris.FranjaSetmanal;
import Factories.FactoriaControladors;

public class ControladorFrangesSetmanals extends ControladorCasUs implements IControladorFrangesSetmanals{

	
	protected int IDCalendariSetmanal;
	
	public ControladorFrangesSetmanals(Actor actor,int IDCalendariSetmanal) throws ActorInvalid{
		this.IDCalendariSetmanal = IDCalendariSetmanal;
	}
	@Override
	public ResultatCasUs FerCasDUs(CasUs cu) throws Exception {
		CasUsFrangesSetmanals cuf = cu.toFrangesSetmanals();
		cuf.cridarControlador(this);
		//TODO CREATE RESULTAT AND RETURN IT
		return null;
	}
	
	
	protected CalendariSetmanal get() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlCalendariSetmanal().get(this.IDCalendariSetmanal);
	}
	
	protected void update(CalendariSetmanal c) throws BDExcepcio{
		FactoriaControladors.getInstance().getCtrlCalendariSetmanal().Update(c);
	}

	public void Insert(InfoDiaSetmana info) throws Exception{
		CalendariSetmanal c = get();
		FranjaSetmanal f = crearFranja();
		f.populate(info);
		c.add(f);
		update(c);
	}

	public void Update(InfoFranjaSetmanal info) throws Exception{
		CalendariSetmanal c = get();
		c.UpdateFranjaSetmanal(info);
		update(c);
	}
	
	public void Delete(int IDFranja) throws Exception{
		CalendariSetmanal c = get();
		c.Delete(IDFranja);
	}
	
	protected FranjaSetmanal crearFranja(){
		return new FranjaSetmanal();
	}
	@Override
	public Set<InfoFranjaSetmanal> getAll() throws Exception {
		CalendariSetmanal c = this.get();
		return c.getFrangesInfo();
	}
	@Override
	public InfoFranjaSetmanal get(int id) throws Exception {
		return this.get().buscarFranja(id);
	}
	


}
