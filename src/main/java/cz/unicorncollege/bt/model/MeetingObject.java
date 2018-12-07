package cz.unicorncollege.bt.model;

import java.util.List;

public abstract class MeetingObject {
	protected String name;	
	protected String code;	
	protected String description;

	protected StringBuilder toCsv(StringBuilder builder){
		return builder.append(System.getProperty("line.separator"))
				.append(name)
				.append(",")
				.append(code)
				.append(",")
				.append(description);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
