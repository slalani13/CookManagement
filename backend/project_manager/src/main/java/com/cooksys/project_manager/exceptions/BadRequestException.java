package com.cooksys.project_manager.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@AllArgsConstructor
@Getter
@Setter
public class BadRequestException extends RuntimeException{

    @Serial
    /* used opt enter to generate random value */
    private static final long serialVersionUID = 4457639202158807731L;

    private String message;

}
