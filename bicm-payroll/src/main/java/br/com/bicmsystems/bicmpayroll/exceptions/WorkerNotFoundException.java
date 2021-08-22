package br.com.bicmsystems.bicmpayroll.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Worker not found")
public class WorkerNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public WorkerNotFoundException(String message) {
        super(message);
    }

}
