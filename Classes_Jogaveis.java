/*
* Essa será a classe abstrata da qual personagem irá herdar
*/

// Overload == Dois ou mais métodos ou construtores com o mesmo nome
// mas assinaturas diferentes

// Override == Redefinir um método herdado de alguma super classe
public interface Classes_Jogaveis{

	public enum Classe{
		BARBARO,
		CACADOR,
		GUERREIRO,
		LADINO,
		MAGO;
	}


	// Habilidade de ataque, afeta outro PC
	void habilidadeEspecial(Personagem Atacante, Personagem Defensor);
	// Habilidade passiva, afeta somente a si próprio
    void habilidadeEspecial(Personagem Proprio); // Overload
	int calcularHP(Classe classe_escolhida);
	/*
	* Habilidades de cada classe:
	*	Barbaro: Ataque Furioso, ataque dobra o bonus e adiciona mais 1d12 de dano
	*	Caçador: Ataque Preciso, quando atacar rola 2d20, seleciona o maior e adiciona 1d6 de dano
	* 	Guerreiro: Recuperar Folêgo, regenera 1d10 de HP
	*	Ladino: Ataque Surpresa, alvo rola sabedoria e vc rola destreza, se seu roll for maior vc da 2d6 a mais de dano
	* 	Mago: Usar uma Magia (LISTAR MAGIAS)
	*/
}
