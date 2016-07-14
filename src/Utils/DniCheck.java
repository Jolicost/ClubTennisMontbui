package Utils;

public abstract class DniCheck {
	
	public static boolean Check(String dni1,String dni2){
		if (dni1 == null || dni2 == null) return false;
 		String num1 = dni1.replaceAll("\\D+",""); 
		String num2 = dni2.replaceAll("\\D+","");
		try{
			return Integer.parseInt(num1) == Integer.parseInt(num2);
		}
		catch (NumberFormatException e){
			return false;
		}
	}

}
