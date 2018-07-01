package seguros;

/**
 * Representação genérica para um seguro nulo
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class SemSeguro extends Seguro{
	
	/**
	 * retorna 0 para mostrar que a classe não tem valor assegurado
	 */
	@Override
	public int getValorSeguro() {
		return 0;
	}
	
	/**
	 * Retorna uma string vazia para mostrar que a classe não tem valor assegurado
	 */
	@Override
	public String toString() {
		return "";
	}
}
