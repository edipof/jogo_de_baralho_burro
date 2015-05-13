package jogador;

import java.util.ArrayList;

import baralho.Carta;
import baralho.Naipe;
import baralho.ValorCarta;

public class MaoDeCartas {
	// Uma MaoDeCartas começa vazia
	// O jogador pode ver as cartas que esta em sua mao
	// O jogador pode adicionar cartas em sua mao
	// O jogador pode escolher e retirar uma carta de sua mao
	private ArrayList<Carta> cartas;

	public MaoDeCartas() {
		this.cartas = new ArrayList<Carta>();
	}

	public void verMao() {
		if (!cartas.isEmpty()) {
			for (Carta carta : cartas) {
				System.out.println("["+cartas.indexOf(carta)+"]"+ carta.getValorCarta() + " de "
						+ carta.getNaipe() + ",");
			}
		} else {
			System.out.println("Mao vazia!");
		}
	}
	
	public void addCartaMao(Carta carta){
		cartas.add(carta);
	}
	
	public Carta escolherCarta(int indexCarta){
		if(indexCarta > cartas.size()){
			System.out.println("Valor Invalido!");
			return null;
		}
		Naipe naipe = cartas.get(indexCarta).getNaipe();
		ValorCarta valorCarta = cartas.get(indexCarta).getValorCarta();
		cartas.remove(indexCarta);
		Carta carta = new Carta(naipe, valorCarta);
		return carta;
	}

}
