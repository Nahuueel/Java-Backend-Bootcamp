package Tarde;

public class asafataIngles implements Mensaje {

    public asafataIngles(){};

    @Override
    public void mensajeBienvenida() {
        System.out.println("Welcome to British Air Lines");
    }

    @Override
    public void mensajeDespedida() {
        System.out.println("Thank you for choosing ur services!");
        
    }

    @Override
    public void mensajeGenerico() {
        System.out.println("Would you like a blanket or some peanuts?");
        
    }

    @Override
    public void mensajeRespuesta() {
        System.out.println("Okey");
    }
    
}
