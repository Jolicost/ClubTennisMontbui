package Domini.CasosUs.Controladors.CanviContrasenya;

import Domini.CasosUs.Controladors.ControladorCasUs;
import Domini.CasosUs.Controladors.Reserva.EstatInvalid;
import Domini.CasosUs.Descriptors.CasUs;
import Domini.CasosUs.Resultats.ResultatCasUs;
import Domini.CasosUs.Resultats.Generals.ResultatCanviarContrasenya;
import Domini.CasosUs.Resultats.Generals.ResultatUnicSuccess;
import Domini.MetaCasosUs.Recuperacio.CasUsRecuperacio;
import Domini.MetaCasosUs.Recuperacio.TrCanviarContrasenya;

public class ControladorCanviContrasenya extends ControladorCasUs implements ICasUsRecuperacio{

	private EstatRecuperacio estat;
	
	public ControladorCanviContrasenya(){
		estat = new CanviantContrasenya();
	}
	@Override
	protected ResultatCasUs ferCasUs(CasUs cu) throws Exception {
		CasUsRecuperacio cur = cu.toRecuperacio();
		return cur.Accio(this);
	}
	@Override
	public ResultatCasUs CanviarContrasenya(String key) throws Exception {
		EstatRecuperacio next = estat.CanviarPass(key);
		ResultatCasUs ret = estat.getResult();
		estat = next;
		return ret;
	}
	@Override
	public ResultatCasUs Submit(String password) throws Exception {
		EstatRecuperacio next = estat.Submit(password);
		ResultatCasUs ret = estat.getResult();
		estat = next;
		return ret;
	}
	
	
	
	
	private abstract class EstatRecuperacio {
		protected ResultatCasUs resultat;
		
		public EstatRecuperacio Submit(String password) throws Exception{
			throw new EstatInvalid();
		}
		
		public EstatRecuperacio CanviarPass(String key) throws Exception{
			throw new EstatInvalid();
		}
		
		public ResultatCasUs getResult() throws Exception{
			throw new EstatInvalid();
		}
	}
	
	private class CanviantContrasenya extends EstatRecuperacio{

		
		public CanviantContrasenya(){

		}
		
		@Override
		public EstatRecuperacio CanviarPass(String key) throws Exception{
			resultat = new ResultatCanviarContrasenya();
			return new ContrasenyaEnviada(key);
		}
		

		public ResultatCasUs getResult() throws Exception{
			return new ResultatCanviarContrasenya();
		} 

		
	}
	
	private class ContrasenyaEnviada extends CanviantContrasenya{
		
		private String key;
		public ContrasenyaEnviada(String key) {
			this.key = key;
		}
		
		public EstatRecuperacio Submit(String password) throws Exception{
			TrCanviarContrasenya tr = new TrCanviarContrasenya(key,password);
			tr.Executar();
			super.resultat = new ResultatUnicSuccess("Contrasenya canviada satisfactoriament");
			return this;
		}

		public ResultatCasUs getResult() throws Exception{
			return resultat;
		}

	
	}

}
