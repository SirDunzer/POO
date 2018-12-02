import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DAO_Personagem {
   
    public static void save(Personagem p, String nome_Arquivo) throws Exception{
        
        BufferedWriter bWriter = null;
        FileWriter fWriter = null;
        
        try{
            fWriter = new FileWriter(nome_Arquivo);
            bWriter = new BufferedWriter(fWriter);
            
            bWriter.append(p.toWriteableString());
            bWriter.newLine(); // deixando cada personagem em uma linha
            bWriter.close();
            fWriter.close();
            
        }catch(IOException e){
            throw new ExcecaoSalvamento("Erro ao salvar");
        }
        
    }
    
    public Personagem init(String nome_arquivo) throws Exception{
        BufferedReader bReader = null;
        FileReader fReader = null;
        List<String> linhas = null;
        Personagem P;
        
        try{
            fReader = new FileReader(nome_arquivo);
            bReader = new BufferedReader(fReader);
            linhas = Files.readAllLines(Paths.get(nome_arquivo));            
            P = new Personagem();
            /**
             * Primeira Linha: Nome, Raça e Classe
             * Segunda Linha: Atributos
             * Terceira Linha: HP base e atual, Mana base e atual, posição atual, total de coordenadas visitadas e coordenadas visitadas
             * Quarta Linha: riquesa, total de armas equipadas e as proprias, total de armaduras equipadas e as proprias, total de itens guardados e os proprios
             */
            for(int i = 0; i < 4; i++){
                
                if(i == 0){
//                    P.
//                    fazer setters para Personagem
                }else if(i == 1){
                    
                }else if(i == 2){
                    
                }else if(i == 3){
                    
                }
            }
            
        }catch(IOException e){
            throw new ExcecaoSalvamento("Erro ao ler");
        }
    }
}
