class Equipamentos{

    public enum Armas{
        ESPADALONGA, // Dano: 1d10 + força
        MACHADO,     // Dano: 1d8  + força
        ESPADA,      // Dano: 1d6  + força
        ARCOLONGO,   // Dano: 1d8  + destreza
        ARCOCURTO,   // Dano: 1d6  + destreza
        ADAGA;	     // Dano: 1d4  + destreza

        public int getDado(){
            int Output=0;
            Dados D = new Dados();
            switch(this){
                case ESPADALONGA: Output = D.rolarD10(); break;
                case MACHADO: Output = D.rolarD8(); break;
                case ESPADA: Output = D.rolarD6(); break;
                case ARCOLONGO: Output = D.rolarD8(); break;
                case ARCOCURTO: Output = D.rolarD6(); break;
                case ADAGA: Output = D.rolarD4(); break;
            }
            return Output;
        }
        
        public int getPeso(){
            switch(this){
                case ESPADALONGA: return 5;
                case MACHADO: return 4;
                case ESPADA: return 3;
                case ARCOLONGO: return 3;
                case ARCOCURTO: return 2;
                case ADAGA: return 1;
                default: return 0;
            }
        }

        @Override
        public String toString(){
            String Output = null;

            switch(this){
                case ESPADALONGA: Output = "Espada Longa"; break;
                case MACHADO: Output = "Machado de Guerra"; break;
                case ESPADA: Output = "Espada"; break;
                case ARCOLONGO: Output = "Arco Longo"; break;
                case ARCOCURTO: Output = "Arco Curto"; break;
                case ADAGA: Output = "Adaga"; break;
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
        
        public int getPeso(){
            switch(this){
                case LEVE: return 9;
                case MEDIA: return 12;
                case PESADA: return 15;
                case ESCUDO: return 2;
                default: return 0;
            }
        }

        @Override
        public String toString(){
            String Output = null;

            switch(this){
                case LEVE: Output = "Armadura Leve"; break;
                case MEDIA: Output = "Armadura Media"; break;
                case PESADA: Output = "Armadura Pesada"; break;
                case ESCUDO: Output = "Escudo"; break;
            }
            return Output;
        }
    }

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
        
        public int getCustoMana(){
            switch(this){
                case BOLA_FOGO: return 6;
                case BOLA_GELO: return 5;
                case RELAMPAGO: return 10;
                case CURAR: return 4;
                default: return 0;
            }
        }
    }
    
    public enum Itens{
        FRUTA        (0),
        POCAO_HP     (10),
        POCAO_MANA   (12),
        TESOURO      (100);
        
        private final int Valor;

        Itens(int Valor){
            this.Valor = Valor;
        }

        public int getValor(){
            return this.Valor;
        }
        
        public int getPeso(){
            switch(this){
                case FRUTA: return 0;
                case POCAO_HP: case POCAO_MANA: return 1;
                case TESOURO: return 10;
                default: return 0;                
            }
        }
        
        @Override
        public String toString(){
            switch(this){
                case FRUTA: return "Fruta";
                case POCAO_HP: return "Poção de HP";
                case POCAO_MANA: return "Poção de Mana";
                case TESOURO: return "Tesouro";
                default: return null;
            }
        }
        
    }
}
