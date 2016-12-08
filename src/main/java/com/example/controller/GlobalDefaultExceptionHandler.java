package com.example.controller;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
@SuppressWarnings("serial")
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public String handlerWrongIdException() {
        return "error";
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ModelAndView wrongInputInformation(HttpMessageNotReadableException ex) {
        ModelAndView modelAndView = new ModelAndView("error1");
        modelAndView.addObject("error1", ex.getMessage());
        return modelAndView;
    }

}
