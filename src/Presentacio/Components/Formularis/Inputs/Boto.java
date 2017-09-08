package Presentacio.Components.Formularis.Inputs;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.Components.SingleWebComponent;
import Presentacio.TagBuilder.ButtonTag;

public class Boto extends SingleWebComponent {

	protected String nom;
	private String id;
	public Boto(String nom){
		
		this.nom = nom;
	}
	
	public Boto(String nom,String id){
		this.nom = nom;
		this.id = id;
	}
	@Override
	protected void writeContent() throws IOException, ServletException {
		super.Append(nom);
	}

	protected ButtonTag getTag(){
		return new ButtonTag();
	}
	
	public void setID(String id){
		this.id = id;
	}
	public String getId(){return id;}

	@Override
	public void InitContent() {
		super.InitContent();
		super.addTag(getTag());
		super.getFirstTag().setId(id);
	}
}
