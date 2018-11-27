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
    
    public void equiparArma(Equipamentos.Armas arma){ // || Isso soma os valores do mapa
        if(arma.getPeso() < this.capacidade_Equipar){ // \/
            if((arma.getPeso() + (this.armas_Equipadas.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                this.armas_Equipadas.put(arma, arma.getPeso());
                return;
            }
        }
        System.err.println("Não foi possível equipar "+arma.toString()+"!");
    }
    
    public void equiparArmadura(Equipamentos.Armaduras armadura){
        if(armadura.getPeso() < this.capacidade_Equipar){
            if((armadura.getPeso() + (this.armaduras_Equipadas.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                if(!(this.armaduras_Equipadas.containsKey(Equipamentos.Armaduras.LEVE) || this.armaduras_Equipadas.containsKey(Equipamentos.Armaduras.MEDIA) || this.armaduras_Equipadas.containsKey(Equipamentos.Armaduras.PESADA))){
                    this.armaduras_Equipadas.put(armadura, armadura.getPeso());
                    return;
                }
            }
        }
        System.err.println("Não foi possivel equipar "+armadura.toString()+"!");
    }
    
    public void guardarArma(Equipamentos.Armas arma){
        if(arma.getPeso() < this.capacidade_Carga){
            if((arma.getPeso()) + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum()) <= this.capacidade_Carga){
                this.objetos_Guardados.put(arma.toString(),arma.getPeso());
                return;
            }
        }
        System.err.println("Não foi possivel guardar "+arma.toString()+"!");
    }
    
    public void guardarArmadura(Equipamentos.Armaduras armadura){
        if(armadura.getPeso() < this.capacidade_Carga){
            if((armadura.getPeso()) + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum()) <= this.capacidade_Carga){
                this.objetos_Guardados.put(armadura.toString(),armadura.getPeso());
                return;
            }
        }
        System.err.println("Não foi possivel guardar "+armadura.toString()+"!");
    }
    
    public void guardarItem(Equipamentos.Itens item){
        if(item.getPeso() < this.capacidade_Carga){
            if((item.getPeso()) + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum()) <= this.capacidade_Carga){
                this.objetos_Guardados.put(item.toString(),item.getPeso());
                return;
            }
        }
        System.err.println("Não foi possível guardar"+item.toString()+"!");
    }
    
    public void removerArmaEquipada(Equipamentos.Armas arma){
        if(this.armas_Equipadas.containsKey(arma)){
            this.armas_Equipadas.replace(arma, null);
            this.armas_Equipadas.remove(arma);
        }
    }
    
    public void removerArmaduraEquipada(Equipamentos.Armaduras armadura){
        if(this.armaduras_Equipadas.containsKey(armadura)){
            this.armaduras_Equipadas.replace(armadura, null);
            this.armaduras_Equipadas.remove(armadura);
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

    public void equiparArmaduraGuardada(Equipamentos.Armaduras armadura){
        if(this.objetos_Guardados.containsKey(armadura.toString())){
            if(armadura.getPeso() < this.capacidade_Equipar){
                if((armadura.getPeso() + (this.armaduras_Equipadas.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                    this.armaduras_Equipadas.put(armadura, armadura.getPeso());
                    this.objetos_Guardados.replace(armadura.toString(), null);
                    this.objetos_Guardados.remove(armadura.toString());
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
    
    public void guardarArmaduraEquipada(Equipamentos.Armaduras armadura){
        if(this.armaduras_Equipadas.containsKey(armadura)){
            if(armadura.getPeso() < this.capacidade_Equipar){
                if((armadura.getPeso() + (this.objetos_Guardados.values().stream().mapToInt(Integer::intValue).sum())) <= this.capacidade_Equipar){
                    this.objetos_Guardados.put(armadura.toString(), armadura.getPeso());
                    this.armaduras_Equipadas.replace(armadura, null);
                    this.armaduras_Equipadas.remove(armadura);
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
   
}
