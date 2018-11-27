public interface Classe_Raca{

    public enum Classe{
        BARBARO,
	CACADOR,
	GUERREIRO,
	LADINO,
	MAGO,
        BANDIDO; // ladino só que pior || somente para NPCs inimigos
    }

    public enum Raca { // adicionar a classe NPC
        ANAO,
        ELFO,
        HUMANO,
        GOBLIN, // somente para NPCs inimigos
        ORC,    // somente para NPCs inimigos
        OGRO,   // somente para NPCs inimigos
        GIGANTE;// somente para NPCs inimigos
    }
    
    int calcularHP(Classe classe_escolhida);
    int calcularMana(Classe classe_escolhida);
    String getStringClasse();
    String getStringRaca();
    Classe getClasse();
    Raca getRaca();
    Classe gerarClasseJogavelAleatoria(); // Usar na fachada quando for criar um NPC
    Raca gerarRacaJogavelAleatoria();     // Usar na fachada quando for criar um NPC
    Classe gerarClasseAleatoria();
    Raca gerarRacaAleatoria();
    /*
    * Habilidades de cada classe:
    *	Barbaro: Ataque Furioso, ataque dobra o bonus e adiciona mais 1d12 de dano, custa 8 de Mana
    *	Caçador: Ataque Preciso, quando atacar rola 2d20, seleciona o maior e adiciona 1d6 de dano, custa 6 de Mana
    * 	Guerreiro: Recuperar Folêgo, regenera 1d10 de HP, 1 d6 de Mana, não custa Mana
    *	Ladino: Ataque Surpresa, alvo rola sabedoria e vc rola destreza, se seu roll for maior vc da 2d6 a mais de dano, custa 7 de mana
    * 	Mago: Usar uma Magia, custo de mana depende da magia
    */
}
