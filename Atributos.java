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
        this.contituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }

		/*GETTERS*/
    public int getForca() {
        return forca;
    }

	public int getdestreza() {
		return destreza;
	}

	public int getContituicao() {
		return contituicao;
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

}
