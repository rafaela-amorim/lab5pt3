package Cenarios;

import lab5.Validador;

/**
 * Representação de um cenario com bonus, extensão de cenário
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class CenarioBonus extends Cenario {

	private int bonus;
	
	// Construtor
	
	/**
	 * Construtor da classe, recebe a descrição do cenário, a porcentagem que é a
	 * taxa usada para calcular o dinheiro do caixa do Sistema quando as apostas
	 * forem fechadas, e o bônus que é o dinheiro distribuído pelo Sistema aos
	 * vencedores da aposta.
	 * 
	 * @param descricao
	 *            Descrição do cenário
	 * @param porcentagem
	 *            Porcentagem direcionada ao caixa do Sistema
	 * @param bonus
	 *            Bônus de dinheiro somado ao rateio para os vencedores da aposta.
	 */
	public CenarioBonus(String descricao, double porcentagem, int bonus, int id) {
		super(descricao, porcentagem, id);
		try {
			this.bonus = Validador.bonusCenario(bonus);
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + i.getMessage());
		}
	}
	
	// Métodos
	
	/**
	 * @return Retorna o bônus do cenário
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * Calcula o montante de dinheiro a ser distribuído entre os vencedores caso o
	 * cenário já tenha sido fechado.
	 * 
	 * @return Rateio do cenário
	 */
	@Override
	public int calculaRateio() {
		return super.calculaRateio() + bonus;
	}

	/**
	 * Representação textual do cenário.
	 */
	@Override
	public String toString() {
		double aux = bonus / 100.0;
		return super.toString() + " - R$ " + String.format("%1$,.2f", aux);
	}
}
