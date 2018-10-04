/*
 * Nessa classe é onde é definido o personagem
 * Essa classe implementa a interfaçe Classe e herda a classe Atributos(por facilidade)
 * Falta fazer métodos estáticos para atacar e defender
 */

 import java.util.Random;

public class Personagem extends Atributos implements Classes_Jogaveis{
    private String nome;
	private int HP_Base;
	private int HP_Atual;
	private int dano_Base;
	private String[] itens_Equipados; // Total de itens que o personagem pode ter equipado
	private String[] itens_Guardados; // Total de itens não equipados que o personagem pode carregar em um dado momento
	private static Random rolarDado = new Random();

    public Personagem(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, Raca race, Classe classe){

		switch(race){

			case ANAO:
				constituicao += 2;
				break;

			case ELFO:
				destreza += 2;
				break;

			case HUMANO:
				forca += 1;
				destreza += 1;
				constituicao += 1;
				inteligencia += 1;
				sabedoria += 1;
				carisma += 1;
				break;
		}
       	super(forca, destreza, constituicao, inteligencia, sabedoria, carisma);
       	this.nome = nome;

		this.HP_Base = calcularHP(classe);
		this.HP_Atual = this.HP_Base;

		// dano_Base afeta o dano de ataque de armas brancas
		this.dano_Base = forca + rolarDado.nextInt(20)+1;
		// nextInt gera um int aleatório de 0 até (limite dado)-1, portanto
		// para gerar um int de 1 até limite dado é necessário somar 1

		this.itens_Equipados = new String[(destreza/3) + 3];
		// Tendo o 3 como base para caso o personagem tenho destreza baixa
		// Isso significa que um personagem pode, no minímo, ter 3 itens equipados ao mesmo tempo
		// E, no máximo, 10 eu acho (elfo que rolou 20 para destreza)

		this.itens_Guardados = new String[(constituicao/2)+10];
		// Tendo 10 como base para caso o personagem tenha constituicao baixa
		// Isso significa que um personagem pode, no minímo, carregar 10 itens
		// E, no máximo, 21 eu acho (anão que rolou 20 para constituicao)
    }

    public String getNome() {
    	return nome;
    }

	public int getHP_Base() {
		return HP_Base;
	}

	public int getdano_Base() {
		return dano_Base;
	}

	@ Override
	public String toString(){
		return ""+this.nome+"tem os seguintes atributos:\n"+super.toString()+"\nTem "+this.HP_Base+" pontos de Vida Base\nTem "+this.HP_Atual+"Ponto de Vida Atualmenten\nSeu dano base é: "+this.dano_Base;
	}

	@Override
	public int calcularHP(Classe classe_escolhida){

		switch(classe_escolhida){

			case BARBARO:
				return this.constituicao + rolarDado.nextInt(12)+1;
			break;

			case FEITICEIRO:
			case MAGO:
				return this.constituicao + rolarDado.nextInt(6)+1;
			break;

			case GUERREIRO:
				return this.constituicao + rolarDado.nextInt(10)+1;
			break;

			case LADINO:
				return this.constituicao + rolarDado.nextInt(8)+1;
			break;

		}
	}


}
