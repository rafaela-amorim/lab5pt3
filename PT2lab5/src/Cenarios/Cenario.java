package Cenarios;

import java.util.HashMap;

import lab5.Aposta;
import lab5.Validador;

/**
 * Representação de um cenario, ele pode ter bônus ou não, ambos podem conter
 * várias apostas
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class Cenario {

	// Atributos

	private int id;
	private HashMap<Integer, Aposta> apostas;
	private String descricao;
	private Estado estado;
	private double porcentagem;
	private int caixaPerdedor;
	private int index;

	// Construtor

	/**
	 * Construtor da classe, recebe a descrição do cenário e a porcentagem para o
	 * cálculo do montante destinado ao caixa do Sistema quando as apostas forem
	 * encerradas.
	 * 
	 * O estado do cenário inicia em Não finalizado, o index inicia em 1 e o
	 * e hashmap inicializado.
	 * 
	 * @param descricao
	 *            Descrição do cenário
	 * @param porcentagem
	 *            taxa para calcular o dinheiro para o caixa do Sistema
	 */
	public Cenario(String descricao, double porcentagem, int id) {
		try {
			this.descricao = Validador.descricaoCenario(descricao);
			this.porcentagem = Validador.taxaSistema(porcentagem);

			estado = Estado.N_FINALIZADO;
			apostas = new HashMap<>();
			index = 1;
			this.id = id;
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro no cadastro de cenario: " + n.getMessage());
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + i.getMessage());
		}
	}

	// Métodos

	/**
	 * Método auxiliar que cadastra uma nova aposta no cenário.
	 * 
	 * @param aposta
	 *            A Aposta que será cadastrada no Cenário;
	 * @return Retorna o índice da aposta.
	 */
	private int cadastraApostaAux(Aposta aposta) {
		Validador.cenarioFechado(getEstado());
		apostas.put(index, aposta);
		return index++;
	}

	/**
	 * Cadastra aposta comum sem seguro, recebe nome do apostador, valor da aposta e
	 * a previsão da aposta.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 */
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		cadastraApostaAux(aposta);
	}

	/**
	 * Cadastra Aposta assegurada por valor, recebe nome do apostador, valor da
	 * aposta, previsão e o valor do seguro, retorna o número identificador da
	 * aposta.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 * @param valorSeguro
	 *            Valor do seguro da Aposta.
	 * @return Número de identificação da aposta
	 */
	public int cadastrarApostaSeguraValor(String apostador, int valor, String previsao, int valorSeguro) {
		Aposta aposta = new Aposta(apostador, valor, previsao, valorSeguro);
		return cadastraApostaAux(aposta);
	}

	/**
	 * Cadastra Aposta assegurada por taxa, recebe nome do apostador, valor da
	 * aposta, previsão e a taxa do seguro, retorna o número identificador da
	 * aposta.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 * @param taxaSeguro
	 *            Taxa do seguro da Aposta.
	 * @return Número de identificação da aposta
	 */
	public int cadastrarApostaSeguraTaxa(String apostador, int valor, String previsao, double taxaSeguro) {
		Aposta aposta = new Aposta(apostador, valor, previsao, taxaSeguro);
		return cadastraApostaAux(aposta);
	}

	/**
	 * Método que cria uma String que armazena uma representação textual de todos
	 * que apostaram nesse cenário, em formato de lista.
	 * 
	 * @return String em forma de lista com todas as apostas.
	 */
	public String exibeApostas() {
		String lista = "";

		for (Aposta item : apostas.values()) {
			lista += item.toString() + System.lineSeparator();
		}

		return lista.trim();
	}

	/**
	 * Fecha o cenário para apostas e determina quanto é o caixa perdedor e qual o
	 * Estado atual de acordo com o resultado do cenário.
	 * 
	 * @param ocorreu
	 *            Boolean que determina se a descrição do cenário ocorreu ou não.
	 */
	public void fecharAposta(boolean ocorreu) {
		Validador.cenarioFechado(getEstado());

		int caixaAux;

		if (ocorreu) {
			caixaAux = caixaContra();
			estado = Estado.OCORREU;
		} else {
			caixaAux = caixaFavoravel();
			estado = Estado.N_OCORREU;
		}
		caixaPerdedor = caixaAux;
	}

	/**
	 * Método que retorna a quantidade total de apostas do cenário.
	 * 
	 * @return Quantidade total de apostas.
	 */
	public int totalDeApostas() {
		return apostas.size();
	}

	/**
	 * Método que retorna a quantidade de dinheiro que irá para o caixa do Sistema
	 * quando as apostas forem encerradas.
	 * 
	 * @return a quantia de dinheiro que irá para o sistema.
	 */
	public int getCaixaCenario() {
		Validador.cenarioAberto(getEstado());
		return (int) Math.floor(caixaPerdedor * porcentagem);
	}

	/**
	 * Método que calcula o caixa total do cenário, somando o caixa das apostas
	 * favoráveis com o das apostas contra.
	 * 
	 * @return Caixa total do cenário.
	 */
	public int valorTotalDeAposta() {
		return caixaFavoravel() + caixaContra();
	}

	/**
	 * Calcula o valor a ser distribuido entre os vencedores se as apostas tiverem
	 * sido encerradas.
	 * 
	 * @param caixaPerdedor
	 *            o dinheiro das apostas perdedoras.
	 * @return Retorna o valor para distribuir entre os ganhadores, ou 0.
	 */
	public int calculaRateio() {
		Validador.cenarioAberto(getEstado());
		return caixaPerdedor - getCaixaCenario();
	}

	/**
	 * Retorna o identificador do cenário.
	 * 
	 * @return Identificador do cenário.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Retorna a descrição do cenário.
	 * 
	 * @return Descrição do cenário.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Retorna a representação do estado atual do cenário.
	 * 
	 * @return Estado atual do cenário.
	 */
	public String getEstado() {
		return estado.toString();
	}

	/**
	 * Representação textual do cenário, contém a descrição e o estado atual do
	 * cenário.
	 */
	@Override
	public String toString() {
		return id + " - " + getDescricao() + " - " + getEstado();
	}

	/**
	 * Calcula o caixa total das apostas favoráveis.
	 * 
	 * @return Retorna o valor total de apostas favoráveis.
	 */
	private int caixaFavoravel() {
		int caixa = 0;

		for (Aposta ap : apostas.values()) {
			if (ap.getPrevisao().equals("VAI ACONTECER")) {
				caixa += ap.getValor();
			}
		}
		return caixa;
	}

	/**
	 * Calcula o caixa total das apostas contra.
	 * 
	 * @return Retorna o valor total de apostas contra.
	 */
	private int caixaContra() {
		int caixa = 0;

		for (Aposta ap : apostas.values()) {
			if (ap.getPrevisao().equals("N VAI ACONTECER")) {
				caixa += ap.getValor();
			}
		}
		return caixa;
	}

	/**
	 * Altera uma aposta assegurada por taxa para aposta assegurada por valor.
	 * 
	 * @param apostaAssegurada
	 *            Identificador da aposta.
	 * @param valor
	 *            Novo valor do seguro da aposta.
	 */
	public void alterarSeguroValor(int apostaAssegurada, int valor) {
		verificaAposta(apostaAssegurada);
		Aposta ap = apostas.get(apostaAssegurada);
		ap.alteraSeguroValor(valor);
	}

	/**
	 * Altera uma aposta assegurada por valor para aposta assegurada por taxa.
	 * 
	 * @param apostaAssegurada
	 *            Identificador da aposta.
	 * @param taxa
	 *            Novo taxa do seguro da aposta.
	 */
	public void alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		verificaAposta(apostaAssegurada);
		Aposta ap = apostas.get(apostaAssegurada);
		ap.alteraSeguroTaxa(taxa);
	}

	/**
	 * Verifica a existência de uma aposta nesse cenário.
	 * 
	 * @param id
	 *            Identificador da aposta.
	 */
	private void verificaAposta(int id) {
		if (!(apostas.containsKey(id))) {
			throw new IllegalAccessError("Aposta inválida ou não existe");
		}
	}

	/**
	 * Retorna a soma do valor que foi assegurado de todos os perdedores.
	 * 
	 * @return valor assegurado dos perdedores.
	 */
	public int valorAssegurado() {
		Validador.cenarioAberto(getEstado());

		int saida = 0;

		for (Aposta ap : apostas.values()) {
			if (getEstado().equals("Finalizado (ocorreu)") && ap.getPrevisao().equals("N VAI ACONTECER")) {
				saida += ap.getValorSeguro();
			}
			if (getEstado().equals("Finalizado (n ocorreu)") && ap.getPrevisao().equals("VAI ACONTECER")) {
				saida += ap.getValorSeguro();
			}
		}
		return saida;
	}
}
