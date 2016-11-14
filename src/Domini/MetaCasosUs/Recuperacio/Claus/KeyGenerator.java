package Domini.MetaCasosUs.Recuperacio.Claus;

import java.math.BigInteger;
import java.security.SecureRandom;

public class KeyGenerator {
		private SecureRandom random = new SecureRandom();

		public KeyGenerator(){
			
		}
		
		public String generate() {
			return new BigInteger(130, random).toString(32);
		}
}
