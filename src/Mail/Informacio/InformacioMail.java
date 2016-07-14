package Mail.Informacio;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public abstract class InformacioMail {
	private static String hostname = "smtp.gmail.com";
	private static int smtport = 587;
	protected static String acc = "reserves.tennis.montbui@gmail.com";
	private static String pass = "ctmontbui08710";
	private static String nom = "Reserves Club Tennis Montbui";
	
	
	protected String to;
	
	
	public InformacioMail(String to){
		this.to = to;
	}
	
	public void Send() throws EmailException{
		Email email = createEmail();
		email.setHostName(hostname);
		email.setSmtpPort(smtport);
		email.setSSLOnConnect(true);
		email.setAuthenticator(new DefaultAuthenticator(acc,pass));
		email.setFrom(acc,nom);
		email.setSubject(getSubject());
		email.setMsg(getMsg());
		email.addTo(to);
		Thread t = new Thread(new Missatger(email));
		t.start();
	}
	
	
	protected Email createEmail(){
		return new SimpleEmail();
	}
	
	protected abstract String getSubject();
	protected abstract String getMsg();
	
	
	private class Missatger implements Runnable{

		public Email mail;
		public Missatger(Email mail){
			this.mail = mail;
		}
		@Override
		public void run() {
			try {
				mail.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
		
	}
}
