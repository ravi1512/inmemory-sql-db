package main.java.com.sql.validators;

public class IntegerValidator extends AbstractColumnValidator{
	public boolean validate(String val) {
		if(val == null)
			return false;
		
		int integerVal;
		try {
			integerVal = Integer.parseInt(val);
			if(integerVal < -1024 || integerVal > 1024)
				return false;
		}catch (NumberFormatException e){
		   return false;
		}
		
		return true;
	}
}
