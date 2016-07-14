package Communicacio.Xarxa.Domini.Entitats;

import Communicacio.Dades.Info;
import Communicacio.Dades.InfoUsuari;
import Communicacio.Excepcions.NoTeGestor;
import Domini.CasosUs.Gestors.GestorColectiu;
import Domini.CasosUs.Gestors.Usuaris.GestorUsuaris;
import Presentacio.Components.Gestors.VistaCRUDUsuaris;
import Presentacio.Components.Gestors.VistaGestorEntitat;
import Presentacio.Components.Gestors.VistaGestorIndividual;
import Presentacio.Components.Gestors.VistaInsertIndividual;
import Presentacio.Components.Gestors.VistaSelectEntitat;
import Presentacio.Components.Gestors.Usuari.VistaGestorUsuari;
import Presentacio.Components.Gestors.Usuari.VistaInsertUsuari;

public class EntitatUsuari extends Entitat {

	@Override
	public String getEntitat() {
		return "usuari";
	}
	

	
	public boolean esUsuari(){return true;}


	@Override
	public VistaGestorEntitat getGestorEntitat() {
		return new VistaCRUDUsuaris();
	}



	@Override
	public GestorColectiu getGestor()throws NoTeGestor {
		return new GestorUsuaris();
	}



	@Override
	public VistaSelectEntitat getSelectorEntitat() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Info getInfo() {
		return new InfoUsuari();
	}



	@Override
	public VistaGestorIndividual getGestorIndividual() {
		return new VistaGestorUsuari();
	}



	@Override
	public VistaInsertIndividual getInsertIndividual() {
		return new VistaInsertUsuari();
	}
	
}



