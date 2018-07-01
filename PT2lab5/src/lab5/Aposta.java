package lab5;

import seguros.Seguro;
import seguros.SeguroTaxa;
import seguros.SeguroValor;
import seguros.SemSeguro;

/**
 * Representação de uma aposta, aposta pode ser assegurada ou não
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class Aposta {

	// Atributos
	private String nomeApostador;

	private int valor;

	private String previsao;

	private Seguro seguro;

	// Construtores

	/**
	 * Construtor da classe, recebe o número do cenário, o nome do apostador, o
	 * valor e a previsão da aposta.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário que será apostado.
	 * @param nome
	 *            Nome do apostador.
	 * @param valor
	 *            Valor a ser apostado.
	 * @param previsao
	 *            Previsão da aposta, se vai acontecer ou não.
	 */
	public Aposta(String nome, int valor, String previsao) {
		this.nomeApostador = Validador.nomeApostador(nome);
		this.valor = Validador.valorAposta(valor);
		this.previsao = Validador.previsaoAposta(previsao);
		seguro = new SemSeguro();
	}

	/**
	 * Constrói a Aposta com seguro, recebe um valor, em centavos, do seguro.
	 * 
	 * @param nome
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta;
	 * @param valorSeguro
	 *            Valor do seguro da aposta.
	 */
	public Aposta(String nome, int valor, String previsao, int valorSeguro) {
		this(nome, valor, previsao);
		seguro = new SeguroValor(Validador.valorSeguroAposta(valorSeguro));
	}

	/**
	 * Constrói a Aposta com seguro, recebe um double que será a taxa para o cálculo
	 * do valor do seguro da aposta.
	 * 
	 * @param nome
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta;
	 * @param taxaSeguro
	 *            Taxa do seguro da aposta.
	 */
	public Aposta(String nome, int valor, String previsao, double taxaSeguro) {
		this(nome, valor, previsao);
		seguro = new SeguroTaxa(valor, taxaSeguro);
	}

	// Métodos

	/**
	 * Retorna o nome do apostador.
	 * 
	 * @return nome do apostador
	 */
	public String getNomeApostador() {
		return nomeApostador;
	}

	/**
	 * Retorna o valor da aposta.
	 * 
	 * @return Valor da aposta.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Retorna a previsão da aposta.
	 * 
	 * @return Previsão da aposta
	 */
	public String getPrevisao() {
		return previsao;
	}

	/**
	 * Retorna o valor do Seguro.
	 * 
	 * @return valor do seguro.
	 */
	public int getValorSeguro() {
		return seguro.getValorSeguro();
	}

	/**
	 * Auxiliar para alterar uma aposta assegurada de taxa para valor.
	 * 
	 * @param valor
	 *            Novo valor para o seguro.
	 */
	public void alteraSeguroValor(int valor) {
		try {
			Validador.valorSeguroAposta(valor);
			seguro = new SeguroValor(valor);
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro ao alterar seguro da aposta: " + i.getMessage());
		}
	}

	/**
	 * Auxiliar para alterar uma aposta assegurada de taxa para valor.
	 * 
	 * @param taxa
	 *            Nova taxa para o seguro.
	 */
	public void alteraSeguroTaxa(double taxa) {
		try {
			Validador.taxaSeguroAposta(taxa);
			seguro = new SeguroTaxa(getValor(), taxa);
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro ao alterar seguro da aposta: " + i.getMessage());
		}
	}

	/**
	 * Retorna a representação textual da aposta.
	 */
	@Override
	public String toString() {
		double aux = (double) valor / 100.0;
		return nomeApostador + " - " + "R$" + String.format("%1$,.2f", aux) + " - " + previsao + seguro.toString();
	}

}
