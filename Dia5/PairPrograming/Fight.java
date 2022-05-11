public class Fight {

    public Fight(){};

/////////////////////////////////////////////////////////////////////////////////////////////

    public Pokemon[] fightLogic(Pokemon[] pokemones){
        boolean flag = true;
        int randomNumber;
        UserInterface interfaceUser = new UserInterface();

        while(flag){
            
            for(int i = 0; i <= 1; i++){
                int e = i == 0 ? 1 : 0;
                
                if(pokemones[i].isDead()){
                    flag = false;
                    break;
                }

                randomNumber = (int)(Math.random()*4+1);
                pokemones[e].reciveDamage(pokemones[i].Attack(randomNumber));
                interfaceUser.printCombatNotification(pokemones,randomNumber,i,e);
            } 
        }
        return pokemones;
    }

////////////////////////////////////////////////////////////////////////////////////////////////

    public void whoWinner(Pokemon[] pokemones){
        UserInterface ganador = new UserInterface();
        if(pokemones[0].getHealth() <= 0){
            ganador.showWinner(pokemones[1]);
        }else{
            ganador.showWinner(pokemones[0]);
        }
    }

}
