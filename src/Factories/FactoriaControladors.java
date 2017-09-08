package Factories;

import Dades.Controladors.BDAnticipada;
import Dades.Controladors.BDCalendari;
import Dades.Controladors.BDCalendariOcupacions;
import Dades.Controladors.BDCalendariSetmanal;
import Dades.Controladors.BDFranja;
import Dades.Controladors.BDNomesSocis;
import Dades.Controladors.BDOcupacio;
import Dades.Controladors.BDPista;
import Dades.Controladors.BDQuota;
import Dades.Controladors.BDReservaSoci;
import Dades.Controladors.BDSoci;
import Dades.Controladors.BDTennis;
import Dades.Controladors.BDUsuari;
import Dades.Controladors.BDUsuariSoci;
import Domini.InterficieBD.CtrlAnticipada;
import Domini.InterficieBD.CtrlCalendari;
import Domini.InterficieBD.CtrlCalendariOcupacions;
import Domini.InterficieBD.CtrlCalendariSetmanal;
import Domini.InterficieBD.CtrlFranja;
import Domini.InterficieBD.CtrlNomesSocis;
import Domini.InterficieBD.CtrlOcupacio;
import Domini.InterficieBD.CtrlPista;
import Domini.InterficieBD.CtrlQuota;
import Domini.InterficieBD.CtrlReservaSoci;
import Domini.InterficieBD.CtrlSoci;
import Domini.InterficieBD.CtrlTennis;
import Domini.InterficieBD.CtrlUsuari;
import Domini.InterficieBD.CtrlUsuariSoci;

public class FactoriaControladors {
	private static FactoriaControladors instance = new FactoriaControladors();
	public static FactoriaControladors getInstance(){return instance;}
	
	private CtrlPista p = new BDPista();
	private CtrlSoci s = new BDSoci();
	private CtrlReservaSoci rs = new BDReservaSoci();
	private CtrlTennis t = new BDTennis();
	private CtrlNomesSocis ns = new BDNomesSocis();
	private CtrlAnticipada an = new BDAnticipada();
	private CtrlOcupacio oc = new BDOcupacio();
	private CtrlFranja cf = new BDFranja();
	private CtrlUsuari cu = new BDUsuari();
	private CtrlCalendari cc = new BDCalendari();
	private CtrlUsuariSoci cus = new BDUsuariSoci();
	private CtrlQuota cq = new BDQuota();
	private CtrlCalendariSetmanal cs = new BDCalendariSetmanal();
	private CtrlCalendariOcupacions co = new BDCalendariOcupacions();
	
	public CtrlPista getCtrlPista(){return p;}
	public CtrlSoci getCtrlSoci(){return s;}
	public CtrlUsuari getCtrlUsuari(){return cu;}
	public CtrlReservaSoci getCtrlReservaSoci(){return rs;}
	public CtrlTennis getCtrlTennis(){return t;}
	public CtrlNomesSocis getCtrlNomesSocis(){return ns;}
	public CtrlAnticipada getCtrlAnticipada(){return an;}
	public CtrlOcupacio getCtrlOcupacio(){return oc;}
	public CtrlFranja getCtrlFranja(){return cf;}
	public CtrlCalendari getCtrlCalendari(){return cc;}
	public CtrlUsuariSoci getCtrlUsuariSoci(){return cus;}
	public CtrlQuota getCtrlQuota(){return cq;}
	public CtrlCalendariSetmanal getCtrlCalendariSetmanal(){return cs;}
	public CtrlCalendariOcupacions getCtrlCalendariOcupacions(){return co;}
}
