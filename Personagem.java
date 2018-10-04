/*
 * Nessa classe é onde é definido o personagem
 * Essa classe implementa a interfaçe Classe e herda a classe Atributos(por facilidade)
 * Falta fazer métodos estáticos para atacar e defender
 */

 import java.util.Random;
 private static Random rolarDado = new Random();

public class Personagem extends Atributos implements Classe{
    private String nome;
	private int HP;
	private int Dano_Base;

    public Personagem(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, Raca race){

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
		this.HP = constituicao + rolarDado(12);
		this.Dano_Base = forca + rolarDado(20);
		// Dano_Base afeta o dano de ataque de armas brancas
    }

    public String getNome() {
    	return nome;
    }

	public int getHP() {
		return HP;
	}

	public int getDano_Base() {
		return Dano_Base;
	}

}
