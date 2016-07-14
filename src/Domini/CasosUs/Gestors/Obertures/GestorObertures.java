package Domini.CasosUs.Gestors.Obertures;

import java.io.Serializable;
import java.util.Set;

import org.joda.time.LocalDate;

import Communicacio.Dades.Info;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.Model.Calendari;
import Factories.FactoriaControladors;

public class GestorObertures extends GestorColectiu {

	private int idCalendari;
	public GestorObertures(int idCalendari){
		this.idCalendari = idCalendari;
	}
	@Override
	public Set<Info> getAll() throws Exception {
		return getCalendari().getInfoObertures();
	}
	
	protected void updateCalendari(Calendari c) throws BDExcepcio{
		FactoriaControladors.getInstance().getCtrlCalendari().Update(c);
	}
	
	protected Calendari getCalendari() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlCalendari().get(idCalendari);
	}
	
	protected LocalDate toLocalDate(Serializable id) throws Exception{
		return LocalDate.parse(id.toString());
	}

	@Override
	public void Delete(Serializable id) throws Exception {
		Calendari c = getCalendari();
		c.getObertura().remove(toLocalDate(id));
		FactoriaControladors.getInstance().getCtrlCalendari().Update(c);	
	}

	@Override
	public Gestor getIndividualUpdater(Serializable id) throws Exception {
		return new GestorOberturaUpdate(this.idCalendari,LocalDate.parse(id.toString()));
	}

	@Override
	public Gestor getIndividualInserter() throws Exception {
		return new GestorOberturaInsert(this.idCalendari);
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getObertura();
	}

}
