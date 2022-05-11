package Tarde;

public class asafataEspaniol implements Mensaje{

    public asafataEspaniol(){};

    @Override
    public void mensajeBienvenida() {
        System.out.println("Bienvenido a Aerolinas Argentinas");
        
    }

    @Override
    public void mensajeDespedida() {
        System.out.println("Gracias por elegir nuestro servicio!");
        
    }

    @Override
    public void mensajeGenerico() {
        System.out.println("Le gustaría una manta o algunos manies?");
        
    }

    @Override
    public void mensajeRespuesta() {
        System.out.println("Okey");
    }
    
}
