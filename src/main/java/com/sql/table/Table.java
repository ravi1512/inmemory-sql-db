package main.java.com.sql.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.com.sql.column.Column;
import main.java.com.sql.row.Row;


public class Table {
	private List<Row> rows;
	private List<Column> columns;
	private String name;
	
	public Table(String name, List<Column> columns) {
		this.name = name;
		this.columns = columns;
		rows = new ArrayList<Row>();
	}
	
	public void addRow(Map<Column, String> columnValues) {
		Boolean valid = Util.validateMandatoryContraint(columns, columnValues);
		if(!valid) {
			System.out.println("Error adding a new row. Check logs for more details");
			return;
		}
		Row newRow;
		try {
			newRow = new Row(columnValues);
			rows.add(newRow);
		} catch (Exception e) {
			System.out.println("Error adding a new row to table"+this.name);
			e.printStackTrace();
		}
	}
	
	public void printData() {
		for(Row row : rows) {
			System.out.println(row +"\n");
		}
	}
	
	public List<Column> getColumns(){
		return columns;
	}

}
