import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Folha {
    public static void exportaPersonagem(Personagem Jogador) throws Exception{
        File personagem = new File("Personagem.txt");
//        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        FileOutputStream output = new FileOutputStream(personagem, true);

        output.write(Jogador.getNome().getBytes());
        output.write("\n".getBytes());
        output.write(String.valueOf(Jogador.getForca()).getBytes()); 
        output.write("\n".getBytes());
        output.write(String.valueOf(Jogador.getDestreza()).getBytes());
        output.write("\n".getBytes());
        output.write(String.valueOf(Jogador.getConstituicao()).getBytes());
        output.write("\n".getBytes());
        output.write(String.valueOf(Jogador.getInteligencia()).getBytes());
        output.write("\n".getBytes());
        output.write(String.valueOf(Jogador.getSabedoria()).getBytes());
        output.write("\n".getBytes());
        output.write(String.valueOf(Jogador.getCarisma()).getBytes());
        output.write("\n---".getBytes());
        System.out.println("Arquivo criado com Sucesso!");
    }

}




/*public static void salvaInformacoes(Personagem Jogador) throws Exception{
        File folhaPersonagem = new File("folhaPersonagem.txt");
        FileOutputStream output = new FileOutputStream(folhaPersonagem, true);

        output.write(Jogador.toString().getBytes());
    }*/