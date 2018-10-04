/*
* Enum do equipamento dos personagens
*/

// O número representa o dano da arma
// No caso da armadura, representa a defesa
// Quando for feito um ataque, será rolado um d20
// Caso d20 > 17 será rolado um d10+bonusForca(caso da espada)
// OU d8+bonusDestreza(caso arco) para calcular o dano do ataque

public class Equipamentos{

	public enum Armas{
		ESPADA,
		ARCOLONGO,
		ADAGA;
	}

        public enum Armaduras{
            LEVE(11),
            MEDIA(14),
            PESADA(17),
            ESCUDO(2);
            
            private final int Valor;
            
            Armaduras(int Valor){
                this.Valor = Valor;
            }
            
            public int getValor(){
                return this.Valor;
            }
            
        }
        
	public enum Magias{
		BOLA_FOGO,
		EMPURRAR,
		CURAR,
		RELAMPAGO;
	}

}
