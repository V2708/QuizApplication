package com.quiz.utilities;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.quiz.exception.QuestionException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception ex,WebRequest request) {
//    	logger.error(ex.getMessage(),ex);
//    	ErrorInfo er=new ErrorInfo();
//    	er.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//    	er.setMessage(environment.getProperty("Genral_Exception","Error Occurred"));
//        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    
//    @ExceptionHandler(QuestionException.class)
//    public ResponseEntity<ErrorInfo> questionExceptionHandler(QuestionException ex,WebRequest request) {
//    	logger.error(ex.getMessage(),ex);
//    	ErrorInfo er=new ErrorInfo();
//    	er.setStatusCode(HttpStatus.BAD_REQUEST.value());
//    	er.setMessage(environment.getProperty(ex.getMessage(),"Error Occurred"));
//        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
//    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception ex, WebRequest request) {
	    logger.error(ex.getMessage(), ex);
	    ErrorInfo er = new ErrorInfo();
	    er.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    er.setMessage(environment.getProperty("General_Exception", "Error Occurred"));
	    return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(QuestionException.class)
	public ResponseEntity<ErrorInfo> questionExceptionHandler(QuestionException ex, WebRequest request) {
	    logger.error(ex.getMessage(), ex);
	    ErrorInfo er = new ErrorInfo();
	    er.setStatusCode(HttpStatus.BAD_REQUEST.value());
	    er.setMessage(environment.getProperty(ex.getMessage(), "Error Occurred"));
	    return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	}

	

    
}
