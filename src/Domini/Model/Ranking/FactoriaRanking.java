package Domini.Model.Ranking;

import java.util.Set;

public class FactoriaRanking {
	private static FactoriaRanking instance = new FactoriaRanking();
	public static FactoriaRanking getInstance(){return instance;}
	
	private SistemaRanking sr = new SistemaRankingProvisional();
	
	public SistemaRanking getSistemaRanking(){return sr;}
	public Set<Integer> getSocisRanking(){return sr.getSocisRanking();}
}
