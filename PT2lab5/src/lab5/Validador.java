package lab5;

/**
 * Classe validadora do sistema, verifica possiveis exceções
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class Validador {
	
	/**
	 * Testa se o nome do Apostador, usado na classe Aposta, não é nulo nem um
	 * argumento vazio.
	 * 
	 * @param nomeAp
	 *            nome do apostador
	 * @return Retorna a própria String se for válida.
	 */
	public static String nomeApostador(String nomeAp) {
		if (nomeAp == null) {
			throw new NullPointerException("Apostador nao pode ser vazio ou nulo");
		}
		if (nomeAp.trim().length() == 0) {
			throw new IllegalArgumentException("Apostador nao pode ser vazio ou nulo");
		}
		return nomeAp;
	}

	/**
	 * Testa a previsão da classe Aposta, se não é nem nula nem argumento vazio.
	 * 
	 * @param previsao
	 *            Previsão da aposta
	 * @return Retorna a própria String se for válida.
	 */
	public static String previsaoAposta(String previsao) {
		if (previsao == null) {
			throw new NullPointerException("Previsao nao pode ser vazia ou nula");
		}
		if (previsao.trim().length() == 0) {
			throw new IllegalArgumentException("Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER"))) {
			throw new IllegalArgumentException("Previsao invalida");
		}
		return previsao;
	}

	/**
	 * Testa se o valor da aposta é um número válido, no caso, um valor positivo.
	 * 
	 * @param valor
	 *            valor da aposta
	 * @return Retorna o próprio valor se for válido.
	 */
	public static int valorAposta(int valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor nao pode ser menor ou igual a zero");
		}
		return valor;
	}

	/**
	 * Testa se a descrição do cenário é um argumento válido, não é nulo nem vazio.
	 * 
	 * @param descricao
	 *            descrição do cenário.
	 * @return Retorna a própria String se for válida.
	 */
	public static String descricaoCenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException("Descricao nao pode ser nula");
		}
		if (descricao.trim().length() == 0) {
			throw new IllegalArgumentException("Descricao nao pode ser vazia");
		}
		return descricao;
	}

	/**
	 * Verifica se o número do cenário é válido.
	 * 
	 * @param index
	 *            número identificador do cenário.
	 * @return Retorna o próprio valor se for válido.
	 */
	public static int indexCenarioSistema(int index) {
		if (index < 1) {
			throw new IllegalAccessError("Cenario invalido");
		}
		return index;
	}

	/**
	 * Verifica se o cenário ainda está aberto para aplciações que necessitam do
	 * cenário fechado para o bom funcionamento.
	 * 
	 * @param estado
	 *            Estado do cenário.
	 */
	public static void cenarioAberto(String estado) {
		if (estado.equals("Nao finalizado")) {
			throw new IllegalAccessError("Cenario ainda esta aberto");
		}
	}

	/**
	 * Verifica se o cenário já foi fechado.
	 * 
	 * @param estado
	 *            Estado do cenário
	 */
	public static void cenarioFechado(String estado) {
		if (!(estado.equals("Nao finalizado"))) {
			throw new IllegalAccessError("Cenario ja esta fechado");
		}
	}

	/**
	 * Testa se o valor inicial do caixa é um número válido, no caso, um valor
	 * positivo.
	 * 
	 * @param caixa
	 *            O valor, em centavos, inicial do caixa.
	 * @return Retorna o próprio valor se for válido.
	 */
	public static int caixaSistema(int caixa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Caixa nao pode ser inferior a 0");
		}
		return caixa;
	}

	/**
	 * Testa se a taxa do Sistema é um número válido, no caso, um valor positivo.
	 * 
	 * @param taxa
	 *            A porcentagem usada para calcular o montante do sistema em cima do
	 *            valor total das apostas perdedoras.
	 * @return Retorna o próprio valor se for válido.
	 */
	public static double taxaSistema(double taxa) {
		if (taxa < 0) {
			throw new IllegalArgumentException("Taxa nao pode ser inferior a 0");
		}
		return taxa;
	}

	/**
	 * Testa se o bonus do Cenário Bônus é válido, isto é, um número positivo.
	 * 
	 * @param bonus
	 *            O bônus do cenário.
	 * @return Retorna o próprio valor se for válido.
	 */
	public static int bonusCenario(int bonus) {
		if (bonus <= 0) {
			throw new IllegalArgumentException("Bonus invalido");
		}
		return bonus;
	}

	/**
	 * Testa se o valor do seguro da Aposta Assegurada é válido, i.e., um número
	 * positivo.
	 * 
	 * @param valorSeguro
	 *            Valor do seguro da aposta
	 * @return Retorna o próprio valor se for válido.
	 */
	public static int valorSeguroAposta(int valorSeguro) {
		if (valorSeguro < 0) {
			throw new IllegalArgumentException("Valor do seguro inválido");
		}
		return valorSeguro;
	}

	/**
	 * Testa se a taxa do seguro da Aposta Assegurada é válida, i.e., um número
	 * positivo.
	 * 
	 * @param taxa
	 *            Taxa do seguro da Aposta
	 * @return Retorna o próprio valor se for válido.
	 */
	public static double taxaSeguroAposta(double taxa) {
		if (taxa < 0) {
			throw new IllegalArgumentException("Taxa do seguro inválida");
		}
		return taxa;
	}

	/**
	 * Verifica se o parâmetro de ordenação é válido.
	 * 
	 * @param ordem
	 *            parâmetro de ordenação.
	 */
	public static void alteraOrdem(String ordem) {
		if (ordem == null) {
			throw new NullPointerException("Ordem nao pode ser vazia ou nula");
		} else if (ordem.trim().length() == 0) {
			throw new IllegalArgumentException("Ordem nao pode ser vazia ou nula");
		} else if (!(ordem.equals("cadastro") || ordem.equals("nome") || ordem.equals("apostas"))) {
			throw new IllegalArgumentException("Ordem invalida");
		}
	}

}