package config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by Habib, on 19/11/2020
 */

//ControllerAdvice run whole of my project
@ControllerAdvice
public class RequestExceptionHandling {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleApiRequestException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), new Date(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_GATEWAY);
    }


    class ErrorMessage {

        private String message;
        private Date errorTime;
        private String httpStatusValue;

        ErrorMessage(String message, Date errorTime, String httpStatusValue) {
            this.message = message;
            this.errorTime = errorTime;
            this.httpStatusValue=httpStatusValue;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Date getErrorTime() {
            return errorTime;
        }

        public void setErrorTime(Date errorTime) {
            this.errorTime = errorTime;
        }

        public String getHttpStatusValue() {
            return httpStatusValue;
        }

        public void setHttpStatusValue(String httpStatusValue) {
            this.httpStatusValue = httpStatusValue;
        }
    }
}
