package main.java.com.sql.column;

public class Column {
	private String name;
	private ColumnType type;
	private String defaultValue;
	private boolean mandatory;
	
	public Column(String name, ColumnType type){
		this.name = name;
		this.type = type;
	}
	
	public Column(String name, ColumnType type, String defaultValue){
		this.name = name;
		this.type = type;
		this.defaultValue = defaultValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public ColumnType getType() {
		return type;
	}

	public void setType(ColumnType type) {
		this.type = type;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
