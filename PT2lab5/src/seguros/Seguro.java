package seguros;

/**
 * Representação padrão do seguro
 * 
 * @author rafaela
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
