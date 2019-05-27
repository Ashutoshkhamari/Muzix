package com.stackroute.exceptions;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(trackAlreadyExistException.class)
    public TrackNotFoundException handleTrackAlreadyExistsException(trackAlreadyExistException trackAlreadyExistsException, final HttpServletRequest request)
    {
        TrackNotFoundException error = new TrackNotFoundException();
        error.setErrorMessage(trackAlreadyExistsException.getMessage());
        error.setRequestedURI(request.getRequestURI());
        return error;
    }

    @ExceptionHandler(TrackNotFoundException.class)
    public TrackNotFoundException handleTrackNotFoundException(TrackNotFoundException trackNotFoundException, final HttpServletRequest request)
    {

        TrackNotFoundException error = new TrackNotFoundException();
        error.setErrorMessage(trackNotFoundException.getMessage());
        error.setRequestedURI(request.getRequestURI());
        return error;

    }
}
