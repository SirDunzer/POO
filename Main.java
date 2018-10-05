/*
 * Nessa classe é onde será instanciado o personagem e onde ocorrerá todo o loop de execução
 */

public class Main {
    public static void main(String[] args) throws Exception{
		Personagem Dunzer = new Personagem("Dunzer",1,2,3,4,5,6, Raca.HUMANO, Personagem.Classe.MAGO);
		System.out.println(Dunzer.toString());
		Folha.Arquivo(Dunzer);
    }

}
