package Cenarios;
/**
 * Representa estado atual de cenário
 * 
 * @author rafaela
 *
 */
public enum Estado {
	
	OCORREU("Finalizado (ocorreu)"),
	N_OCORREU("Finalizado (n ocorreu)"),
	N_FINALIZADO("Nao finalizado");
	
	private String descricao;
	
	/**
	 * Construtor do Enum, recebe uma String que será o Estado.
	 * 
	 * @param descricao 
	 * 				Descrição do Estado.
	 */
	private Estado(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Retorna a descrição do Estado.
	 * 
	 * @return Descrição do Estado.
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * Representação textual do Estado.
	 */
	@Override
	public String toString() {
		return getDescricao();
	}
}
