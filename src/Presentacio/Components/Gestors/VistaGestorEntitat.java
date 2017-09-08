package Presentacio.Components.Gestors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;

import Communicacio.Dades.Info;
import Presentacio.Components.MultipleWebComponent;
import Presentacio.Components.Gestors.Botons.BotonsGestor;
import Presentacio.Components.Gestors.Taules.Taula;
import Presentacio.TagBuilder.TagFactory;

public abstract class VistaGestorEntitat extends MultipleWebComponent{

	
	public VistaGestorEntitat(){
		this.setMainTag(TagFactory.getInstance().getContainerTag());
	}
	@Override
	protected void createComponents() {
		super.AddComponent(getBotons());
		
		Set<Info> resultat = (Set<Info>) super.io.getParam("taula");
		
		List<String> header = new ArrayList<>();
		if (resultat.iterator().hasNext()) {
			Info i = resultat.iterator().next();
			header = i.getAttributeNames();
		}
		
		Set<List<String>> content = new HashSet<>();
		for (Info i : resultat){
			content.add(i.getAttributeValues());
		}
		super.AddComponent(new Taula(header, content));
	}
	@Override
	protected void IncludeMetadata() throws IOException, ServletException {
		super.IncludeFile(getTableFile());
	}
	
	protected String getTableFile(){
		return "Components/Taules/GestorEntitat.jsp";
	}

	protected abstract BotonsGestor getBotons();
}
