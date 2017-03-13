package Presentacio.Components;

import java.io.IOException;
import javax.servlet.ServletException;

public abstract class RecursiveWebComponent extends MultipleWebComponent {

	public RecursiveWebComponent()
	{
		super();
	}
	@Override
	protected void writeContent()
			throws IOException, ServletException {
		super.getFirst().Include();
	}
	@Override
	protected void createComponents() throws Exception{
		super.AddComponent(createChild());
	}

	
	protected abstract WebComponent createChild() throws Exception;

}
