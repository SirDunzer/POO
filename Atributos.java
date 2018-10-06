/*
* Essa classe é herdada pela classe personagem
*/

public class Atributos {
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;
    Dados d = new Dados();


    public Atributos(Raca race){

        forca = d.rolarValores();
        destreza = d.rolarValores();
        constituicao = d.rolarValores();
        inteligencia = d.rolarValores();
        sabedoria = d.rolarValores();
        carisma = d.rolarValores();

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
    }

		/*GETTERS*/
    public int getForca() {
    	return forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

	@Override
	public String toString(){
		return "Força: "+forca+"\nDestreza: "+destreza+"\nConstituição: "+constituicao+"\nInteligência: "+inteligencia+"\nSabedoria: "+sabedoria+"\nCarisma: "+carisma+"\n";
	}

	public int modificadorForca(){
		if(forca == 1){
			return -5;
		}else if(forca == 2 || forca == 3){
			return -4;
		}else if(forca == 4 || forca == 5){
			return -3;
		}else if(forca == 6 || forca == 7){
			return -2;
		}else if(forca == 8 || forca == 9){
			return -1;
		}else if(forca == 10|| forca == 11){
			return 0;
		}else if(forca == 12 || forca == 13){
			return 1;
		}else if(forca == 14 || forca == 15){
			return 2;
		}else if(forca == 16 || forca == 17){
			return 3;
		}else if(forca == 18 || forca == 19){
			return 4;
		}else if(forca == 20){
			return 5;
		}else if(forca > 20){
			return 6;
		}
        return 0;
	}

	public int modificadorDestreza(){
		if(destreza == 1){
			return -5;
		}else if(destreza == 2 || destreza == 3){
			return -4;
		}else if(destreza == 4 || destreza == 5){
			return -3;
		}else if(destreza == 6 || destreza == 7){
			return -2;
		}else if(destreza == 8 || destreza == 9){
			return -1;
		}else if(destreza == 10|| destreza == 11){
			return 0;
		}else if(destreza == 12 || destreza == 13){
			return 1;
		}else if(destreza == 14 || destreza == 15){
			return 2;
		}else if(destreza == 16 || destreza == 17){
			return 3;
		}else if(destreza == 18 || destreza == 19){
			return 4;
		}else if(destreza == 20){
			return 5;
		}else if(destreza > 20){
			return 6;
		}
        return 0;
	}

	public int modificadorConstituicao(){
		if(constituicao == 1){
			return -5;
		}else if(constituicao == 2 || constituicao == 3){
			return -4;
		}else if(constituicao == 4 || constituicao == 5){
			return -3;
		}else if(constituicao == 6 || constituicao == 7){
			return -2;
		}else if(constituicao == 8 || constituicao == 9){
			return -1;
		}else if(constituicao == 10|| constituicao == 11){
			return 0;
		}else if(constituicao == 12 || constituicao == 13){
			return 1;
		}else if(constituicao == 14 || constituicao == 15){
			return 2;
		}else if(constituicao == 16 || constituicao == 17){
			return 3;
		}else if(constituicao == 18 || constituicao == 19){
			return 4;
		}else if(constituicao == 20){
			return 5;
		}else if(constituicao > 20){
			return 6;
		}
        return 0;
	}

	public int modificadorInteligencia(){
		if(inteligencia == 1){
			return -5;
		}else if(inteligencia == 2 || inteligencia == 3){
			return -4;
		}else if(inteligencia == 4 || inteligencia == 5){
			return -3;
		}else if(inteligencia == 6 || inteligencia == 7){
			return -2;
		}else if(inteligencia == 8 || inteligencia == 9){
			return -1;
		}else if(inteligencia == 10|| inteligencia == 11){
			return 0;
		}else if(inteligencia == 12 || inteligencia == 13){
			return 1;
		}else if(inteligencia == 14 || inteligencia == 15){
			return 2;
		}else if(inteligencia == 16 || inteligencia == 17){
			return 3;
		}else if(inteligencia == 18 || inteligencia == 19){
			return 4;
		}else if(inteligencia == 20){
			return 5;
		}else if(inteligencia > 20){
			return 6;
		}
        return 0;
	}

	public int modificadorSabedoria(){
		if(sabedoria == 1){
			return -5;
		}else if(sabedoria == 2 || sabedoria == 3){
			return -4;
		}else if(sabedoria == 4 || sabedoria == 5){
			return -3;
		}else if(sabedoria == 6 || sabedoria == 7){
			return -2;
		}else if(sabedoria == 8 || sabedoria == 9){
			return -1;
		}else if(sabedoria == 10|| sabedoria == 11){
			return 0;
		}else if(sabedoria == 12 || sabedoria == 13){
			return 1;
		}else if(sabedoria == 14 || sabedoria == 15){
			return 2;
		}else if(sabedoria == 16 || sabedoria == 17){
			return 3;
		}else if(sabedoria == 18 || sabedoria == 19){
			return 4;
		}else if(sabedoria == 20){
			return 5;
		}else if(sabedoria > 20){
			return 6;
		}
        return 0;
	}

	public int modificadorCarisma(){
		if(carisma == 1){
			return -5;
		}else if(carisma == 2 || carisma == 3){
			return -4;
		}else if(carisma == 4 || carisma == 5){
			return -3;
		}else if(carisma == 6 || carisma == 7){
			return -2;
		}else if(carisma == 8 || carisma == 9){
			return -1;
		}else if(carisma == 10|| carisma == 11){
			return 0;
		}else if(carisma == 12 || carisma == 13){
			return 1;
		}else if(carisma == 14 || carisma == 15){
			return 2;
		}else if(carisma == 16 || carisma == 17){
			return 3;
		}else if(carisma == 18 || carisma == 19){
			return 4;
		}else if(carisma == 20){
			return 5;
		}else if(carisma > 20){
			return 6;
		}
        return 0;
	}

}
