package Domini.MetaCasosUs.Accions;

public class AccionsVeureReserves extends GrupAccions {

	@Override
	protected void crearMenu() {
		menu.add(new AccioPropiesReserves());
		menu.add(new AccioFrangesPistes());
	}

	@Override
	public int getMinRang() {
		return 0;
	}

	@Override
	protected String getNomGrup() {
		return "Veure Reserves";
	}

}
