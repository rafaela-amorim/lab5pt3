package Comparators;

import java.util.Comparator;

import Cenarios.Cenario;

/**
 * Classe que implementa Comparator, compara o número identificador de 2
 * cenários, o menor valor fica antes do maior.
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class OrdemCadastro implements Comparator<Cenario> {

	/**
	 * Compara o identificador de 2 cenários
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return Integer.compare(cenario1.getId(), cenario2.getId());
	}
}
