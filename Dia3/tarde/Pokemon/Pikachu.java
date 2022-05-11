//package Dia3.tarde.Pokemon;

public class Pikachu extends Pokemon {
    
    public Pikachu(){
        this.name = "Pikachu";
        this.damage=50;
        this.health=100;
        this.defense=25;
    }

    @Override
    public double specialAtack(){
        int randomAtack = ((int)(Math.random()*3+1));

        switch(randomAtack){
            case 1:
                return damage * 1.50; 
            break;
            case 2:
                return damage * 1.20;
            break;
            case 3:
                return damage * 1.15;
            break;
            default:
                return damage;
        }
    }
}
