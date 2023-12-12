package tn.esprit.etude_de_cas.Exceptions;

public class BlocNotFoundException extends RuntimeException{
    public BlocNotFoundException() {
        super("Bloc non trouvé");
    }

    public BlocNotFoundException(String message) {
        super(message);
    }
}
