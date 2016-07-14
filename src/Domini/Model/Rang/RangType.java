package Domini.Model.Rang;

public enum RangType {
	SuperAdmin
	{
		@Override
		public Rang toRang() {
			return FactoriaRangs.getInstance().getSuperadmin();
		}
	}	,
 	Admin
	 {
			@Override
			public Rang toRang() {
				return FactoriaRangs.getInstance().getAdmin();
			}
		}	
	,Monitor
	{
		@Override
		public Rang toRang() {
			return FactoriaRangs.getInstance().getMonitor();
		}
	}	
	,Normal
	{
		@Override
		public Rang toRang() {
			return FactoriaRangs.getInstance().getNormal();
		}
	};
	
	public abstract Rang toRang();
}
