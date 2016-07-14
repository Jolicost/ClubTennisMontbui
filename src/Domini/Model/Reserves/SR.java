package Domini.Model.Reserves;

import java.util.Set;

import Communicacio.Dades.Reserves.InfoReserva;
import Communicacio.Dades.Reserves.InfoReservaSoci;
import Communicacio.Dades.Reserves.InfoSenseReserva;
import Domini.Model.Soci;

public class SR extends NomesSocis {
	public SR(){
		
	}
	public SR(Soci propietari,Set<Soci> Jugadors){
		super(propietari,Jugadors);
	}
	
	@Override
	public boolean EsSenseReserva(){return true;}
	@Override
	protected String getTipus() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoSenseReserva();
	}
	
}
