package Domini.Transaccions.Assignacions;

import java.util.HashSet;
import java.util.Set;

import Communicacio.Dades.InfoUsuari;
import Dades.Excepcions.BDExcepcio;
import Domini.Model.Usuari;
import Factories.FactoriaControladors;

public class TrBuscarUsuari {

	private String query;
	
	private Set<InfoUsuari> result;
	
	private FactoriaCriteris criteris;
	public TrBuscarUsuari(String query){
		this.query = query;
		result = new HashSet<>();
		criteris = new FactoriaCriteris();
	}
	
	public Set<InfoUsuari> getResult(){return result;}
	
	public void Executar() throws BDExcepcio{
		Set<Usuari> usuaris = FactoriaControladors.getInstance().getCtrlUsuari().getAll();
		Set<Criteri> criteris = this.criteris.filtra(this.query);
		for (Usuari u: usuaris){
			for (Criteri c: criteris){
				if (c.cumpleix(u)) result.add(u.toInfo());
			}
		}
	}
	
	
	private class FactoriaCriteris{
		private Set<Criteri> criteris;
		public FactoriaCriteris(){
			criteris = new HashSet<>();
			InitCriteris();
		}
		
		private void InitCriteris(){
			criteris.add(new critNom());
			criteris.add(new critCorreu());
			criteris.add(new critDNI());
			criteris.add(new critNSoci());
		}
		public Set<Criteri> filtra(String query){
			Set<Criteri> ret = new HashSet<>();
			for (Criteri c: criteris) {
				c.setQuery(query);
				if (c.queryfits()) ret.add(c);
			}
			return ret;
		}
		
		public Set<Criteri> getAll(){return criteris;}
	}
	
	private abstract class Criteri{
		protected String query;
		public Criteri(){}
		public Criteri(String query){this.query = query;}
		public void setQuery(String query){this.query = query;}
		public boolean CumpleixCriteri(){
			if (query == null) return false;
			else return queryfits();
		}
		public Set<Usuari> Busca(Set<Usuari> in){
			Set<Usuari> ret = new HashSet<>();
			for (Usuari u:in){
				if (cumpleix(u)) ret.add(u);
			}
			return ret;
		}
		
		protected abstract boolean queryfits();
		protected abstract boolean cumpleix(Usuari u);
	}
	
	private abstract class critFrase extends Criteri{

		public critFrase(String query) {
			super(query);
		}
		public critFrase(){super();}
		
		@Override
		protected boolean cumpleix(Usuari u) {
			String frase = getFrase(u);
			if (frase == null) return false;
			else return frase.toLowerCase().contains(super.query.toLowerCase());
		}
		
		protected abstract String getFrase(Usuari u);
		
	}
	
	private abstract class critNumero extends Criteri{
		
	}
	
	private class critNom extends critFrase {

		public critNom(String query) {
			super(query);
		}
		public critNom() {
			super();
		}
		@Override
		protected String getFrase(Usuari u) {
			return u.getNom();
		}
		protected boolean queryfits(){
			return super.query.matches("[a-zA-Z]+");
		}
		
	}
	
	private class critCorreu extends critFrase{
		public critCorreu(String query) {
			super(query);
		}

		public critCorreu() {
			super();
		}

		@Override
		protected String getFrase(Usuari u) {
			return u.getCorreu();
		}

		@Override
		protected boolean queryfits() {
			return super.query.contains("@");
		}		
	}
	
	private class critDNI extends critFrase{
		public critDNI(String query) {
			super(query);
		}

		public critDNI() {
			super();
		}

		@Override
		protected String getFrase(Usuari u) {
			return u.getDni();
		}

		@Override
		protected boolean queryfits() {
			return super.query.matches("^[a-zA-Z0-9]*$");
		}		
	}
	
	private class critNSoci extends Criteri{
		public critNSoci(String query) {
			super(query);
		}

		public critNSoci() {
			super();
		}

		@Override
		protected boolean queryfits() {
			return super.query.matches("[0-9]+");
		}

		@Override
		protected boolean cumpleix(Usuari u) {
			if (u.EsSoci()){
				return String.valueOf(u.getSoci().getNumero()).contains(super.query);
			}
			else return false;
		}		
	}
	
	
	
	
	
	
	
	
	
}
