
import java.util.Scanner;

/*
 * Nessa classe é onde será instanciado o personagem e onde ocorrerá todo o loop de execução
 */

public class Main {
    public static void main(String[] args) throws Exception{
            Scanner scan = new Scanner(System.in);
            System.out.println("======== Criar Personagem ========");
            System.out.print("Digite o nome do seu Personagem: ");
            String nome = scan.nextLine();

            Dados D = new Dados();
            
            String teste = "MAGO";
            
            Personagem Jogador1 = new Personagem(nome, Raca.HUMANO, Personagem.Classe.valueOf(teste));
            Personagem Miguel = new Personagem("Miguel",Raca.HUMANO, Personagem.Classe.BARBARO);

            System.out.println(Jogador1.toString());
            System.out.println(Miguel.toString());

            Personagem.habilidadeEspecial(Miguel, Jogador1, Equipamentos.Armas.ESPADALONGA);

            System.out.println(Jogador1.getHP_Atual());
            Folha.salvaInformacoes(Jogador1);
            Folha.exportaPersonagem(Jogador1);
    }

}
