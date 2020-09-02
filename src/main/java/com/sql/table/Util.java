package main.java.com.sql.table;


import java.util.List;
import java.util.Map;

import main.java.com.sql.column.Column;
import main.java.com.sql.column.ColumnType;
import main.java.com.sql.validators.IntegerValidator;
import main.java.com.sql.validators.StringValidator;

public class Util {

	public static boolean validateColumnConstraint(ColumnType ct, String val) {
		if(ct == ColumnType.STRING_TYPE) {
			StringValidator sv = new StringValidator();
			return sv.validate(val);
		} else if(ct == ColumnType.INT_TYPE) {
			IntegerValidator iv = new IntegerValidator();
			return iv.validate(val);
		}
		
		return false;
	}
	
	public static boolean validateMandatoryContraint(List<Column> column, Map<Column, String> columnValues) {
		for(Column col : column) {
			if(col.isMandatory() && columnValues.getOrDefault(col, null) != null)
				return false;
		}
		return true;
	}
	
}
