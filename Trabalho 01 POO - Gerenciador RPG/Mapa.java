import java.util.*;
//import java.util.Map;
//import java.util.List;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Random;

/*
Fazer alguma classe que permita movimentar-se no mapa (Classe combate)
Fazer alguma classe que simule um sistema de turnos durante o combate (Classe combate)
Fazer alguma classe que permita interação com o jogador com o local onde ele está (caso não haja um inimigo nesse local) !!FAZER!!
Fazer algo que remova um inimigo de uma tile do mapa caso ele já tenha sido enfrentado e derrotado Classe Combate + !!FAZER!!
De algum modo inserir na classe do personagem uma lista de todos os locais já visitados !!FAZER!!
*/

public class Mapa {
    final int[][] Mundo;
    Coordenadas posicaoInicial;
    Map<Coordenadas,Locais> pontosInteresse;
    
    public Mapa(int total_Players){
        this.Mundo = new int[256][256];
        for(int i=0;i<256;i++){
            for(int j=0;j<256;j++){
                this.Mundo[i][j] = 0; // 0 = Player não está lá
            }
        }
        this.Mundo[128][128] = 1; // 1 = Player está lá
        this.posicaoInicial = new Coordenadas(128,128);
        this.pontosInteresse = geraPontosInteresse();
    }
    
    Map<Coordenadas,Locais> geraPontosInteresse(){
        int x,y;
        List<Locais> LocalRandom = Collections.unmodifiableList(Arrays.asList(Locais.values()));
        Random R = new Random();
        Coordenadas Temp = null;
        Locais Possiveis = null;
        Map<Coordenadas,Locais> Final = new HashMap<>();
        
        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 256; j++){
                for(int k = 0; k < 256; k++){
                    Temp = new Coordenadas(j,k);
                }
            }
            Possiveis = Locais.NADA;
            Final.put(Temp,Possiveis); // fazer um scriptzinho para evitar mapas absurdos
            // exemplo : mapa que seja 70 % baús ou coisa assim
        }
        
        for(int i = 0; i< 220; i++){
            do{
                x = R.nextInt(256); // enquanto ele não selecionar uma tile vazia 
                y = R.nextInt(256); // vai ficar recalculando as coordenadas
                Temp = new Coordenadas(x,y);
            }while(! Final.containsValue(Locais.NADA));
            Possiveis = LocalRandom.get(R.nextInt(LocalRandom.size()));
            Final.put(Temp,Possiveis);
        }
        
        Final.put(new Coordenadas(127,127),Locais.INIMIGO);
        Final.put(new Coordenadas(127,128),Locais.FLORESTA);
        Final.put(new Coordenadas(127,129),Locais.LOJA);
        Final.put(new Coordenadas(128,127),Locais.CIDADE);
        Final.put(new Coordenadas(128,129),Locais.MONUMENTO);
        Final.put(new Coordenadas(129,127),Locais.BAU);
        Final.put(new Coordenadas(129,128),Locais.VILAREJO);
        Final.put(new Coordenadas(129,129),Locais.OBELISCO);
        Final.put(new Coordenadas(128,128),Locais.NADA); // garantindo que no spawn do player não vai haver nada
        return Final;
        
    }

    class Coordenadas{
        int X;
        int Y;

        public Coordenadas(int x, int y){
            this.X = x;
            this.Y = y;
        }

        public int getX(){
            return this.X;
        }

        public int getY(){
            return this.Y;
        }

        public void setX(int x){
            this.X = x;
        }

        public void setY(int y){
            this.Y = y;
        }
    }
    
    enum Locais{
        INIMIGO,   // inimigo que vai iniciar combate com o player assim que ele chegar na mesma tile
        BAU,       // bau com alguns itens e dinheiro
        LOJA,      // uma loja de um tipo aleatório
        FLORESTA,  // um lugar onde o player pode descançar 
        MONUMENTO, // monumento aos deuses -> Regenera X % do HP máximo
        CIDADE,    // tem diversas lojas para comprar e vender itens, assim como lugares para descançar
        NADA,      // um espaço vazio no mapa, sem nada de relevante, nem nenhuma atividade especial
        VILAREJO,  // tem poucas lojas, e pode ter lugares para descançar
        OBELISCO;  // outro tipo de homenagem aos deuses -> Regenera X % da Mana Máxima 
        
        @Override
        public String toString(){
            switch(this){
                case INIMIGO: return "Inimigo";
                case BAU: return "Bau";
                case LOJA: return "Loja";
                case FLORESTA: return "Floresta";
                case MONUMENTO: return "Monumento";
                case CIDADE: return "Cidade";
                case NADA: return "Nada";
                case VILAREJO: return "Vilarejo";
                case OBELISCO: return "Obelisco";
                default: return null;
            }
        }
    }
}