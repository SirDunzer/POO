import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;

public class Folha {
    public static void exportaPersonagem(Personagem Jogador) throws Exception{
        File personagem = new File("Personagem.txt");
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(Jogador.getNome()); output.newLine();
        output.write(String.valueOf(Jogador.getForca())); output.newLine();
        output.write(String.valueOf(Jogador.getDestreza())); output.newLine();
        output.write(String.valueOf(Jogador.getConstituicao())); output.newLine();
        output.write(String.valueOf(Jogador.getInteligencia())); output.newLine();
        output.write(String.valueOf(Jogador.getSabedoria())); output.newLine();
        output.write(String.valueOf(Jogador.getCarisma())); output.newLine();
        System.out.println("Arquivo criado com Sucesso!");
    }

}




/*public static void salvaInformacoes(Personagem Jogador) throws Exception{
        File folhaPersonagem = new File("folhaPersonagem.txt");
        FileOutputStream output = new FileOutputStream(folhaPersonagem, true);

        output.write(Jogador.toString().getBytes());
    }*/