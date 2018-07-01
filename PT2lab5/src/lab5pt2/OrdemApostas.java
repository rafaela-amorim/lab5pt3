package lab5pt2;

import java.util.Comparator;

import Cenarios.Cenario;

public class OrdemApostas implements Comparator<Cenario>{

	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		int qtdApostas1 = cenario1.totalDeApostas();
		int qtdApostas2 = cenario2.totalDeApostas();
		
		if (qtdApostas1 < qtdApostas2) {
			return -1;
		} else if (qtdApostas1 > qtdApostas2) {
			return 1;
		}
		return 0;
	}
	
}
