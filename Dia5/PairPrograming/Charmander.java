public class Charmander extends Pokemon {
   
    public Charmander(){
        this.name = "Charmander";
        this.damage = 75.0;
        this.health = 175.0;
        this.defense = 15.0;
    };
    
    @Override
    public double Attack(int attackNumber){
        switch(attackNumber){
            case 1:
                return damage * 1.70; 
            case 2:
                return damage * 1.10;
            case 3:
                return damage * 1.05;
            default:
                return damage;
        }
    }

    @Override
    public String GetAtackName(int attackNumber){
        switch(attackNumber){
            case 1:
                return "Lanzallamas"; 
            case 2:
                return "Ascuas";
            case 3:
                return "Arañaso";
            default:
                return "Ataque normal";
        }
    }

}
