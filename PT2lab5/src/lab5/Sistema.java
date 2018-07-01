package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import Cenarios.Cenario;
import Cenarios.CenarioBonus;
import Comparators.OrdemApostas;
import Comparators.OrdemCadastro;
import Comparators.OrdemNome;

/**
 * Representa o sistema de apostas, pode conter diversos cenários diferentes
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class Sistema {

	// Atributos

	private int indiceCenarios;

	private int caixa;

	private double taxa;

	private HashMap<Integer, Cenario> cenarios;

	private Comparator<Cenario> comparador;

	// Construtores

	/**
	 * Construtor da classe, inicializa o mapa que armazenará os cenários
	 * cadastrados, inicializa o índice que representa a ordem de cadastro dos
	 * cenários e recebe o caixa inicial do Sistema e a taxa para calcular o quanto
	 * o Sistema ganha em cada aposta encerrada, o comparador, inicialmente, é de ordem de cadastro .
	 * 
	 * @param caixa
	 *            Dinheiro total inicial do Sistema.
	 * @param taxa
	 *            Taxa para calcular o ganho do Sistema.
	 */
	public Sistema(int caixa, double taxa) {
		cenarios = new HashMap<>();
		indiceCenarios = 1;
		comparador = new OrdemCadastro();

		try {
			this.caixa = Validador.caixaSistema(caixa);
			this.taxa = Validador.taxaSistema(taxa);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na inicializacao: " + e.getMessage());
		}
	}

	// Métodos

	/**
	 * verifica a existencia do cenário no sistema, ou se o índice passado é válido.
	 * 
	 * @param index
	 *            numeração do cenário.
	 */
	private void verificaCenario(int index) throws IllegalAccessError {
		Validador.indexCenarioSistema(index);

		if (!(cenarios.containsKey(index))) {
			throw new IllegalAccessError("Cenario nao cadastrado");
		}
	}

	/**
	 * Cadastra um novo cenário no Sistema.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 * @return O índice do cenário cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		Cenario aux = new Cenario(descricao, taxa, indiceCenarios);
		cenarios.put(indiceCenarios, aux);
		return indiceCenarios++;
	}

	/**
	 * Cadastra um novo Cenário com bônus no Sistema.
	 * 
	 * @param descricao
	 *            Descrição do cenário
	 * @param bonus
	 *            Bônus que será distribuído entre os vencedores da aposta.
	 * @return Retorna o identificador do cenário.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		Cenario aux = new CenarioBonus(descricao, taxa, bonus, indiceCenarios);
		cenarios.put(indiceCenarios, aux);
		this.caixa -= bonus;
		return indiceCenarios++;
	}

	/**
	 * Cadastra uma nova aposta no cenário equivalente ao índice passado no
	 * parâmetro.
	 * 
	 * @param cenario
	 *            Identificador do cenário.
	 * @param nome
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 */
	public void cadastrarAposta(int cenario, String nome, int valor, String previsao) {
		try {
			verificaCenario(cenario);
			cenarios.get(cenario).cadastrarAposta(nome, valor, previsao);
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro no cadastro de aposta: " + n.getMessage());
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: " + i.getMessage());
		} catch (IllegalAccessError a) {
			throw new IllegalAccessError("Erro no cadastro de aposta: " + a.getMessage());
		}
	}

	/**
	 * Cadastra no sistema Aposta com Seguro por valor, recebendo os parâmetros da
	 * aposta e o identificador do cenário no qual se deseja apostar.
	 * 
	 * @param cenario
	 *            Identificador do cenário.
	 * @param nome
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 * @param valSeg
	 *            Valor Assegurado
	 * @param custo
	 *            Preço do seguro.
	 * @return Retorna o identificador da Aposta.
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valSeg,
			int custo) {
		try {
			verificaCenario(cenario);
			int indice = cenarios.get(cenario).cadastrarApostaSeguraValor(apostador, valor, previsao, valSeg);
			caixa += custo;
			return indice;
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por valor: " + n.getMessage());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: " + e.getMessage());
		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro no cadastro de aposta assegurada por valor: " + e.getMessage());
		}
	}

	/**
	 * Cadastra uma nova Aposta com Seguro por taxa no Sistema, recebe os parâmetros
	 * da Aposta assegurada e o identificador do cenário no qual será apostado.
	 * 
	 * @param cenario
	 *            Identificador do cenário.
	 * @param nome
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 * @param taxa
	 *            Porcentagem para calcular o valor assegurado com base no valor da
	 *            aposta.
	 * @param custo
	 *            Preço do seguro.
	 * @return Retorna o identificador da Aposta.
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		try {
			verificaCenario(cenario);
			int indice = cenarios.get(cenario).cadastrarApostaSeguraTaxa(apostador, valor, previsao, taxa);
			caixa += custo;
			return indice;
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: " + n.getMessage());
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: " + i.getMessage());
		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		}
	}

	/**
	 * Retorna a representação textual do cenário a partir do número que representa
	 * a posição do cenário no conjunto.
	 * 
	 * @param cenario
	 *            Representa a posição do cenário por ordem de cadastro.
	 * @return Representação textual do cenário.
	 */
	public String exibirCenario(int cenario) {
		try {
			verificaCenario(cenario);
			return cenarios.get(cenario).toString();
		} catch (IllegalAccessError a) {
			throw new IllegalAccessError("Erro na consulta de cenario: " + a.getMessage());
		}
	}

	/**
	 * Retorna uma lista com todos os cenários cadastrados no Sistema precedidos
	 * pelo número que representa a ordem em que foram cadastrados.
	 * 
	 * @return String em forma de lista com todos os cenários cadastrados.
	 */
	public String exibirCenarios() {
		String lista = "";

		for (Map.Entry<Integer, Cenario> par : cenarios.entrySet()) {
			lista += par.getValue().toString() + System.lineSeparator();
		}

		return lista.trim();
	}

	/**
	 * Retorna o montante total das apostas de determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return Retorna o valor total que foi apostado nesse cenário.
	 */
	public int valorTotalDeApostas(int cenario) {
		try {
			verificaCenario(cenario);
			return cenarios.get(cenario).valorTotalDeAposta();
		} catch (IllegalAccessError a) {
			throw new IllegalAccessError("Erro na consulta do valor total de apostas: " + a.getMessage());
		}
	}

	/**
	 * Retorna a quantidade de apostas que foram feitas em determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return A quantidade de apostas que foram feitas nesse cenário.
	 */
	public int totalDeApostas(int cenario) {
		try {
			verificaCenario(cenario);
			return cenarios.get(cenario).totalDeApostas();
		} catch (IllegalAccessError a) {
			throw new IllegalAccessError("Erro na consulta do total de apostas: " + a.getMessage());
		}
	}

	/**
	 * Retorna uma lista de todas as apostas feitas em determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return String em forma de lista com todas as apostas do cenário.
	 */
	public String exibeApostas(int cenario) {
		try {
			verificaCenario(cenario);
			return cenarios.get(cenario).exibeApostas();
		} catch (IllegalAccessError a) {
			throw new IllegalAccessError("Erro ao exibir apostas: " + a.getMessage());
		}
	}

	/**
	 * Fecha as apostas para determinado cenário e acrescenta ao caixa do Sistema a
	 * porcentagem adequada do montante adquirido no cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @param ocorreu
	 *            Boolean que indica se o cenário ocorreu ou não.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		try {
			verificaCenario(cenario);
			cenarios.get(cenario).fecharAposta(ocorreu);

			int caixaCenario = cenarios.get(cenario).getCaixaCenario();
			caixa += caixaCenario;
			caixa -= cenarios.get(cenario).valorAssegurado();
		} catch (IllegalAccessError a) {
			throw new IllegalAccessError("Erro ao fechar aposta: " + a.getMessage());
		}
	}

	/**
	 * Retorna o montante de dinheiro que vai ser distribuído entre os vencedores da
	 * Aposta do Cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return Retorna o valor a ser distribuído entre os ganhadores.
	 */
	public int getTotalRateioCenario(int cenario) {
		try {
			verificaCenario(cenario);
			return cenarios.get(cenario).calculaRateio();
		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro na consulta do total de rateio do cenario: " + e.getMessage());
		}
	}

	/**
	 * Retorna o caixa total do Sistema.
	 * 
	 * @return Caixa do Sistema.
	 */
	public int getCaixa() {
		return caixa;
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
		try {
			verificaCenario(cenario);
			return cenarios.get(cenario).getCaixaCenario();
		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro na consulta do caixa do cenario: " + e.getMessage());
		}
	}

	/**
	 * Altera uma aposta assegurada por valor para aposta assegurada por taxa.
	 * 
	 * @param cenario
	 *            O identificador do cenário ao qual pertence a aposta.
	 * @param apostaAssegurada
	 *            Identificador da aposta.
	 * @param valor
	 *            Novo valor do seguro da aposta.
	 * @return Retorna o identificador da aposta.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		try {
			verificaCenario(cenario);
			cenarios.get(cenario).alterarSeguroValor(apostaAssegurada, valor);
			return apostaAssegurada;
		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro ao alterar seguro da aposta: " + e.getMessage());
		}
	}

	/**
	 * Altera uma aposta assegurada por valor para aposta assegurada por taxa.
	 * 
	 * @param cenario
	 *            O identificador do cenário ao qual pertence a aposta.
	 * @param apostaAssegurada
	 *            Identificador da aposta.
	 * @param taxa
	 *            Nova taxa do seguro da aposta.
	 * @return Retorna o identificador da aposta.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		try {
			verificaCenario(cenario);
			cenarios.get(cenario).alterarSeguroTaxa(apostaAssegurada, taxa);
			return apostaAssegurada;
		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro ao alterar seguro da aposta: " + e.getMessage());
		}
	}

	/**
	 * Altera o método de comparação para a ordenação dos cenários.
	 * 
	 * @param ordem
	 *            parâmetro de ordenação
	 */
	public void alterarOrdem(String ordem) {
		try {
			Validador.alteraOrdem(ordem);
			if (ordem.equals("cadastro")) {
				comparador = new OrdemCadastro();
			} else if (ordem.equals("nome")) {
				comparador = new OrdemNome();
			} else if (ordem.equals("apostas")) {
				comparador = new OrdemApostas();
			}
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro ao alterar ordem: " + n.getMessage());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao alterar ordem: " + e.getMessage());
		}
	}

	/**
	 * Recebe um número que representa a posição do cenário desejado, o cenário será
	 * exibido de acordo com a nova ordenação.
	 * 
	 * @param cenario
	 *            Posição do cenário.
	 * @return Representação textual do cenpário.
	 */
	public String exibirCenarioOrdenado(int cenario) {
		try {
			verificaCenario(cenario);

			ArrayList<Cenario> copia = new ArrayList<>();
			copia.addAll(cenarios.values());

			Collections.sort(copia, comparador);
			return copia.get(cenario - 1).toString();

		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro na consulta de cenario ordenado: " + e.getMessage());
		}
	}
}