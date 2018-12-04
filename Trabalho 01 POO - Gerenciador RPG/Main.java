public class Main {

    public static void main(String[] args) throws Exception{
        // Aqui ao invés deste menu() eu instancio objetos da façade, da interface gráfica e do dao
        // talvez passando eles como argumentos uns aos outros.
    }


//    public static void menu() throws Exception{
//        int numeroFuncao = 1;
//        Scanner scan = new Scanner(System.in);
//        int numeroJogadores = 0;
//        System.out.println("\n======== Gerenciador RPG ========");
//	System.out.print("\nQuantos jogadores na grupo?:\n");
//	numeroJogadores = scan.nextInt();
//        Personagem[] Herois = null;
//        
//        while(numeroFuncao != 0){
//            System.out.println("\n======== Gerenciador RPG ========");
//            System.out.println("1 - Criar Personagem");
//            System.out.println("2 - Mostrar Informacoes dos Personagens");
//            System.out.println("3 - Salvar Informacoes");
//            System.out.println("4 - Ataque Mágico");
//            System.out.println("5 - Ataque Com Arma");
//            System.out.println("6 - Ataque Desarmado");
//            System.out.println("7 - Habilidade Especial");
//            System.out.println("\n\n0 - Sair");
//            System.out.print("\n\nEscolha: ");
//            numeroFuncao = scan.nextInt();
//            switch(numeroFuncao){
//                    
//                case 1:
//                    Herois = criaPersonagem(numeroJogadores);
//                    System.out.println("Personagem(ns) Criado(s) com Sucesso");
//                    break;
//
//                case 2:
//
//                    if(Herois == null){
//                        System.out.println("Nenhum personagem Cadastrado");
//                    }else{                        
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println(Herois[i].toString());
//                        }
//                    }
//                    break;
//
//                case 3:
//                    for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                        Folha.exportaPersonagem(Herois[i]);
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("\n========Ataque Magico ========");
//                    System.out.println("Atacante: ");
//                    for(int i = 0; i < numeroJogadores && Herois[i] != null; i++){
//                        System.out.println((i+1)+" - "+Herois[i].getNome());
//                    }
//                    int atacante = scan.nextInt()-1;
//
//                    System.out.println("Defensor: ");
//                    for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                        System.out.println((i+1)+" - "+Herois[i].getNome());
//                    }
//                    int defensor = scan.nextInt()-1;
//
//                    System.out.println("Magias: ");
//                    System.out.println("1 - Bola de Fogo ");
//                    System.out.println("2 - Bola de Gelo ");
//                    System.out.println("3 - Relampago ");
//                    int magiaEscolhida = scan.nextInt();
//                    Inventario.Equipamentos.Magias magia;
//                    switch(magiaEscolhida){
//                        case 1:
//                            magia = Inventario.Equipamentos.Magias.BOLA_FOGO;
//                            break;
//                        case 2:
//                            magia = Inventario.Equipamentos.Magias.BOLA_GELO;
//                            break;
//                        case 3:
//                            magia = Inventario.Equipamentos.Magias.RELAMPAGO;
//                            break;
//                        default:
//                            magia = null;
//                            break;
//                    }
//                    Personagem.usarMagia(Herois[atacante], Herois[defensor], magia);
//                    
//                    if(!(Herois[defensor].checkVivo())){
//                        System.out.println(Herois[defensor].getNome()+" Morreu !");
//                        Herois[defensor] = null;
//                    }
//                    break;
//                        
//                    case 5: // ataque com arma
//
//                        System.out.println("\n========Ataque com Arma========");
//                        System.out.println("Atacante: ");
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int atk = scan.nextInt()-1;
//
//                        System.out.println("Defensor: ");
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int dfs = scan.nextInt()-1;
//
//                        System.out.println("Armas: ");
//                        System.out.println("1 - Espada Longa");
//                        System.out.println("2 - Espada");
//                        System.out.println("3 - Arco Longo");
//                        System.out.println("4 - Arco Curto");
//                        System.out.println("5 - Adaga");
//                        int armaEscolhida = scan.nextInt();
//                        Inventario.Equipamentos.Armas arma;
//                        switch(armaEscolhida){
//                            case 1:
//                                arma = Inventario.Equipamentos.Armas.ESPADALONGA;
//                                break;
//                            case 2:
//                                arma = Inventario.Equipamentos.Armas.ESPADA;
//                                break;
//                            case 3:
//                                arma = Inventario.Equipamentos.Armas.ARCOLONGO;
//                                break;
//                            case 4:
//                                arma = Inventario.Equipamentos.Armas.ARCOCURTO;
//                                break;
//                            case 5:
//                                arma = Inventario.Equipamentos.Armas.ADAGA;
//                                break;
//                            default:
//                                arma = null;
//                                break;
//                        }
//                        Personagem.ataque(Herois[atk], Herois[dfs], arma);
//                        
//                        if(!(Herois[dfs].checkVivo())){
//                            System.out.println(Herois[dfs].getNome()+" Morreu !");
//                            Herois[dfs] = null;
//                        }
//                        
//                        break;
//                        
//                    case 6: // ataque sem arma
//                        System.out.println("\n========Ataque com Arma========");
//                        System.out.println("Atacante: ");
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int atacante1 = scan.nextInt()-1;
//                        
//                        System.out.println("Defensor: ");
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int defensor1 = scan.nextInt()-1;
//                        
//                        Personagem.ataque(Herois[atacante1], Herois[defensor1]);
//                        if(!(Herois[defensor1].checkVivo())){
//                           System.out.println(Herois[defensor1].getNome()+" Morreu !");
//                            Herois[defensor1] = null;
//                        }
//                        break;
//                        
//                    case 7: // habilidade especial
//                        System.out.println("\n========Habilidade Especial========");
//                        System.out.println("Selecione o Primeiro Jogador: ");
//                        
//                        for(int i = 0; i < numeroJogadores && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int principal = scan.nextInt()-1;
//                        
//                        switch(Herois[principal].getClasse()){
//                         
//                            case GUERREIRO:
//                            case MAGO:
//                                Personagem.habilidadeEspecial(Herois[principal]);
//                                break;
//                                
//                            case LADINO:
//                            case CACADOR:
//                            case BARBARO:
//                                
//                                System.out.println("Selecione o Alvo: ");
//
//                                for(int i = 0; i < numeroJogadores; i++){
//                                    System.out.println((i+1)+" - "+Herois[i].getNome());
//                                }
//                                int alvo = scan.nextInt()-1;
//                                
//                                System.out.println("Escolha sua Arma:");
//                                System.out.println("1 - Espada Longa");
//                                System.out.println("2 - Espada");
//                                System.out.println("3 - Arco Longo");
//                                System.out.println("4 - Arco Curto");
//                                System.out.println("5 - Adaga");
//                                int armaEscolhida2 = scan.nextInt();
//                                Inventario.Equipamentos.Armas arma2;
//                                switch(armaEscolhida2){
//                                    case 1:
//                                        arma2 = Inventario.Equipamentos.Armas.ESPADALONGA;
//                                        break;
//                                    case 2:
//                                        arma2 = Inventario.Equipamentos.Armas.ESPADA;
//                                        break;
//                                    case 3:
//                                        arma2 = Inventario.Equipamentos.Armas.ARCOLONGO;
//                                        break;
//                                    case 4:
//                                        arma2 = Inventario.Equipamentos.Armas.ARCOCURTO;
//                                        break;
//                                    case 5:
//                                        arma2 = Inventario.Equipamentos.Armas.ADAGA;
//                                        break;
//                                    default:
//                                        arma2 = null;
//                                        break;
//                                }
//                                
//                                Personagem.habilidadeEspecial(Herois[principal], Herois[alvo], arma2);
//                                if(!(Herois[alvo].checkVivo())){
//                                    System.out.println(Herois[alvo].getNome()+" Morreu !");
//                                    Herois[alvo] = null;
//                                }
//                                break;
//                        }
//                        
//                        break;
//		}	
//    	}
//    }
//
//
//    public static Personagem[] criaPersonagem(int numeroJogadores){
//
//        Personagem[] heroi = new Personagem[numeroJogadores];
//        Scanner scan = new Scanner(System.in);
//        String nome = null;
//        int escolha = 0;
//        Personagem.Raca raca;
//        Personagem.Classe classe;
//
//        for(int i = 0; i<numeroJogadores;i++){
//
//            System.out.println("\n======== Criar Personagem ========");
//
//            System.out.print("Digite o nome do seu Personagem: ");
//            nome = scan.nextLine();
//
//            System.out.println("\nEscolha a Raca: ");
//            System.out.println("1 - Anão\n2 - Humano\n3 - Elfo");
//            escolha = scan.nextInt();
//            switch(escolha){
//                case 1:
//                    raca = Personagem.Raca.ANAO;
//                    break;
//                case 2:
//                    raca = Personagem.Raca.HUMANO;
//                    break;
//                case 3:
//                    raca = Personagem.Raca.ELFO;
//                    break;
//                default:
//                    raca = null;
//                    break;
//            }
//
//            System.out.println("\nEscolha a Classe: ");
//            System.out.println("1 - Barbaro\n2 - Caçador\n3 - Guerreiro\n4 - Ladino\n5 - Mago");
//            escolha = scan.nextInt();
//            switch(escolha){
//                case 1:
//                    classe = Personagem.Classe.BARBARO;
//                    break;
//                case 2:
//                    classe = Personagem.Classe.CACADOR;
//                    break;
//                case 3:
//                    classe = Personagem.Classe.GUERREIRO;
//                    break;
//                case 4:
//                    classe = Personagem.Classe.LADINO;
//                    break;
//                case 5:
//                    classe = Personagem.Classe.MAGO;
//                    break;
//                default:
//                    classe = null;
//                    break;
//            }
//            heroi[i] = new Personagem(nome,raca,classe);
//            scan.nextLine();
//        }
//        return heroi;
//    }
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) throws Exception{
//        // Aqui ao invés deste menu() eu instancio objetos da façade, da interface gráfica e do dao
//        // talvez passando eles como argumentos uns aos outros.
//        menu();
//    }
//
//
//    public static void menu() throws Exception{
//        int numeroFuncao = 1;
//        Scanner scan = new Scanner(System.in);
//        int numeroJogadores = 0;
//        System.out.println("\n======== Gerenciador RPG ========");
//	System.out.print("\nQuantos jogadores na grupo?:\n");
//	numeroJogadores = scan.nextInt();
//        Personagem[] Herois = null;
//        
//        while(numeroFuncao != 0){
//            System.out.println("\n======== Gerenciador RPG ========");
//            System.out.println("1 - Criar Personagem");
//            System.out.println("2 - Mostrar Informacoes dos Personagens");
//            System.out.println("3 - Salvar Informacoes");
//            System.out.println("4 - Ataque Mágico");
//            System.out.println("5 - Ataque Com Arma");
//            System.out.println("6 - Ataque Desarmado");
//            System.out.println("7 - Habilidade Especial");
//            System.out.println("\n\n0 - Sair");
//            System.out.print("\n\nEscolha: ");
//            numeroFuncao = scan.nextInt();
//            switch(numeroFuncao){
//                    
//                case 1:
//                    Herois = criaPersonagem(numeroJogadores);
//                    System.out.println("Personagem(ns) Criado(s) com Sucesso");
//                    break;
//
//                case 2:
//
//                    if(Herois == null){
//                        System.out.println("Nenhum personagem Cadastrado");
//                    }else{                        
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println(Herois[i].toString());
//                        }
//                    }
//                    break;
//
//                case 3:
//                    for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                        Folha.exportaPersonagem(Herois[i]);
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("\n========Ataque Magico ========");
//                    System.out.println("Atacante: ");
//                    for(int i = 0; i < numeroJogadores && Herois[i] != null; i++){
//                        System.out.println((i+1)+" - "+Herois[i].getNome());
//                    }
//                    int atacante = scan.nextInt()-1;
//
//                    System.out.println("Defensor: ");
//                    for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                        System.out.println((i+1)+" - "+Herois[i].getNome());
//                    }
//                    int defensor = scan.nextInt()-1;
//
//                    System.out.println("Magias: ");
//                    System.out.println("1 - Bola de Fogo ");
//                    System.out.println("2 - Bola de Gelo ");
//                    System.out.println("3 - Relampago ");
//                    int magiaEscolhida = scan.nextInt();
//                    Inventario.Equipamentos.Magias magia;
//                    switch(magiaEscolhida){
//                        case 1:
//                            magia = Inventario.Equipamentos.Magias.BOLA_FOGO;
//                            break;
//                        case 2:
//                            magia = Inventario.Equipamentos.Magias.BOLA_GELO;
//                            break;
//                        case 3:
//                            magia = Inventario.Equipamentos.Magias.RELAMPAGO;
//                            break;
//                        default:
//                            magia = null;
//                            break;
//                    }
//                    Personagem.usarMagia(Herois[atacante], Herois[defensor], magia);
//                    
//                    if(!(Herois[defensor].checkVivo())){
//                        System.out.println(Herois[defensor].getNome()+" Morreu !");
//                        Herois[defensor] = null;
//                    }
//                    break;
//                        
//                    case 5: // ataque com arma
//
//                        System.out.println("\n========Ataque com Arma========");
//                        System.out.println("Atacante: ");
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int atk = scan.nextInt()-1;
//
//                        System.out.println("Defensor: ");
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int dfs = scan.nextInt()-1;
//
//                        System.out.println("Armas: ");
//                        System.out.println("1 - Espada Longa");
//                        System.out.println("2 - Espada");
//                        System.out.println("3 - Arco Longo");
//                        System.out.println("4 - Arco Curto");
//                        System.out.println("5 - Adaga");
//                        int armaEscolhida = scan.nextInt();
//                        Inventario.Equipamentos.Armas arma;
//                        switch(armaEscolhida){
//                            case 1:
//                                arma = Inventario.Equipamentos.Armas.ESPADALONGA;
//                                break;
//                            case 2:
//                                arma = Inventario.Equipamentos.Armas.ESPADA;
//                                break;
//                            case 3:
//                                arma = Inventario.Equipamentos.Armas.ARCOLONGO;
//                                break;
//                            case 4:
//                                arma = Inventario.Equipamentos.Armas.ARCOCURTO;
//                                break;
//                            case 5:
//                                arma = Inventario.Equipamentos.Armas.ADAGA;
//                                break;
//                            default:
//                                arma = null;
//                                break;
//                        }
//                        Personagem.ataque(Herois[atk], Herois[dfs], arma);
//                        
//                        if(!(Herois[dfs].checkVivo())){
//                            System.out.println(Herois[dfs].getNome()+" Morreu !");
//                            Herois[dfs] = null;
//                        }
//                        
//                        break;
//                        
//                    case 6: // ataque sem arma
//                        System.out.println("\n========Ataque com Arma========");
//                        System.out.println("Atacante: ");
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int atacante1 = scan.nextInt()-1;
//                        
//                        System.out.println("Defensor: ");
//                        for(int i = 0; i < numeroJogadores  && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int defensor1 = scan.nextInt()-1;
//                        
//                        Personagem.ataque(Herois[atacante1], Herois[defensor1]);
//                        if(!(Herois[defensor1].checkVivo())){
//                           System.out.println(Herois[defensor1].getNome()+" Morreu !");
//                            Herois[defensor1] = null;
//                        }
//                        break;
//                        
//                    case 7: // habilidade especial
//                        System.out.println("\n========Habilidade Especial========");
//                        System.out.println("Selecione o Primeiro Jogador: ");
//                        
//                        for(int i = 0; i < numeroJogadores && Herois[i] != null; i++){
//                            System.out.println((i+1)+" - "+Herois[i].getNome());
//                        }
//                        int principal = scan.nextInt()-1;
//                        
//                        switch(Herois[principal].getClasse()){
//                         
//                            case GUERREIRO:
//                            case MAGO:
//                                Personagem.habilidadeEspecial(Herois[principal]);
//                                break;
//                                
//                            case LADINO:
//                            case CACADOR:
//                            case BARBARO:
//                                
//                                System.out.println("Selecione o Alvo: ");
//
//                                for(int i = 0; i < numeroJogadores; i++){
//                                    System.out.println((i+1)+" - "+Herois[i].getNome());
//                                }
//                                int alvo = scan.nextInt()-1;
//                                
//                                System.out.println("Escolha sua Arma:");
//                                System.out.println("1 - Espada Longa");
//                                System.out.println("2 - Espada");
//                                System.out.println("3 - Arco Longo");
//                                System.out.println("4 - Arco Curto");
//                                System.out.println("5 - Adaga");
//                                int armaEscolhida2 = scan.nextInt();
//                                Inventario.Equipamentos.Armas arma2;
//                                switch(armaEscolhida2){
//                                    case 1:
//                                        arma2 = Inventario.Equipamentos.Armas.ESPADALONGA;
//                                        break;
//                                    case 2:
//                                        arma2 = Inventario.Equipamentos.Armas.ESPADA;
//                                        break;
//                                    case 3:
//                                        arma2 = Inventario.Equipamentos.Armas.ARCOLONGO;
//                                        break;
//                                    case 4:
//                                        arma2 = Inventario.Equipamentos.Armas.ARCOCURTO;
//                                        break;
//                                    case 5:
//                                        arma2 = Inventario.Equipamentos.Armas.ADAGA;
//                                        break;
//                                    default:
//                                        arma2 = null;
//                                        break;
//                                }
//                                
//                                Personagem.habilidadeEspecial(Herois[principal], Herois[alvo], arma2);
//                                if(!(Herois[alvo].checkVivo())){
//                                    System.out.println(Herois[alvo].getNome()+" Morreu !");
//                                    Herois[alvo] = null;
//                                }
//                                break;
//                        }
//                        
//                        break;
//		}	
//    	}
//    }
//
//
//    public static Personagem[] criaPersonagem(int numeroJogadores){
//
//        Personagem[] heroi = new Personagem[numeroJogadores];
//        Scanner scan = new Scanner(System.in);
//        String nome = null;
//        int escolha = 0;
//        Personagem.Raca raca;
//        Personagem.Classe classe;
//
//        for(int i = 0; i<numeroJogadores;i++){
//
//            System.out.println("\n======== Criar Personagem ========");
//
//            System.out.print("Digite o nome do seu Personagem: ");
//            nome = scan.nextLine();
//
//            System.out.println("\nEscolha a Raca: ");
//            System.out.println("1 - Anão\n2 - Humano\n3 - Elfo");
//            escolha = scan.nextInt();
//            switch(escolha){
//                case 1:
//                    raca = Personagem.Raca.ANAO;
//                    break;
//                case 2:
//                    raca = Personagem.Raca.HUMANO;
//                    break;
//                case 3:
//                    raca = Personagem.Raca.ELFO;
//                    break;
//                default:
//                    raca = null;
//                    break;
//            }
//
//            System.out.println("\nEscolha a Classe: ");
//            System.out.println("1 - Barbaro\n2 - Caçador\n3 - Guerreiro\n4 - Ladino\n5 - Mago");
//            escolha = scan.nextInt();
//            switch(escolha){
//                case 1:
//                    classe = Personagem.Classe.BARBARO;
//                    break;
//                case 2:
//                    classe = Personagem.Classe.CACADOR;
//                    break;
//                case 3:
//                    classe = Personagem.Classe.GUERREIRO;
//                    break;
//                case 4:
//                    classe = Personagem.Classe.LADINO;
//                    break;
//                case 5:
//                    classe = Personagem.Classe.MAGO;
//                    break;
//                default:
//                    classe = null;
//                    break;
//            }
//            heroi[i] = new Personagem(nome,raca,classe);
//            scan.nextLine();
//        }
//        return heroi;
//    }
}