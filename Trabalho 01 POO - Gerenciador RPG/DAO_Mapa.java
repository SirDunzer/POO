import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DAO_Mapa {
    
    public static void save(Mapa m, String nome_Arquivo) throws Exception{
        
        BufferedWriter bWriter = null;
        FileWriter fWriter = null;
        int j = 0;
        
        try{
            fWriter = new FileWriter(nome_Arquivo);
            bWriter = new BufferedWriter(fWriter);

            bWriter.newLine();
            for(Mapa.Coordenadas X : m.pontosInteresse.keySet()){
                bWriter.append("("+X.getX()+","+X.getY()+"-");
                bWriter.append(m.pontosInteresse.get(X).toString()+")");
                if(j++ != m.pontosInteresse.size()-1){
                    bWriter.append(";");
                }
                bWriter.newLine();
            }
            
            bWriter.close();
            fWriter.close();
            
        }catch(IOException e){
            throw new ExcecaoSalvamento("Erro ao salvar");
        }
        
    }
    
    public static Personagem init(String nome_Arquivo){
        
    }
    
    public void init(){
        
    }
}
