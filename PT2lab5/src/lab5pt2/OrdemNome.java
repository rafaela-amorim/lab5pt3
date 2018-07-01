package lab5pt2;

import java.util.Comparator;

import Cenarios.Cenario;

public class OrdemNome implements Comparator<Cenario>{

	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return cenario1.getDescricao().compareTo(cenario2.getDescricao());
	}
	
}
