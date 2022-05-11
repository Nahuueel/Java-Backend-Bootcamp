package Tarde;

public class asafataAleman implements Mensaje {

    public asafataAleman(){}; 

    @Override
    public void mensajeBienvenida() {
        System.out.println("Willkommen bei Lufthansa");
        
    }

    @Override
    public void mensajeDespedida() {
        System.out.println("Vielen Dank, dass Sie sich für unseren Service entschieden haben!");
        
    }

    @Override
    public void mensajeGenerico() {
        System.out.println("Möchtest du eine Decke oder ein paar Erdnüsse?");
        
    }

    @Override
    public void mensajeRespuesta() {
        System.out.println("Okey");
    }
}
