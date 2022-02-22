package br.com.developertips.sharing.core.common.exception;


public class AlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 7743037328574438446L;
    
    public AlreadyExistException(String message) {
        super(message);
    }
}
