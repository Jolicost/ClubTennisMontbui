package Presentacio.Components.Formularis.Inputs;

import Presentacio.TagBuilder.ButtonTag;
import Presentacio.TagBuilder.SubmitButtonTag;

public class BotoEnviar extends Boto{
	public BotoEnviar(String nom,String id) {
		super(nom,id);
	}

	protected ButtonTag getTag(){
		return new SubmitButtonTag();
	}
}
