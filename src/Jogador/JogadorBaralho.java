package Jogador;

import java.util.ArrayList;

import baralho.Carta;

public interface JogadorBaralho {
	
	public ArrayList<Carta> mao = new ArrayList<Carta>();
	
	public ArrayList<Carta> getMao(ArrayList<Carta> cartas);
	public void setMao(ArrayList<Carta> cartas);
}
