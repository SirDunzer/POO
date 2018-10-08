
import java.util.Scanner;

/*
 * Nessa classe é onde será instanciado o personagem e onde ocorrerá todo o loop de execução
 */

public class Main {

    public static void main(String[] args) throws Exception{
        menu();
    }


    public static void menu(){
        int numeroFuncao;
        Scanner scan = new Scanner(System.in);
				int numeroJogadores = 1;
        	System.out.println("======== Gerenciador RPG ========");
					System.out.println("\nQuantos jogadores na grupo?\n : ");
					numeroJogadores = scan.nextInt();
					System.out.flush();

					System.out.println("======== Gerenciador RPG ========");
        	System.out.println("\n\n1 - Criar Personagem");
					System.out.println("\n\n0 - Sair");

        numeroFuncao = scan.nextInt();
        while(numeroFuncao != 0){
					switch(numeroFuncao){
						case 0:
					}
			Personagem Herois = criaPersonagem(numeroJogadores);
    	}


		public static Personagem criaPersonagem(int numeroJogadores){

			Scanner scan = new Scanner(System.in);
			System.out.println("======== Criar Personagem ========");

			System.out.print("Digite o nome do seu Personagem: ");
			String nome = scan.nextLine();

			System.out.println("\nEscolha a Raca: ");
			System.out.println("1 - Anão\n2 - Humano\n3 - Elfo");
			int escolha = scan.nextInt();
			Personagem.Raca raca;
			switch(escolha){
				case 1:
					raca = Personagem.Raca.ANAO;
					break;
				case 2:
					raca = Personagem.Raca.HUMANO;
					break;
				case 3:
					raca = Personagem.Raca.ELFO;
					break;
				default:
					raca = null
					break;
			}

			System.out.print("\nEscolha a Classe: ");
			System.out.println("1 - Barbaro\n2 - Caçador\n3 - Guerreiro\n4 - Ladino\n5 - Mago");
			escolha = scan.nextInt();
			Personagem.Classe classe;
			switch(escolha){
				case 1:
					classe = Personagem.Classe.BARBARO;
					break;
				case 2:
					 classe = Personagem.Classe.CACADOR;
					 break;
				case 3:
					classe = Personagem.Classe.GUERREIRO;
					break;
				case 4:
					 classe = Personagem.Classe.LADINO;
					 break;
				case 5:
					 classe = Personagem.Classe.MAGO;
					 break;
				default:
					 classe = null
					 break;
			}

			Personagem heroi = new Personagem[numeroJogadores];
			heroi = new Personagem(nome,raca,classe);
			return heroi;
			// System.out.println(heroi[i].toString());
		}




}
//            Dados D = new Dados();
//
//            String teste = "MAGO";
//
//            Personagem Jogador1 = new Personagem(nome, Raca.HUMANO, Personagem.Classe.valueOf(teste));
//            Personagem Miguel = new Personagem("Miguel",Raca.HUMANO, Personagem.Classe.BARBARO);
//
//            System.out.println(Jogador1.toString());
//            System.out.println(Miguel.toString());
//
//            Personagem.habilidadeEspecial(Miguel, Jogador1, Equipamentos.Armas.ESPADALONGA);
//
//            System.out.println(Jogador1.getHP_Atual());
//            Folha.salvaInformacoes(Jogador1);
//            Folha.exportaPersonagem(Jogador1);
