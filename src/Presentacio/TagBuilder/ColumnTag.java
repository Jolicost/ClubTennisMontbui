package Presentacio.TagBuilder;

public abstract class ColumnTag extends CustomTag {
	
	private int prop;
	private int offset;
	
	public ColumnTag(int prop,int offset){
		this.prop = prop;
		this.offset = offset;
		InitTag();
	}
	
	public ColumnTag(int prop){
		this.prop = prop;
		this.offset = 0;
		InitTag();
	}
	
	protected void InitTag(){
		String proportion = "col-" + getColumnName();
		if (prop > 0) {
			proportion += "-" + prop;
			super.appendAttribute("class", proportion);
		}
		
		String offset = "col-" + getColumnName() + "-offset-";
		if (this.offset > 0) super.appendAttribute("class", offset + this.offset);
	}

	
	protected abstract String getColumnName();
	

}
