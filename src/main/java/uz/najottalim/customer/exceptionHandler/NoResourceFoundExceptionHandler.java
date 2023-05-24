package uz.najottalim.customer.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.najottalim.customer.dto.ErrorDTO;
import uz.najottalim.customer.exceptions.NoResourceFoundException;

@ControllerAdvice
public class NoResourceFoundExceptionHandler{
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> noResourceFoundExceptionHandler(NoResourceFoundException ex) {
        return ResponseEntity.badRequest().body(ErrorDTO.builder().errors(ex.getMessage()).build());
    }
}
