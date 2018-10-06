import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Folha {
    public static void salvaInformacoes(Personagem Jogador) throws Exception{
        File folhaPersonagem = new File("folhaPersonagem.txt");
        FileOutputStream output = new FileOutputStream(folhaPersonagem, true);

        output.write(Jogador.toString().getBytes());
    }
    
    public static void exportaPersonagem(Personagem Jogador) throws Exception{
        File personagem = new File("Personagem.txt");
        FileOutputStream output = new FileOutputStream(personagem, true);

        output.write(Jogador.getNome().getBytes());
        output.write(String.valueOf(Jogador.getForca()).getBytes());
        output.write(String.valueOf(Jogador.getDestreza()).getBytes());
        output.write(String.valueOf(Jogador.getConstituicao()).getBytes());
        output.write(String.valueOf(Jogador.getInteligencia()).getBytes());
        output.write(String.valueOf(Jogador.getSabedoria()).getBytes());
        output.write(String.valueOf(Jogador.getCarisma()).getBytes());
    }
    
}
