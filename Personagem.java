/*
 * Nessa classe é onde é definido o personagem
 * Essa classe implementa a interfaçe Classe e herda a classe Atributos(por facilidade)
 */

 import java.util.Random;
 private static Random rolarDado = new Random();

public class Personagem implements Classe, extends Atributos{
    private String nome;
	private int HP;
	private int Dano_Base;
	// Métodos de ataque (importados de classe)

    public Personagem(String nome, int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma, Raca race){
		switch(race){

			case ANAO:
				constituicao += 2;

			case ELFO:
				destreza += 2;

			case HUMANO:
				forca += 1;
				destreza += 1;
				constituicao += 1;
				inteligencia += 1;
				sabedoria += 1;
				carisma += 1;
		}
       	super(forca, destreza, constituicao, inteligencia, sabedoria, carisma);
       	this.nome = nome;
		this.HP = constituicao + rolarDado(12);
		this.Dano_Base = forca + rolarDado(20);
		// Dano_Base afeta o dano de ataque de armas brancas
		// Dano mágico é afetado por outra coisa
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
