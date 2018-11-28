import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {
    
    private Map<Equipamentos.Armas, Integer> armas_Equipadas;
    private Map<Equipamentos.Armaduras, Integer> armaduras_Equipadas;
    private Map<String,Integer> objetos_Guardados; // Como se fosse a mochila do personagem
    private int Riquesa;
    private int capacidade_Carga;
    private int capacidade_Equipar;
    
    public Inventario(int forca, int modificador_forca){
        this.capacidade_Carga = 2 * forca + modificador_forca;
        this.capacidade_Equipar = 2 * forca;
        this.armas_Equipadas = new HashMap<>();
        this.armaduras_Equipadas = new HashMap<>();
        this.objetos_Guardados = new HashMap<>();
        this.Riquesa = 0;
    }
    
    // retorna uma lista de objetos 
    public List<Equipamentos.Armas> getArmasEquipadas(){
        List<Equipamentos.Armas> newList = new ArrayList<>();
        newList.addAll(this.armas_Equipadas.keySet());
        return newList;
    }
    
    // retorna uma lista de objetos
    public List<Equipamentos.Armaduras> getArmadurasEquipadas(){
        List<Equipamentos.Armaduras> newList = new ArrayList<>();
        newList.addAll(this.armaduras_Equipadas.keySet());
        return newList; 
    }
    
    // retorna uma lista de objetos
    public List<String> getItensGuardados(){
        List<String> newList = new ArrayList<>();
        newList.addAll(this.objetos_Guardados.keySet());
        return newList;
    }
    
    public int getRiquesa(){
        return this.Riquesa;
    }
    
    // jogar uma exceção quando ocorrer um erro
    public void equiparArma(Equipamentos.Armas arma) throws Exception{ 
        if(arma.getPeso() < this.capacidade_Equipar){                  
            if((arma.getPeso() + (this.armas_Equipadas.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                this.armas_Equipadas.put(arma, arma.getPeso());
                return;
            }
        }
        throw new ExcecaoInventario("Impossivel Equipar");
    }
    
    public void equiparArmadura(Equipamentos.Armaduras armadura, Personagem p)throws Exception{
        if(armadura.getPeso() < this.capacidade_Equipar){
            if((armadura.getPeso() + (this.armaduras_Equipadas.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                if(!(this.armaduras_Equipadas.containsKey(Equipamentos.Armaduras.LEVE) || this.armaduras_Equipadas.containsKey(Equipamentos.Armaduras.MEDIA) || this.armaduras_Equipadas.containsKey(Equipamentos.Armaduras.PESADA))){
                    this.armaduras_Equipadas.put(armadura, armadura.getPeso());
                    p.calcularDefesa();
                    return;
                }
            }
        }
        throw new ExcecaoInventario("Impossivel Equipar");
    }
    
    public void guardarArma(Equipamentos.Armas arma) throws Exception{
        if(arma.getPeso() < this.capacidade_Carga){
            if((arma.getPeso()) + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum()) <= this.capacidade_Carga){
                this.objetos_Guardados.put(arma.toString(),arma.getPeso());
                return;
            }
        }
        throw new ExcecaoInventario("Impossivel Guardar");
    }
    
    public void guardarArmadura(Equipamentos.Armaduras armadura, Personagem p) throws Exception{
        if(armadura.getPeso() < this.capacidade_Carga){
            if((armadura.getPeso()) + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum()) <= this.capacidade_Carga){
                this.objetos_Guardados.put(armadura.toString(),armadura.getPeso());
                p.calcularDefesa();
                return;
            }
        }
        throw new ExcecaoInventario("Impossivel Guardar");
    }
    
    public void guardarItem(Equipamentos.Itens item) throws Exception{
        if(item.getPeso() < this.capacidade_Carga){
            if((item.getPeso()) + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum()) <= this.capacidade_Carga){
                this.objetos_Guardados.put(item.toString(),item.getPeso());
                return;
            }
        }
        throw new ExcecaoInventario("Impossivel Guardar");
    }
    
    public void removerArmaEquipada(Equipamentos.Armas arma){
        if(this.armas_Equipadas.containsKey(arma)){
            this.armas_Equipadas.replace(arma, null);
            this.armas_Equipadas.remove(arma);
        }
    }
    
    public void removerArmaduraEquipada(Equipamentos.Armaduras armadura, Personagem p){
        if(this.armaduras_Equipadas.containsKey(armadura)){
            this.armaduras_Equipadas.replace(armadura, null);
            this.armaduras_Equipadas.remove(armadura);
            p.calcularDefesa();
        }        
    }
    
    public void removerItemGuardado(String Item){
        if(this.objetos_Guardados.containsKey(Item)){
            this.objetos_Guardados.replace(Item, null);
            this.objetos_Guardados.remove(Item);
        }
    }
    
    public void equiparArmaGuardada(Equipamentos.Armas arma){
        if(this.objetos_Guardados.containsKey(arma.toString())){
            if(arma.getPeso() < this.capacidade_Equipar){
                if((arma.getPeso() + (this.armas_Equipadas.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                    this.armas_Equipadas.put(arma, arma.getPeso());
                    this.objetos_Guardados.replace(arma.toString(), null);
                    this.objetos_Guardados.remove(arma.toString());
                }
            }
        }
    }

    public void equiparArmaduraGuardada(Equipamentos.Armaduras armadura, Personagem p){
        if(this.objetos_Guardados.containsKey(armadura.toString())){
            if(armadura.getPeso() < this.capacidade_Equipar){
                if((armadura.getPeso() + (this.armaduras_Equipadas.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                    this.armaduras_Equipadas.put(armadura, armadura.getPeso());
                    this.objetos_Guardados.replace(armadura.toString(), null);
                    this.objetos_Guardados.remove(armadura.toString());
                    p.calcularDefesa();
                }
            }
        }
    }
    
    public void guardarArmaEquipada(Equipamentos.Armas arma){
        if(this.armas_Equipadas.containsKey(arma)){
            if(arma.getPeso() < this.capacidade_Equipar){
                if((arma.getPeso() + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                    this.objetos_Guardados.put(arma.toString(), arma.getPeso());
                    this.armas_Equipadas.replace(arma, null);
                    this.armas_Equipadas.remove(arma);
                }
            }
        }
    }
    
    public void guardarArmaduraEquipada(Equipamentos.Armaduras armadura, Personagem p){
        if(this.armaduras_Equipadas.containsKey(armadura)){
            if(armadura.getPeso() < this.capacidade_Equipar){
                if((armadura.getPeso() + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                    this.objetos_Guardados.put(armadura.toString(), armadura.getPeso());
                    this.armaduras_Equipadas.replace(armadura, null);
                    this.armaduras_Equipadas.remove(armadura);
                    p.calcularDefesa();
                }
            }
        }
    }
    
    public void alterarRiquesa(int Delta){
        this.Riquesa += Delta;
    }
    
    public void calcularRiquesa(Personagem.Classe classe){
        switch(classe){
            
            case BARBARO:
            case BANDIDO:
                this.Riquesa = 10;
                break;   
                
            case GUERREIRO:
            case CACADOR:
                this.Riquesa = 30;
                break;
                
            case MAGO:
                this.Riquesa = 50;
                break;
                
            case LADINO:
                this.Riquesa = 100;
                break;
                
            default: this.Riquesa = 0;
        }
    }
    
    public void usarItem(String item, Personagem user) throws Exception{
        for(String S : this.objetos_Guardados.keySet()){
            if(S.equals(item) && S.equals("Fruta")){
                user.alteraHP(2);
            }else if(S.equals(item) && S.equals("Poção de HP")){
                user.alteraHP(15);
            }else if(S.equals(item) && S.equals("Poção de Mana")){
                user.alteraMana(15);
            }else{
                throw new ExcecaoInventario("Não pode Usar Esse Item");
            }
        }
    }
    
    static class Equipamentos{

        public enum Armas{
            ESPADALONGA, // Dano: 1d10 + força
            MACHADO,     // Dano: 1d8  + força
            ESPADA,      // Dano: 1d6  + força
            ARCOLONGO,   // Dano: 1d8  + destreza
            ARCOCURTO,   // Dano: 1d6  + destreza
            ADAGA;	     // Dano: 1d4  + destreza

            public int getDado(){
                int Output=0;
                Dados D = new Dados();
                switch(this){
                    case ESPADALONGA: Output = D.rolarD10(); break;
                    case MACHADO: Output = D.rolarD8(); break;
                    case ESPADA: Output = D.rolarD6(); break;
                    case ARCOLONGO: Output = D.rolarD8(); break;
                    case ARCOCURTO: Output = D.rolarD6(); break;
                    case ADAGA: Output = D.rolarD4(); break;
                }
                return Output;
            }

            public int getPeso(){
                switch(this){
                    case ESPADALONGA: return 5;
                    case MACHADO: return 4;
                    case ESPADA: return 3;
                    case ARCOLONGO: return 3;
                    case ARCOCURTO: return 2;
                    case ADAGA: return 1;
                    default: return 0;
                }
            }

            @Override
            public String toString(){
                String Output = null;

                switch(this){
                    case ESPADALONGA: Output = "Espada Longa"; break;
                    case MACHADO: Output = "Machado de Guerra"; break;
                    case ESPADA: Output = "Espada"; break;
                    case ARCOLONGO: Output = "Arco Longo"; break;
                    case ARCOCURTO: Output = "Arco Curto"; break;
                    case ADAGA: Output = "Adaga"; break;
                }
                return Output;
            }
        }

        public enum Armaduras{ // O número é o valor de defesa da armadura
            LEVE(12),
            MEDIA(14),
            PESADA(18),
            ESCUDO(2);

            private final int Valor;

            Armaduras(int Valor){
                this.Valor = Valor;
            }

            public int getValor(){
                return this.Valor;
            }

            public int getPeso(){
                switch(this){
                    case LEVE: return 9;
                    case MEDIA: return 12;
                    case PESADA: return 15;
                    case ESCUDO: return 2;
                    default: return 0;
                }
            }

            @Override
            public String toString(){
                String Output = null;

                switch(this){
                    case LEVE: Output = "Armadura Leve"; break;
                    case MEDIA: Output = "Armadura Media"; break;
                    case PESADA: Output = "Armadura Pesada"; break;
                    case ESCUDO: Output = "Escudo"; break;
                }
                return Output;
            }
        }

        public enum Magias{ // Ignoram a armadura, mas se o alvo rolar (d20+const > 15) toma metade do dano
            BOLA_FOGO, // Dano: 3d4
            BOLA_GELO, // Dano: 2d6
            RELAMPAGO, // Dano: 1d10 + Sempre da dano cheio
            CURAR;	   // Regenera: 1d8 de HP

            public int getDado(){
                int Output=0;
                Dados D = new Dados();
                switch(this){
                    case BOLA_FOGO: Output = D.rolarD4() + D.rolarD4() + D.rolarD4(); break;
                    case BOLA_GELO: Output = D.rolarD6() + D.rolarD6(); break;
                    case RELAMPAGO: Output = D.rolarD10(); break;
                }
                return Output;
            }

            public int getCustoMana(){
                switch(this){
                    case BOLA_FOGO: return 6;
                    case BOLA_GELO: return 5;
                    case RELAMPAGO: return 10;
                    case CURAR: return 4;
                    default: return 0;
                }
            }
        }

        public enum Itens{
            FRUTA        (0),
            POCAO_HP     (10),
            POCAO_MANA   (12),
            TESOURO      (100);

            private final int Valor;

            Itens(int Valor){
                this.Valor = Valor;
            }

            public int getValor(){
                return this.Valor;
            }

            public int getPeso(){
                switch(this){
                    case FRUTA: return 0;
                    case POCAO_HP: case POCAO_MANA: return 1;
                    case TESOURO: return 10;
                    default: return 0;                
                }
            }

            @Override
            public String toString(){
                switch(this){
                    case FRUTA: return "Fruta";
                    case POCAO_HP: return "Poção de HP";
                    case POCAO_MANA: return "Poção de Mana";
                    case TESOURO: return "Tesouro";
                    default: return null;
                }
            }

        }
    }

}
