package tn.esprit.etude_de_cas.Exceptions;

public class BlocDejaReserveException extends RuntimeException{
    public  BlocDejaReserveException(){
        super("Le bloc a deja ete reservé pour un foyer");
    }

    public BlocDejaReserveException(String message){
        super(message);}
}
