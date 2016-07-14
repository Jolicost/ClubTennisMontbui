package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoObertures;
import Communicacio.Excepcions.NoTeGestor;
import Communicacio.Xarxa.Domini.Entitats.Constructors.ConstructorEntitat;
import Communicacio.Xarxa.Domini.Entitats.Constructors.FactoriaConstructors;
import Domini.CasosUs.Gestors.GestorColectiu;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;

public class EntitatHoraris extends Entitat{

	@Override
	public String getEntitat() {
		return "horaris";
	}

	@Override
	public VistaGestorEntitat getGestorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GestorColectiu getGestor() throws NoTeGestor {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Info getInfo() {
		return new InfoObertures();
	}

	@Override
	public VistaGestorIndividual getGestorIndividual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VistaInsertIndividual getInsertIndividual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ConstructorEntitat getConstructor() {
		return FactoriaConstructors.getInstance().getJSON();
	}

}
