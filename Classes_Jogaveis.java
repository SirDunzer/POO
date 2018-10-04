/*
* Essa será a classe abstrata da qual personagem irá herdar
*/

// Overload == Dois ou mais métodos ou construtores com o mesmo nome
// mas assinaturas diferentes

// Override == Redefinir um método herdado de alguma super classe
public interface Classes_Jogaveis{

	public enum Classe{
		BARBARO,
		FEITICEIRO,
		GUERREIRO,
		LADINO,
		MAGO;
	}

	int habilidadeEspecial(Classe classe_escolhida);
	int calcularHP(Classe classe_escolhida);
	/*
	* Habilidades de cada classe:
	*	Barbaro: Ataque furioso, próximo ataque dobra o bonus e adiciona mais 1d20 de dano
	*	Feiticeiro: Usar um feitiço (LISTAR FEITIÇOS)
	* 	Guerreiro: Recuperar Folêgo, regenera 1d10 de HP
	*	Ladino: Ataque Surpresa, alvo rola percepção e vc rola destreza, se seu roll for maior vc da 2d6 a mais de dano
	* 	Mago: Usar uma magia (LISTAR MAGIAS)
	*/
}
