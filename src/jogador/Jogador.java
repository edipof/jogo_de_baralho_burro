package jogador;

import baralho.Carta;

public abstract class Jogador {
	// Todo jogador tem uma MaoDeCartas
	protected MaoDeCartas mao;
	
	public abstract String getNome();
	
	public Jogador() {
		this.mao = new MaoDeCartas();
	}

	public Carta jogarCartaMao(int index) {
		return mao.escolherCarta(index);
	}
	
	public void addCartaMao(Carta carta){
		mao.addCartaMao(carta);
	}
	
	public void verMao(){
		mao.verMao();
	}
	
	public MaoDeCartas getMao() {
		return mao;
	}

	public void setMao(MaoDeCartas mao) {
		this.mao = mao;
	}

}
