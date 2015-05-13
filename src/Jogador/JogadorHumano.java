package Jogador;

import java.util.ArrayList;

import baralho.Carta;

public class JogadorHumano extends Pessoa implements JogadorBaralho {

	@Override
	public ArrayList<Carta> getMao(ArrayList<Carta> cartas) {
		
		return mao;
	}

	@Override
	public void setMao(ArrayList<Carta> cartas) {
		// TODO Auto-generated method stub
		
	}

}
