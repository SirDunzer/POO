import java.util.*;
//import java.util.Map;
//import java.util.List;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Random;

/*
Fazer alguma classe que permita movimentar-se no mapa
Fazer alguma classe que simule um sistema de turnos durante o combate
Fazer alguma classe que permita interação com o jogador com o local onde ele está (caso não haja um inimigo nesse local)
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
        Coordenadas Temp;
        Locais Possiveis;
        Map<Coordenadas,Locais> Final = new HashMap<>();
        
        for(int i = 0; i < 256; i++){
            do{
                x = R.nextInt(256);
                y = R.nextInt(256);
                Temp = new Coordenadas(x,y);
            }while(Final.containsKey(Temp)); // vai gerar novas coordenadas <X,Y> equanto não gerar uma única
            Possiveis = LocalRandom.get(R.nextInt(LocalRandom.size()));
            Final.put(Temp,Possiveis);
        }
        
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
        INIMIGO,
        BAU,
        LOJA,
        FLORESTA,
        MONUMENTO,
        CIDADE;
        
        @Override
        public String toString(){
            switch(this){
                case INIMIGO: return "Inimigo";
                case BAU: return "Bau";
                case LOJA: return "Loja";
                case FLORESTA: return "Floresta";
                case MONUMENTO: return "Monumento";
                default: return null;
            }
        }
    }
}