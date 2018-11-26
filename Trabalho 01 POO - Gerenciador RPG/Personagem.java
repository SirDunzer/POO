/*
 * Fazer algum método que faça com que a partida acabe quaso o ultimo personagem jogável morrer
 * Adicionar classes para os NPCs
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Personagem extends Atributos implements Classe_Raca{
    private final String nome;
    private final int HP_Base;
    private final Raca race;
    private final Classe classe;
    private final int Mana_Base;
    private int HP_Atual;
    private int Mana_Atual;
    private int Defesa;
    private int Riquesa;
    private boolean estaVivo;
    private String[] itens_Equipados; // Itens que o personagem tem equipado neste momento
    private String[] itens_Guardados; // Itens não equipados que o personagem tem neste momento

    public Personagem(String nome,Raca race, Classe classe){
        super(race);
       	this.nome = nome;
        this.race = race;
        this.classe = classe;

        this.HP_Base = calcularHP(this.classe);
        this.HP_Atual = this.HP_Base;
        this.Mana_Base = calcularMana(this.classe);
        this.Mana_Atual = this.Mana_Base;

        this.itens_Equipados = new String[(this.getDestreza()/3) + 3]; // mudar isso para ser to tipo enum de equipamentos

        this.itens_Guardados = new String[(this.getConstituicao()/2)+10];// mudar isso para ser to tipo enum de equipamentos
        // deveria tornar nossas vidas mais fáceis, apesar de que vai ser uma merda implementar

        this.estaVivo = true;
        this.Defesa = 0;
        this.Riquesa = 0;
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
    
    public int getRiquesa(){
        return this.Riquesa;
    }

    public boolean checkVivo(){
        return this.estaVivo;
    }
    
    public boolean checkManasuficiente(int necessaria){
        return this.Mana_Atual >= necessaria;
    }
        
    @Override
    public String getStringClasse(){
        switch(this.classe){
            case BARBARO: return "Barbaro";
            case GUERREIRO: return "Guerreiro";
            case LADINO: return "Ladino";
            case MAGO: return "Mago";
            case CACADOR: return "Cacador";
            case LADRAO: return "Ladrao";
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
        }while(! C.equals(Classe_Raca.Classe.LADRAO));
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
    
    // Quando equipar uma armadura deverá recalcular a defesa
    
    public void equiparArma(Equipamentos.Armas arma){
        for(int i=0;i<(super.getDestreza()/3)+3;i++){
            if(this.itens_Equipados[i] == null){
                itens_Equipados[i] = arma.toString();
                return;
            }
        }
        System.err.println(this.nome+" Não pode equipar mais nenhum Item !");
    }
    
    public void equiparArmadura(Equipamentos.Armaduras armadura){
        
        for(int i=0;i<(super.getDestreza()/3)+3;i++){    
            if(this.itens_Equipados[i] == null){        
                for(String s : this.itens_Equipados){
                    if(s.equals("Armadura Leve") || s.equals("Armadura Media") || s.equals("Armadura Pesada")){
                        System.err.println(this.nome+" Não Pode Equipar Mais de Duas Armaduras ao Mesmo Tempo!");
                        return;
                    }
                }
                this.itens_Equipados[i] = armadura.toString();
                return;
            }
        }
        System.err.println(this.nome+" Não pode equipar mais nenhum Item !");
    }
    
    public void guardarArma(Equipamentos.Armas arma){
        for(int i=0;i<(super.getConstituicao()/3)+3;i++){
            if(this.itens_Guardados[i] == null){
                itens_Guardados[i] = arma.toString();
                return;
            }
        }
        System.err.println(this.nome+" Não pode guardar mais nenhum Item !");
    }
    
    public void guardarArmadura(Equipamentos.Armaduras armadura){
        for(int i=0;i<(super.getConstituicao()/3)+3;i++){
            if(this.itens_Guardados[i] == null){
                itens_Guardados[i] = armadura.toString();
                return;
            }
        }
        System.err.println(this.nome+" Não pode guardar mais nenhum Item !");
    }
    
    public void removerItemEquipado(String Item){
        for(int i = 0; i < this.itens_Equipados.length;i++){
            if(itens_Equipados[i].equals(Item)){
                itens_Equipados[i] = null;
                return;
            }
        }
        System.err.println("Não Equipou "+Item);
    }
    
    public void removerItemGuardado(String Item){
        for(int i = 0; i < this.itens_Guardados.length;i++){
            if(itens_Guardados[i].equals(Item)){
                itens_Guardados[i] = null;
                return;
            }
        }
        System.err.println("Não Guardou "+Item);
    }
    
    public void equiparItemGuardado(String Item){ // mover item que esta guardado para um equipado
        for(int i = 0; i < this.itens_Guardados.length;i++){
            if(this.itens_Guardados[i].equals(Item)){
                for(int j = 0; j < this.itens_Equipados.length;j++){
                    if(this.itens_Equipados[j] == null){
                        this.itens_Equipados[j] = this.itens_Guardados[i];
                        this.itens_Guardados[i] = null;
                        return;
                    }
                }
            }
        }
        System.err.println("Voce não esta com "+Item+" guardado ou não tem mais espaço para equipar itens");
    }

    public void guardarItemEquipado(String Item){
        for(int i = 0; i < this.itens_Equipados.length;i++){
            if(this.itens_Equipados[i].equals(Item)){
                for(int j = 0; j < this.itens_Guardados.length;j++){
                    if(this.itens_Guardados[j] == null){
                        this.itens_Guardados[j] = this.itens_Equipados[i];
                        this.itens_Equipados[i] = null;
                        return;
                    }
                }
            }
        }
        System.err.println("Voce não esta com "+Item+" equipado ou não tem mais espaço para guardar itens");        
    }
    
    public void trocarEquipado_Guardado(String Equipado, String Guardado){
        for(int i = 0; i < this.itens_Guardados.length;i++){
            if(this.itens_Guardados[i].equals(Guardado)){
                for(int j = 0; j < this.itens_Equipados.length;j++){
                    if(this.itens_Equipados[j] == Equipado){
                        this.itens_Equipados[j] = Guardado;
                        this.itens_Guardados[i] = Equipado;
                        return;
                    }
                }
            }
        }
        System.err.println("Não foi possível fazer essa Troca");
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
    
    // Fazer método para exibir a riquesa
    public void alteraRiquesa(int Delta){
        this.Riquesa += Delta;
    }

    public void calcularDefesa(){

        for(String Itens : this.itens_Equipados){
            if(Itens.equals("Armadura Leve")){
                    this.Defesa += 12;
            }if(Itens.equals("Armadura Media")){
                    this.Defesa += 14;
            }if(Itens.equals("Armadura Pesada")){
                    this.Defesa += 18;
            }if(Itens.equals("Escudo")){
                    this.Defesa += 2;
            }
        }
    }
    
    public void calcularRiquesa(){
        switch(this.classe){
            
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

    @Override
    public String toString(){
        return ""+this.nome+" é um(a) "+this.getStringRaca()+" "+this.getStringClasse()+" e tem os seguintes atributos:\n"+super.toString()+"\n"+this.HP_Base+" Pontos de Vida Base\n"+this.HP_Atual+" Pontos Atuais de Vida\n";
    }

    @Override
    public int calcularHP(Classe classe_escolhida){
        Dados D = new Dados();
        
        switch(classe_escolhida){
            case BARBARO: return super.getConstituicao() + D.rolarD12();
            case MAGO: return super.getConstituicao() + D.rolarD6();
            case GUERREIRO: case CACADOR: return super.getConstituicao() + D.rolarD10();
            case LADINO: return super.getConstituicao() + D.rolarD8();
            case LADRAO: return super.getConstituicao()-1 + D.rolarD6();
            default: return -1;
        }
    }
    
    @Override
    public int calcularMana(Classe classe_escolhida){
        Dados D = new Dados();
        
        switch(classe_escolhida){
            case BARBARO: return super.getSabedoria() + D.rolarD4();
            case LADINO: case GUERREIRO: return super.getSabedoria() + D.rolarD6();
            case CACADOR: return super.getSabedoria() + D.rolarD8();
            case MAGO: return super.getSabedoria() + D.rolarD12();
            case LADRAO: return super.getSabedoria()-1 + D.rolarD4();
            default: return -1;
        }
    }

    public static void habilidadeEspecial(Personagem Atacante, Personagem Defensor, Equipamentos.Armas ArmaEscolhida){
        int Dano = 0;
        Dados D = new Dados();
        int X = 0; // para verificar se houve um critico
        int X1 = 0;

        switch(Atacante.classe){

            case BARBARO:
                if(Atacante.checkManasuficiente(8)){
                    X = D.rolarD20();
                    if(X > Defensor.getDefesa()){
                        Dano = 2*Atacante.modificadorForca() + ArmaEscolhida.getDado() + D.rolarD12();
                    }
                    if(Dano <= 0){Dano = 0;}
                    if(X == 20){Dano *= 2;}
                    Defensor.alteraHP(Dano*-1);   
                }else{
                    System.err.println("Não há mana Suficiente para isso !");
                }
                break;

            case CACADOR:
                if(Atacante.checkManasuficiente(6)){
                    X = D.rolarD20();
                    X1 = D.rolarD20();
                    if(X > Defensor.getDefesa() || X1 > Defensor.getDefesa()){
                        Dano = ArmaEscolhida.getDado() + D.rolarD6();
                    }
                    if(Dano <= 0){Dano = 0;}
                    if(X == 20 || X1 == 20){Dano *= 2;}
                    Defensor.alteraHP(Dano*-1);
                }else{
                    System.err.println("Não há mana Suficiente para isso !");
                }
                break;

            case LADINO:
                if(Atacante.checkManasuficiente(7)){
                    X = D.rolarD20();
                    X1 = D.rolarD20();
                    if(X + Atacante.modificadorDestreza() > X1 + Defensor.modificadorSabedoria()){
                        Dano = ArmaEscolhida.getDado() + D.rolarD6() + D.rolarD6();
                    }
                    if(Dano <= 0){Dano = 0;}
                    Defensor.alteraHP(Dano*-1);
                }else{
                    System.err.println("Não há mana Suficiente para isso !");
                }
                break;
        }
}

    // @Overload
    public static void habilidadeEspecial(Personagem Proprio){
        Dados D = new Dados();

        switch(Proprio.classe){

            case GUERREIRO:
                Proprio.alteraHP(D.rolarD10()); // Recuperar Folego
                Proprio.alteraMana(D.rolarD6());
                break;

            case MAGO:
                if(Proprio.checkManasuficiente(Equipamentos.Magias.CURAR.getCustoMana())){
                    Proprio.alteraHP(D.rolarD8()); // Magia de Cura
                }else{
                    System.err.println("Não há mana Suficiente para isso !");
                }
                break;
        }
    }

    public static void usarMagia(Personagem Atacante, Personagem Defensor, Equipamentos.Magias MagiaEscolhida){
        int Dano = 0;
        Dados D = new Dados();

        switch(MagiaEscolhida){

            case BOLA_FOGO:
                if(Atacante.checkManasuficiente(Equipamentos.Magias.BOLA_FOGO.getCustoMana())){
                    Dano += MagiaEscolhida.getDado();
                    if(D.rolarD20()+Defensor.getConstituicao() > 15){Dano /= 2;}
                    Defensor.alteraHP(Dano*-1);                    
                }else{
                    System.err.println("Não há mana Suficiente para isso !");
                }
                break;

            case BOLA_GELO:
                if(Atacante.checkManasuficiente(Equipamentos.Magias.BOLA_GELO.getCustoMana())){
                    Dano += MagiaEscolhida.getDado();
                    if(D.rolarD20()+Defensor.getConstituicao() > 15){Dano /= 2;}
                    Defensor.alteraHP(Dano*-1);
                }else{
                    System.err.println("Não há mana Suficiente para isso !");
                }
                break;

            case RELAMPAGO:
                if(Atacante.checkManasuficiente(Equipamentos.Magias.RELAMPAGO.getCustoMana())){                    
                    Dano += MagiaEscolhida.getDado();
                    Defensor.alteraHP(Dano*-1);
                }else{
                    System.err.println("Não há mana Suficiente para isso !");
                }
                break;
        }
    }

    public static void ataque(Personagem Atacante, Personagem Defensor, Equipamentos.Armas ArmaEscolhida){
        Dados d = new Dados();
        int Dano = 0;
        int X = 0;

        switch(ArmaEscolhida){
            case ESPADALONGA:
            case ESPADA:
                X = d.rolarD20();
                if(X > Defensor.getDefesa()){
                    Dano = Atacante.modificadorForca() + ArmaEscolhida.getDado();
                }
                if(X == 20){Dano *= 2;}
                Defensor.alteraHP(Dano*-1);
            break;

            case ARCOLONGO:
            case ARCOCURTO:
            case ADAGA:
                X = d.rolarD20();
                if(X > Defensor.getDefesa()){
                    Dano = Atacante.modificadorDestreza() + ArmaEscolhida.getDado();
                }
                if(X == 20){Dano *= 2;}
                Defensor.alteraHP(Dano*-1);
            break;
        }

    }

    // Ataque Desarmado aka Soco
    // @Overload
    public static void ataque(Personagem Atacante, Personagem Defensor){
        Dados d = new Dados();
        int Dano = 0;
        int X = 0;

        X = d.rolarD20();
        if(X > Defensor.getDefesa()){
                Dano = Atacante.modificadorForca() + d.rolarD4();
        }
        if(X == 20){Dano *= 2;}
        Defensor.alteraHP(Dano*-1);
    }

}
