package be.technifutur.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("[ERROR] Product not found.");
    }
}
