package Mail.Informacio;

public class ComptaCreadaMail extends InformacioMail{

	public ComptaCreadaMail(String to) {
		super(to);
	}

	@Override
	protected String getSubject() {
		return "Registre de compte al club tennis montbui";
	}

	@Override
	protected String getMsg() {
		return "benvingut al club tennis montbui!";
	}

}
