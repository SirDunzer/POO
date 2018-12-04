import java.util.Random;

public class NPC extends Personagem{
    private boolean Hostil;
    
    // quando foi criar um NPC usa-se um nome aleatório
    // e uma classe aleatória 
    public NPC(String nome, Raca raca, Classe classe, Mapa M){
        super(nome,raca,classe,M);
        Random R = new Random();
        this.Hostil = R.nextBoolean();
    }
    // método para interagir com o player, se não for hostil
    
    public boolean getHostil(){
        return this.Hostil;
    }
    
}
