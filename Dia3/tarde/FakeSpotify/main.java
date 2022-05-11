package Dia3.tarde.FakeSpotify;
import java.util.Scanner;

public class main {
    private static Object Default;

    public static void main(String[] args){
        Scanner userI = new Scanner(System.in);
        int choice;

        System.out.println("Bienvenidos a Esputifay ¿con que usuario desea logear?");
        System.out.println("1) Usuario estandard");
        System.out.println("2) Usuario premium");

        choice = userI.nextInt();
        
        switch(choice){
            case 1:
                UsuarioEstandar usuarioE = new UsuarioEstandar();
                usuarioE.escucharCancion("cancion estandard");
            break;
            case 2:
                UsuarioPremium usuarioP = new UsuarioPremium();
                usuarioP.escucharCancion("cancion premium");
            break;
            default:
                System.out.println("Presione una tecla correspondiente");
        }

        

    }
    
}
