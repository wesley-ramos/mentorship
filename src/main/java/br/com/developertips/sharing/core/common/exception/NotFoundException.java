package br.com.developertips.sharing.core.common.exception;


public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 52595469979810252L;
    
    public NotFoundException(String message) {
        super(message);
    }
}
