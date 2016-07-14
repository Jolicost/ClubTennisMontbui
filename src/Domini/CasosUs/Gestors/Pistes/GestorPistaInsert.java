package Domini.CasosUs.Gestors.Pistes;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoPista;
import Communicacio.Descriptors.FactoriaDescriptors;
import Communicacio.Xarxa.Domini.Entitats.Pista.FactoriaTipusPista;
import Domini.Model.Pista;
import Factories.FactoriaControladors;

public class GestorPistaInsert extends GestorPista {

	public GestorPistaInsert() {
		super();
	}


	public void Insert(Info i) throws Exception{
		InfoPista ip = i.toInfoPista();
		Pista p = FactoriaTipusPista.getInstance().crearPista(ip.getTipus());
		p.Populate(ip);
		FactoriaControladors.getInstance().getCtrlPista().Insert(p);	
	}

	@Override
	public void Submit(Info i) throws Exception {
		Insert(i);
	}

	public String getDescriptorGestor() throws Exception{
		return FactoriaDescriptors.getInstance().getInsert();
	}


	

}
