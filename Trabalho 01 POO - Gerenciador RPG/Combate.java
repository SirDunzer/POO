/*
* Aqui será modelado o sistema geral de combate
* isso inclui turnos, uso de itens, ataques, tentativas de fuga, etc.
* O sistema de combate deverá ser instanciado somente uma vez durante o loop de execução principal
*/
public class Combate {
    // usa um loop while(true) que executa ataques e tudo mais -- loop principal do combate
    // caso/quando um personagem morrer o loop acaba (o combate acaba)
    
    public void loop(Personagem atacante, Personagem defensor){
        
        while(true){
            // prompt(atacante, armaEscolhida);
            // prompt(atacante, tipo ataque);
            //TODO: perguntar ao usuário qual arma ele quer usar
            //TODO: perguntar ao usuário que tipo de ataque ele vai dar
        }
        
    }
    
    static class Ataque{
    
        // A Mágia é escolhida antes
        public static void AtaqueMagico(Personagem atacante, Personagem defensor, Inventario.Equipamentos.Magias magiaEscolhida) throws Exception{
            int Dano = 0;
            Dados D = new Dados();

            switch(magiaEscolhida){

                case BOLA_FOGO:
                    if(atacante.getMana_Atual() >= Equipamentos.Magias.BOLA_FOGO.getCustoMana()){
                        Dano += magiaEscolhida.getDado();
                        if(D.rolarD20()+defensor.getConstituicao() > 15){Dano /= 2;}
                        defensor.alteraHP(Dano*-1);                    
                    }else{
                        throw new ExcecaoCombate("Não há Mana Suficiente");
                    }
                    break;

                case BOLA_GELO:
                    if(atacante.getMana_Atual() >= Equipamentos.Magias.BOLA_GELO.getCustoMana()){
                        Dano += magiaEscolhida.getDado();
                        if(D.rolarD20()+defensor.getConstituicao() > 15){Dano /= 2;}
                        defensor.alteraHP(Dano*-1);
                    }else{
                        throw new ExcecaoCombate("Não há Mana Suficiente");
                    }
                    break;

                case RELAMPAGO:
                    if(atacante.getMana_Atual() >= Equipamentos.Magias.RELAMPAGO.getCustoMana()){                    
                        Dano += magiaEscolhida.getDado();
                        defensor.alteraHP(Dano*-1);
                    }else{
                        throw new ExcecaoCombate("Não há Mana Suficiente");
                    }
                    break;
            }
        }
        
        // A arma é escolhida antes
        public static void AtaqueArmado(Personagem atacante, Personagem defensor, Inventario.Equipamentos.Armas armaEscolhida){
            Dados d = new Dados();
            int Dano = 0;
            int X;

            switch(armaEscolhida){
                case ESPADALONGA:
                case MACHADO:
                case ESPADA:
                    X = d.rolarD20();
                    if(X > defensor.getDefesa()){
                        Dano = atacante.modificadorForca() + armaEscolhida.getDado();
                    }
                    if(X == 20){Dano *= 2;}
                    defensor.alteraHP((Dano*-1) + (int)(defensor.getDefesa()/4));
                break;

                case ARCOLONGO:
                case ARCOCURTO:
                case ADAGA:
                    X = d.rolarD20();
                    if(X > defensor.getDefesa()){
                        Dano = atacante.modificadorDestreza() + armaEscolhida.getDado();
                    }
                    if(X == 20){Dano *= 2;}
                    defensor.alteraHP((Dano*-1) + (int)(defensor.getDefesa()/4));
                break;
            }
        }

        // Ataque Desarmado
        public static void AtaqueDesarmado(Personagem atacante, Personagem defensor){
            Dados d = new Dados();
            int Dano = 0;
            int X = 0;

            X = d.rolarD20();
            if(X > defensor.getDefesa()){
                Dano = atacante.modificadorForca() + d.rolarD4();
            }
            if(X == 20){Dano *= 2;}
            defensor.alteraHP(Dano*-1);
        }
        
        public static void habilidadeEspecial(Personagem[] Envolvidos, Inventario.Equipamentos.Armas... armaEscolhida) throws Exception{
            int Dano = 0;
            Dados D = new Dados();
            int X; // para verificar se houve um critico
            int X1;
            
            int escolha = 0; /*perguntar ao usuário qual arma ele pretende usar*/
            
            if(Envolvidos.length > 1){ // há mais de um personagem => um atacante e um defensor
                
                switch(Envolvidos[0].getClasse()){
                    case BARBARO:
                        if(Envolvidos[0].getMana_Atual() >= 8){
                            X = D.rolarD20();
                            if(X > Envolvidos[1].getDefesa()){
                                Dano = 2*Envolvidos[0].modificadorForca() + armaEscolhida[].getDado() + D.rolarD12();
                            }
                            if(Dano <= 0){Dano = 0;}
                            if(X == 20){Dano *= 2;}
                            Envolvidos[1].alteraHP(Dano*-1);   
                        }else{
                            System.err.println("Não há mana Suficiente para isso !");
                        }
                        break;

                    case CACADOR:
                        if(Envolvidos[0].getMana_Atual() >= 6){
                            X = D.rolarD20();
                            X1 = D.rolarD20();
                            if(X > Envolvidos[1].getDefesa() || X1 > Envolvidos[1].getDefesa()){
                                Dano = armaEscolhida.getDado() + D.rolarD6();
                            }
                            if(Dano <= 0){Dano = 0;}
                            if(X == 20 || X1 == 20){Dano *= 2;}
                            Envolvidos[1].alteraHP(Dano*-1);
                        }else{
                            System.err.println("Não há mana Suficiente para isso !");
                        }
                        break;

                    case LADINO:
                        if(Envolvidos[0].getMana_Atual() >= 7){
                            X = D.rolarD20();
                            X1 = D.rolarD20();
                            if(X + Envolvidos[0].modificadorDestreza() > X1 + Envolvidos[1].modificadorSabedoria()){
                                Dano = armaEscolhida.getDado() + D.rolarD6() + D.rolarD6();
                            }
                            if(Dano <= 0){Dano = 0;}
                            Envolvidos[1].alteraHP(Dano*-1);
                        }else{
                            System.err.println("Não há mana Suficiente para isso !");
                        }
                        break;
                }
                
            }else{ // há 1 personagem, que vai usar sua habilidade em si próprio
                switch(Envolvidos[0].getClasse()){
                    case GUERREIRO:
                        Envolvidos[0].alteraHP(D.rolarD10()); // Recuperar Folego
                        Envolvidos[0].alteraMana(D.rolarD6());
                        break;

                    case MAGO:
                        if(Envolvidos[0].getMana_Atual() >= Inventario.Equipamentos.Magias.CURAR.getCustoMana()){
                            Envolvidos[0].alteraHP(D.rolarD8()); // Magia de Cura
                        }else{
                            throw new ExcecaoCombate("Não há Mana Suficiente");
                        }
                        break;
                }
            }
        }
    }
}
