package map.struct.MapStruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleFileUploadException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<ResponseMessage> handlerMaxSizeException(MaxUploadSizeExceededException exc){
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Can not upload"));
	}
	
}
