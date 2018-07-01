package lab5pt2;

import easyaccept.EasyAccept;

/**
 * Representação da fachada do sistema, controla todas as funções disponiveis
 * 
 * @author rafaela
 *
 */
public class Facade {

	public static void main(String[] args) {
		args = new String[] { "lab5pt2.Facade", "easyAccept/us1_test.txt",
												"easyAccept/us2_test.txt",
												"easyAccept/us3_test.txt",
												"easyAccept/us4_test.txt",
												"easyAccept/us5_test.txt",
												"easyAccept/us6_test.txt"};
		EasyAccept.main(args);
	}

	// Atributos

	private Sistema sistema;

	private boolean iniciado;

	// Métodos

	/**
	 * Construtor da classe, contém um booleano que indica se o sistema já foi
	 * inicializado ou não, o booleano começa em false.
	 */
	public Facade() {
		iniciado = false;
	}

	/**
	 * Método que verifica se o sistema já foi inicializado ou não.
	 */
	private void jaInicializou() {
		if (!(iniciado)) {
			throw new IllegalAccessError("Erro na inicializacao");
		}
	}

	/**
	 * Inicializa o Sistema, com uma taxa para o cálculo dos ganhos do sistema e um
	 * caixa que representa o dinheiro que o sistema tem inicialmente.
	 * 
	 * @param caixa
	 *            dinheiro inicial do sistema
	 * @param taxa
	 *            taxa para calcular o quanto o sistema ganha por aposta encerrada.
	 */
	public void inicializa(int caixa, double taxa) {
		sistema = new Sistema(caixa, taxa);
		iniciado = true;

	}

	/**
	 * Retorna a quantidade de dinheiro que o caixa tem atualmente.
	 * 
	 * @return Retorna o dinheiro do sistema
	 */
	public int getCaixa() {
		jaInicializou();
		return sistema.getCaixa();
	}

	/**
	 * Cadastra um novo cenário no sistema, com a descrição passada como parâmetro.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 * @return Retorna a numeração do cenário cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		jaInicializou();
		return sistema.cadastrarCenario(descricao);

	}

	/**
	 * Retorna a representação textual do cenário de mesma numeração da passada como
	 * parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @return Retorna uma String com as informações do cenário.
	 */
	public String exibirCenario(int cenario) {
		jaInicializou();
		return sistema.exibirCenario(cenario);

	}

	/**
	 * Exibe uma lista com a representação textual de todos os cenários cadastrados
	 * no Sistema.
	 * 
	 * @return Retorna uma String em forma de lista.
	 */
	public String exibirCenarios() {
		jaInicializou();
		return sistema.exibirCenarios();
	}

	/**
	 * Cadastra uma nova aposta no cenário de mesma numeração à passada como
	 * parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @param apostador
	 *            nome do apostador
	 * @param valor
	 *            valor da aposta
	 * @param previsao
	 *            previsão da aposta
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		jaInicializou();
		sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	/**
	 * Retorna um inteiro com o total de dinheiro que foi apostado no cenário de
	 * mesma numeração do parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @return Retorna o valor total que foi apostado
	 */
	public int valorTotalDeApostas(int cenario) {
		jaInicializou();
		return sistema.valorTotalDeApostas(cenario);
	}

	/**
	 * Retorna um inteiro que é a quantidade de apostas feitas no cenário de mesma
	 * numeração do parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário.
	 * @return Quantidade de apostas do cenário
	 */
	public int totalDeApostas(int cenario) {
		jaInicializou();
		return sistema.totalDeApostas(cenario);
	}

	/**
	 * Exibe uma lista com a representação textual de todas as apostas feitas no
	 * cenário de mesma numeração do parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @return Retorna uma String na forma de lista.
	 */
	public String exibeApostas(int cenario) {
		jaInicializou();
		return sistema.exibeApostas(cenario);
	}

	/**
	 * Fecha a aposta do cenário de mesma numeração do parâmetro e calcula a
	 * porcentagem que o Sistema receberá de acordo com o resultado final da aposta.
	 * 
	 * @param cenario
	 *            numeração do cenário.
	 * @param ocorreu
	 *            boolean que representa se a previsão do cenário ocorreu ou não.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		jaInicializou();
		sistema.fecharAposta(cenario, ocorreu);
	}

	/**
	 * Retorna a quantia de dinheiro que irá para o caixa do Sistema quando as
	 * apostas forem encerradas, se isso ainda não tiver ocorrido, então retorna -1.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @return O dinheiro que irá para o Sistema ou -1.
	 */
	public int getCaixaCenario(int cenario) {
		jaInicializou();
		return sistema.getCaixaCenario(cenario);
	}

	/**
	 * Retorna o montante total das apostas de determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return Retorna o valor total que foi apostado nesse cenário.
	 */
	public int getTotalRateioCenario(int cenario) {
		jaInicializou();
		return sistema.getTotalRateioCenario(cenario);
	}

	/**
	 * Cadastra um novo cenário com bônus.
	 * 
	 * @param descricao
	 *            Descrição do cenário
	 * @param bonus
	 *            Bônus que será adicionado ao montante distribuído entre os
	 *            vencedores da aposta.
	 * @return Retorna o número de identificação do cenário.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		jaInicializou();
		return sistema.cadastrarCenario(descricao, bonus);
	}

	/**
	 * Cadastra uma nova aposta assegurada por valor no cenário especificado.
	 * 
	 * @param cenario
	 *            Identificador do cenário
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 * @param valSeg
	 *            Valor que será assegurado caso o apostador perca
	 * @param custo
	 *            Valor pago pelo seguro
	 * @return Retorna o número de identificação da aposta.
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valSeg,
			int custo) {
		jaInicializou();
		return sistema.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valSeg, custo);
	}

	/**
	 * Cadastra uma nova aposta assegurada por taxa no cenário especificado.
	 * 
	 * @param cenario
	 *            Identificador do cenário
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 * @param taxa
	 *            Taxa para calcular o valor que será assegurado em cima do valor
	 *            apostado caso o apostador perca.
	 * @param custo
	 *            Valor pago pelo seguro
	 * @return Retorna o número de identificação da aposta.
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		jaInicializou();
		return sistema.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}

	/**
	 * Altera uma aposta assegurada por taxa para aposta assegurada por valor.
	 * 
	 * @param cenario
	 *            Identificador do cenário
	 * @param apostaAssegurada
	 *            Identificador da aposta assegurada
	 * @param valor
	 *            Novo valor para o seguro da aposta
	 * @return Retorna o número de identificação da aposta.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		jaInicializou();
		return sistema.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}

	/**
	 * Altera uma aposta assegurada por valor para aposta assegurada por taxa.
	 * 
	 * @param cenario
	 *            Identificador do cenário
	 * @param apostaAssegurada
	 *            Identificador da aposta assegurada
	 * @param taxa
	 *            Taxa para calcular o valor que será assegurado em cima do valor
	 *            apostado caso o apostador perca.
	 * @return Retorna o número de identificação da aposta.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		jaInicializou();
		return sistema.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}
}
