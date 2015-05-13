package jogador;

import baralho.Carta;

public abstract class Jogador {
	// Todo jogador tem uma MaoDeCartas
	protected MaoDeCartas mao;
	
	public abstract String getNome();
	
	public Jogador() {
		this.mao = new MaoDeCartas();
	}

	public Carta getCartaMao(int index) {
		return mao.escolherCarta(index);
	}

	public MaoDeCartas getMao() {
		return mao;
	}

	public void setMao(MaoDeCartas mao) {
		this.mao = mao;
	}

}
