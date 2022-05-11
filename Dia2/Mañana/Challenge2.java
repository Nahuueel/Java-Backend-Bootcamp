import java.util.Scanner;
public class Challenge2 {
    public static void main(String[] args) {
        int[] arreglo = new int[10];
        Scanner userI = new Scanner(System.in);

        int mayor = 0;
        int menor = 1000000;

        for(int i = 0; i <10; i++){
        System.out.println("Ingrese un numero en la posicion "+ (i+1));
            arreglo[i] = userI.nextInt();
        }

        for(int i = 0; i<10; i++){
            if(arreglo[i]>mayor){
                mayor = arreglo[i];
            }else if(arreglo[i]<menor){
                menor = arreglo[i];
            }
        }
        System.out.println("El numero mayor es "+ mayor +" El menor es "+ menor);

        for(int i = 0; i<10; i++){
            for(int e = 0; e<10; e++){
                if(arreglo[i]>arreglo[e]){
                    int retorno = arreglo[i];
                    arreglo[i] = arreglo[e];
                    arreglo[e] = retorno;
                }
            }
        }

        System.out.println("Array de manera descendiente:");
        for(int i = 0; i<10; i++){
            System.out.println(arreglo[i]);
        }
        System.out.println("Array de manera ascendiente:");
        for(int i = 9; i>=0; i--){
            System.out.println(arreglo[i]);
        }

        System.out.println("Numeros pares: ");
        for(int i = 0; i<10; i++){
            if(arreglo[i]%2==0) System.out.println(arreglo[i]);
        }

        System.out.println("Numeros impares: ");
        for(int i = 0; i<10; i++){
            if(arreglo[i]%2!=0) System.out.println(arreglo[i]);
        }

    }
}
