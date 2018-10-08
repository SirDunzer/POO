
import java.util.Scanner;

/*
 * Nessa classe é onde será instanciado o personagem e onde ocorrerá todo o loop de execução
 */

public class Main {

    public static void main(String[] args) throws Exception{
        menu();
    }


    public static void menu() throws Exception{
        int numeroFuncao = 1;
        Scanner scan = new Scanner(System.in);
        int numeroJogadores = 1;
        System.out.println("\n======== Gerenciador RPG ========");
	System.out.print("\nQuantos jogadores na grupo?\n : ");
	numeroJogadores = scan.nextInt();
        int N_MAX = 0;
        
        while(numeroFuncao != 0){
            System.out.println("\n======== Gerenciador RPG ========");
            System.out.println("1 - Criar Personagem");
            System.out.println("2 - Mostrar Informacoes dos Personagens");
            System.out.println("3 - Salvar Informacoes");
            System.out.println("\n\n0 - Sair");
            System.out.print("\n\nEscolha: ");
            numeroFuncao = scan.nextInt();
            Personagem[] Herois = null;
		switch(numeroFuncao){
                    case 1:
                        if(N_MAX < numeroJogadores){
                            Herois = criaPersonagem(numeroJogadores, N_MAX);
                            N_MAX++;
                        }
                        else System.out.println("Grupo lotado!");
                        break;
                    case 2:
                        for(int i = 0; i < N_MAX; i++){
                            System.out.println(Herois[N_MAX].toString());
                        }
                        break;
                    case 3:
                        for(int i = 0; i < N_MAX; i++){
                            Folha.exportaPersonagem(Herois[i]);
                        }
                        break;
                    case 4:
                        System.out.println("\n======== Ataque Magico ========");
                        System.out.println("Atacante: ");
                        for(int i = 0; i < N_MAX; i++){
                            System.out.println((i+1)+" - "+Herois[i].getNome());
                        }
                        int atacante = scan.nextInt()-1;
                        
                        System.out.println("Defensor: ");
                        for(int i = 0; i < N_MAX; i++){
                            System.out.println((i+1)+" - "+Herois[i].getNome());
                        }
                        int defensor = scan.nextInt()-1;
                        
                        System.out.println("Magias: ");
                        System.out.println("1 - Bola de Fogo ");
                        System.out.println("2 - Bola de Gelo ");
                        System.out.println("3 - Relampago ");
                        int magiaEscolhida = scan.nextInt();
                        Equipamentos.Magias magia;
                            switch(magiaEscolhida){
				case 1:
					magia = Equipamentos.Magias.BOLA_FOGO;
					break;
				case 2:
					magia = Equipamentos.Magias.BOLA_GELO;
					break;
				case 3:
					magia = Equipamentos.Magias.RELAMPAGO;
					break;
                                default:
                                    magia = null;
                                    break;
                            }
                        Personagem.usarMagia(Herois[atacante], Herois[defensor], magia);
		}
			
    	}
    }


		public static Personagem[] criaPersonagem(int numeroJogadores, int N_MAX){

			Scanner scan = new Scanner(System.in);
			System.out.println("\n======== Criar Personagem ========");

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
					raca = null;
					break;
			}

			System.out.println("\nEscolha a Classe: ");
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
					 classe = null;
					 break;
			}

			Personagem[] heroi = new Personagem[numeroJogadores];
			heroi[N_MAX] = new Personagem(nome,raca,classe);
			return heroi;
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
