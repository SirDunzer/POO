import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DAO_RPG { // fazer uma interfaçe disso
    /*
    *  O que deve ser salvo no arquivo:
    *       O vetor de personagens atualmente no jogo
    *           Isso inclui seu inventário, lista de movimentos já realizados, etc.
    *       O mapa, em seu estado atual
    *       Só ... ?
    */
    
    public void save(Personagem[] personagens, Mapa mundi) throws Exception{
        
        BufferedWriter bWriter = null;
        FileWriter fWriter = null;
        String nome_Arquivo = "RPG-save.csv";
        
        try{
            fWriter = new FileWriter(nome_Arquivo);
            bWriter = new BufferedWriter(fWriter);
            
            bWriter.write(personagens.length);
            for(Personagem p : personagens){
                bWriter.append(p.toWriteableString());
                bWriter.newLine();
            }
            bWriter.newLine();
            for(Mapa.Coordenadas X : mundi.pontosInteresse.keySet()){
                bWriter.append("("+X.getX()+","+X.getY()+"-");
                bWriter.append(mundi.pontosInteresse.get(X).toString()+")");
                bWriter.append(";");
                bWriter.newLine();
            }
            
        }catch(IOException e){
            throw new ExcecaoSalvamento("Erro ao salvar");
        }
        
    }
    
    public void init(){
        
    }
}
