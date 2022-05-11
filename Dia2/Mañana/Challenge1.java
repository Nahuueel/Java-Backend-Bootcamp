import java.util.Scanner;
public class Challenge1 {

    public static void main(String[] args) {

    Scanner userI = new Scanner(System.in);
    int choice, a, b, result;

    System.out.println("Ingrese la operacion que desea realizar:");
    System.out.println("1) Restar");
    System.out.println("2) Sumar");
    System.out.println("3) Multiplicar");
    System.out.println("4) Dividir");

    choice = userI.nextInt();

    switch(choice){
        case 1:
            System.out.println("Ingrese dos numeros a restar");
            a = userI.nextInt();
            b = userI.nextInt();
            result = a - b;
            System.out.println("La suma de los dos numeros es: "+result);
        break;

        case 2:
            System.out.println("Ingrese dos numeros a sumar");
            a = userI.nextInt();
            b = userI.nextInt();
            result = a + b;
            System.out.println("La suma de los dos numeros es: "+result);
        break;
        case 3:
            System.out.println("Ingrese dos numeros a multiplicar");
            a = userI.nextInt();
            b = userI.nextInt();
            result = a * b;
            System.out.println("La multiplicadion de los dos numeros es: "+result);
        break;
        case 4:
            System.out.println("Ingrese dos numeros a dividir (dividendo y divisor)");
            a = userI.nextInt();
            b = userI.nextInt();
            result = a/b;
            System.out.println("La division de los dos numeros es: "+result);
        break;
        default:
            System.out.println("Ingrese una tecla valida");
    }

    }
}
