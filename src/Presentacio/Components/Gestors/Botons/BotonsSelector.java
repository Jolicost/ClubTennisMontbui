package Presentacio.Components.Gestors.Botons;

import java.io.IOException;

import javax.servlet.ServletException;

import Presentacio.TagBuilder.RowTag;

public class BotonsSelector extends BotonsGestor {

	@Override
	protected void createComponents() {
		super.addTag(new RowTag());
		super.AddComponent(new BotoSeleccio());
	}

	@Override
	protected void IncludeMetadata() throws IOException, ServletException {
		super.IncludeFile("Components/Taules/BotonsSelector.jsp");
	}
}
