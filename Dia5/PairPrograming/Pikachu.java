public class Pikachu extends Pokemon {
    public Pikachu(){
        this.name = "Pikachu";
        this.damage=50.0;
        this.health=100.0;
        this.defense=25.0;
    }

    @Override
    public double Attack(int attackNumber){
        switch(attackNumber){
            case 1:
                return damage * 1.50; 
            case 2:
                return damage * 1.20;
            case 3:
                return damage * 1.15;
            default:
                return damage;
        }
    }

    @Override
    public String GetAtackName(int attackNumber){
        switch(attackNumber){
            case 1:
                return "Impactrueno"; 
            case 2:
                return "Cabezaso electrico";
            case 3:
                return "Cola Ferreo";
            default:
                return "Ataque normal";
        }
    }

}
