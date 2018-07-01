package Comparators;

import java.util.Comparator;

import Cenarios.Cenario;

/**
 * Classe que implementa Comparator, compara o número total de Apostas de 2
 * cenários, o maior valor fica antes do menor.
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class OrdemApostas implements Comparator<Cenario> {
	
	/**
	 * Compara o total de Apostas de 2 cenários
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return Integer.compare(cenario2.totalDeApostas(), cenario1.totalDeApostas());
	}
}
