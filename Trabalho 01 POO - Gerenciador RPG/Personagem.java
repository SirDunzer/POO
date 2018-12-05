/*
 * Fazer algum método que faça com que a partida acabe quaso o ultimo personagem jogável morrer
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/**
 * !!!! FAZER MÉTODO move !!!! 
 */
public class Personagem extends Acoes implements Classe_Raca{
    
    private Atributos atributos;
    private String nome;
    private Raca race;
    private Classe classe;
    private int HP_Base;
    private int Mana_Base;
    private int HP_Atual;
    private int Mana_Atual;
    private int Defesa;
    private boolean estaVivo;
    private Inventario inventario;
    private Mapa.Coordenadas posicaoAtual;
    private List<Mapa.Coordenadas> visitadas;
    private final DAO_Personagem saver;
    
    public Personagem(String nome,Raca race, Classe classe, Mapa mundi){
        this.atributos = new Atributos(race);
       	this.nome = nome;
        this.race = race;
        this.classe = classe;

        this.HP_Base = calcularHP(this.classe);
        this.HP_Atual = this.HP_Base;
        this.Mana_Base = calcularMana(this.classe);
        this.Mana_Atual = this.Mana_Base;
        this.inventario = new Inventario(this.atributos.getForca(),this.atributos.modificadorForca());
        this.posicaoAtual = mundi.getPosicaoInicial();
        this.visitadas = new ArrayList<>();
        this.visitadas.add(posicaoAtual);
        this.saver = new DAO_Personagem();

        this.estaVivo = true;
        this.Defesa = 0;
    }
    
    public Personagem(){
        
        this.atributos = null;
       	this.nome = null;
        this.race = null;
        this.classe = null;

        this.HP_Base = -1;
        this.HP_Atual = -1;
        this.Mana_Base = -1;
        this.Mana_Atual = -1;
        this.inventario = null;
        this.posicaoAtual = null;
        this.visitadas = new ArrayList<>();
        this.saver = null;

        this.estaVivo = false;
        this.Defesa = -1;
        
    }

    public String getNome() {
    	return this.nome;
    }

    public int getHP_Base() {
        return this.HP_Base;
    }

    public int getHP_Atual(){
            return this.HP_Atual;
    }
    
    public int getMana_Base(){
        return this.Mana_Base;
    }
    
    public int getMana_Atual(){
        return this.Mana_Atual;
    }

    public int getDefesa(){
        return this.Defesa;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
    
    public Atributos getAtributos(){
        return this.atributos;
    }
    
    public void setHP_Base(int HP_Base) {
        this.HP_Base = HP_Base;
    }

    public void setMana_Base(int Mana_Base) {
        this.Mana_Base = Mana_Base;
    }
    
    public void setHP_Atual(int HP_Atual) {
        this.HP_Atual = HP_Atual;
    }

    public void setMana_Atual(int Mana_Atual) {
        this.Mana_Atual = Mana_Atual;
    }

    public void setVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    //alterar
    public void setPosicaoAtual(Mapa.Coordenadas posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }
    
    public void setPosicaoAtual(Integer X, Integer Y){
        this.posicaoAtual.setX(X);
        this.posicaoAtual.setY(Y);
    }
    
    public void setVisitadas(List<Mapa.Coordenadas> visitadas) {
        this.visitadas = visitadas;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRace(Raca race) {
        this.race = race;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    public void addVisitada(Integer X, Integer Y){
        Mapa M = new Mapa(); // super desperdício de tempo e memória, mas não há muito o que fazer sem drasticamente alterar a modelagem
        this.visitadas.add(M.new Coordenadas(X,Y));
    }

    public boolean checkVivo(){
        return this.estaVivo;
    }
        
    @Override
    public String getStringClasse(){
        switch(this.classe){
            case BARBARO: return "Barbaro";
            case GUERREIRO: return "Guerreiro";
            case LADINO: return "Ladino";
            case MAGO: return "Mago";
            case CACADOR: return "Cacador";
            case BANDIDO: return "BANDIDO";
            default: return null;
        }
    }
    
    @Override
    public String getStringRaca(){
        switch(this.race){
            case ANAO: return "Anao";
            case HUMANO: return "Humano";
            case ELFO: return "Elfo";
            case GOBLIN: return "Goblin";
            case ORC: return "Orc";
            case OGRO: return "Ogro";
            case GIGANTE: return "Gigante";
            default: return null;
        }
    }

    @Override
    public Classe getClasse(){
        return this.classe;
    }
    
    @Override
    public Raca getRaca(){
        return this.race;
    }

    @Override
    public Classe gerarClasseJogavelAleatoria(){
        Classe C = null;
        do{
            Random R = new Random();
            List<Classe> randomClasse = Collections.unmodifiableList(Arrays.asList(Classe.values()));
            C = randomClasse.get(R.nextInt(randomClasse.size()));
        }while(! C.equals(Classe_Raca.Classe.BANDIDO));
        return C;
    }
    
    @Override
    public Raca gerarRacaJogavelAleatoria(){
        Raca R1 = null;
        do{
            Random R = new Random();
            List<Raca> randomRaca = Collections.unmodifiableList(Arrays.asList(Raca.values()));
            R1 = randomRaca.get(R.nextInt(randomRaca.size()));
        }while(! R1.equals(Classe_Raca.Raca.GIGANTE) || ! R1.equals(Classe_Raca.Raca.ORC) || ! R1.equals(Classe_Raca.Raca.GOBLIN) || ! R1.equals(Classe_Raca.Raca.OGRO));
        return R1;
    }
    
    @Override
    public Classe gerarClasseAleatoria(){
        Random R = new Random();
        List<Classe> randomClasse = Collections.unmodifiableList(Arrays.asList(Classe.values()));
        return randomClasse.get(R.nextInt(randomClasse.size()));
    }
    
    @Override
    public Raca gerarRacaAleatoria(){
        Random R = new Random();
        List<Raca> randomRaca = Collections.unmodifiableList(Arrays.asList(Raca.values()));
        return randomRaca.get(R.nextInt(randomRaca.size()));
    }
    
    public void alteraHP(int Delta){
            this.HP_Atual += Delta;
            if(Delta < 0){
                System.out.println(this.nome+" levou "+Delta+" pontos de Dano !");
            }else if(Delta > 0){
                System.out.println(this.nome+" regenerou "+Delta+" pontos de HP !");
            }else{
                System.out.println(this.nome +" não levou Dano !");
            }
            if(this.getHP_Atual() <= 0){
                this.estaVivo = false;
                return;
            }
            System.out.println("O HP Atual de "+this.nome+" é: "+this.getHP_Atual());
    }
    
    public void alteraMana(int Delta){
            this.Mana_Atual += Delta;
            if(Delta < 0){
                System.out.println(this.nome+" perdeu "+Delta+" pontos de Mana !");
            }else if(Delta > 0){
                System.out.println(this.nome+" regenerou "+Delta+" pontos de Mana !");
            }else{
                System.out.println(this.nome +" não gastou Mana !");
            }
            System.out.println("A Mana Atual de "+this.nome+" é: "+this.getMana_Atual());
    }
    
    // defesa é recalculada toda vez que uma armadura é equipada
    public void calcularDefesa(){

        for(Inventario.Equipamentos.Armaduras A : this.inventario.getArmadurasEquipadas()){
            if(A.equals(Inventario.Equipamentos.Armaduras.LEVE)){
                this.Defesa += 12;
            }if(A.equals(Inventario.Equipamentos.Armaduras.MEDIA)){
                this.Defesa += 14;
            }if(A.equals(Inventario.Equipamentos.Armaduras.PESADA)){
                this.Defesa += 18;
            }if(A.equals(Inventario.Equipamentos.Armaduras.ESCUDO)){
                this.Defesa += 2;
            }
        }
    }

    @Override
    public String toString(){
        return ""+this.nome+" é um(a) "+this.getStringRaca()+" "+this.getStringClasse()+" e tem os seguintes atributos:\n"+super.toString()+"\n"+this.HP_Base+" Pontos de Vida Base\n"+this.HP_Atual+" Pontos Atuais de Vida\n";
    }
    
    public String toWriteableString(){
        String result;
        result = this.nome;
        result += ";"+this.getStringRaca();
        result += ";"+this.getStringClasse();
        result += "\r\n";
        result += this.atributos.toWriteableString();
        result += "\r\n";
        result += this.getHP_Base();
        result += ";"+this.getHP_Atual();
        result += ";"+this.getMana_Base();
        result += ";"+this.getMana_Atual();
        result += ";"+"{"+this.posicaoAtual.getX()+","+this.posicaoAtual.getY()+"}";
        result += ";"+this.visitadas.size()+";{";
        int j = 0;
        for(Mapa.Coordenadas C : this.visitadas){
            result+= "("+C.getX()+","+C.getY()+")";
            if(j++ != this.visitadas.size()-1){
                result += ";"; // garantindo que o ultimo par não tem ; depois
            }
        }
        result += "}\r\n"+this.inventario.toString();
        return "\r\n"+result;
    }
    
    @Override
    public int calcularHP(Classe classe_escolhida){
        Dados D = new Dados();
        
        switch(classe_escolhida){
            case BARBARO: return this.atributos.getConstituicao() + D.rolarD12();
            case MAGO: return this.atributos.getConstituicao() + D.rolarD6();
            case GUERREIRO: case CACADOR: return this.atributos.getConstituicao() + D.rolarD10();
            case LADINO: return this.atributos.getConstituicao() + D.rolarD8();
            case BANDIDO: return this.atributos.getConstituicao()-1 + D.rolarD6();
            default: return -1;
        }
    }
    
    @Override
    public int calcularMana(Classe classe_escolhida){
        Dados D = new Dados();
        
        switch(classe_escolhida){
            case BARBARO: return this.atributos.getSabedoria() + D.rolarD4();
            case LADINO: case GUERREIRO: return this.atributos.getSabedoria() + D.rolarD6();
            case CACADOR: return this.atributos.getSabedoria() + D.rolarD8();
            case MAGO: return this.atributos.getSabedoria() + D.rolarD12();
            case BANDIDO: return this.atributos.getSabedoria()-1 + D.rolarD4();
            default: return -1;
        }
    }
    
    public void save(String filename) throws Exception{
        try{
            this.saver.save(this,filename);
        }catch(Exception e){
            throw e;
        }
    }
    
    public Personagem load(String filename) throws Exception{
        try{
            return this.saver.init(filename);
        }catch(Exception e){
            throw e;
        }finally{
            return null;
        }
        
    }
    
    public static void kill(Personagem P){
        P = null;
        // mensagem P.nome Morreu !
    }
    
    @Override
    public void mover(Mapa mundi){
        Mapa.Coordenadas newPosicao = null;
        /*perguntar ao usuário a direção para qual ele quer se mover*/
        /*TODO: Modificar os valores de posicao no mapa*/
        this.visitadas.add(this.posicaoAtual);
        this.posicaoAtual = newPosicao;

    }
}
