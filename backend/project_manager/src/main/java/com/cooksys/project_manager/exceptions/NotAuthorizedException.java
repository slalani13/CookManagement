package com.cooksys.project_manager.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@AllArgsConstructor
@Getter
@Setter
public class NotAuthorizedException extends RuntimeException{

    @Serial
    /* used opt enter to generate random value */
    private static final long serialVersionUID = 6027453887427113694L;

    private String message;
}
