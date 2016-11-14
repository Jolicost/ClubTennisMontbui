package Mail.Informacio;

public class RecuperarContrasenyaMail extends InformacioMail{

	private String key;
	public RecuperarContrasenyaMail(String to,String key) {
		super(to);
		this.key = key;
	}
	
	private static final String subject = "Club Tennis Montbui: Recuperar Contrasenya";
	
	private static final String body = 
			"S'ha iniciat el procediment per recuperar la contrasenya " +
		    "del teu compte a la pagina de reserves del club tennis montbui: http://reserves.tennismontbui.net \n\n" +
		    "Per tal de completar el canvi de contrasenya, fes click sobre l'enllaç al final del correu, " +
		    "si no has demanat aquest canvi, no fagis res.\n\n" +
		    "Fes click sobre l'enllaç i canvia la teva contrasenya: ";

	@Override
	protected String getSubject() {
		return subject;
	}
	
	private String getPwdChangeUrl(){
		return "http://reserves.tennismontbui.net/CanviarContrasenya?id=" + key;
	}

	@Override
	protected String getMsg() {
		return body + getPwdChangeUrl();
	}

}
