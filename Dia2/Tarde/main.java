package Tarde;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int eleccion;
        Scanner userI = new Scanner(System.in);
        boolean flag = true;

        while(flag){
        System.out.println("Eliga la aerolinea que desea utilizar");
        System.out.println("1)Lufthansa");
        System.out.println("2)British Airways");
        System.out.println("3)Aerolineas Argentinas");
        
        eleccion = userI.nextInt();
        switch(eleccion){
            case 1:
                asafataAleman Lufthansa = new asafataAleman(); 
                Lufthansa.mensajeBienvenida();
                Lufthansa.mensajeGenerico();
                Lufthansa.mensajeDespedida();
                flag = false;
            break;
            case 2:
                asafataIngles britishAirways = new asafataIngles();
                britishAirways.mensajeBienvenida();
                britishAirways.mensajeGenerico();
                britishAirways.mensajeDespedida();
                flag = false;
            break;
            case 3:
                asafataEspaniol aeroArgentinas = new asafataEspaniol();
                aeroArgentinas.mensajeBienvenida();
                aeroArgentinas.mensajeGenerico();
                aeroArgentinas.mensajeDespedida();
                flag = false;
            break;
            default:
                System.out.println("Ingrese una opcion valida");
            }
        }
    }
}
