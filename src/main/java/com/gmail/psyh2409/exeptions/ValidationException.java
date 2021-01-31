package com.gmail.psyh2409.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ValidationException extends Exception {

    private final String message;
}
