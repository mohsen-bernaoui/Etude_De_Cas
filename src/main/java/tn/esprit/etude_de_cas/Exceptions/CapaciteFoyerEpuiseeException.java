package tn.esprit.etude_de_cas.Exceptions;

public class CapaciteFoyerEpuiseeException extends RuntimeException{
    public CapaciteFoyerEpuiseeException() {
        super("La capacité du foyer est épuisée");
    }

    public CapaciteFoyerEpuiseeException(String message) {
        super(message);
    }
}
