package Domini.CasosUs.Gestors.Pistes;

import java.io.Serializable;

import Communicacio.Dades.Info;
import Communicacio.Descriptors.FactoriaDescriptors;
import Communicacio.Excepcions.GestorInvalid;
import Communicacio.Xarxa.Domini.Entitats.Entitat;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Gestor;
import Domini.CasosUs.Gestors.Franges.GestorOcupacionsPista;
import Domini.Model.Pista;
import Factories.FactoriaControladors;

public class GestorPistaUpdate extends GestorPista {

	
	private int id;
	public GestorPistaUpdate(int id) {
		super();
		this.id = id;
	}
	
	private Pista get() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlPista().get(id);
	}

	@Override
	public void Update(Info i) throws Exception {
		Pista p = get();
		p.Populate(i.toInfoPista());
		FactoriaControladors.getInstance().getCtrlPista().Update(p);
	}

	@Override
	public void Delete() throws Exception {
		//FactoriaControladors.getInstance().getCtrlPista();
	}

	@Override
	public Info Get() throws Exception {
		return get().toInfo();
	}

	@Override
	public void Submit(Info i) throws Exception {
		Update(i);
	}

	@Override
	public Gestor getIndividualSelector(String entitat) throws Exception {
		return new SelectorCalendariPista(this.id);
	}

	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getUpdate();
	}

	@Override
	public Gestor getCollectionManager(String entitat) throws Exception {
		Entitat e = FactoriaEntitats.getInstance().getEntitat(entitat);
		
		if (e.getEntitat().equals(FactoriaEntitats.getInstance().getOcupacio())){
			return new GestorOcupacionsPista(this.id);
		}
		else{
			throw new GestorInvalid();
		}
	}

	@Override
	public Serializable getKey() throws GestorInvalid {
		return id;
	}
	
	


	

}
