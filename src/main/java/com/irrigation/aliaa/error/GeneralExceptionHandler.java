package com.irrigation.aliaa.error;

import java.util.Optional;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.irrigation.aliaa.dto.ResponseModel;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {


	  @Override
	  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

	    ResponseModel errorResponse = new ResponseModel();
	    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
	    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());
	    errorResponse.setDescription(e.getMessage());

	    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	  }

	  @Override
	  protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);

	  }

	  @Override
	  protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException e, HttpHeaders headers,
	      HttpStatus status, WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

	    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException e, HttpHeaders headers,
	      HttpStatus status, WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException e, HttpHeaders headers, HttpStatus status,
	      WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

	    StringBuilder stringBuilder = new StringBuilder();
	    for (org.springframework.validation.FieldError fieldError : e.getBindingResult().getFieldErrors()) {
	      stringBuilder.append(fieldError.getDefaultMessage()).append(", ");
	    }
	    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
	    
	    ResponseModel errorResponse = new ResponseModel();
	    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
	    errorResponse.setDescription(stringBuilder.toString());
	    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

	    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	  
	    ResponseModel errorResponse = new ResponseModel();
	    errorResponse.setEcode(HttpStatus.METHOD_NOT_ALLOWED.name());
	    errorResponse.setDescription(e.getMessage());
	    errorResponse.setMessage(HttpStatus.METHOD_NOT_ALLOWED.name());

	    return new ResponseEntity<Object>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	  }

	  @Override
	  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }

	  @Override
	  protected ResponseEntity<Object> handleBindException(BindException e, HttpHeaders headers, HttpStatus status,
	      WebRequest request) {
		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.BAD_REQUEST.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.BAD_REQUEST.name());

		    return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	  }


	  @ExceptionHandler(BusinessException.class)
	  @ResponseBody
	  public ResponseEntity<ResponseModel> handleBusinessException(BusinessException e, WebRequest request) {
		  log.error(e.getMessage(), e);
		   if (e.getExtraResponseData() != null && !e.getExtraResponseData().isEmpty()) {
			   ResponseModel errorResponse = new ResponseModel();
			      errorResponse.setAdditionalInfo(e.getExtraResponseData());
			      errorResponse.setDescription(e.getMessage());
			      errorResponse.setEcode(e.getEcode());
			      if (e.getHttpStatus() == null) {
			        errorResponse.setMessage(e.getMessage());
			        errorResponse.setEcode(HttpStatus.INTERNAL_SERVER_ERROR.name());
			        
			        return new ResponseEntity<ResponseModel>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
			      errorResponse.setEcode(e.getHttpStatus().name());
			      errorResponse.setMessage(e.getMessage());
			      return new ResponseEntity<ResponseModel>(errorResponse, e.getHttpStatus());
			    } else {
			    	ResponseModel errorResponse = new ResponseModel();
			      errorResponse.setDescription(e.getMessage());
			      errorResponse.setEcode(e.getEcode());
			      if (e.getHttpStatus() == null) {
			    	errorResponse.setMessage(e.getMessage());
			    	errorResponse.setEcode(HttpStatus.INTERNAL_SERVER_ERROR.name());
			        return new ResponseEntity<ResponseModel>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
			      errorResponse.setMessage(e.getMessage());
			      errorResponse.setEcode(e.getHttpStatus().name());
			      return new ResponseEntity<ResponseModel>(errorResponse, e.getHttpStatus());
			    }

	  }


	  @ExceptionHandler(Exception.class)
	  @ResponseBody
	  public ResponseEntity<ResponseModel> processRuntimeException(Exception e, WebRequest request) {
		log.error(e.getMessage(), e);
	    return Optional.of(e).map(o -> o.getCause()).filter(BusinessException.class::isInstance)
	        .map(BusinessException.class::cast).map(e1 -> this.handleBusinessException(e1, request))
	        .orElseGet(() -> {
	        	
	  	    ResponseModel errorResponse = new ResponseModel();
	  	    errorResponse.setEcode(HttpStatus.INTERNAL_SERVER_ERROR.name());
	  	    errorResponse.setDescription(e.getMessage());
	  	    errorResponse.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.name());
	  	      log.error(e.getMessage());
	          return new ResponseEntity<ResponseModel>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	        });
	  }

	  @ExceptionHandler(Throwable.class)
	  @ResponseBody
	  public ResponseEntity<ResponseModel> handle(Throwable e, WebRequest request) {
		  log.error(e.getMessage(), e);
		    ResponseModel errorResponse = new ResponseModel();
		    errorResponse.setEcode(HttpStatus.INTERNAL_SERVER_ERROR.name());
		    errorResponse.setDescription(e.getMessage());
		    errorResponse.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.name());
		    log.error(e.getMessage());
	        return new ResponseEntity<ResponseModel>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

}
