package seguros;

/**
 * Representação de um seguro calculado por taxa
 * 
 * @author rafaela
 *
 */
public class SeguroTaxa extends Seguro {
	
	private int valorAposta;
	private double taxa;
	
	/**
	 * Construtor da classe, recebe o valor da aposta e a taxa para poder calcular o valor assegurado
	 * 
	 * @param valorAposta
	 * 		valor da aposta
	 * @param taxa
	 * 		taxa para poder calcular o valor assegurado
	 */
	public SeguroTaxa(int valorAposta, double taxa) {
		super();
		this.valorAposta = valorAposta;
		this.taxa = taxa;
	}
	
	/**
	 * Método que calcula e retorna o valor assegurado
	 */
	@Override
	public int getValorSeguro() {
		return (int) (valorAposta * taxa);
	} 
	
	/**
	 * Representação textual do seguro
	 */
	public String toString() {
		int aux = (int) (taxa * 100);
		return " - ASSEGURADA (TAXA) - " + String.format("%d%%", aux);
	}
}
