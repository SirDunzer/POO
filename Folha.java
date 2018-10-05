import java.io.File;
import java.io.FileOutputStream;

public class Folha {
    public static void Arquivo(Personagem Player) throws Exception{
        File folhaPersonagem = new File("folhaPersonagem.txt");
        FileOutputStream output = new FileOutputStream(folhaPersonagem, true);

        output.write(Player.toString().getBytes());

    }
}
