package com.example.cooksys.project_management.controllers.advice;

import com.example.cooksys.project_management.dtos.ErrorDto;
import com.example.cooksys.project_management.exceptions.BadRequestException;
import com.example.cooksys.project_management.exceptions.NotAuthorizedException;
import com.example.cooksys.project_management.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice(basePackages = {"com.cooksys.social_media.controllers"})
@ResponseBody
public class ControllerAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorDto handleBadRequestException(BadRequestException badReq, HttpServletRequest request){
        return new ErrorDto(badReq.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDto handleNotFoundException(HttpServletRequest request, NotFoundException exception){
        return new ErrorDto(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(NotAuthorizedException.class)
    public ErrorDto handleNotAuthorizedException(HttpServletRequest request, NotFoundException exception){
        return new ErrorDto(exception.getMessage());
    }

}
