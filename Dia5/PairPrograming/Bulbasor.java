public class Bulbasor extends Pokemon {
    public Bulbasor(){
        this.name = "Bulbasor";
        this.damage = 30.0;
        this.health = 125.0;
        this.defense = 45.0;
    };

    @Override
    public double Attack(int attackNumber){
        switch(attackNumber){
            case 1:
                return damage * 1.40; 
            case 2:
                return damage * 1.30;
            case 3:
                return damage * 1.25;
            default:
                return damage;
        }
    }

    @Override
    public String GetAtackName(int attackNumber){
        switch(attackNumber){
            case 1:
                return "Hojas Navaja"; 
            case 2:
                return "Cabezaso Hoja";
            case 3:
                return "Latigo Cepa";
            default:
                return "Ataque normal";
        }
    }

}
