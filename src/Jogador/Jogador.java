package Jogador;

import baralho.Baralho;

public abstract class Jogador {

	protected Baralho mao;
	
	public abstract String getNome();
	
	public Jogador() {
		this.mao = new Baralho();
	}

	/*public Carta getCartaMao(int index) {
		if (index > getMao().size()) {
			System.out.println("Valor invalido!");
			return null;
		}
		return mao.get(index);
	}*/

	public Baralho getMao() {
		return mao;
	}

	public void setMao(Baralho mao) {
		this.mao = mao;
	}

}
