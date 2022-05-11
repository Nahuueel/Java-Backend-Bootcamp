import java.util.Scanner;

public class UserInterface{

    public UserInterface(){};

    public Pokemon[] selectPokemon(Pokemon[] pokemones){
        Scanner userI = new Scanner(System.in);
        
        for(int i = 0; i <= 1; i++){
            boolean flag = true;
            while(flag){
                System.out.println("Elija pokemon "+(i+1)+":");
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
            return pokemones;
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        public void printCombatNotification(Pokemon[] pokemones, int randomNumber, int i, int e){

            System.out.println(pokemones[i].getName() + " ataca a "+ pokemones[e].getName());
            System.out.println(pokemones[i].GetAtackName(randomNumber));
            System.out.println(pokemones[i].getName() +" Puntos de vida: "+(int)pokemones[i].getHealth());
            System.out.println(pokemones[e].getName() +" Puntos de vida: "+(int)pokemones[e].getHealth());
            System.out.println("----------------------------------------------------------------------");
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        public void showWinner(Pokemon pokemon){
            System.out.println(pokemon.getName() +" Es el Ganador!");
        }
    
}
