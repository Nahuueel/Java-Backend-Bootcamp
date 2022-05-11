public class Pokemon{
    protected String name;
    protected double health, damage, defense;

    public double getDamage(){
        return this.damage;
    }

    public double getHealth(){
        return this.health;
    }

    public double getDefense(){
        return this.defense;
    }

    public String getName(){
        return this.name;
    }

    public void reciveDamage(Double _atack){
        this.health = health - (_atack - defense);
    }
    
    public boolean isDead(){
        boolean answer = this.health <= 0 ? true : false; 
        return answer;
    }

    public double Attack(int attackNumber){
        return 0.0;
    }

    public String GetAtackName(int attackNumber){
        return "";
    }

}
