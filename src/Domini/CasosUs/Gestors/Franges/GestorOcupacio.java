package Domini.CasosUs.Gestors.Franges;

import Communicacio.Dades.Info;
import Communicacio.Dades.Reserves.InfoOcupacio;
import Communicacio.Xarxa.Domini.Entitats.FactoriaEntitats;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Gestors.Accions.Accio;
import Domini.Model.Reserves.Franja;
import Domini.Model.Reserves.Ocupacio;
import Domini.Model.Reserves.Tipus.FactoriaTipusOcupacio;
import Factories.FactoriaControladors;

public class GestorOcupacio extends GestorFranja{

	public GestorOcupacio(Accio accio) {
		super(accio);
	}
	
	public GestorOcupacio(Accio accio,int IdOcupacio) {
		super(accio,IdOcupacio);	
	}

	protected Ocupacio getOcupacio() throws BDExcepcio{
		return FactoriaControladors.getInstance().getCtrlOcupacio().Get(super.idFranja);
	}

	@Override
	public String getEntitat() throws Exception {
		return FactoriaEntitats.getInstance().getOcupacio();
	}

	@Override
	public void Delete() throws Exception {
		
	}

	@Override
	protected Franja crearFranja(Info i) throws Exception {
		InfoOcupacio io = i.toInfoOcupacio();
		Ocupacio o = FactoriaTipusOcupacio.getInstance().getOcupacio(io.getTipus());
		o.Populate(io);
		return o;
	}

	@Override
	protected Franja editarFranja(Info i) throws Exception {
		InfoOcupacio io= i.toInfoOcupacio();
		Ocupacio o = this.getOcupacio();
		o.Populate(io);
		return o;
	}


}
