package com.cooksys.project_manager.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@AllArgsConstructor
@Getter
@Setter
public class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -5937169122436346472L;

    private String message;
}
