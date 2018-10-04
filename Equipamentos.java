/*
* Enum do equipamento dos personagens
*/

public class Equipamentos{

	public enum Armas{
		ESPADALONGA, // Dano: 1d10
		ESPADA,      // Dano: 1d8
		ARCOLONGO,   // Dano: 2d6
		ARCOCURTO,	 // Dano: 1d6
		ADAGA;	     // Dano: 1d4
	}

    public enum Armaduras{ // O valor é o valor de defesa da armadura
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

	public enum Magias{ // Ignoram a armadura, mas se o alvo rolar +15 de const toma metade do dano
		BOLA_FOGO, // Dano: 3d4
		BOLA_GELO, // Dano: 2d6
		RELAMPAGO, // Dano: 1d10
		CURAR;	   // Regenera: 1d8 de HP
	}

}
