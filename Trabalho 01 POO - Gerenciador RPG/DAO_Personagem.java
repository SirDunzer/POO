import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

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
        String [] S2 = null;
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
                S2 = S.split(";");
                switch (i) {
                    
                    case 0:
                        
                        P.setNome(S2[0]);
                        
                        switch (S2[1]) {
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
                        
                        switch (S2[1]) {
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
                        P.getAtributos().setForca(Integer.valueOf(S2[0]));
                        P.getAtributos().setDestreza(Integer.valueOf(S2[1]));
                        P.getAtributos().setConstituicao(Integer.valueOf(S2[2]));
                        P.getAtributos().setInteligencia(Integer.valueOf(S2[3]));
                        P.getAtributos().setSabedoria(Integer.valueOf(S2[4]));
                        P.getAtributos().setCarisma(Integer.valueOf(S2[5]));
                        break;
                        
                    case 2:
                        P.setHP_Base(Integer.valueOf(S2[0]));
                        P.setHP_Atual(Integer.valueOf(S2[1]));
                        P.setMana_Base(Integer.valueOf(S2[2]));
                        P.setMana_Atual(Integer.valueOf(S2[3]));
                        
                        String S3 = S2[4];
                        String[] S4 = null;
                        List<Mapa.Coordenadas> V = new ArrayList<>();
                        
                        S3 = S3.substring(1, S3.length()-1);
                        P.setPosicaoAtual(Integer.valueOf(S3.split(",")[0]),Integer.valueOf(S3.split(",")[1]));
                        
                        S3 = S2[6].substring(1, S2[6].length()-1);
                        S4 = S3.split(";");
                        
                        for(int j = 0; j < Integer.valueOf(S2[5]); j ++){
                            S4[j] = S4[j].substring(1, S4[j].length()-1);
                            P.addVisitada(Integer.valueOf(S4[j].split(",")[0]),Integer.valueOf(S4[j].split(",")[1]));
                        }
                        break;
                        
                    case 3:
                        
                        P.setInventario(new Inventario(P.getAtributos().getForca(), P.getAtributos().modificadorForca()));
                        P.getInventario().setRiquesa(Integer.valueOf(S2[0]));
                        
                        String S5 = S2[2];
                        S5 = S5.substring(1,S5.length()-1);
                        for(int j = 0; j < Integer.valueOf(S2[1]); j++){
                            
                            switch(S5.split(",")[j]){
                                
                                case "Adaga":
                                    P.getInventario().equiparArma(Inventario.Equipamentos.Armas.ADAGA);
                                    break;
                                    
                                case "Espada":
                                    P.getInventario().equiparArma(Inventario.Equipamentos.Armas.ESPADA);
                                    break;
                                    
                                case "Espada Longa":
                                    P.getInventario().equiparArma(Inventario.Equipamentos.Armas.ESPADALONGA);
                                    break;
                                    
                                case "Machado de Guerra":
                                    P.getInventario().equiparArma(Inventario.Equipamentos.Armas.MACHADO);
                                    break;
                                    
                                case "Arco Longo":
                                    P.getInventario().equiparArma(Inventario.Equipamentos.Armas.ARCOLONGO);
                                    break;
                                    
                                case "Arco Curto":
                                    P.getInventario().equiparArma(Inventario.Equipamentos.Armas.ARCOCURTO);
                                    break;
                                
                            }
                        }
                        
                        S5 = S2[4];
                        S5 = S5.substring(1,S5.length()-1);
                        for(int j = 0; j < Integer.valueOf(S2[3]); j++){

                            switch(S5.split(",")[j]){
                                
                                case "Armadura Leve":
                                    P.getInventario().equiparArmadura(Inventario.Equipamentos.Armaduras.LEVE,P);
                                    break;
                                    
                                case "Armadura Media":
                                    P.getInventario().equiparArmadura(Inventario.Equipamentos.Armaduras.MEDIA,P);
                                    break;
                                    
                                case "Armadura Pesada":
                                    P.getInventario().equiparArmadura(Inventario.Equipamentos.Armaduras.PESADA,P);
                                    break;
                                    
                                case "Escudo":
                                    P.getInventario().equiparArmadura(Inventario.Equipamentos.Armaduras.ESCUDO,P);
                                    break;
                                
                            }
                        }
                        
                        S5 = S2[6];
                        S5 = S5.substring(1,S5.length()-1);
                        
                        for(int j = 0; j < Integer.valueOf(S2[5]); j++){

                            switch(S5.split(",")[j]){
                                
                                case "Fruta":
                                    P.getInventario().guardarItem(Inventario.Equipamentos.Itens.FRUTA);
                                    break;
                                    
                                case "Poção de HP":
                                    P.getInventario().guardarItem(Inventario.Equipamentos.Itens.POCAO_HP);
                                    break;
                                    
                                case "Poção de Mana":
                                    P.getInventario().guardarItem(Inventario.Equipamentos.Itens.POCAO_MANA);
                                    break;
                                    
                                case "Tesouro":
                                    P.getInventario().guardarItem(Inventario.Equipamentos.Itens.TESOURO);
                                    break;
                                
                            }
                        }
                        
                        break;
                        
                    default:
                        break;
                }
            }
            bReader.close();
            fReader.close();
            P.setVivo(true);
            return P;
        }catch(IOException e){
            throw new ExcecaoSalvamento("Erro ao ler");
        }
    }
}
