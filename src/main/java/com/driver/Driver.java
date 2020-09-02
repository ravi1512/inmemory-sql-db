package main.java.com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.sql.column.Column;
import main.java.com.sql.column.ColumnType;
import main.java.com.sql.table.Table;

public class Driver {	
	public static void main(String args[]) {
		checkSQLQueries();
	}
	
	private static void checkSQLQueries() {
		Table tab = createTable("name_table");
		populateTable(tab, 5);
		tab.printData();
	}
	
	private static Table createTable(String tableName) {
		List<Column> cols = new ArrayList<>();
		Column nameCol = new Column("name", ColumnType.STRING_TYPE);
		Column numCol = new Column("number", ColumnType.INT_TYPE);
		
		cols.add(nameCol);
		cols.add(numCol);
		
		Table newTable = new Table(tableName, cols);	
		return newTable;
	}
	
	private static void populateTable(Table tab, int entries) {
		int val = 1000;
		for(int i=0; i < entries; i++) {
			Map<Column, String> columnValues = new HashMap<>();
			for(Column col : tab.getColumns()) {
				if(col.getName().equals("name"))
					columnValues.put(col, "ravi"+i);
				else
					columnValues.put(col, String.valueOf(val + i));
			}
			tab.addRow(columnValues);
		}		
	}
	
	
}
