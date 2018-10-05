/*
* Enum do equipamento dos personagens
*/

public class Equipamentos{

	public enum Armas{
		ESPADALONGA, // Dano: 1d10 + força
		ESPADA,      // Dano: 1d8  + força
		ARCOLONGO,   // Dano: 1d8  + destreza
		ARCOCURTO,	 // Dano: 1d6  + destreza
		ADAGA;	     // Dano: 1d4  + destreza
	}

    public enum Armaduras{ // O número é o valor de defesa da armadura
        LEVE(12),
        MEDIA(14),
        PESADA(18),
        ESCUDO(2);

        private final int Valor;

        Armaduras(int Valor){
            this.Valor = Valor;
        }

        public int getValor(){
            return this.Valor;
        }

    }

	public enum Magias{ // Ignoram a armadura, mas se o alvo rolar (d20+const > 15) toma metade do dano
		BOLA_FOGO, // Dano: 3d4
		BOLA_GELO, // Dano: 2d6
		RELAMPAGO, // Dano: 1d10 + Sempre da dano cheio
		CURAR;	   // Regenera: 1d8 de HP
	}

}
