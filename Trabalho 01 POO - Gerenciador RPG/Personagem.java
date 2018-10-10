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
    private int Defesa; // adicionar método para equipar item e, se for armadura, adicionar a este valor
    private String[] itens_Equipados; // Total de itens que o personagem pode ter equipado
    private String[] itens_Guardados; // Total de itens não equipados que o personagem pode carregar em um dado momento

    public Personagem(String nome,Raca race, Classe classe){
        super(race);
       	this.nome = nome;
        this.race = race;
        this.classe = classe;

        this.HP_Base = calcularHP(this.classe);
        this.HP_Atual = this.HP_Base;

        this.itens_Equipados = new String[(this.getDestreza()/3) + 3];
        // Tendo o 3 como base para caso o personagem tenho destreza baixa
        // Isso significa que um personagem pode, no minÃ­mo, ter 3 itens equipados ao mesmo tempo
        // E, no mÃ¡ximo, 10 eu acho (elfo que rolou 20 para destreza)

        this.itens_Guardados = new String[(this.getConstituicao()/2)+10];
        // Tendo 10 como base para caso o personagem tenha constituicao baixa
        // Isso significa que um personagem pode, no minÃ­mo, carregar 10 itens
        // E, no mÃ¡ximo, 21 eu acho (anÃ£o que rolou 20 para constituicao)

        this.estaVivo = true;
        this.Defesa = 0;
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
        Classe X = null;
        switch(this.classe){
            case BARBARO:
                X = Classe.BARBARO;
                break;
            case GUERREIRO:
                X = Classe.GUERREIRO;
                break;
            case LADINO:
                X = Classe.LADINO;
                break;
            case MAGO:
                X = Classe.MAGO;
                break;
            case CACADOR:
                X = Classe.CACADOR;
                break;
        }
        return X;
    }
    
    public Raca getRaca(){
        Raca X = null;
        switch(this.race){
            case ANAO:
                X = Raca.ANAO;
                break;
            case HUMANO:
                X = Raca.HUMANO;
                break;
            case ELFO:
                X = Raca.ELFO;
                break;
        }
        return X;
    }    
    
    // quando for utilizar este método, deve-se impedir que sejam selecionadas magias
    public void equiparItem(String Equip){
        boolean Equipou = false;

        for(int i=0;i<(super.getDestreza()/3)+3;i++){
            if(this.itens_Equipados[i] == null){
                this.itens_Equipados[i] = Equip;
                Equipou = true;
            }
            if(Equipou){break;}
        }

        if(Equipou){return;}
        else{
            System.err.println(this.nome+" Não pode equipar mais nenhum Item !");
            return;
        }
    }

    public void guardarItem(String Equip){
        boolean Guardou = false;

    for(int i=0;i<(super.getConstituicao()/2)+10;i++){

        if(this.itens_Guardados[i] == null){
            this.itens_Guardados[i] = Equip;
            Guardou = true;
        }
        if(Guardou){break;}
    }

    if(Guardou){return;}
    else{
        System.err.println(this.nome+" Não pode carregar mais nenhum Item !");
        return;
    }
}

    public void alteraHP(int Delta){
            this.HP_Atual += Delta;
            if(Delta <= 0){
                System.out.println(this.nome+" tomou "+Delta+" pontos de Dano !");
            }else{
                System.out.println(this.nome+" regenerou "+Delta+" pontos de HP ");
            }
            System.out.println("O HP Atual de "+this.nome+" é: "+this.getHP_Atual());
            if(this.getHP_Atual() <= 0){
                this.estaVivo = false;
            }
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

    //@overload
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
//	@Overload
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
