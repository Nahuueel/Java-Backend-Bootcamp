//package Dia3.tarde.Pokemon;

public class Pokemon{
    String name;
    protected int health, damage, defense;

    public int getDamage(){
        return this.damage;
    }

    public int getHealth(){
        return this.health;
    }

    public int getDefense(){
        return this.defense;
    }

    public String getName(){
        return this.name;
    }

    public void reciveDamage(int _atack){
        this.health =health - (_atack - defense);
    }
    
    public boolean isDead(){
        boolean answer = this.health <= 0 ? true : false; 
        return answer;
    }

    public double specialAtack(){
        return 0.0;
    }

}
