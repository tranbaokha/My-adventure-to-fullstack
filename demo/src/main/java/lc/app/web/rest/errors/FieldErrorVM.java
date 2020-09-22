package lc.app.web.rest.errors;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FieldErrorVM implements Serializable {

    private static final long serialVersionUID = 1L;

    private  String objectName;

    private String field;

    private String message;

    public FieldErrorVM(String dto, String field, String message) {
        this.objectName = dto;
        this.field = field;
        this.message = message;
    }

    public FieldErrorVM(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

}
