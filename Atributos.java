/*
* Essa classe será herdada pela classe personagem
*/

public class Atributos {
    private int forca;
    private int destreza;
    private int contituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;


    public Atributos(int forca, int destreza, int constituicao, int inteligencia, int sabedoria, int carisma){
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }

		/*GETTERS*/
    public int getForca() {
        return this.forca;
    }

	public int getdestreza() {
		return this.destreza;
	}

	public int getContituicao() {
		return this.contituicao;
	}

	public int getInteligencia() {
		return this.inteligencia;
	}

	public int getSabedoria() {
		return this.sabedoria;
	}

	public int getCarisma() {
		return this.carisma;
	}

		/*SETTERS*/
	public void setForca(int forca) {
		this.forca = forca;
	}

    public void setdestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setContituicao(int contituicao) {
        this.contituicao = contituicao;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

	@Override
	public String toString(){
		return "Força: "+this.forca+" Destreza: "+this.destreza+" Constituição: "+this.constituicao+" Sabedoria: "+this.sabedoria+" Inteligência: "+this.inteligencia;
	}

	public int bonusForca(){
		if(this.forca == 1){
			return -5;
		}else if(this.forca == 2 || this.forca == 3){
			return -4;
		}else if(this.forca == 4 || this.forca == 5){
			return -3;
		}else if(this.forca == 6 || this.forca == 7){
			return -2;
		}else if(this.forca == 8 || this.forca == 9){
			return -1;
		}else if(this.forca == 10|| this.forca == 11){
			return 0;
		}else if(this.forca == 12 || this.forca == 13){
			return 1;
		}else if(this.forca == 14 || this.forca == 15){
			return 2;
		}else if(this.forca == 16 || this.forca == 17){
			return 3;
		}else if(this.forca == 18 || this.forca == 19){
			return 4;
		}else if(this.forca == 20){
			return 5;
		}else if(this.forca > 20){
			return 6;
		}
	}

	public int bonusDestreza(){
		if(this.destreza == 1){
			return -5;
		}else if(this.destreza == 2 || this.destreza == 3){
			return -4;
		}else if(this.destreza == 4 || this.destreza == 5){
			return -3;
		}else if(this.destreza == 6 || this.destreza == 7){
			return -2;
		}else if(this.destreza == 8 || this.destreza == 9){
			return -1;
		}else if(this.destreza == 10|| this.destreza == 11){
			return 0;
		}else if(this.destreza == 12 || this.destreza == 13){
			return 1;
		}else if(this.destreza == 14 || this.destreza == 15){
			return 2;
		}else if(this.destreza == 16 || this.destreza == 17){
			return 3;
		}else if(this.destreza == 18 || this.destreza == 19){
			return 4;
		}else if(this.destreza == 20){
			return 5;
		}else if(this.destreza > 20){
			return 6;
		}
	}

	public int bonusConstituicao(){
		if(this.constituicao == 1){
			return -5;
		}else if(this.constituicao == 2 || this.constituicao == 3){
			return -4;
		}else if(this.constituicao == 4 || this.constituicao == 5){
			return -3;
		}else if(this.constituicao == 6 || this.constituicao == 7){
			return -2;
		}else if(this.constituicao == 8 || this.constituicao == 9){
			return -1;
		}else if(this.constituicao == 10|| this.constituicao == 11){
			return 0;
		}else if(this.constituicao == 12 || this.constituicao == 13){
			return 1;
		}else if(this.constituicao == 14 || this.constituicao == 15){
			return 2;
		}else if(this.constituicao == 16 || this.constituicao == 17){
			return 3;
		}else if(this.constituicao == 18 || this.constituicao == 19){
			return 4;
		}else if(this.constituicao == 20){
			return 5;
		}else if(this.constituicao > 20){
			return 6;
		}
	}

	public int bonusInteligencia(){
		if(this.inteligencia == 1){
			return -5;
		}else if(this.inteligencia == 2 || this.inteligencia == 3){
			return -4;
		}else if(this.inteligencia == 4 || this.inteligencia == 5){
			return -3;
		}else if(this.inteligencia == 6 || this.inteligencia == 7){
			return -2;
		}else if(this.inteligencia == 8 || this.inteligencia == 9){
			return -1;
		}else if(this.inteligencia == 10|| this.inteligencia == 11){
			return 0;
		}else if(this.inteligencia == 12 || this.inteligencia == 13){
			return 1;
		}else if(this.inteligencia == 14 || this.inteligencia == 15){
			return 2;
		}else if(this.inteligencia == 16 || this.inteligencia == 17){
			return 3;
		}else if(this.inteligencia == 18 || this.inteligencia == 19){
			return 4;
		}else if(this.inteligencia == 20){
			return 5;
		}else if(this.inteligencia > 20){
			return 6;
		}
	}

	public int bonusSabedoria(){
		if(this.sabedoria == 1){
			return -5;
		}else if(this.sabedoria == 2 || this.sabedoria == 3){
			return -4;
		}else if(this.sabedoria == 4 || this.sabedoria == 5){
			return -3;
		}else if(this.sabedoria == 6 || this.sabedoria == 7){
			return -2;
		}else if(this.sabedoria == 8 || this.sabedoria == 9){
			return -1;
		}else if(this.sabedoria == 10|| this.sabedoria == 11){
			return 0;
		}else if(this.sabedoria == 12 || this.sabedoria == 13){
			return 1;
		}else if(this.sabedoria == 14 || this.sabedoria == 15){
			return 2;
		}else if(this.sabedoria == 16 || this.sabedoria == 17){
			return 3;
		}else if(this.sabedoria == 18 || this.sabedoria == 19){
			return 4;
		}else if(this.sabedoria == 20){
			return 5;
		}else if(this.sabedoria > 20){
			return 6;
		}
	}

	public int bonusCarisma(){
		if(this.carisma == 1){
			return -5;
		}else if(this.carisma == 2 || this.carisma == 3){
			return -4;
		}else if(this.carisma == 4 || this.carisma == 5){
			return -3;
		}else if(this.carisma == 6 || this.carisma == 7){
			return -2;
		}else if(this.carisma == 8 || this.carisma == 9){
			return -1;
		}else if(this.carisma == 10|| this.carisma == 11){
			return 0;
		}else if(this.carisma == 12 || this.carisma == 13){
			return 1;
		}else if(this.carisma == 14 || this.carisma == 15){
			return 2;
		}else if(this.carisma == 16 || this.carisma == 17){
			return 3;
		}else if(this.carisma == 18 || this.carisma == 19){
			return 4;
		}else if(this.carisma == 20){
			return 5;
		}else if(this.carisma > 20){
			return 6;
		}
	}

}
