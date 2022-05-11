public class Main {
    
    public static void main(String[] args) {
        Pokemon[] pokemones = new Pokemon[2];
        UserInterface menu = new UserInterface();
        Fight fight = new Fight();

        pokemones = menu.selectPokemon(pokemones);
        pokemones = fight.fightLogic(pokemones);
        fight.whoWinner(pokemones);
    }
}
