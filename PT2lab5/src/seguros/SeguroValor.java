package seguros;

/**
 * Representação de um seguro de valor
 * 
 * @author rafaela
 *
 */
public class SeguroValor extends Seguro {
	
	private int valor;
	
	/**
	 * Construtor da classe, recebe o valor do seguro
	 * 
	 * @param valor
	 * 		valor do seguro
	 */
	public SeguroValor(int valor) {
		super();
		this.valor = valor;
	}
	
	/**
	 * Retorna o valor do Seguro
	 */
	@Override
	public int getValorSeguro() {
		return valor;
	}
	
	/**
	 * Representação textual do seguro
	 */
	@Override
	public String toString() {
		double aux = (double) valor / 100.0;
		return " - ASSEGURADA (VALOR) - R$" + String.format("%1$,.2f", aux);
	}
}
