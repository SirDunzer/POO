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
        String S = null;
        Personagem P = null;
        
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
                S = linhas.get(i);
                
                switch (i) {
                    
                    case 0:
                        
                        P.setNome(S.split(";")[0]);
                        
                        switch (S.split(";")[1]) {
                            case "Anao":
                                P.setRace(Classe_Raca.Raca.ANAO);
                                break;
                            case "Humano":
                                P.setRace(Classe_Raca.Raca.HUMANO);
                                break;
                            case "Elfo":
                                P.setRace(Classe_Raca.Raca.ELFO);
                                break;
                            default:
                                break;
                        }
                        
                        switch (S.split(";")[1]) {
                            case "Barbaro":
                                P.setClasse(Classe_Raca.Classe.BARBARO);
                                break;
                            case "Cacador":
                                P.setClasse(Classe_Raca.Classe.CACADOR);
                                break;
                            case "Guerreiro":
                                P.setClasse(Classe_Raca.Classe.GUERREIRO);
                                break;
                            case "Ladino":
                                P.setClasse(Classe_Raca.Classe.LADINO);
                                break;
                            case "Mago":
                                P.setClasse(Classe_Raca.Classe.MAGO);
                                break;
                            default:
                                break;
                        }
                        break;
                        
                    case 1:
                        
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
            }
            
        }catch(IOException e){
            throw new ExcecaoSalvamento("Erro ao ler");
        }
    }
}
