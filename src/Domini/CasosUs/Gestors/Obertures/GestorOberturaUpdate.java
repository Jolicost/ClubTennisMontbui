package Domini.CasosUs.Gestors.Obertures;

import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoObertura;
import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.Model.Calendari;
import Factories.FactoriaControladors;

public class GestorOberturaUpdate extends GestorObertura {

	protected LocalDate dia;
	
	public GestorOberturaUpdate(int idCalendari,LocalDate dia) {
		super(idCalendari);
		this.dia = dia;
	}
	
	@Override
	public void Update(Info i) throws Exception {
		InfoObertura io = i.toInfoObertura();
		Calendari c = getCalendari();
		c.BorrarObertura(dia);
		c.AfegirObertura(io.getDia(),io.getInterval());
		FactoriaControladors.getInstance().getCtrlCalendari().Update(c);
	}
	
	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getUpdate();
	}
	
	@Override
	public Info Get() throws Exception {
		return super.getCalendari().getInfoObertura(dia);
	}

	@Override
	public void Submit(Info i) throws Exception {
		Update(i);
	}



	
	
}
