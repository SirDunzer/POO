/*
 * Nessa classe é onde o personagem é definido
 * Essa classe implementa a interfaçe Classe e herda a classe Atributos(por facilidade)
 */

public class Personagem extends Atributos implements Classe_Raca{
    private final String nome;
    private final int HP_Base;
    private final Raca race;
    private final Classe classe;
    private boolean estaVivo;
    private int HP_Atual;
    private int Defesa;
    private int Riquesa;
    private String[] itens_Equipados; // Itens que o personagem tem equipado neste momento
    private String[] itens_Guardados; // Itens não equipados que o personagem tem neste momento

    public Personagem(String nome,Raca race, Classe classe){
        super(race);
       	this.nome = nome;
        this.race = race;
        this.classe = classe;

        this.HP_Base = calcularHP(this.classe);
        this.HP_Atual = this.HP_Base;

        this.itens_Equipados = new String[(this.getDestreza()/3) + 3];
        // Tendo o 3 como base para caso o personagem tenho destreza baixa

        this.itens_Guardados = new String[(this.getConstituicao()/2)+10];
        // Tendo 10 como base para caso o personagem tenha constituicao baixa

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

    public int getDefesa(){
            return this.Defesa;
    }
    
    public int getRiquesa(){
        return this.Riquesa;
    }

    public boolean checkVivo(){
            return this.estaVivo;
    }
        
    public String getStringClasse(){
        String X = null;
        switch(this.classe){
            case BARBARO:
                X = "Barbaro";
                break;
            case GUERREIRO:
                X = "Guerreiro";
                break;
            case LADINO:
                X = "Ladino";
                break;
            case MAGO:
                X = "Mago";
                break;
            case CACADOR:
                X = "Cacador";
                break;
        }
        return X;
    }
    
    public String getStringRaca(){
        String X = null;
        switch(this.race){
            case ANAO:
                X = "Anao";
                break;
            case HUMANO:
                X = "Humano";
                break;
            case ELFO:
                X = "Elfo";
                break;
        }
        return X;
    }

    public Classe getClasse(){
        return this.classe;
    }
    
    public Raca getRaca(){
        return this.race;
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

    @Override
    public String toString(){
        return ""+this.nome+" é um(a) "+this.getStringRaca()+" "+this.getStringClasse()+" e tem os seguintes atributos:\n"+super.toString()+"\n"+this.HP_Base+" Pontos de Vida Base\n"+this.HP_Atual+" Pontos Atuais de Vida\n";
    }

    @Override
    public int calcularHP(Classe classe_escolhida){
        Dados D = new Dados();
        int Output = 0;

        switch(classe_escolhida){

            case BARBARO:
                Output = super.getConstituicao() + D.rolarD12();
            break;

            case MAGO:
                Output = super.getConstituicao() + D.rolarD6();
            break;

            case GUERREIRO:
            case CACADOR:
                Output = super.getConstituicao() + D.rolarD10();
            break;

            case LADINO:
                Output = super.getConstituicao() + D.rolarD8();
            break;

        }
        return Output;
    }

    public static void habilidadeEspecial(Personagem Atacante, Personagem Defensor, Equipamentos.Armas ArmaEscolhida){
        int Dano = 0;
        Dados D = new Dados();
        int X = 0; // para verificar se houve um critico
        int X1 = 0;

        switch(Atacante.classe){

            case BARBARO:
                X = D.rolarD20();
                if(X > Defensor.getDefesa()){
                    Dano = 2*Atacante.modificadorForca() + ArmaEscolhida.getDado() + D.rolarD12();
                }
                if(Dano <= 0){Dano = 0;}
                if(X == 20){Dano *= 2;}
                Defensor.alteraHP(Dano*-1);
                break;

            case CACADOR:
                X = D.rolarD20();
                X1 = D.rolarD20();
                if(X > Defensor.getDefesa() || X1 > Defensor.getDefesa()){
                    Dano = ArmaEscolhida.getDado() + D.rolarD6();
                }
                if(Dano <= 0){Dano = 0;}
                if(X == 20 || X1 == 20){Dano *= 2;}
                Defensor.alteraHP(Dano*-1);
                break;

            case LADINO:
                X = D.rolarD20();
                X1 = D.rolarD20();
                if(X + Atacante.modificadorDestreza() > X1 + Defensor.modificadorSabedoria()){
                    Dano = ArmaEscolhida.getDado() + D.rolarD6() + D.rolarD6();
                }
                if(Dano <= 0){Dano = 0;}
                Defensor.alteraHP(Dano*-1);
                break;
        }
}

    // @Overload
    public static void habilidadeEspecial(Personagem Proprio){
        Dados D = new Dados();

        switch(Proprio.classe){

            case GUERREIRO:
                Proprio.alteraHP(D.rolarD10()); // Recuperar Folego
            break;

            case MAGO:
                Proprio.alteraHP(D.rolarD8()); // Magia de Cura
            break;
        }
    }

    public static void usarMagia(Personagem Atacante, Personagem Defensor, Equipamentos.Magias MagiaEscolhida){
        int Dano = 0;
        Dados D = new Dados();

        switch(MagiaEscolhida){

            case BOLA_FOGO:
                Dano += MagiaEscolhida.getDado();
                if(D.rolarD20()+Defensor.getConstituicao() > 15){Dano /= 2;}
                Defensor.alteraHP(Dano*-1);
                break;

            case BOLA_GELO:
                Dano += MagiaEscolhida.getDado();
                if(D.rolarD20()+Defensor.getConstituicao() > 15){Dano /= 2;}
                Defensor.alteraHP(Dano*-1);
                break;

            case RELAMPAGO:
                Dano += MagiaEscolhida.getDado();
                Defensor.alteraHP(Dano*-1);
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
