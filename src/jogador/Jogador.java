package jogador;

import java.util.ArrayList;

import baralho.Carta;

public abstract class Jogador {

	protected ArrayList<Carta> mao;
	
	public abstract String getNome();
	
	public Jogador() {
		this.mao = new ArrayList<Carta>();
	}

	/*public Carta getCartaMao(int index) {
		if (index > getMao().size()) {
			System.out.println("Valor invalido!");
			return null;
		}
		return mao.get(index);
	}*/

	public ArrayList<Carta> getMao() {
		return mao;
	}

	public void setMao(ArrayList<Carta> mao) {
		this.mao = mao;
	}

}
