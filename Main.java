/*
 * Nessa classe é onde será instanciado o personagem e onde ocorrerá todo o loop de execução
 */

public class Main {
    public static void main(String[] args) throws Exception{
            Dados D = new Dados();
            
            Personagem Dunzer = new Personagem("Dunzer",D.rolarD20(),D.rolarD20(),D.rolarD20(),D.rolarD20(),D.rolarD20(),D.rolarD20(), Raca.HUMANO, Personagem.Classe.MAGO);
            Personagem Miguel = new Personagem("Miguel",D.rolarD20(),D.rolarD20(),D.rolarD20(),D.rolarD20(),D.rolarD20(),D.rolarD20(),Raca.HUMANO, Personagem.Classe.BARBARO);
            
            System.out.println(Dunzer.toString());
            System.out.println(Miguel.toString());
            
            Personagem.habilidadeEspecial(Miguel, Dunzer);
            
            System.out.println(Dunzer.toString());
            System.out.println(Miguel.toString());
//            Folha.Arquivo(Dunzer);
    }

}
