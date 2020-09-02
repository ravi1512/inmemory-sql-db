package main.java.com.sql.row;

import java.util.Map;

import main.java.com.sql.column.Column;
import main.java.com.sql.column.ColumnType;
import main.java.com.sql.table.Util;

public class Row {
	private Map<Column, String> columnNameToValueMap;
	
	public Row(Map<Column, String> columnValues) throws Exception {
		if(!verifyColumnValues(columnValues))
			throw new Exception("Invalid column values");
		this.columnNameToValueMap = columnValues;
	}
	
	public void setColumnValue(Column column, String val) {
		columnNameToValueMap.put(column, val);
	}
	
	 @Override
	 public String toString() { 
		StringBuilder sb = new StringBuilder("");
		for (Map.Entry<Column, String> entry : columnNameToValueMap.entrySet()) { 
			sb.append(entry.getKey().getName() + " --> "+ entry.getValue()+ "\n");
		}
		return sb.toString();
	 } 
	 
	 public boolean verifyColumnValues(Map<Column, String> columnValues) {
			for (Map.Entry<Column, String> entry : columnValues.entrySet()) { 
				ColumnType ct = entry.getKey().getType();
				Boolean valid = Util.validateColumnConstraint(ct, entry.getValue());
				if(!valid) {
					System.out.println("Invalid value for ColumnType "+ct+" Value: "+entry.getValue());
					return false;
				}
			}
			return true;
		}
	
	
}
