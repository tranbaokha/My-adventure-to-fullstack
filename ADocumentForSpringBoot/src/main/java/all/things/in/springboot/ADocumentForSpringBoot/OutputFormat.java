package all.things.in.springboot.ADocumentForSpringBoot;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OutputFormat <T> {
	private int code;
	private String message;
	private List<T> data;
	public OutputFormat(int code, String message, List<T> set) {
		super();
		this.code = code;
		this.message = message;
		this.data = set;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> dataList) {
		this.data = dataList;
	}
	
}
