package Presentacio.Components.Gestors.Botons;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.TagBuilder.RowTag;

public class BotonsCRUD extends BotonsGestor {



	@Override
	protected void createComponents() {
		super.setMainTag(new RowTag());
		super.AddComponent(new BotoEditar());
		super.AddComponent(new BotoEliminar());
		super.AddComponent(new BotoInsertar());
	}

	@Override
	protected void IncludeMetadata() throws IOException, ServletException {
		super.IncludeFile("Components/Taules/BotonsGestor.jsp");
	}

}
