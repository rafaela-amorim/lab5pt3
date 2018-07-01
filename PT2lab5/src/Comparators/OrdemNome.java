package Comparators;

import java.util.Comparator;

import Cenarios.Cenario;

/**
 * Classe que implementa Comparator, compara a descrição de 2 cenários, a
 * ordenação é por ordem lexicográfica.
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class OrdemNome implements Comparator<Cenario> {

	/**
	 * Compara a descrição de 2 cenários
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return cenario1.getDescricao().compareTo(cenario2.getDescricao());
	}

}
