package tn.esprit.etude_de_cas.Exceptions;

public class FoyerNotFoundException extends RuntimeException{
    public FoyerNotFoundException(){
        super("Foyer non trouvé");

    }
    public FoyerNotFoundException(String message){
        super(message);
    }
}
