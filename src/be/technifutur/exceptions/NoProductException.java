package be.technifutur.exceptions;

public class NoProductException extends  RuntimeException {

    public NoProductException() {
        super("No products.");
    }
}
