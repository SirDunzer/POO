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
    	return nome;
    }

    public int getHP_Base() {
        return HP_Base;
    }

    @Override
    public String toString(){
        return ""+this.nome+"tem os seguintes atributos:\n"+super.toString()+"\nTem "+this.HP_Base+" pontos de Vida Base\nTem "+this.HP_Atual+"Ponto de Vida Atualmenten\n";
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

    @Override
	public void habilidadeEspecial(Personagem Atacante, Personagem Defensor){
		int Dano;
        Dados D = new Dados();

		switch(this.classe){

			case BARBARO: // alterar para combinar com os valores corretos de armas e armaduras
				if(D.rolarD20() > 16){
					Dano = 2*Atacante.bonusForca() + D.rolarD10() + D.rolarD12();
					// reduzir HP
				}
			break;

			case CACADOR:
				if(D.rolarD20() > 16 || D.rolarD20() > 16){
					Dano = D.rolarD8() + D.rolarD6();
					// reduzir HP
				}
			break;

			case GUERREIRO: // mover para habilidade própria
				Atacante.HP_Atual += D.rolarD10();
			break;

			case LADINO:
				if(D.rolarD20()+Atacante.bonusDestreza() > D.rolarD20()+Defensor.bonusSabedoria()){
					Dano = D.rolarD4() + D.rolarD6() + D.rolarD6();
					// reduzir HP
				}
			break;

			case MAGO:

			break;

		}

	}

	@Override
	public void habilidadeEspecial(Personagem Proprio){

	}

	// refazer o ataque, usando o enum de
	// equipamentos para calcular o dano e a defesa

}
