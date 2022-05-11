package Dia3.tarde.FakeSpotify;

public class Usuario {
    
    public void escucharCancion(String _cancion){
        System.out.println("Se esta reproduciendo "+ _cancion);
    }

    public void elegirCancion(){}

    public void siguienteCancion(){}

    public void anteriorCancion(){}

    public void pausar(){
        System.out.println("Cancion pausada.");
    }

    public void reanudar(){
        System.out.println("Cancion reanudada");
    }

    
}
