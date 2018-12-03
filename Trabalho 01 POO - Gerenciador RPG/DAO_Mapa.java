import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DAO_Mapa {
    
    /* !! Mapa e personagem devem ser salvos em arquivos diferentes !! */
    
    public static void save(Mapa m, String nome_Arquivo) throws Exception{
        
        BufferedWriter bWriter = null;
        FileWriter fWriter = null;
        int j = 0;
        
        try{
            fWriter = new FileWriter(nome_Arquivo);
            bWriter = new BufferedWriter(fWriter);

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
    
    public static Mapa init(String nome_Arquivo) throws Exception{
        BufferedReader bReader = null;
        FileReader fReader = null;
        String S = null;
        String [] S2 = null;
        Mapa M = null;
        
        try{
            fReader = new FileReader(nome_Arquivo);
            bReader = new BufferedReader(fReader);
            S = bReader.readLine();
            M.newMundo();
            M.setPosicaoInicial(128, 128);
   
            S2 = S.split(";");

            for(String S3 : S2){
               S3 = S3.substring(1, S3.length()-1);
               String[] S4 = S3.split("-");
               
               switch(S4[2]){
                   
                    case "Inimigo":
                        M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.INIMIGO);
                        break;
                       
                    case "Bau":
                        M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.BAU);
                        break;
                       
                   case "Loja":
                       M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.LOJA);
                       break;
                       
                   case "Floresta":
                       M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.FLORESTA);
                       break;
                    
                   case "Monumento":
                       M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.MONUMENTO);
                       break;   
                       
                   case "Cidade":
                       M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.CIDADE);
                       break;
                       
                   case "Nada":
                       M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.NADA);
                       break;   
                    
                   case "Vilarejo":
                       M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.VILAREJO);
                       break;
                       
                   case "Obelisco":
                       M.newpontosInteresse(Integer.parseInt(S4[0]), Integer.parseInt(S4[1]), Mapa.Locais.OBELISCO);
                       break;   
               }
               
            }
            
            bReader.close();
            fReader.close();
            return M;
        }catch(IOException e){
            throw new ExcecaoSalvamento("Erro ao ler");
        }
        
    }
    
    public void init(){
        
    }
}
