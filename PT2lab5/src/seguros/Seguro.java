package seguros;

/**
 * Representação padrão do seguro
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public abstract class Seguro {
	
	/**
	 * Define como vai ser retornado o valor do seguro
	 * 
	 * @returns inteiro com o valor assegurado
	 */
	public abstract int getValorSeguro();
	
	/**
	 * Representação textual do seguro
	 */
	@Override
	public abstract String toString();
}
