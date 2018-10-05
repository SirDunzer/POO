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

		public int getDado(){
			int Output=0;
			Dados D = new Dados();
			switch(this){
				case ESPADALONGA: Output = D.rolarD10(); break;
				case ESPADA: Output = D.rolarD8(); break;
				case ARCOLONGO: Output = D.rolarD8(); break;
				case ARCOCURTO: Output = D.rolarD6(); break;
				case ADAGA: Output = D.rolarD4(); break;
			}
			return Output;
		}

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

        // Magos não precisam equipar magias
        // Eles sempre terão elas
	public enum Magias{ // Ignoram a armadura, mas se o alvo rolar (d20+const > 15) toma metade do dano
		BOLA_FOGO, // Dano: 3d4
		BOLA_GELO, // Dano: 2d6
		RELAMPAGO, // Dano: 1d10 + Sempre da dano cheio
		CURAR;	   // Regenera: 1d8 de HP

		public int getDado(){
			int Output=0;
			Dados D = new Dados();
			switch(this){
				case BOLA_FOGO: Output = D.rolarD4() + D.rolarD4() + D.rolarD4(); break;
				case BOLA_GELO: Output = D.rolarD6() + D.rolarD6(); break;
				case RELAMPAGO: Output = D.rolarD10(); break;
			}
			return Output;
		}

	}

        @Override
        public String toString(){
			String Output=null;

            if(this.instanceof(Armas)){

				switch(this){
					case ESPADALONGA: Output = "Espada Longa"; break;
					case ESPADA: Output = "Espada"; break;
					case ARCOLONGO: Output = "Arco Longo"; break;
					case ARCOCURTO: Output = "ARCOCURTO"; break;
					case ADAGA: Output = "ADAGA"; break;
				}

			}else if(this.instanceof(Armaduras)){

				switch(this){
					case LEVE: Output = "Armadura Leve"; break;
					case MEDIA: Output = "Armadura Media"; break;
					case PESADA: Output = "Armadura Pesada"; break;
					case ESCUDO: Output = "Escudo"; break;
				}

			}else if(this.instanceof(Magias)){

				switch(this){
					case BOLA_FOGO: Output = "Bola de Fogo"; break;
					case BOLA_GELO: Output = "Bola de Gelo"; break;
					case RELAMPAGO: Output = "Relampago"; break;
					case CURAR: Output = "Cura"; break;
				}

			}
			return Output;
        }

}
