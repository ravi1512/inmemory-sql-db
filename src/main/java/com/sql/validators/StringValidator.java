package main.java.com.sql.validators;

public class StringValidator extends AbstractColumnValidator{
	public boolean validate(String val) {
		if(val == null || val.length() >20)
			return false;
		return true;
	}
}
