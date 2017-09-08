package Domini.Model.Reserves;

import Communicacio.Dades.Reserves.InfoReservaSoci;
import Communicacio.Dades.Reserves.InfoSenseReserva;
import Domini.Model.Soci;
import Domini.Model.Reserves.Tipus.FactoriaTipusReserva;

public class SR extends NomesSocis {
	public SR(){
		
	}
	public SR(Soci propietari){
		super(propietari);
	}
	
	@Override
	public boolean EsSenseReserva(){return true;}
	@Override
	public String getTipus() {
		return FactoriaTipusReserva.getInstance().getSenseReserva().getNom();
	}
	@Override
	protected InfoReservaSoci crearInfoReservaSoci() {
		return new InfoSenseReserva();
	}
	
}
