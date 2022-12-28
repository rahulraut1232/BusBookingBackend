package com.app.global_exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_excs.BookingHandlingException;
import com.app.custom_excs.BusHandlingException;
import com.app.custom_excs.MailHandlingException;
import com.app.custom_excs.StationHandlingException;
import com.app.dto.ErrorDTO;

//global exception handler for exceptions in backend

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	exceptions which are not handled by any class are handled in this handler
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDTO> handleException(Exception e) {
		e.printStackTrace();
		System.out.println("in handle any exception "+e.getCause());
		return new ResponseEntity<>(new ErrorDTO("Server side error !!!!", e.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	Bus related exceptions handler
	@ExceptionHandler(BusHandlingException.class)
	   public ResponseEntity<ErrorDTO> handleBusHandlingException(BusHandlingException e){
	       System.out.println("in handle bus exception");
	       return new ResponseEntity<>(new ErrorDTO("Server side error !!!!", e.getMessage()), HttpStatus.BAD_REQUEST);
	   }
	
//	Station related exceptions handler
	@ExceptionHandler(StationHandlingException.class)
	public ResponseEntity<ErrorDTO> handleStationHandlingException(StationHandlingException e) {
		System.out.println("in handle any exception "+e.getCause());
		return new ResponseEntity<>(new ErrorDTO("Server side error !!!!", e.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	Booking related exceptions handler
	@ExceptionHandler(BookingHandlingException.class)
	public ResponseEntity<ErrorDTO> handleBookingHandlingException(BookingHandlingException e){
		System.out.println("in handle bus exception");
		return new ResponseEntity<>(new ErrorDTO("Server side error !!!!", e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
//	send mail related exceptions handler
	@ExceptionHandler(MailHandlingException.class)
	public ResponseEntity<ErrorDTO> handleMailHandlingException(MailHandlingException e){
		System.out.println("in handle bus exception");
		return new ResponseEntity<>(new ErrorDTO("Server side error !!!!", e.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
