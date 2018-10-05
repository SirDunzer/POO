/*
 * Nessa classe é onde o personagem é definido
 * Essa classe implementa a interfaçe Classe e herda a classe Atributos(por facilidade)
 */


public class Personagem extends Atributos implements Classes_Jogaveis{
    private final String nome;
	private final int HP_Base;
	private final Raca race;
	private final Classe classe;
	private int HP_Atual;
	private int Defesa; // adicionar método para equipar item e, se for armadura, adicionar a este valor
	private String[] itens_Equipados; // Total de itens que o personagem pode ter equipado
	private String[] itens_Guardados; // Total de itens não equipados que o personagem pode carregar em um dado momento

    public Personagem(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, Raca race, Classe classe){

        super(forca, destreza, constituicao, inteligencia, sabedoria, carisma, race);
       	this.nome = nome;
        this.race = race;
        this.classe = classe;

        this.HP_Base = calcularHP(this.classe);
        this.HP_Atual = this.HP_Base;

        this.itens_Equipados = new String[(destreza/3) + 3];
        // Tendo o 3 como base para caso o personagem tenho destreza baixa
        // Isso significa que um personagem pode, no minÃ­mo, ter 3 itens equipados ao mesmo tempo
        // E, no mÃ¡ximo, 10 eu acho (elfo que rolou 20 para destreza)

        this.itens_Guardados = new String[(constituicao/2)+10];
        // Tendo 10 como base para caso o personagem tenha constituicao baixa
        // Isso significa que um personagem pode, no minÃ­mo, carregar 10 itens
        // E, no mÃ¡ximo, 21 eu acho (anÃ£o que rolou 20 para constituicao)
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

    @Override
	public String toString(){
        return ""+this.nome+" tem os seguintes atributos:\n"+super.toString()+"\n"+this.HP_Base+" Pontos de Vida Base\n"+this.HP_Atual+" Pontos Atuais de Vida\n";
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

	// fazer condição de morte
	public void alteraHP(int Delta){
		this.HP_Atual += Delta;
	}


    @Override
	public void habilidadeEspecial(Personagem Atacante, Personagem Defensor){
		int Dano;
        Dados D = new Dados();
		Dados X = null; // para verificar se houve um critico
		Dados X1 = null;

		switch(this.classe){ // Falta calcular a defesa

			case BARBARO:
				X = D.rolarD20();
				if(X > Defensor.getDefesa()){        // Alterar
					Dano = 2*Atacante.bonusForca() + D.rolarD10() + D.rolarD12();
				}
				if(X == 20){Dano *= 2;}
				Defensor.alteraHP(Dano*-1);
			break;

			case CACADOR:
				X = D.rolarD20();
				X1 = D.rolarD20();
				if(X > Defensor.getDefesa() || X1 > Defensor.getDefesa()){
					Dano = D.rolarD8() + D.rolarD6();
				}
				if(X == 20 || X1 == 20){Dano *= 2;}
				Defensor.alteraHP(Dano*-1);
			break;

			case LADINO:
				X = D.rolarD20();
				X1 = D.rolarD20();
				if(X + Atacante.bonusDestreza() > X1 + Defensor.bonusSabedoria()){
					Dano = D.rolarD4() + D.rolarD6() + D.rolarD6();
					Defensor.alteraHP(Dano*-1);
				}
			break;

			case MAGO:
				// selecionar a magia e aplicar o dano
			break;

		}

	}

	@Override
	public void habilidadeEspecial(Personagem Proprio){
		Dados D = new Dados();

		switch(Proprio){

			case GUERREIRO:
				Proprio.alteraHP(D.rolarD10());
			break;

			case MAGO:
				Proprio.alteraHP(D.rolarD8());
			break;

		}

	}

	// refazer o ataque, usando o enum de
	// equipamentos para calcular o dano e a defesa

}
