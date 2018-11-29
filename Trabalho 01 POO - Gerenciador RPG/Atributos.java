
public class Atributos {
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;
    Dados d = new Dados();


    public Atributos(Classe_Raca.Raca raca){

        forca = d.rolarValores();
        destreza = d.rolarValores();
        constituicao = d.rolarValores();
        inteligencia = d.rolarValores();
        sabedoria = d.rolarValores();
        carisma = d.rolarValores();

        switch(raca){
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
            
            case ORC:
                forca += 1;
                destreza += 1;
                constituicao += 2;
                inteligencia -= 1;
                sabedoria -= 1;
                carisma -= 2;
                break;
                
            case GOBLIN:
                destreza += 2;
                constituicao -= 1;
                forca -= 1;
                break;
                
            case GIGANTE:
                forca += 5;
                constituicao += 3;
                destreza -= 3;
                inteligencia -= 4;
                sabedoria -= 5;
                carisma -= 6;
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
    
    public String toWriteableString(){
        return ""+this.forca+";"+this.destreza+";"+this.constituicao+";"+this.inteligencia+";"+this.sabedoria+";"+this.carisma;
    }

    public int modificadorForca(){

        switch(this.forca){
            case 1:
                    return -5;
            case 2: case 3:
                    return -4;
            case 4: case 5:
                    return -3;
            case 6: case 7:
                    return -2;
            case 8: case 9:
                    return -1;
            case 10: case 11:
                    return 0;
            case 12: case 13:
                    return 1;
            case 14: case 15:
                    return 2;
            case 16: case 17:
                    return 3;
            case 18: case 19:
                    return 4;
            case 20:
                    return 5;
            default:
                    return 6;
        }
    }

    public int modificadorDestreza(){

        switch(this.destreza){
            case 1:
                    return -5;
            case 2: case 3:
                    return -4;
            case 4: case 5:
                    return -3;
            case 6: case 7:
                    return -2;
            case 8: case 9:
                    return -1;
            case 10: case 11:
                    return 0;
            case 12: case 13:
                    return 1;
            case 14: case 15:
                    return 2;
            case 16: case 17:
                    return 3;
            case 18: case 19:
                    return 4;
            case 20:
                    return 5;
            default:
                    return 6;
        }
    }

    public int modificadorConstituicao(){

        switch(this.constituicao){
            case 1:
                    return -5;
            case 2: case 3:
                    return -4;
            case 4: case 5:
                    return -3;
            case 6: case 7:
                    return -2;
            case 8: case 9:
                    return -1;
            case 10: case 11:
                    return 0;
            case 12: case 13:
                    return 1;
            case 14: case 15:
                    return 2;
            case 16: case 17:
                    return 3;
            case 18: case 19:
                    return 4;
            case 20:
                    return 5;
            default:
                    return 6;
        }
    }

    public int modificadorInteligencia(){

        switch(this.inteligencia){
            case 1:
                    return -5;
            case 2: case 3:
                    return -4;
            case 4: case 5:
                    return -3;
            case 6: case 7:
                    return -2;
            case 8: case 9:
                    return -1;
            case 10: case 11:
                    return 0;
            case 12: case 13:
                    return 1;
            case 14: case 15:
                    return 2;
            case 16: case 17:
                    return 3;
            case 18: case 19:
                    return 4;
            case 20:
                    return 5;
            default:
                    return 6;
        }
    }

    public int modificadorSabedoria(){

        switch(this.sabedoria){
            case 1:
                    return -5;
            case 2: case 3:
                    return -4;
            case 4: case 5:
                    return -3;
            case 6: case 7:
                    return -2;
            case 8: case 9:
                    return -1;
            case 10: case 11:
                    return 0;
            case 12: case 13:
                    return 1;
            case 14: case 15:
                    return 2;
            case 16: case 17:
                    return 3;
            case 18: case 19:
                    return 4;
            case 20:
                    return 5;
            default:
                    return 6;
        }
    }

    public int modificadorCarisma(){

       switch(this.carisma){
            case 1:
                    return -5;
            case 2: case 3:
                    return -4;
            case 4: case 5:
                    return -3;
            case 6: case 7:
                    return -2;
            case 8: case 9:
                    return -1;
            case 10: case 11:
                    return 0;
            case 12: case 13:
                    return 1;
            case 14: case 15:
                    return 2;
            case 16: case 17:
                    return 3;
            case 18: case 19:
                    return 4;
            case 20:
                    return 5;
            default:
                    return 6;
        }
    }

}
