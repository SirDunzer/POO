/*
* Enum do equipamento dos personagens
*/

// O número representa o dano da arma
// No caso da armadura, representa a defesa
// Quando for feito um ataque, será rolado um d20
// Caso d20 > 17 será rolado um d10+bonusForca(caso da espada)
// OU d8+bonusDestreza(caso arco) para calcular o dano do ataque
public enum Equipamento{
	ESPADA(10),
	ARCOLONGO(8),
	ARMADURA(17);

	private int Valor;

	public int getValor(){
		return this.Valor;
	}
}
