//package Dia3.tarde.Pokemon;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner userI = new Scanner(System.in);
        Pokemon pokemones[] = new Pokemon[2];
    
        for(int i = 0; i <= 1; i++){
        boolean flag = true;
        while(flag){
            System.out.println("Elija pokemon"+(i+1)+":");
            System.out.println("1) Pikachu");
            System.out.println("2) Bulbasor");
            System.out.println("3) Charmander");

            int choice = userI.nextInt();
            switch(choice){
                case 1:
                    pokemones[i] = new Pikachu();
                    flag = false;
                break;
                case 2:
                    pokemones[i] = new Bulbasor();
                    flag = false;    
                break;
                case 3:
                    pokemones[i] = new Charmander();
                    flag = false;
                break;
                default:
                System.out.println("Ingrese una opcion correcta");
                }
            }
        }
        
        boolean flag = true;
        while(flag){
            
            for(int i = 0; i <= 1; i++){
                int e = i == 0 ? 1 : 0;
                
                if(pokemones[i].isDead()){
                    flag = false;
                    break;
                }

                System.out.println(pokemones[i].getName() + " ataca a "+ pokemones[e].getName());
                pokemones[e].reciveDamage(pokemones[i].getDamage());

                System.out.println(pokemones[i].getName() +" Puntos de vida: "+pokemones[i].getHealth());
                System.out.println(pokemones[e].getName() +" Puntos de vida: "+pokemones[e].getHealth());
                System.out.println("----------------------------------------------------------------------");
            } 
        }
    }
}
