package all.things.in.springboot.ADocumentForSpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> notFoundExceptionHandler(Exception ex, WebRequest request){
		List<String> data = new ArrayList<String>();
		data.add(ex.getMessage());
		OutputFormat<String> handler = new OutputFormat<String>(404, "Not Found", data);
		return new ResponseEntity(handler, HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	        errors.add(error.getField() + ": " + error.getDefaultMessage());
	    }
	    OutputFormat<String> exceptionResponse = new OutputFormat<String>(400, "Fail", errors);
	    return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}	
