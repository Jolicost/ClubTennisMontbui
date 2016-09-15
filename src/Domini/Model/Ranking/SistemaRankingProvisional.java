package Domini.Model.Ranking;

import java.util.HashSet;
import java.util.Set;

public class SistemaRankingProvisional implements SistemaRanking {

	private static int[] socis_masc = {
			2,
			7,
			21,
			48,
			303,
			491,
			505,
			512,
			524,
			525,
			545,
			558,
			599,
			611,
			630,
	};
	
	private static int[] socis_fem = {
			22,
			280,
			537,
			546,
			555,
			589,
			612,
	};
	
	private Set<Integer> socis_ranking;
	
	public SistemaRankingProvisional(){
		socis_ranking = new HashSet<>();
		for (int i : socis_masc) socis_ranking.add(i);
		for (int j : socis_fem) socis_ranking.add(j);
	}
	@Override
	public Set<Integer> getSocisRanking() {
		return socis_ranking;
	}

}
