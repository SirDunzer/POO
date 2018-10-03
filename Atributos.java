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

    /**
     * @return the forca
     */
    public int getForca() {
        return forca;
    }

    /**
     * @param forca the forca to set
     */
    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * @return the destreza
     */
    public int getdestreza() {
        return destreza;
    }

    /**
     * @param destreza the destreza to set
     */
    public void setdestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * @return the contituicao
     */
    public int getContituicao() {
        return contituicao;
    }

    /**
     * @param contituicao the contituicao to set
     */
    public void setContituicao(int contituicao) {
        this.contituicao = contituicao;
    }

    /**
     * @return the inteligencia
     */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
     * @param inteligencia the inteligencia to set
     */
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    /**
     * @return the sabedoria
     */
    public int getSabedoria() {
        return sabedoria;
    }

    /**
     * @param sabedoria the sabedoria to set
     */
    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    /**
     * @return the carisma
     */
    public int getCarisma() {
        return carisma;
    }

    /**
     * @param carisma the carisma to set
     */
    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

}
