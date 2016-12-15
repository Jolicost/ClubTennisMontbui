package Domini.CasosUs.Controladors.Reserva;

import org.apache.commons.mail.EmailException;
import org.joda.time.Interval;

import Communicacio.Dades.InfoSoci;
import Communicacio.Dades.Reserves.InfoFranja;
import Communicacio.Dades.Reserves.Correus.InfoReservaRealitzada;
import Dades.Controladors.DTO.DTOPistaSoci;
import Dades.Excepcions.BDExcepcio;
import Domini.CasosUs.Resultats.Reserva.ResultatReservaConfirmada;
import Domini.Excepcions.NoPotReservar;
import Domini.Model.Pista;
import Domini.Model.Soci;
import Domini.Model.Reserves.Franja;
import Domini.Model.Transaccions.SocisQuotaSuperada.TrQuotaSuperadaNomesSocis;
import Domini.Transaccions.InsertarFranja.TrReserva;
import Factories.FactoriaControladors;
import Mail.Informacio.InformacioMail;
import Mail.Informacio.ReservaRealitzadaMail;

public abstract class ConfirmarReserva extends EstatFerReserva {

	public ConfirmarReserva() {
		super();
	}
	
	protected int IdPista;
	protected Interval i;
	
	protected Soci s;
	protected Pista p;
	
	public void Confirmar() throws NoPotReservar, BDExcepcio{
		DTOPistaSoci dto = new DTOPistaSoci(this.IdPista,this.soci);
		dto.executar();
		s = dto.getSoci();
		p = dto.getPista();
		
		TrReserva tr = crearTransaccio();
		tr.Executar();
		Franja f = tr.getResult();
		FactoriaControladors.getInstance().getCtrlFranja().Insert(f);
		
		try {
			EnviarMail(f);
		} catch (EmailException e) {
			e.printStackTrace();
		}
		super.resultat = new ResultatReservaConfirmada();
	}
	
	
	
	private void EnviarMail(Franja f) throws EmailException{
		InfoFranja i = f.toInfo();
		InfoSoci is = this.s.toInfo();
		InfoReservaRealitzada ir = new InfoReservaRealitzada(is,i);
		InformacioMail m = new ReservaRealitzadaMail(ir);
		m.Send();
	}
	


	public boolean TeSeguent(){
		return false;
	}
	
	protected Soci obtenirSoci() throws BDExcepcio{
		return s;
	}
	protected Pista getPista() throws BDExcepcio{
		return p;
	}
	protected abstract TrReserva crearTransaccio() throws BDExcepcio;

	public int getIdPista() {
		return IdPista;
	}

	public void setIdPista(int idPista) {
		IdPista = idPista;
	}

	public Interval getI() {
		return i;
	}

	public void setI(Interval i) {
		this.i = i;
	}

	public void setSoci(int soci) {
		this.soci = soci;
	}
}
