package Domini.CasosUs.Gestors.Obertures;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoObertura;
import Communicacio.Descriptors.FactoriaDescriptors;
import Domini.Model.Calendari;
import Factories.FactoriaControladors;

public class GestorOberturaInsert extends GestorObertura{

	public GestorOberturaInsert(int idCalendari) {
		super(idCalendari);
	}

	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getInsert();
	}
	
	public void Insert(Info i) throws Exception {
		InfoObertura io = i.toInfoObertura();
		Calendari c = getCalendari();
		c.getObertura().put(io.getDia(),io.getInterval());
		FactoriaControladors.getInstance().getCtrlCalendari().Update(c);
	}

	@Override
	public void Submit(Info i) throws Exception {
		Insert(i);
	}
	


}
